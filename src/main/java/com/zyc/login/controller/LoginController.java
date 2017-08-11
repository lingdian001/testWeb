package com.zyc.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zyc.login.service.ILoginService;
import com.zyc.user.model.User;

@Controller
@RequestMapping("/login")
public class LoginController{
	@Autowired
	private ILoginService loginService;
	
	/**
	  * @Description: 登录系统
	  * @param @param request
	  * @param @param response
	  * @param @return
	  * @param @throws Exception
	 */
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView(); 
		User user=loginService.login("zyc", "123456");
		mv.addObject("user", user);  
		mv.addObject("message", "Hello World!");  
		mv.setViewName("WEB-INF/jsp/admin");  
		return mv;  
	}
	
	@RequestMapping("/loginOut")
	public ModelAndView loginOut(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView(); 
		User user=loginService.login("zyc", "123456");
		mv.addObject("user", user);  
		mv.addObject("message", "Hello World!");  
		mv.setViewName("WEB-INF/jsp/login");  
		return mv;  
	}
	
}
