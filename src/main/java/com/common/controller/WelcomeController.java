package com.common.controller;

import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/initial")
public class WelcomeController {

	private static final Logger logger = Logger.getLogger(WelcomeController.class);
	
	private static boolean isExecute=false;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getWelcome() {

		//logs debug message
		if(logger.isDebugEnabled()){
			logger.debug("getWelcome is executed!");
		}
		
		//logs exception
		logger.error("This is Error message", new Exception("Testing"));
		
		ModelAndView model = new ModelAndView("welcome");
		model.addObject("msg", "Hello Spring MVC + Log4j with GET");
		return model;

	}
	
	
	@RequestMapping(value = "/AjaxCall")
	@ResponseBody
	public ModelAndView getWelcome1() {

		//logs debug message
		if(logger.isDebugEnabled()){
			logger.debug("getWelcome1 is executed!");
		}
		
		//logs exception
		logger.error("This is Error message", new Exception("Testing"));
		
		ModelAndView model = new ModelAndView("welcome");
		model.addObject("msg", "Hello Spring MVC + Log4j with Post");
		return model;

	}

	public void welcomeText(){
		System.out.println("Welcome test method");
	}
	
	@RequestMapping(value = "/randomNoDisplay", method = RequestMethod.GET)
	public ModelAndView randomNoDisplay() {

		//logs debug message
		if(logger.isDebugEnabled()){
			logger.debug("getWelcome is executed!");
		}
		
		//logs exception
		logger.error("This is Error message", new Exception("Testing"));
		
		ModelAndView model = new ModelAndView("RandomNoDisplay");
		model.addObject("msg", "Hello Random Number display");
		return model;

	}
	
	@RequestMapping(value = "/getRandomNo")
	@ResponseBody
	public int getRandomNo() {
		
//		int i=new Double(Math.random()+3*12).intValue();
		Random rand = new Random();

		int i = rand.nextInt(50) + 1;
		
		//logs debug message
		if(logger.isDebugEnabled()){
			logger.debug("getRandomNo is executed!"+i);
		}
		return i;

	}
	
	@RequestMapping(value = "/printRndomNo/{randomNo}")
	public ModelAndView printRndomNo(@PathVariable("randomNo") String randomNo) {

		//logs debug message
		if(logger.isDebugEnabled()){
			logger.debug("printRndomNo is executed!");
		}
		
		logger.debug("Random number is "+ randomNo);
		ModelAndView model = new ModelAndView("RandomNoDisplay");
		model.addObject("msg", "The Random No is"+randomNo);
		return model;

	}
	
	@RequestMapping(value = "/printRndomNoAjax/{randomNo}")
	@ResponseBody
	public String printRndomNoAjax(@PathVariable("randomNo") String randomNo) {

		//logs debug message
		if(logger.isDebugEnabled()){
			logger.debug("printRndomNoAjax is executed!");
		}
		
		logger.debug("Random number is "+ randomNo);
		return "The Random No is "+randomNo;

	}
	
}
