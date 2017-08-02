package com.zyc.shoping.sys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/sys")
public class SysController{

	/**
	  * @Description: 登录系统
	  * @param @param request
	  * @param @param response
	  * @param @return
	  * @param @throws Exception
	 */
	@RequestMapping("/toFunPage")
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String pageName = request.getParameter("pageName");
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("WEB-INF/jsp/"+pageName);  
		return mv;  
	}
	
	
	
}
