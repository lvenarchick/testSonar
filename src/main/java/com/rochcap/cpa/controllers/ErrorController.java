
package com.rochcap.cpa.controllers;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rochcap.cpa.utils.Constants;

@Controller
public class ErrorController
{
	@Autowired
	ServletContext context;
	
	@RequestMapping(value = "errors", method = RequestMethod.GET)
	public ModelAndView renderErrorPage(HttpServletRequest httpRequest)
	{
		return new ModelAndView("serverError");
	}

	@RequestMapping(value = "errors", method = RequestMethod.POST)
	public ModelAndView renderErrorPage2(HttpServletRequest httpRequest, ModelMap model)
	{
		return new ModelAndView("serverError");
	}
}
