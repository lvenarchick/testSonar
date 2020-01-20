
package com.rochcap.cpa.controllers;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LoginController
{
	public static final Logger logger = Logger.getLogger("*** " + LoginController.class);
	private static final String SERVICES_URL = "https://services.appliedcard.com";

	@Autowired
	ServletContext context;

	
	// Initial Page
	@RequestMapping(value = "/associate", method = RequestMethod.GET)
	public String displayLogin(ModelMap model, HttpServletRequest request, HttpServletResponse response)
	{
		String page = "login";
		return page;
	}

	// Validate Login
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView validateLogin(ModelMap model, HttpServletRequest request, HttpSession session)
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String domain = request.getParameter("domain");

		if (username == null || username.equals("") || password == null || password.equals(""))
		{
			logger.warn("validateLogin - User name and/or password are missing. username: " + username);
			session.setAttribute("authenticated", false);
			model.addAttribute("errorMessage", "Please enter a User Name and/or Password!");
			return new ModelAndView("login", model);
		}

		if (domain == null || domain.equals(""))
		{
			logger.warn("validateLogin - Domain name missing.");
			session.setAttribute("authenticated", false);
			model.addAttribute("errorMessage", "Please select a Domain!");
			return new ModelAndView("login", model);
		}

		try
		{
//			//LdapAuthentication ldap = new LdapAuthentication();
//			String authenticatedMessage = "";
//			logger.debug("validateLogin - authenticated message: " + authenticatedMessage);
//
//			// User authenticated successfully
//			if (authenticatedMessage.equals(""))
//			{
//				session.setAttribute("authenticated", true);
//				session.setAttribute("username", username);
//				ArrayList<String> groups = ldap.getAuthenticationGroups(username, password, domain);
//				if (groups == null || groups.isEmpty())
//				{
//					logger.warn("validateLogin - user: " + username + " get groups failed.");
//					session.setAttribute("authenticated", false);
//					model.addAttribute("errorMessage", "Unable to access authentication server. ");
//					return new ModelAndView("login", model);
//				}
//				else
//				{
//					logger.debug("validateLogin - load Associate Page");
//					CpaRequest cpaRequest = new CpaRequest();
//					model.addAttribute("newRecord", "true");
//					model.addAttribute("associate", "true");
//					model.addAttribute("associateId", username);
//					model.addAttribute("company", context.getAttribute("cpa-website-domain-name"));
//					return new ModelAndView("cpaDataRequest", "cpaRequest", cpaRequest);
//				}
//			}
//			else
//			{
//				logger.warn("validateLogin - user: " + username + " authentication failed. authenticatedMessage: " + authenticatedMessage);
//				session.setAttribute("authenticated", false);
//				model.addAttribute("errorMessage", authenticatedMessage);
				return new ModelAndView("login", model);
//			}
		}
		catch (Exception e)
		{
			logger.error("validateLogin - Exception: " + e.getMessage());
			model.addAttribute("errorMessage", "Server Error. Server may be down!");
			session.setAttribute("authenticated", false);
			return new ModelAndView("login", model);
		}
		finally
		{
		}
	}
}