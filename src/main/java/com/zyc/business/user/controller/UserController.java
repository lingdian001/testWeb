package com.zyc.business.user.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyc.business.user.model.UserPo;
import com.zyc.business.user.model.UserVo;
import com.zyc.business.user.service.IUserService;
import com.zyc.sys.base.model.CurrentPage;
import com.zyc.sys.util.usual.MD5Util;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;

	/**
	  * @Description: 分页查询所有用户
	  * @param
	 */
	@RequestMapping("/selectUsers")
	@ResponseBody
	public Object selectUsers(HttpServletRequest request,HttpServletResponse response){
		 String pageNumber = request.getParameter("pageNumber");
		 String pageSize = request.getParameter("pageSize");
		 String loginId = request.getParameter("loginId");
		 String userName = request.getParameter("username");
		 UserVo userVo = new UserVo();
		 userVo.setLoginId(loginId);
		 userVo.setUserName(userName);
		 CurrentPage<UserPo,UserVo> currentPage = new CurrentPage<UserPo,UserVo>();
		 currentPage.setParamObject(userVo);
		 currentPage.setPageNo(Integer.parseInt(pageNumber));
		 currentPage.setPageSize(Integer.parseInt(pageSize));
		 CurrentPage<UserPo,UserVo> resutlPage = userService.getUsers(currentPage);
		 return resutlPage;
	}
	
	/**
	  * @Description: 重置密码为"111111"
	  * @param @param request
	  * @param @param response
	 */
	public void resetPassword(HttpServletRequest request,HttpServletResponse response){
		String loginId = request.getParameter("loginId");
		response.setContentType("text/xml;charset=utf-8");     
	    response.setHeader("Cache-Control","no-cache");
	    UserPo userPo = new UserPo();
	    userPo.setLoginId(loginId);
	    userPo.setPassword(MD5Util.getMD5("111111"));
		boolean isSuccess=this.userService.updateUser(userPo);;
		try {
			JSONObject jsobjcet = new JSONObject();  
	        jsobjcet.put("isSuccess", isSuccess);
	        response.getWriter().write(jsobjcet.toString());
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	  * @Description: 根据登录账号查询用户信息
	  * @param @param request
	  * @param @param response
	 */
	@RequestMapping("/checkUser")
	public void checkUser(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/xml;charset=utf-8");     
	    response.setHeader("Cache-Control","no-cache");
		String loginId = request.getParameter("loginId");
		UserPo user = this.userService.getUserById(loginId);
		boolean isExist=false;
		if(user !=null){
			isExist=true;
		}
		try {
			JSONObject jsobjcet = new JSONObject();  
	        jsobjcet.put("valid", !isExist);
	        response.getWriter().write(jsobjcet.toString());
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	  * @Description: 保存用户
	  * @param @param request
	  * @param @param response
	 */
	@RequestMapping("/saveUser")
	public void saveUser(@ModelAttribute UserPo userPo,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/xml;charset=utf-8");     
	    response.setHeader("Cache-Control","no-cache");
	    userPo.setPassword(MD5Util.getMD5(userPo.getPassword()));
		boolean isSuccess=this.userService.saveUser(userPo);;
		try {
			JSONObject jsobjcet = new JSONObject();  
	        jsobjcet.put("isSuccess", isSuccess);
	        response.getWriter().write(jsobjcet.toString());
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	  * @Description: 根据账号查询用户
	  * @param @param request
	  * @param @param response
	 */
	@RequestMapping("/getUserById")  
    public void getUserById(HttpServletRequest request,HttpServletResponse response){  
        String loginId = request.getParameter("loginId");  
        UserPo user = this.userService.getUserById(loginId);  
        try {
			JSONObject jsobjcet = new JSONObject();  
	        jsobjcet.put("user", user);
	        response.getWriter().write(jsobjcet.toString());
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	/**
	  * @Description: 更新用户
	  * @param @param request
	  * @param @param response
	 */
	@RequestMapping("/updateUser")
	public void updateUser(@ModelAttribute UserPo userPo,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/xml;charset=utf-8");     
	    response.setHeader("Cache-Control","no-cache");
		boolean isSuccess=this.userService.updateUser(userPo);;
		try {
			JSONObject jsobjcet = new JSONObject();  
	        jsobjcet.put("isSuccess", isSuccess);
	        response.getWriter().write(jsobjcet.toString());
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	  * @Description: 删除用户
	  * @param @param request
	  * @param @param response
	 */
	@RequestMapping("/deleteUser")
	public void deleteUser(@ModelAttribute UserPo userPo,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/xml;charset=utf-8");     
	    response.setHeader("Cache-Control","no-cache");
		boolean isSuccess=this.userService.updateUser(userPo);;
		try {
			JSONObject jsobjcet = new JSONObject();  
	        jsobjcet.put("isSuccess", isSuccess);
	        response.getWriter().write(jsobjcet.toString());
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}