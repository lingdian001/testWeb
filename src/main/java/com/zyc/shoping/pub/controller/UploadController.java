package com.zyc.shoping.pub.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/pub")
public class UploadController {

	@RequestMapping(value = "/uploadfile", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> uploadFile(
			@RequestParam(value = "upfile", required = false) MultipartFile file,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String realName = null;
		String uuidName = null;
		String realPath = null;

		try {
			// 文件原来的名称
			realName = file.getOriginalFilename();
			// 得到这个文件的uuidname
			uuidName = this.getUUIDFileName(file.getOriginalFilename());
			// 图片保存的工程
			realPath = request.getServletContext().getRealPath("/images");
			// 得到文件的输入流
			InputStream in = new BufferedInputStream(file.getInputStream());
			// 获得文件的输出流
			OutputStream out = new BufferedOutputStream(new FileOutputStream(
					new File(realPath, uuidName)));
			String rootPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();

			IOUtils.copy(in, out);
			in.close();
			out.close();
			// 将图片信息传递到我的数据库当中
			int flag = 1;

			if (flag != 0) {
				map.put("state", "SUCCESS");// UEDITOR的规则:不为SUCCESS则显示state的内容
				map.put("url", rootPath+"/images/" + uuidName); // 能访问到你现在图片的路径
				map.put("size", file.getSize());
				map.put("type", file.getContentType());
				map.put("original", realName);
				JSONObject jsonObject = JSONObject.fromObject(map);
				response.getWriter().write(jsonObject.toString());
				response.getWriter().flush();
				response.getWriter().close();
			}
		} catch (IOException e) {
			map.put("state", "文件上传失败!"); // 在此处写上错误提示信息，这样当错误的时候就会显示此信息
			map.put("url", "");
			map.put("title", "");
			map.put("original", "");
			e.printStackTrace();
		}
		return null;
	}

	/**
	  * @Description: 取的uuidname防止文件同名问题
	  * @param @param s
	  * @param @param split
	  * @param @return
	 */
	private String getExtName(String s, char split) {
		int i = s.lastIndexOf(split);
		int leg = s.length();
		return i > 0 ? (i + 1) == leg ? " " : s.substring(i + 1, s.length())
				: " ";
	}

	/**
	  * @Description: 生成图片唯一编码
	  * @param @param fileName
	  * @param @return
	 */
	private String getUUIDFileName(String fileName) {
		UUID uuid = UUID.randomUUID();
		StringBuilder sb = new StringBuilder(100);
		sb.append(uuid.toString()).append(".")
				.append(this.getExtName(fileName, '.'));
		return sb.toString();
	}

}
