package com.diankangwo.controller;

import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.diankangwo.constant.resultMsg;
import com.diankangwo.dao.InvitationDAO;
import com.diankangwo.dao.UserDAO;
import com.diankangwo.domain.Invitation;
import com.diankangwo.domain.UserInfo;
import com.diankangwo.util.GuidUtil;
import com.diankangwo.util.TokenUtils;

/**
 * 用戶控制器
 * 
 * @author xiaoyu
 *
 */
@Controller
public class UserController {
	@Autowired
	private UserDAO userDao;

	@Resource
	private ReflectionSaltSource saltSource;

	@Resource
	private ShaPasswordEncoder passwordEncoder;
	
	@Autowired
	private InvitationDAO ivtDao;

	/**
	 * 获取指定用户的公开信息
	 * 
	 * @param uid
	 *            用户UID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/users/show", method = RequestMethod.GET)
	public String show(String uid) {
		UserInfo user = userDao.getUserByUid(uid);
		String code = "2";
		String msg = "处理异常！";
		if (user != null) {
			code = "1";
			msg = "查询成功！";
			user.setPassword("");
			user.setSalt_value("");
		}else {
			msg = "未查询到用户信息！";
		}
		return resultMsg.mapToJson(code, msg, user);
	}

	/**
	 * 注册
	 * 
	 * @param tel
	 *            电话号码
	 * @param password
	 *            密码
	 * @param msg_code
	 *            短信验证码
	 * @return json
	 */
	@ResponseBody
	@RequestMapping(value = "/users/reg", method = RequestMethod.POST)
	public String register(String tel, String password, String msgCode,Integer invitedUID,HttpServletRequest req) {
		UserInfo user = new UserInfo();
		user.setTel(tel);
		user.setUid(GuidUtil.getGuid());
		user.setUsername(tel);
		user.setEnabled(true);
		user.setSalt_value(System.currentTimeMillis() + "");
		password = passwordEncoder.encodePassword(password, saltSource.getSalt(user));
		user.setPassword(password);
		user.setAccessToken(TokenUtils.createToken(user.getUid(), req));
		user.setUserGroup(invitedUID);
		String code = "2";
		String msg = "处理异常！";
		if (userDao.getUserByTel(tel) != null) {
			msg = "该手机号码已注册！";
		}else{
			if (userDao.addUser(user)) {
				Invitation ivt = new Invitation();
				ivt.setDate(new Date());
				ivt.setMy_earnings(0.0);
				ivt.setSpending_total(0.0);
				ivt.setFuid(user.getUid());
				ivt.setUid(invitedUID);
				ivt.setUserName(user.getUsername());
				ivtDao.saveOrUpdate(ivt);
				// 处理关键信息
				code = "1";
				msg = "注册成功！";
				user.setPassword("");
				user.setSalt_value("");
			}else {
				msg="系统异常，注册失败！";
			}
		}
		return resultMsg.mapToJson(code, msg, user);
	}

	/**
	 * 修改密码
	 * 
	 * @param msg_code
	 *            短信验证码
	 * @param new_password
	 *            新密码
	 * @param tel
	 *            手机号
	 * @return json
	 */
	@ResponseBody
	@RequestMapping(value = "/users/password", method = RequestMethod.POST)
	public String updatePassWord(String msgCode,String newPassword,String tel) {
		UserInfo user = userDao.getUserByTel(tel);
		String code = "2";
		String msg = "处理异常！";
		if (user != null) {
			if(user.getTel().equals(tel)){
				user.setSalt_value(System.currentTimeMillis() + "");
				newPassword = passwordEncoder.encodePassword(newPassword, saltSource.getSalt(user));
				user.setPassword(newPassword);
				if (userDao.saveOrUpdate(user) != null) {
					code = "1";
					msg = "修改密码成功！";
					user.setPassword("");
					user.setSalt_value("");
				}else {
					msg = "系统异常，修改失败！";
				}
			}
		}else{
			msg = "未查询到用户信息！"; 
		}
		return resultMsg.mapToJson(code, msg, user);
	}

	/**
	 * 修改手机号
	 * 
	 * @param msg_code
	 *            短信验证码
	 * @param new_tel
	 *            新手机号
	 * @param access_token
	 *            token
	 * @param new_tel_msg_code
	 *            新手机号验证码
	 * @return json
	 */
	@ResponseBody
	@RequestMapping(value = "/users/tel", method = RequestMethod.POST)
	public String updatetel(String msgCode, String newTel, String newTelMsgCode, String accessToken,
			HttpServletRequest req) {
		UserInfo user = userDao.getUserByToken(accessToken);
		user.setTel(newTel);
		user.setAccessToken(TokenUtils.createToken(user.getUid(), req));
		String code = "2";
		String msg = "处理异常！";
		if (userDao.updateUser(user)) {
			code = "1";
			msg = "查询成功！";
			user.setPassword("");
			user.setSalt_value("");
		}else{
			msg = "系统异常，修改失败！";
		}
		return resultMsg.mapToJson(code, msg, "");
	}

	/**
	 * 修改个人资料
	 * 
	 * @param profile_image_url
	 *            头像
	 * @param username
	 *            用户名
	 * @param description
	 *            简介
	 * @param access_token
	 *            token
	 * @param gender
	 *            性别
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/users/info", method = RequestMethod.POST)
	public String updatetel(String profileImageUrl, String username, String description, String accessToken,
			boolean gender) {
		UserInfo user = userDao.getUserByToken(accessToken);
		String code = "2";
		String msg = "处理异常！";
		if (user != null) {
			user.setUsername(username);
			user.setDescription(description);
			user.setGender(gender);
			if (userDao.update(user) != null) {
				code = "1";
				msg = "更新成功！";
				user.setPassword("");
				user.setSalt_value("");
			}else{
				msg = "系统异常，修改失败！";
			}
		}else{
			msg = "无效的token!";
		}
		return resultMsg.mapToJson(code, msg, "");
	}

	/**
	 * 注销登陆
	 * 
	 * @param uid
	 *            用户UID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/users/log_out", method = RequestMethod.POST)
	public String login(String accessToken, String getuiCID, HttpServletRequest req) {
		UserInfo user = userDao.getUserByToken(accessToken);
		String code = "2";
		String msg = "注销异常！";
		if (user != null) {
			code = "1";
			msg = "注销成功！";
			user.setPassword("");
			user.setSalt_value("");
		}
		return resultMsg.mapToJson(code, msg, "");
	}

	/**
	 * 用户登录
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @param getui_cid
	 *            个推CID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/users/login", method = RequestMethod.POST)
	public String login(String username, String password, String getui_cid) {
		UserInfo user = userDao.getUserByTel(username);
		String code = "2";
		String msg = "处理异常！";
		if (user != null) {
			password = passwordEncoder.encodePassword(password, user.getSalt_value());
			if (user.getPassword().equals(password)) {
				user.setGetui_cid(getui_cid);
				if (userDao.updateUser(user)) {
					code = "1";
					msg = "查询成功！";
				}
			}else{
				msg="密码错误!";
			}
			user.setPassword(null);
			user.setSalt_value(null);
		}else{
			msg="未查询到用户信息！";
		}
		return resultMsg.mapToJson(code, msg, user);
	}

}