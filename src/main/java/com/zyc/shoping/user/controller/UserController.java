package com.zyc.shoping.user.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyc.shoping.sys.util.CurrentPage;
import com.zyc.shoping.user.model.User;
import com.zyc.shoping.user.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;

	@RequestMapping("/showUser")  
    public String toIndex(HttpServletRequest request,Model model){  
        String loginId = request.getParameter("loginId");  
        User user = this.userService.getUserById(loginId);  
        model.addAttribute("user", user);  
        return "hello";  
    }
	
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
		 String username = request.getParameter("username");
		 CurrentPage<Map<String,String>> currentPage = new CurrentPage<Map<String,String>>();
		 List<Map<String,String>> pageList = new ArrayList<Map<String,String>>();
		 
		 Map<String,String> pageMap1 = new HashMap<String,String>();
		 pageMap1.put("email", "name1");
		 pageMap1.put("userName", "status1");
		 pageMap1.put("sex", "1");
		 pageMap1.put("age", "10");
		 pageMap1.put("telphone", "2017-01");
		 pageMap1.put("loginId", "1");
		 
		 Map<String,String> pageMap2 = new HashMap<String,String>();
		 pageMap2.put("email", "name1");
		 pageMap2.put("userName", "status1");
		 pageMap2.put("sex", "1");
		 pageMap2.put("age", "10");
		 pageMap2.put("telphone", "2017-01");
		 pageMap2.put("loginId", "1");
		 
		 pageList.add(pageMap1);
		 pageList.add(pageMap2);
		 currentPage.setPageItems(pageList);
		 currentPage.setTotal(100);
		 return currentPage;
	}
	
	/**
	  * @Description: 重置密码为"111111"
	  * @param @param request
	  * @param @param response
	 */
	public void resetPassword(HttpServletRequest request,HttpServletResponse response){
		String loginId = request.getParameter("loginId");
		
	}
	
	
}