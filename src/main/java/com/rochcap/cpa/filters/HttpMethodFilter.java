
package com.rochcap.cpa.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class HttpMethodFilter extends OncePerRequestFilter
{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException
	{

		if (request.getMethod().equals("OPTIONS"))
			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		else if (request.getMethod().equals("TRACE"))
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		else
			filterChain.doFilter(request, response);

	}
}
