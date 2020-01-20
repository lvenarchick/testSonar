
package com.rochcap.cpa.ldap;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;

import org.jboss.logging.Logger;

import com.rochcap.cpa.utils.Constants;

public class LdapAuthentication
{
	private static final Logger logger = Logger.getLogger("*** " + LdapAuthentication.class);

	// Domain controllers for ACSBNT
	private static final String BDC1 = "bocaips.acsbnt.ad.net";
	private static final String BDC2 = "bocadc1.acsbnt.ad.net";

	// Domain controllers for ACSNT
	private static final String PDC1 = "pennips1.acsnt.ad.net";
	private static final String PDC2 = " penndc1.acsnt.ad.net";

	// Domain controllers for CCB
	private static final String CDC1 = "ccbips1.ccbbank.net";
	private static final String CDC2 = "ccbdc1.ccbbank.net";

	// Domain controllers for ACSF)
	private static final String FDC1 = "famoffips1.acsfo.appliedcard.com";
	private static final String FDC2 = "famoffdc1.acsfo.appliedcard.com";

	public LdapAuthentication()
	{
	}

	public ArrayList<String> getAuthenticationGroups(String username, String password, String domain)
	{
		// logger.debug("LdapAuthentication.authenticate enter");

		String returnMessage = "";
		Hashtable env = null;
		DirContext ctx = null;
		ArrayList<String> groups = null;
		try
		{
			env = initLdapEnv(username, password, domain);
			if (env == null)
				throw new Exception("env is null.");
			// logger.debug("LdapAuthentication.getAuthenticationGroups (1) - username: " + username);
		}
		catch (Exception e)
		{
			returnMessage = "Domain controllers are not available!";
			logger.error("LdapAuthentication.getAuthenticationGroups - initLdapEnv Exception: ", e);
		}

		try
		{
			if (returnMessage.equalsIgnoreCase(""))
			{

				// Create the initial directory context
				ctx = new InitialLdapContext(env, null);
				// logger.debug("LdapAuthentication.authenticate (2)");

				SearchControls searchCtls = new SearchControls();
				// String returnedAtts[] = { "sn", "givenName", "memberOf", "name", "badPwdCount" }; // Specify the attributes to return
				String returnedAtts[] = { "memberOf", "name" }; // Specify the attributes to return
				searchCtls.setReturningAttributes(returnedAtts);
				searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE); // Specify the search scope
				String searchFilter = "(sAMAccountName=" + username + ")";

				String searchBase = "";
				if (domain.equalsIgnoreCase("ccbbank"))
				{
					searchBase = "DC=" + domain + ",DC=net"; // Specify the Base for the search
				}
				else
				{
					searchBase = "DC=" + domain + ",DC=ad,DC=net"; // Specify the Base for the search
				}

				// logger.debug("LdapAuthentication.authenticate (3) - searchBase: " + searchBase);

				// Search for objects using the filter
				NamingEnumeration answer = ctx.search(searchBase, searchFilter, searchCtls);
				groups = getGroups(answer);

				ctx.close();
			}
		}
		catch (NamingException e)
		{
			logger.error("LdapAuthentication.getAuthenticationGroups NamingException: Invalid user name or password!", e);
			returnMessage = "Invalid user name or password!";

		}
		catch (Exception e)
		{
			logger.error("LdapAuthentication.getAuthenticationGroups Exception: ", e);
			returnMessage = "Authentication error occurred. message: " + e.getMessage();
		}
		finally
		{
			try
			{
				if (ctx != null)
					ctx.close();
			}
			catch (Exception e)
			{
				logger.error("LdapAuthentication.getAuthenticationGroups unable to close connection Exception: ", e);
			}
		}
		return groups;
	}

	private ArrayList<String> getGroups(NamingEnumeration answer) throws Exception
	{
		boolean isAuthenticated = false;
		ArrayList<String> groups = new ArrayList();
		// logger.debug("isAuthenticated - answer has elements: " + answer.hasMoreElements());

		while (answer.hasMoreElements())
		{
			// logger.debug("isAuthenticated - answer had elements");
			SearchResult sr = (SearchResult) answer.next();
			Attributes attrs = sr.getAttributes();

			if (attrs != null)
			{
				NamingEnumeration memberOf = attrs.get("memberOf").getAll();
				String name = (String) attrs.get("name").get();
				// logger.debug("getGroups - ldap name: " + name);

				while (memberOf.hasMoreElements())
				{
					String group = memberOf.next().toString();
					logger.debug("getGroups - group: " + group);

//TODO:					
//					if (group.toUpperCase().startsWith("CN=" + Constants.DOMAIN_GROUP_CPA))
//					{
						groups.add("cpa");
						logger.debug("getGroups - added " + Constants.DOMAIN_GROUP_CPA);
//					}
				}
				// logger.debug("isAuthenticated (FINAL VALUE) isAuthenticated: " + isAuthenticated);
			}
		}
		return groups;
	}

	public String authenticate(String username, String password, String domain)
	{
		logger.debug("LdapAuthentication.authenticate enter");

		String returnMessage = "";
		Hashtable env = null;
		DirContext ctx = null;
		try
		{
			env = initLdapEnv(username, password, domain);
			if (env == null)
				throw new Exception("env is null.");
			logger.debug("LdapAuthentication.authenticate - username: " + username);
		}
		catch (Exception e)
		{
			returnMessage = "Domain controllers are not available!";
			logger.error("LdapAuthentication.authenticate - initLdapEnv Exception: ", e);
		}

		try
		{
			if (returnMessage.equalsIgnoreCase(""))
			{

				// Create the initial directory context
				ctx = new InitialLdapContext(env, null);
				// logger.debug("LdapAuthentication.authenticate (2)");

				SearchControls searchCtls = new SearchControls();
				// String returnedAtts[] = { "sn", "givenName", "memberOf", "name", "badPwdCount" }; // Specify the attributes to return
				String returnedAtts[] = { "memberOf", "name" }; // Specify the attributes to return
				searchCtls.setReturningAttributes(returnedAtts);
				searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE); // Specify the search scope
				String searchFilter = "(sAMAccountName=" + username + ")";

				String searchBase = "";
				if (domain.equalsIgnoreCase("ccbbank"))
				{
					searchBase = "DC=" + domain + ",DC=net"; // Specify the Base for the search
				}
				else
				{
					searchBase = "DC=" + domain + ",DC=ad,DC=net"; // Specify the Base for the search
				}

				// logger.debug("LdapAuthentication.authenticate (3) - searchBase: " + searchBase);

				// Search for objects using the filter
				NamingEnumeration answer = ctx.search(searchBase, searchFilter, searchCtls);
				boolean auth = isAuthenticated(answer);
				if (!auth)
				{
					returnMessage = "Invalid user name or password!";
					logger.warn("LdapAuthentication.authenticate - Invalid user name or password!");
				}
				else
				{
					logger.info("LdapAuthentication.authenticate - user: " + username + ", authenticated: " + auth);
				}
				ctx.close();
			}
		}
		catch (NamingException e)
		{
			logger.error("LdapAuthentication.authenticate NamingException: Invalid user name or password!", e);
			returnMessage = "Invalid user name or password!";

		}
		catch (Exception e)
		{
			logger.error("LdapAuthentication.authenticate Exception: ", e);
			returnMessage = "Authentication error occurred. message: " + e.getMessage();
		}
		finally
		{
			try
			{
				if (ctx != null)
					ctx.close();
			}
			catch (Exception e)
			{
				logger.error("LdapAuthentication.authenticate unable to close connection Exception: ", e);
			}
		}
		return returnMessage;
	}

	private boolean isAuthenticated(NamingEnumeration answer) throws Exception
	{
		boolean isAuthenticated = false;
		String group = null;
		// logger.debug("isAuthenticated - answer has elements: " + answer.hasMoreElements());
		while (answer.hasMoreElements())
		{
			// logger.debug("isAuthenticated - answer had elements");
			SearchResult sr = (SearchResult) answer.next();
			Attributes attrs = sr.getAttributes();

			if (attrs != null)
			{
				NamingEnumeration memberOf = attrs.get("memberOf").getAll();
				String name = (String) attrs.get("name").get();
				// logger.debug("isAuthenticated - ldap name: " + name);

				while (memberOf.hasMoreElements())
				{
					group = memberOf.next().toString();
					// logger.debug("isAuthenticated - group: " + group);

					// parse groups to see if they are auth toi use tool
//TODO:					
//					if (group.toUpperCase().startsWith("CN=" + (Constants.DOMAIN_GROUP_CPA).trim())					)
//					{
						isAuthenticated = true;
						logger.debug("isAuthenticated (GROUP COMPARE) isAuthenticated: " + isAuthenticated);
						break;
//					}
				}
				// logger.debug("isAuthenticated (FINAL VALUE) isAuthenticated: " + isAuthenticated);
			}
		}
		return isAuthenticated;
	}

	private Hashtable initLdapEnv(String username, String password, String domain) throws Exception
	{
		String domainControllerName = getDomainController(domain);
		// logger.debug("LdapAuthentication.initLdapEnv - username: " + username + ", domain: " + domain + ", domainControllerName: " + domainControllerName);

		if (domainControllerName == null)
			return null;

		String ldapURL = "ldap://" + domainControllerName + ":" + "389" + "/";
		// logger.debug("LdapAuthentication.initLdapEnv - ldapURL: " + ldapURL);
		Hashtable env = new Hashtable();
		env.put(Context.PROVIDER_URL, ldapURL);
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.REFERRAL, "follow");
		env.put(Context.SECURITY_AUTHENTICATION, "simple");

		String securityPrin = "";
		if (domain.equalsIgnoreCase("ccbbank"))
		{
			securityPrin = username + "@" + domain + ".net";
			// logger.debug("LdapAuthentication.initLdapEnv - securityPrin1: " + securityPrin);
		}
		else
		{
			securityPrin = username + "@" + domain + ".ad.net";
			// logger.debug("LdapAuthentication.initLdapEnv - securityPrin2: " + securityPrin);
		}
		env.put(Context.SECURITY_PRINCIPAL, securityPrin);
		env.put(Context.SECURITY_CREDENTIALS, password);

		return env;
	}

	private String getDomainController(String domain) throws Exception
	{
		String domainController = null;
		if (domain.equalsIgnoreCase("acsbnt"))
		{
			if (sendPingRequest(BDC1))
				domainController = BDC1;
			else if (sendPingRequest(BDC2))
				domainController = BDC2;
		}
		else if (domain.equalsIgnoreCase("acsnt"))
		{
			if (sendPingRequest(PDC1))
				domainController = PDC1;
			else if (sendPingRequest(PDC2))
				domainController = PDC2;
		}
		else if (domain.equalsIgnoreCase("ccbbank"))
		{
			if (sendPingRequest(CDC1))
				domainController = CDC1;
			else if (sendPingRequest(CDC2))
				domainController = CDC2;
		}
		else if (domain.equalsIgnoreCase("acsfo"))
		{
			if (sendPingRequest(FDC1))
				domainController = FDC1;
			else if (sendPingRequest(FDC2))
				domainController = FDC2;
		}

		// logger.debug("getDomainController - domainController: " + domainController);
		return domainController;
	}

	public boolean sendPingRequest(String ipAddress) throws UnknownHostException, IOException
	{
		// logger.debug("sendPingRequest - ipaddress: " + ipAddress);

		boolean isReachable = false;

		InetAddress ia = InetAddress.getByName(ipAddress);
		if (ia.isReachable(5000))
		{
			// logger.debug("sendPingRequest - ipaddress " + ipAddress + " is reachable");
			isReachable = true;
		}
		else
		{
			// logger.debug("sendPingRequest - ipaddress " + ipAddress + " is notreachable");
		}
		return isReachable;
	}

}