package com.diankangwo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.diankangwo.constant.resultMsg;
import com.diankangwo.dao.InvitationDAO;
import com.diankangwo.dao.MyEarningsDAO;
import com.diankangwo.dao.UserDAO;
import com.diankangwo.domain.Invitation;
import com.diankangwo.domain.MyEarnings;
import com.diankangwo.domain.UserInfo;
import com.diankangwo.dto.invitationDto;

/**
 * 分享控制器
 * @author xiaoyu
 *
 */
@Controller
public class InvitationController {

	@Autowired
	private InvitationDAO invitationDao;
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private MyEarningsDAO meDao;
	
	/**
	 * 获取我的邀请信息
	 * @param uid 用户UID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/invitation", method = RequestMethod.GET)
	public String getInvitation(String accessToken){
		Map<String, Object> mapJson = new HashMap<String, Object>();
		UserInfo user = userDao.getUserByToken(accessToken);
		List<Invitation> ivtList  = null;
		double sumMoney = 0;
		String code = "2";
		String msg = "处理异常！";
		if (user != null) {
			ivtList = invitationDao.findByUid(user.getId());
			mapJson.put("number_of_users", ivtList != null?ivtList.size():null);
			mapJson.put("invitation_code", user.getUid());
			if (ivtList != null) {
				for (Invitation invitation : ivtList) {
					sumMoney += invitation.getMy_earnings();
					code = "1";
					msg="查询成功！";
				}
			}else {
				msg = "未查询到数据！";
			}
			mapJson.put("profit", sumMoney);
		}else {
			msg = "未获取到用户信息！";
		}
		return resultMsg.mapToJson(code, msg,mapJson);
	}
	
	/**
	 * 获取我的客户列表
	 * @param uid 用户UID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/invitation/users", method = RequestMethod.GET)
	public String getInvitationUser(String accessToken){
		List<invitationDto> ivtDList = new ArrayList<invitationDto>();
		invitationDto ivtD = new invitationDto();
		UserInfo user = userDao.getUserByToken(accessToken);
		List<Invitation> ivtList = invitationDao.findByUid(user.getId());
		Double my_earnings_total = 0.0;
		Double spending_total = 0.0;
		String code = "2";
		String msg = "处理异常！"; 
		if (user != null) {
			if (ivtList != null) {
				for (Invitation invitation : ivtList) {
					my_earnings_total += invitation.getMy_earnings();
					spending_total += invitation.getSpending_total();
				}
				ivtD.setGender(user.getGender()==true?"男":"女");
				ivtD.setMy_earnings_total(my_earnings_total);
				ivtD.setProfile_image_url(user.getProfileImageUrl());
				ivtD.setUglify_tel(user.getTel().substring(0, 3) + "****" + user.getTel().substring(7, user.getTel().length()));
				ivtD.setUid(user.getUid());
				ivtD.setUsername(user.getUsername());
				ivtD.setMy_earnings_total(my_earnings_total);
				ivtD.setMy_earnings_total(my_earnings_total);
				ivtDList.add(ivtD);
				code = "1";
				msg = "查询成功！";
			}else{
				msg = "未查询到分享信息！";
			}
		}else{
			msg = "未查询到用户信息！";
		}
		return resultMsg.mapToJson(code, msg,ivtList);
	}
	

	/**
	 * 获取我的收益列表
	 * @param accessToken token
	 * @param uid 用户UID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/invitation/profit", method = RequestMethod.GET)
	public String show(String accessToken,String fuid) {
		UserInfo user = userDao.getUserByToken(accessToken);
		String code = "2";
		String msg = "处理异常！";
		List<MyEarnings> meList = new ArrayList<MyEarnings>();
		List<Invitation> iList = null;
		if (user != null) {
			if (fuid.isEmpty() || fuid == "") {
				iList = invitationDao.findByUid(user.getId());
				if (iList != null) {
					for (Invitation invitation : iList) {
						List<MyEarnings> mList = meDao.getUserByUid(invitation.getFuid());
						if (mList != null) {
							for (MyEarnings myEarnings : mList) {
								meList.add(myEarnings);
							}
						}
					}
				}
			}else {
				meList = meDao.getUserByUid(fuid);
			}
			if (meList.size()>0) {
				msg = "查询成功！";
			}else{
				msg="未查询到记录！";
			}
			code = "1";
		}else {
			msg = "未查询到用户信息！";
		}
		return resultMsg.mapToJson(code, msg, meList);
	}
}
