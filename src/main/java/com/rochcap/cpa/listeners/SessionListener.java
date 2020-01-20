
package com.rochcap.cpa.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener
{

	@Override
	public void sessionCreated(HttpSessionEvent event)
	{
		System.out.println("==== Session is created ====");
		event.getSession().setMaxInactiveInterval(30 * 60);

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se)
	{
		System.out.println("==== Session is destroyed ====");

	}

}
