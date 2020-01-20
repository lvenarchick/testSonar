
package com.rochcap.cpa.models;

import java.sql.Timestamp;

public class CpaEvent
{
	private String recordId = "";
	private String cpaRecordId = "";
	private String previousStatus = "";
	private String newStatus = "";
	private String note = "";
	private String userId = "";
	private Timestamp eventDate;
	private String event = "";
	
	public String getRecordId()
	{
		return recordId;
	}
	public void setRecordId(String recordId)
	{
		this.recordId = recordId;
	}
	public String getCpaRecordId()
	{
		return cpaRecordId;
	}
	public void setCpaRecordId(String cpaRecordId)
	{
		this.cpaRecordId = cpaRecordId;
	}
	public String getPreviousStatus()
	{
		return previousStatus;
	}
	public void setPreviousStatus(String previousStatus)
	{
		this.previousStatus = previousStatus;
	}
	public String getNewStatus()
	{
		return newStatus;
	}
	public void setNewStatus(String newStatus)
	{
		this.newStatus = newStatus;
	}
	public String getNote()
	{
		return note;
	}
	public void setNote(String note)
	{
		this.note = note;
	}
	public String getUserId()
	{
		return userId;
	}
	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	public String getEvent()
	{
		return event;
	}
	public void setEvent(String event)
	{
		this.event = event;
	}
	public Timestamp getEventDate()
	{
		return eventDate;
	}
	public void setEventDate(Timestamp eventDate)
	{
		this.eventDate = eventDate;
	}
	@Override
	public String toString()
	{
		return "CpaEvent [recordId=" + recordId + ", cpaRecordId=" + cpaRecordId + ", previousStatus=" + previousStatus + ", newStatus=" + newStatus + ", note=" + note + ", userId=" + userId + ", eventDate=" + eventDate + ", event=" + event + "]";
	}


	
	
}
