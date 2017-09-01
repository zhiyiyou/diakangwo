package com.diankangwo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.diankangwo.constant.resultMsg;
import com.diankangwo.dao.CouponsDAO;
import com.diankangwo.dao.CouponsUserDAO;
import com.diankangwo.dao.UserDAO;
import com.diankangwo.domain.Coupons;
import com.diankangwo.domain.CouponsUser;
import com.diankangwo.domain.UserInfo;

/**
 * 优惠券控制器
 * 
 * @author xiaoyu
 *
 */
@Controller
public class CouponsController {
	@Autowired
	private UserDAO userDao;
	@Autowired
	private CouponsDAO couponsDao;
	@Autowired
	private CouponsUserDAO couponsUserDao;

	/**
	 * 获取我的优惠券列表
	 * @param accessToken
	 * @param type
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/coupons/list", method = RequestMethod.GET)
	public String show(String accessToken,String type) {
		UserInfo user = userDao.getUserByToken(accessToken);
		String code = "2";
		String msg = "处理异常！";
		List<Coupons> cList = null;
		if (user != null) {
			cList = couponsDao.findAll();
			if (cList != null) {
				code = "1";
				msg = "查询成功！";
			}else {
				msg = "未查询到优惠券信息！";
			}
		} else {
			msg = "未查询到用户信息！";
		}
		return resultMsg.mapToJson(code, msg, cList);
	}
	
	/**
	 * 领取指定优惠券
	 * @param accessToken
	 * @param type
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/coupons/receive", method = RequestMethod.GET)
	public String receive(String accessToken,Integer id) {
		UserInfo user = userDao.getUserByToken(accessToken);
		String code = "2";
		String msg = "处理异常！";
		Coupons coupons = null;
		if (user != null) {
			coupons = couponsDao.find(id);
			if (coupons != null) {
				CouponsUser cu = new CouponsUser();
				cu.setDenomination(coupons.getDenomination());
				cu.setDetail(coupons.getDetail());
				cu.setEnd_date(coupons.getEnd_date());
				cu.setName(coupons.getName());
				cu.setStart_date(coupons.getStart_date());
				cu.setUse_condition(coupons.getUse_condition());
				cu.setUsed_date(coupons.getUsed_date());
				cu.setType("未使用！");
				if (couponsUserDao.saveOrUpdate(cu) != null) {
					code = "1";
					msg = "领取成功！";
				}else {
					msg = "系统异常，领取失败！";
				}
			}else{
				msg = "未查询到指定优惠券！";
			}
		} else {
			msg = "未查询到用户信息！";
		}
		return resultMsg.mapToJson(code, msg, null);
	}
}
