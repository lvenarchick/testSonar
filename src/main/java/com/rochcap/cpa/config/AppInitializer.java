
package com.rochcap.cpa.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.jboss.logging.Logger;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.rochcap.cpa.listeners.AppRequestContextListener;
import com.rochcap.cpa.listeners.SessionListener;
import com.rochcap.cpa.utils.Constants;
import com.rochcap.cpa.validators.RequestValidator;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
	private static final Logger log = Logger.getLogger("*** " + AppInitializer.class);
	
	@Override
	protected Class<?>[] getRootConfigClasses()
	{
		return new Class[] { WebMvcConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses()
	{
		return new Class[] { SecurityConfig.class };
	}

	@Override
	protected String[] getServletMappings()
	{
		return new String[] { "/" };
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException
	{
		super.onStartup(servletContext);
		servletContext.addListener(new SessionListener());
		servletContext.addListener(new AppRequestContextListener());
		servletContext.getSessionCookieConfig().setHttpOnly(true);
		servletContext.getSessionCookieConfig().setSecure(true);
		
		String domainName = System.getProperty("cpa-website-domain-name");
		if(domainName == null || (!domainName.equalsIgnoreCase(Constants.WEBSITE_DOMAIN_NAME_AB) &&
		   !domainName.equalsIgnoreCase(Constants.WEBSITE_DOMAIN_NAME_CARBON)))
			throw new ServletException("The Wildfly System Property 'cpa-website-domain-name' has not been setup correctly.");
		else
		{	
			servletContext.setAttribute("cpa-website-domain-name", domainName);
			if(domainName.equalsIgnoreCase(Constants.WEBSITE_DOMAIN_NAME_AB))
			{
				servletContext.setAttribute("cpa-website-name", Constants.WEBSITE_NAME_AB);
				servletContext.setAttribute("cpa-website-favicon-name", Constants.WEBSITE_FAVICON_NAME_AB);
				servletContext.setAttribute("cpa-website-href_url", Constants.WEBSITE_HREF_URL_AB);
				servletContext.setAttribute("cpa-website-jsdisabled-url", Constants.WEBSITE_JSDISABLED_URL_AB);
				servletContext.setAttribute("cpa-website-logo-name", Constants.WEBSITE_LOGO_NAME_AB);
				servletContext.setAttribute("cpa-website-logo-height", Constants.WEBSITE_LOGO_HEIGHT_AB);
				servletContext.setAttribute("cpa-website-logo-width", Constants.WEBSITE_LOGO_WIDTH_AB);
				servletContext.setAttribute("cpa-website-address", Constants.WEBSITE_ADDRESS_AB);
				servletContext.setAttribute("cpa-website-phone", Constants.WEBSITE_PHONE_AB);
				servletContext.setAttribute("cpa-website-assistance-phone", Constants.WEBSITE_REQUEST_ASSISTANCE_PHONE_AB);
			}
			else if (domainName.equalsIgnoreCase(Constants.WEBSITE_DOMAIN_NAME_CARBON))
			{		
				servletContext.setAttribute("cpa-website-name", Constants.WEBSITE_NAME_CARBON);
				servletContext.setAttribute("cpa-website-favicon-name", Constants.WEBSITE_FAVICON_NAME_CARBON);
				servletContext.setAttribute("cpa-website-href-url", Constants.WEBSITE_HREF_URL_CARBON);
				servletContext.setAttribute("cpa-website-jsdisabled-url", Constants.WEBSITE_JSDISABLED_URL_CARBON);
				servletContext.setAttribute("cpa-website-logo-name", Constants.WEBSITE_LOGO_NAME_CARBON);
				servletContext.setAttribute("cpa-website-logo-height", Constants.WEBSITE_LOGO_HEIGHT_CARBON);
				servletContext.setAttribute("cpa-website-logo-width", Constants.WEBSITE_LOGO_WIDTH_CARBON);
				servletContext.setAttribute("cpa-website-address", Constants.WEBSITE_ADDRESS_CARBON);
				servletContext.setAttribute("cpa-website-phone", Constants.WEBSITE_PHONE_CARBON);
				servletContext.setAttribute("cpa-website-assistance-phone", Constants.WEBSITE_REQUEST_ASSISTANCE_PHONE_CARBON);
			}
			
			log.info("onStartup - Initialization Complete. Website Name: " + servletContext.getAttribute("cpa-website-name"));
		}	
	}
}
