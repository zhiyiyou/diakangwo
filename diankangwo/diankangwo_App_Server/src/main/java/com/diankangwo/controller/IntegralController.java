package com.diankangwo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.diankangwo.constant.resultMsg;
import com.diankangwo.dao.IntegralDAO;
import com.diankangwo.dao.IntegralInfoDAO;
import com.diankangwo.dao.UserDAO;
import com.diankangwo.domain.Integral;
import com.diankangwo.domain.IntegralInfo;
import com.diankangwo.domain.UserInfo;

/**
 * 用户积分控制器
 * 
 * @author xiaoyu
 *
 */
@Controller
public class IntegralController {
	@Autowired
	private UserDAO userDao;

	@Autowired
	private IntegralDAO integralDao;
	
	@Autowired
	private IntegralInfoDAO integralInfoDao;

	/**
	 * 获取用户积分信息
	 * 
	 * @param accessToken
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/integral", method = RequestMethod.GET)
	public String show(String accessToken) {
		UserInfo user = userDao.getUserByToken(accessToken);
		String code = "2";
		String msg = "处理异常！";
		if (user != null) {
			code = "1";
			msg = "查询成功！";
			user.setPassword("");
			user.setSalt_value("");
		} else {
			msg = "未查询到用户信息！";
		}
		return resultMsg.mapToJson(code, msg, user);
	}

	/**
	 * 获取用户积分列表
	 * 
	 * @param accessToken
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/integral/list", method = RequestMethod.GET)
	public String integralList(String accessToken) {
		UserInfo user = userDao.getUserByToken(accessToken);
		String code = "2";
		String msg = "处理异常！";
		List<Integral> integralList = null;
		if (user != null) {
			integralList = integralDao.getUserByUid(user.getUid());
			if (integralList != null) {
				code = "1";
				msg = "查询成功！";
				user.setPassword("");
				user.setSalt_value("");
			}else {
				msg = "未查询到积分信息！";
			}
		} else {
			msg = "未查询到用户信息！";
		}
		return resultMsg.mapToJson(code, msg, integralList);
	}

	/**
	 * 获取积分说明信息
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/integral/info", method = RequestMethod.GET)
	public String info() {
		List<IntegralInfo> IntegralInfoList = integralInfoDao.findAll();
		String code = "2";
		String msg = "处理异常！";
		if (IntegralInfoList != null) {
			code = "1";
			msg = "查询成功！";
		} else {
			msg = "未查询到积分信息！";
		}
		return resultMsg.mapToJson(code, msg, IntegralInfoList);
	}
}
