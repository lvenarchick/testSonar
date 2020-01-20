
package com.rochcap.cpa.controllers;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.rochcap.cpa.dao.RequestDataDAO;
import com.rochcap.cpa.models.CpaEvent;
import com.rochcap.cpa.models.CpaRequest;
import com.rochcap.cpa.tags.StatesSorted;
import com.rochcap.cpa.utils.Constants;
import com.rochcap.cpa.validators.RequestValidator;

@Controller
@SessionAttributes("cpa")
public class RequestController
{
	private static final Logger log = Logger.getLogger("*** " + RequestController.class);
	
	@Autowired
	ServletContext context;
	
	@Autowired
	private RequestValidator requestValidator;

	@Autowired
	RequestDataDAO requestDataDAO;
	
	@GetMapping("/")
	public ModelAndView cpaConsumerRequest(ModelMap model, HttpServletResponse response, HttpSession session)
	{
		log.debug("Consumer / Parent of Minor / Authorized Agent Request");
		CpaRequest cpaRequest = new CpaRequest();
		model.addAttribute("newRecord", "true");
		model.addAttribute("company", context.getAttribute("cpa-website-domain-name"));
		return new ModelAndView("cpaDataRequest", "cpaRequest", cpaRequest);
	}

//	@GetMapping("/associate")
//	public ModelAndView cpaAssociateRequest(ModelMap model, HttpServletResponse response, HttpSession session)
//	{
//		log.debug("Associate Request");
//		CpaRequest cpaRequest = new CpaRequest();
//		model.addAttribute("newRecord", "true");
//		model.addAttribute("associate", "true");
//		model.addAttribute("company", context.getAttribute("cpa-website-domain-name"));
//		return new ModelAndView("cpaDataRequest", "cpaRequest", cpaRequest);
//	}
	
	// CPA request submission
	@RequestMapping(value = "/submitRequest", method = RequestMethod.POST)
	public String submitRequest(@ModelAttribute("cpaRequest") CpaRequest cpaRequest, BindingResult result, ModelMap model, HttpServletRequest request, HttpSession session)
	{
		String view = "redirect:/submitSuccess";
		try
		{
			requestValidator.validate(cpaRequest, result);
			if (result.hasErrors())
			{
				result.getAllErrors().forEach((error) -> log.debug("Error: " + error));
//TODO:				
//				if (!cpaRequest.getDocId().equals(""))
//					model.addAttribute("poa", cpaRequest.getValidateDocId());
//								
//				model.addAttribute("accountType", maintenanceRequest.getAccountType());
				
				
				
				view = "cpaDataRequest";
			}
			else
			{	
				// Get ip address
				String remoteAddress = request.getRemoteAddr();
				cpaRequest.setIpAddress(remoteAddress);

				//Create record id
				String recordId = UUID.randomUUID().toString();
				cpaRequest.setRecordId(recordId);
				log.debug("submitRequest - recordId: " + cpaRequest.getRecordId());

				DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				Calendar cal = Calendar.getInstance();
				String dateEntered = sdf.format(cal.getTime());
				cpaRequest.setDateEntered(dateEntered);
				
				CpaEvent cpaEvent = new CpaEvent();
				cpaEvent.setRecordId(UUID.randomUUID().toString());
				cpaEvent.setCpaRecordId(recordId);
				
				cpaEvent.setEventDate(new Timestamp(cal.getTimeInMillis()));

				if(!cpaRequest.getAssociateId().equals(""))
					cpaEvent.setUserId(cpaRequest.getAssociateId());
				
				if(requestValidator.isValidRequestState(cpaRequest.getConsumerState()))
				{
					cpaRequest.setRequestStatus(Constants.REQUEST_STATUS_SUBMITTED);
					cpaEvent.setNewStatus(Constants.REQUEST_STATUS_SUBMITTED);
					cpaEvent.setEvent(Constants.REQUEST_EVENT_SUBMITTED);
				}
				else
				{
					cpaRequest.setRequestStatus(Constants.REQUEST_STATUS_REJECTED);
					cpaEvent.setNewStatus(Constants.REQUEST_STATUS_REJECTED);
					cpaEvent.setEvent(Constants.REQUEST_EVENT_REJECTED_STATE_VALIDATION_FAILURE);
				}
				
				cal = Calendar.getInstance();
				cal.add(Calendar.DAY_OF_MONTH, 10);
				String dateTenDayResponseDue = sdf.format(cal.getTime());
				cpaRequest.setTenDayResponseDueDate(dateTenDayResponseDue);

				cal = Calendar.getInstance();
				cal.add(Calendar.DAY_OF_MONTH, 45);
				String dateFourtyFiveDayResponseDue = sdf.format(cal.getTime());
				cpaRequest.setTenDayResponseDueDate(dateFourtyFiveDayResponseDue);
				
				cal = Calendar.getInstance();
				cal.add(Calendar.DAY_OF_MONTH, 90);
				String dateNintyDayResponseDue = sdf.format(cal.getTime());
				cpaRequest.setNintyDayResponseDueDate(dateNintyDayResponseDue);
				
				//TODO comment out next two lines for production
				logRequestData(cpaRequest);
				logRequestEvent(cpaEvent);
				
				boolean response = requestDataDAO.writeRequestData(cpaRequest);
				log.debug("submitRequest - Request writeRequestData response: " + response + ", recordId: " + cpaRequest.getRecordId());
				if (response)
				{	
					response = requestDataDAO.writeRequestEvent(cpaEvent);
					if(response)
						log.debug("submitRequest - Request writeRequestEvent response: " + response + ", recordId: " + cpaRequest.getRecordId());
					else
						log.error("submitRequest - Request writeRequestEvent response: " + response + ", recordId: " + cpaRequest.getRecordId());
				}
				else
				{
					log.error("submitRequest - Failed to write request data. recordId: " + cpaRequest.getRecordId());
					view = "serverError";
				}
			}
		}
		catch (Exception ex)
		{
			view = "serverError";
		}
		finally
		{
		}

		return view;
	}

	@RequestMapping(value = "submitSuccess", method = RequestMethod.GET)
    public String submitSuccess()
	{
		log.debug("submitSuccess");
        return "cpaDataRequestThankyou";
    }

//	@RequestMapping(value = "submitRejected", method = RequestMethod.GET)
//    public String submitRejected()
//	{
//		log.debug("submitRejected");
//        return "cpaDataRequestReject";
//    }
	
	@ModelAttribute("states")
	public LinkedHashMap<String, String> mailingstate()
	{
		StatesSorted states = new StatesSorted();
		return states.getStates();
	}

	private void logRequestData(CpaRequest cpaRequest)
	{
		log.debug("**** CPA Request Data ****");
		log.debug(cpaRequest.toString());
	}

	private void logRequestEvent(CpaEvent cpaEvent)
	{
		log.debug("**** CPA Request Event ****");
		log.debug(cpaEvent.toString());
	}
	
	@RequestMapping(value = "/sessionTimeout", method = RequestMethod.GET)
	public String sessionTimeout(ModelMap model, HttpSession session)
	{
		return "sessionTimeout";
	}

	@RequestMapping(value = "/jsdisabled", method = RequestMethod.GET)
	public String jsdisabled(ModelMap model, HttpSession session)
	{
		return "jscriptDisabled";
	}
	
}
