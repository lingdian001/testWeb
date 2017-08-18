package com.zyc.business.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyc.business.user.model.UserPo;
import com.zyc.business.user.model.UserVo;
import com.zyc.business.user.service.IUserService;
import com.zyc.sys.base.model.CurrentPage;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;

	@RequestMapping("/showUser")  
    public String toIndex(HttpServletRequest request,Model model){  
        String loginId = request.getParameter("loginId");  
        UserVo user = this.userService.getUserById(loginId);  
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
		
	}
	
	
}