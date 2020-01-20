
package com.rochcap.cpa.interceptor;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.rochcap.cpa.utils.DataSecurityViolationDetection;

public class SessionManager implements HandlerInterceptor
{
	public static final Logger logger = Logger.getLogger("*** " + SessionManager.class);

	// Validates if the user has been authenticated.
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
		boolean returnValue = true;

		// XXS Evaluation
		DataSecurityViolationDetection dataSecurityViolationDetection = new DataSecurityViolationDetection();
		Map<String, String[]> m = request.getParameterMap();
		Set<?> s = m.entrySet();
		Iterator<?> it = s.iterator();
		while (it.hasNext())
		{
			boolean quit = false;
			@SuppressWarnings("unchecked")
			Map.Entry<String, String[]> entry = (Map.Entry<String, String[]>) it.next();

			//String key = entry.getKey();
			String[] value = entry.getValue();
			// logger.debug("preHandle XXS Evaluation - key: " + key + ", value: " + value[0]);
			if (value.length > 1)
			{
				for (int i = 0; i < value.length; i++)
				{
					if (dataSecurityViolationDetection.detect(value[i]))
					{
						returnValue = false;
						quit = true;
						break;
					}
				}
			}
			else
			{
				if (dataSecurityViolationDetection.detect(value[0]))
				{
					returnValue = false;
					quit = true;
				}
			}

			if (quit)
				break;
		}
		logger.debug("XXS/HTML Intrusion Detected: " + !returnValue);
		return returnValue;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
	{

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception
	{

	}
}
