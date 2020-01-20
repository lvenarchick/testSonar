
package com.rochcap.cpa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;

import com.rochcap.cpa.controllers.RequestController;

@Repository
public class ValidationDAO
{
	@Resource(lookup = "java:/DEFAULT_DB2DS")
	DataSource dataSource;

	public ValidationDAO()
	{
	};

	private static final Logger logger = Logger.getLogger("*** " + ValidationDAO.class);

	public boolean isValidZipState(String zipCode, String state)
	{
		boolean validZip = false;
		try (
				Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM APPZPST WHERE APZIP5 = ? AND APST = ?");)
		{
			ps.setString(1, zipCode);
			ps.setString(2, state);

			try (ResultSet rs = ps.executeQuery())
			{
				while (rs.next())
					validZip = (rs.getInt(1) > 0 ? true : false);
			}

			logger.debug(String.format("Zip Code: %s, State: %s - isValidZipState: %s", zipCode, state, validZip));
		}
		catch (Exception ex)
		{
			logger.error("Exception in ValidationDAO.isValidZipState: " + ex.getMessage());
			ex.printStackTrace();
		}
		finally
		{
		}
		return validZip;
	}	
	
//	public boolean isValidPhoneNumber(String areaCode, String exchange)
//	{
//		boolean validPhone = false;
//		try (
//				Connection conn = dataSource.getConnection();
//				PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM CHPHONE WHERE PHNPA = ? AND PHNXX = ?");)
//		{
//			ps.setString(1, areaCode);
//			ps.setString(2, exchange);
//
//			try (ResultSet rs = ps.executeQuery())
//			{
//				while (rs.next())
//					validPhone = (rs.getInt(1) > 0 ? true : false);
//			}
//
//			logger.debug(String.format("Area Code: %s, Exchange: %s - isValidPhoneNumber: %s", areaCode, exchange, validPhone));
//		}
//		catch (Exception ex)
//		{
//			logger.error("Exception in ValidationDAO.isValidPhoneNumber:" + ex.getMessage());
//			ex.printStackTrace();
//		}
//		finally
//		{
//		}
//		return validPhone;
//	}



//	public boolean isValidDomain(String email)
//	{
//		boolean validDomain = false;
//		try (
//				Connection conn = dataSource.getConnection();
//				PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM APPDOMAIN WHERE APDOMN = ?");)
//		{
//			String emailDomainName = email.substring(email.lastIndexOf(".") + 1);
//
//			ps.setString(1, emailDomainName.toLowerCase());
//
//			try (ResultSet rs = ps.executeQuery())
//			{
//				while (rs.next())
//					validDomain = (rs.getInt(1) > 0 ? true : false);
//			}
//
//			logger.debug(String.format("Email domain: %s is %s domain", emailDomainName, (validDomain ? "a valid" : "an invalid")));
//		}
//		catch (Exception ex)
//		{
//			logger.error("Exception in ValidationDAO.isValidDomain: " + ex.getMessage());
//			ex.printStackTrace();
//		}
//		finally
//		{
//		}
//		return validDomain;
//	}
}
