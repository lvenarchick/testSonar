
package com.rochcap.cpa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;

import com.rochcap.cpa.models.CpaEvent;
import com.rochcap.cpa.models.CpaRequest;

@Repository
public class RequestDataDAO
{
	@Resource(lookup = "java:/DEFAULT_DB2DS")
	DataSource dataSource;
	
	private static final Logger logger = Logger.getLogger("*** " + RequestDataDAO.class);
	
	public RequestDataDAO()
	{}

	public boolean writeRequestData(CpaRequest cpaRequest)
	{
		boolean success = false;
		String query = "INSERT INTO CPAREQUEST " +
				" VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(query);)
		{

			//logger.debug("writeRequestData toString: " + cpaRequest.toString());
			ps.setString(1, cpaRequest.getRecordId());
			ps.setString(2, cpaRequest.getRequester());
			ps.setString(3, cpaRequest.getAgencyName());
			ps.setString(4, cpaRequest.getAgencyAddress());
			ps.setString(5, cpaRequest.getAgencyCity());
			ps.setString(6, cpaRequest.getAgencyState());
			ps.setString(7, cpaRequest.getAgencyZip());
			ps.setString(8, cpaRequest.getAgentFirstName());
			ps.setString(9, cpaRequest.getAgentMiddleName());
			ps.setString(10, cpaRequest.getAgentLastName());
			ps.setString(11, cpaRequest.getAgentAddress());
			ps.setString(12, cpaRequest.getAgentCity());
			ps.setString(13, cpaRequest.getAgentState());
			ps.setString(14, cpaRequest.getAgentZip());
			ps.setString(15, cpaRequest.getAgentDob());
			ps.setString(16, cpaRequest.getAgentSsnLastFour());
			ps.setString(17, cpaRequest.getAssociateId());
			ps.setString(18, cpaRequest.getSubmittedToFdrDate());
			ps.setString(19, cpaRequest.getRequestTypeCategories());
			ps.setString(20, cpaRequest.getRequestTypeSpecific());
			ps.setString(21, cpaRequest.getRequestTypeDelete());
			ps.setString(22, cpaRequest.getRequestTypeOptOut());
			ps.setString(23, cpaRequest.getConsumerFirstName());
			ps.setString(24, cpaRequest.getConsumerMiddleName());
			ps.setString(25, cpaRequest.getConsumerLastName());
			ps.setString(26, cpaRequest.getConsumerAddress());
			ps.setString(27, cpaRequest.getConsumerApartment());
			ps.setString(28, cpaRequest.getConsumerCity());
			ps.setString(29, cpaRequest.getConsumerState());
			ps.setString(30, cpaRequest.getConsumerZip());
			ps.setString(31, cpaRequest.getConsumerPhone());
			ps.setString(32, cpaRequest.getConsumerDob());
			ps.setString(33, cpaRequest.getConsumerSsnLastFour());
			ps.setString(34, cpaRequest.getConsumerEmailAuthorization());
			ps.setString(35, cpaRequest.getConsumerEmail());
			ps.setString(36, cpaRequest.getDocId());
			ps.setString(37, cpaRequest.getPerjuryConfirmation());
			ps.setString(38, cpaRequest.getRequestStatus());
			ps.setString(39, cpaRequest.getIpAddress());
			ps.setString(40, cpaRequest.getDateEntered());
			ps.setString(41, cpaRequest.getTenDayResponseDueDate());
			ps.setString(42, cpaRequest.getFourtyFiveDayResponseDueDate());
			ps.setString(43, cpaRequest.getNintyDayResponseDueDate());

			ps.executeUpdate();
			success = true;
		}
		catch (Exception ex)
		{
			logger.error("writeRequestData Exception: ", ex);
			
		}
		finally
		{
		}

		return success;
	}
	
	public boolean writeRequestEvent(CpaEvent cpaEvent)
	{
		boolean success = false;
		String query = "INSERT INTO CPAEVENT " +
				"(RECORDID,CPAREQRECORDID,PREVSTATUS,NEWSTATUS,NOTE,USERID,EVENTDATE,EVENT) " +
				" VALUES(?,?,?,?,?,?,?,?)";
		
		try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(query);)
		{
			//logger.debug("writeRequestEvent toString: " + cpaEvent.toString());
			
			ps.setString(1, cpaEvent.getRecordId());
			ps.setString(2, cpaEvent.getCpaRecordId());
			ps.setString(3, "");
			ps.setString(4, cpaEvent.getNewStatus().toUpperCase());
			ps.setString(5, "");
			ps.setString(6, cpaEvent.getUserId().toUpperCase());
			ps.setTimestamp(7, cpaEvent.getEventDate());
			ps.setString(8, cpaEvent.getEvent().toUpperCase());
			
			ps.executeUpdate();
			success = true;
		}
		catch (Exception ex)
		{
			logger.error("writeRequestEvent Exception: ", ex);
		}
		finally
		{
		}

		return success;
	}
}
