package com.common.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Component
@RequestMapping("/sample")
public class SampleController {
	@RequestMapping("/init")
	public ModelAndView initalMethod(){
		return new ModelAndView();
	}
}
