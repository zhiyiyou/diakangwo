package com.diankangwo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.diankangwo.constant.resultMsg;
import com.diankangwo.dao.BrowseLogDAO;
import com.diankangwo.dao.UserDAO;
import com.diankangwo.domain.BrowseLog;
import com.diankangwo.domain.UserInfo;
import net.sf.json.JSONArray;

/**
 * 浏览记录控制器
 * 
 * @author xiaoyu
 *
 */
@Controller
public class BrowseLogController {

	@Autowired
	private UserDAO userDao;
	@Autowired
	private BrowseLogDAO browseLogDAO;
	
	/**
	 * 获取浏览记录列表
	 * @param accessToken
	 * @param sort
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/browse_log", method = RequestMethod.GET)
	public String show(String accessToken,String sort,String type) {
		UserInfo user = userDao.getUserByToken(accessToken);
		String code = "2";
		String msg = "处理异常！";
		List<BrowseLog>  blList = null;
		if (user != null) {
			blList = browseLogDAO.getUserByUid(accessToken, sort);
			if (blList != null) {
				code = "1";
				msg = "查询成功！";
			}else {
				msg = "未查询到浏览记录！";
			}
		}else {
			msg = "未查询到用户信息！";
		}
		return resultMsg.mapToJson(code, msg, blList);
	}
	
	/**
	 * 删除浏览记录数据
	 * @param accessToken
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/browse_log/del", method = RequestMethod.POST)
	public String del(String accessToken,String id) {
		UserInfo user = userDao.getUserByToken(accessToken);
		String code = "2";
		String msg = "处理异常！";
		if (user != null) {
			try {
				JSONArray json = JSONArray.fromObject(id); // 首先把字符串转成 JSONArray 对象
				List l = JSONArray.toList(json);
				for (Object object : l) {
					browseLogDAO.deleteById(id);
				}
				code = "1";
				msg = "删除成功！";
			} catch (Exception e) {
				msg = "删除异常!";
			}
		}else {
			msg = "未查询到用户信息！";
		}
		return resultMsg.mapToJson(code, msg, null);
	}
}
