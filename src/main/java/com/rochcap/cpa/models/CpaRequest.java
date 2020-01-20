
package com.rochcap.cpa.models;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

public class CpaRequest
{
	private String recordId = "";
	
	private String requester = ""; // three value drop down. consumer, authorized agent, associate
	
	private String agencyName = "";
	private String agencyAddress = "";
	private String agencyCity = "";
	private String agencyState = "";
	private String agencyZip = "";
	private String agentFirstName = "";
	private String agentMiddleName = "";
	private String agentLastName = "";
	private String agentAddress = "";
	private String agentCity = "";
	private String agentState = "";
	private String agentZip = "";
	private String agentDob = "";
	private String agentSsnLastFour = "";
	
	private String associateId = "";
	private String submittedToFdrDate = "";
	
	private String requestTypeCategories = ""; 
	private String requestTypeSpecific = ""; 
	private String requestTypeDelete = ""; 
	private String requestTypeOptOut = ""; 
		
	private String consumerFirstName = "";
	private String consumerMiddleName = "";
	private String consumerLastName = "";
	private String consumerAddress = "";
	private String consumerApartment = "";
	private String consumerCity = "";
	private String consumerState = "";
	private String consumerZip = "";
	private String consumerPhone = "";
	private String consumerDob = "";
	private String consumerSsnLastFour = "";
	
	private String consumerEmail = "";
	private String consumerEmailAuthorization = "";
	
	private String docId;
	private MultipartFile validateDocId;
	
	private String perjuryConfirmation = "";
	
	private String requestStatus = "";
	private String ipAddress = "";
	
	private String dateEntered = "";
	private String tenDayResponseDueDate = "";
	private String fourtyFiveDayResponseDueDate = "";
	private String nintyDayResponseDueDate = "";
	
	public String getRecordId()
	{
		return recordId;
	}
	public void setRecordId(String recordId)
	{
		this.recordId = recordId;
	}
	public String getRequester()
	{
		return requester;
	}
	public void setRequester(String requester)
	{
		this.requester = requester;
	}
	public String getAgencyName()
	{
		return agencyName;
	}
	public void setAgencyName(String agencyName)
	{
		this.agencyName = agencyName;
	}
	public String getAgencyAddress()
	{
		return agencyAddress;
	}
	public void setAgencyAddress(String agencyAddress)
	{
		this.agencyAddress = agencyAddress;
	}
	public String getAgencyCity()
	{
		return agencyCity;
	}
	public void setAgencyCity(String agencyCity)
	{
		this.agencyCity = agencyCity;
	}
	public String getAgencyState()
	{
		return agencyState;
	}
	public void setAgencyState(String agencyState)
	{
		this.agencyState = agencyState;
	}
	public String getAgencyZip()
	{
		return agencyZip;
	}
	public void setAgencyZip(String agencyZip)
	{
		this.agencyZip = agencyZip;
	}
	public String getAgentFirstName()
	{
		return agentFirstName;
	}
	public void setAgentFirstName(String agentFirstName)
	{
		this.agentFirstName = agentFirstName;
	}
	public String getAgentMiddleName()
	{
		return agentMiddleName;
	}
	public void setAgentMiddleName(String agentMiddleName)
	{
		this.agentMiddleName = agentMiddleName;
	}
	public String getAgentLastName()
	{
		return agentLastName;
	}
	public void setAgentLastName(String agentLastName)
	{
		this.agentLastName = agentLastName;
	}
	public String getAgentAddress()
	{
		return agentAddress;
	}
	public void setAgentAddress(String agentAddress)
	{
		this.agentAddress = agentAddress;
	}
	public String getAgentCity()
	{
		return agentCity;
	}
	public void setAgentCity(String agentCity)
	{
		this.agentCity = agentCity;
	}
	public String getAgentState()
	{
		return agentState;
	}
	public void setAgentState(String agentState)
	{
		this.agentState = agentState;
	}
	public String getAgentZip()
	{
		return agentZip;
	}
	public void setAgentZip(String agentZip)
	{
		this.agentZip = agentZip;
	}
	public String getAgentDob()
	{
		return agentDob;
	}
	public void setAgentDob(String agentDob)
	{
		this.agentDob = agentDob;
	}
	public String getAgentSsnLastFour()
	{
		return agentSsnLastFour;
	}
	public void setAgentSsnLastFour(String agentSsnLastFour)
	{
		this.agentSsnLastFour = agentSsnLastFour;
	}
	public String getAssociateId()
	{
		return associateId;
	}
	public void setAssociateId(String associateId)
	{
		this.associateId = associateId;
	}
	public String getSubmittedToFdrDate()
	{
		return submittedToFdrDate;
	}
	public void setSubmittedToFdrDate(String submittedToFdrDate)
	{
		this.submittedToFdrDate = submittedToFdrDate;
	}

	public String getConsumerFirstName()
	{
		return consumerFirstName;
	}
	public void setConsumerFirstName(String consumerFirstName)
	{
		this.consumerFirstName = consumerFirstName;
	}
	public String getConsumerMiddleName()
	{
		return consumerMiddleName;
	}
	public void setConsumerMiddleName(String consumerMiddleName)
	{
		this.consumerMiddleName = consumerMiddleName;
	}
	public String getConsumerLastName()
	{
		return consumerLastName;
	}
	public void setConsumerLastName(String consumerLastName)
	{
		this.consumerLastName = consumerLastName;
	}
	public String getConsumerAddress()
	{
		return consumerAddress;
	}
	public void setConsumerAddress(String consumerAddress)
	{
		this.consumerAddress = consumerAddress;
	}
	public String getConsumerApartment()
	{
		return consumerApartment;
	}
	public void setConsumerApartment(String consumerApartment)
	{
		this.consumerApartment = consumerApartment;
	}
	public String getConsumerCity()
	{
		return consumerCity;
	}
	public void setConsumerCity(String consumerCity)
	{
		this.consumerCity = consumerCity;
	}
	public String getConsumerState()
	{
		return consumerState;
	}
	public void setConsumerState(String consumerState)
	{
		this.consumerState = consumerState;
	}
	public String getConsumerZip()
	{
		return consumerZip;
	}
	public void setConsumerZip(String consumerZip)
	{
		this.consumerZip = consumerZip;
	}
	public String getConsumerPhone()
	{
		return consumerPhone;
	}
	public void setConsumerPhone(String consumerPhone)
	{
		this.consumerPhone = consumerPhone;
	}
	public String getConsumerDob()
	{
		return consumerDob;
	}
	public void setConsumerDob(String consumerDob)
	{
		this.consumerDob = consumerDob;
	}
	public String getConsumerSsnLastFour()
	{
		return consumerSsnLastFour;
	}
	public void setConsumerSsnLastFour(String consumerSsnLastFour)
	{
		this.consumerSsnLastFour = consumerSsnLastFour;
	}
	public String getConsumerEmail()
	{
		return consumerEmail;
	}
	public void setConsumerEmail(String consumerEmail)
	{
		this.consumerEmail = consumerEmail;
	}
	public String getConsumerEmailAuthorization()
	{
		return consumerEmailAuthorization;
	}
	public void setConsumerEmailAuthorization(String consumerEmailAuthorization)
	{
		this.consumerEmailAuthorization = consumerEmailAuthorization;
	}
	public String getDocId()
	{
		return docId;
	}
	public void setDocId(MultipartFile docId)
	{
		String returnValue = "";
		if (docId != null)
		{
			try
			{
				validateDocId = docId;
				byte[] mcImage = docId.getBytes();
				String mcImageContectType = docId.getContentType();
				returnValue = mcImageContectType + "~" + Base64.getEncoder().encodeToString(mcImage);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		this.docId = returnValue;
		
	}
	
	public MultipartFile getValidateDocId()
	{
		return validateDocId;
	}
	
	public String getPerjuryConfirmation()
	{
		return perjuryConfirmation;
	}
	public void setPerjuryConfirmation(String perjuryConfirmation)
	{
		this.perjuryConfirmation = perjuryConfirmation;
	}
	public String getRequestStatus()
	{
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus)
	{
		this.requestStatus = requestStatus;
	}
	public String getIpAddress()
	{
		return ipAddress;
	}
	public void setIpAddress(String ipAddress)
	{
		this.ipAddress = ipAddress;
	}
	public String getDateEntered()
	{
		return dateEntered;
	}
	public void setDateEntered(String dateEntered)
	{
		this.dateEntered = dateEntered;
	}
	public String getTenDayResponseDueDate()
	{
		return tenDayResponseDueDate;
	}
	public void setTenDayResponseDueDate(String tenDayResponseDueDate)
	{
		this.tenDayResponseDueDate = tenDayResponseDueDate;
	}
	public String getFourtyFiveDayResponseDueDate()
	{
		return fourtyFiveDayResponseDueDate;
	}
	public void setFourtyFiveDayResponseDueDate(String fourtyFiveDayResponseDueDate)
	{
		this.fourtyFiveDayResponseDueDate = fourtyFiveDayResponseDueDate;
	}
	public String getNintyDayResponseDueDate()
	{
		return nintyDayResponseDueDate;
	}
	public void setNintyDayResponseDueDate(String nintyDayResponseDueDate)
	{
		this.nintyDayResponseDueDate = nintyDayResponseDueDate;
	}
	public String getRequestTypeCategories()
	{
		return requestTypeCategories;
	}
	public void setRequestTypeCategories(String requestTypeCategories)
	{
		this.requestTypeCategories = requestTypeCategories;
	}
	public String getRequestTypeSpecific()
	{
		return requestTypeSpecific;
	}
	public void setRequestTypeSpecific(String requestTypeSpecific)
	{
		this.requestTypeSpecific = requestTypeSpecific;
	}
	public String getRequestTypeDelete()
	{
		return requestTypeDelete;
	}
	public void setRequestTypeDelete(String requestTypeDelete)
	{
		this.requestTypeDelete = requestTypeDelete;
	}
	public String getRequestTypeOptOut()
	{
		return requestTypeOptOut;
	}
	public void setRequestTypeOptOut(String requestTypeOptOut)
	{
		this.requestTypeOptOut = requestTypeOptOut;
	}
	@Override
	public String toString()
	{
		return "CpaRequest [recordId=" + recordId + ", requester=" + requester + ", agencyName=" + agencyName + ", agencyAddress=" + agencyAddress + ", agencyCity=" + agencyCity + ", agencyState=" + agencyState + ", agencyZip=" + agencyZip + ", agentFirstName=" + agentFirstName + ", agentMiddleName=" + agentMiddleName + ", agentLastName=" + agentLastName + ", agentAddress=" + agentAddress + ", agentCity=" + agentCity + ", agentState=" + agentState + ", agentZip=" + agentZip + ", agentDob=" + agentDob + ", agentSsnLastFour=" + agentSsnLastFour + ", associateId=" + associateId + ", submittedToFdrDate=" + submittedToFdrDate + ", requestTypeCategories=" + requestTypeCategories + ", requestTypeSpecific=" + requestTypeSpecific + ", requestTypeDelete=" + requestTypeDelete + ", requestTypeOptOut=" + requestTypeOptOut + ", consumerFirstName=" + consumerFirstName + ", consumerMiddleName=" + consumerMiddleName + ", consumerLastName=" + consumerLastName + ", consumerAddress=" + consumerAddress
				+ ", consumerApartment=" + consumerApartment + ", consumerCity=" + consumerCity + ", consumerState=" + consumerState + ", consumerZip=" + consumerZip + ", consumerPhone=" + consumerPhone + ", consumerDob=" + consumerDob + ", consumerSsnLastFour=" + consumerSsnLastFour + ", consumerEmail=" + consumerEmail + ", consumerEmailAuthorization=" + consumerEmailAuthorization + ", perjuryConfirmation=" + perjuryConfirmation + ", requestStatus=" + requestStatus + ", ipAddress=" + ipAddress + ", dateEntered=" + dateEntered + ", tenDayResponseDueDate=" + tenDayResponseDueDate + ", fourtyFiveDayResponseDueDate=" + fourtyFiveDayResponseDueDate + ", nintyDayResponseDueDate=" + nintyDayResponseDueDate + "]";
	}



}
