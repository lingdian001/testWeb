package com.zyc.sys.base;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class BaseController {
	
	@Autowired
	private  HttpServletRequest request;
	@Autowired
	private  HttpServletResponse response;
	
	
	/**
	 * 客户端返回JSON字符串
	 * @author baijie
	 * @param response
	 * @param Map<String, Object>
	 * @return
	 * @throws IOException 
	 */
	public void returnJson(HttpServletResponse response,  Object object) throws IOException {
		JSONObject jsonObj = JSONObject.fromObject(object);
        response.getWriter().write(jsonObj.toString());
	}
	
	/**
	 * 客户端返回字符串
	 * @param response
	 * @param string
	 * @return
	 */
	public String returnString(String string) {
		try {
			response.reset();
	        response.setContentType("text/xml; charset=UTF-8");
	        response.setCharacterEncoding("UTF-8");
			response.getWriter().print(string);
			return null;
		} catch (IOException e) {
			return null;
		}
	}
	
	
}
