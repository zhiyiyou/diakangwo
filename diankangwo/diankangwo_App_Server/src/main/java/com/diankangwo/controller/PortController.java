package com.diankangwo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.diankangwo.constant.resultMsg;
import com.diankangwo.dao.PortDAO;
import com.diankangwo.dao.UserDAO;
import com.diankangwo.domain.Port;
import com.diankangwo.domain.UserInfo;
import com.diankangwo.dto.PortDto;

/**
 * 端口控制器
 * 
 * @author xiaoyu
 *
 */
@Controller
public class PortController {
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private PortDAO portDao;
	
	@Resource
	private ReflectionSaltSource saltSource;

	@Resource
	private ShaPasswordEncoder passwordEncoder;

	/**
	 * 获取端口列表
	 * @param accessToken token
	 * @param type 可选 mine / saleing
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/ports", method = RequestMethod.GET)
	public String show(String accessToken,String type) {
		UserInfo user = userDao.getUserByToken(accessToken);
		String code = "2";
		String msg = "处理异常！";
		List<Port> pList = null;
		if (user != null) {
			pList = portDao.findByType(type);
			code = "1";
			msg = "查询成功！";
		}else {
			msg = "未查询到用户信息！";
		}
		return resultMsg.mapToJson(code, msg, pList);
	}
	
	/**
	 * 获取端口信息
	 * @param accessToken token
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/ports/one", method = RequestMethod.GET)
	public String one(String accessToken) {
		UserInfo user = userDao.getUserByToken(accessToken);
		String code = "2";
		String msg = "处理异常！";
		List<Port> pList = null;
		List<PortDto> pDtoList = new ArrayList<PortDto>();
		if (user != null) {
			pList = portDao.findByUser(user.getId());
			if (pList != null) {
				Port p = new Port();
				PortDto pd = new PortDto();
				p = pList.get(0);
				pd.setCertificate_pic_url(p.getCertificate_pic_url());
				pd.setId(p.getId());
				pd.setPortId(p.getPortId());
				pd.setPresent_value(p.getPresent_value());
				pd.setPrice(p.getPrice());
				pd.setSaleing(p.getSaleing());
				pd.setSource(p.getSource());
				pd.setType(p.getType());
				pd.setUserinfo(p.getUserinfo());
				pd.setDays("");
				pd.setMonths("");
				pd.setYears("");
				pd.setQuarters("");
				code = "1";
				msg = "查询成功！";
			}else {
				msg = "为查询到用户下的端口信息！";
			}
		}else {
			msg = "未查询到用户信息！";
		}
		return resultMsg.mapToJson(code, msg, pDtoList);
	}
	
	/**
	 * 申请端口
	 * @param accessToken token
	 * @param tel 手机号
	 * @param id_card 身份证
	 * @param name 姓名
	 * @param money 预约金额
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/ports/one", method = RequestMethod.POST)
	public String one(String accessToken,String tel,String IDCard,String name,Float money) {
		UserInfo user = userDao.getUserByToken(accessToken);
		String code = "2";
		String msg = "处理异常！";
		if (user != null) {
			Port p = new Port();
			p.setId_card(IDCard);
			p.setMoney(money);
			p.setName(name);
			p.setUserinfo(user);
			if (portDao.saveOrUpdate(p) != null) {
				code = "1";
				msg = "申请成功！";
			}else {
				msg = "系统异常，申请失败！";
			}
		}else {
			msg = "未查询到用户信息！";
		}
		return resultMsg.mapToJson(code, msg, null);
	}
	
	/**
	 * 出售/转让端口
	 * @param accessToken token
	 * @param port_id 端口ID
	 * @param type 类型
	 * @param f_name 好友姓名
	 * @param f_id_card 好友身份证
	 * @param f_tel 好友手机号
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/ports/put", method = RequestMethod.POST)
	public String one(String accessToken,String portID,String type,String FName,String FIDCard,String FTel) {
		UserInfo user = userDao.getUserByToken(accessToken);
		String code = "2";
		String msg = "处理异常！";
		if (user != null) {
			Port p = portDao.findByPortId(portID);
			Port p1 = portDao.findByPortCondition(FName, FIDCard, FTel);
			p.setSource("offline");
			p.setTel(p1.getTel());
			p.setName(p1.getName());
			p.setId_card(p1.getId_card());
			p.setType("offline");
			if (portDao.saveOrUpdate(p) != null) {
				code = "1";
				msg = "申请成功！";
			}else {
				msg = "系统异常，申请失败！";
			}
		}else {
			msg = "未查询到用户信息！";
		}
		return resultMsg.mapToJson(code, msg, null);
	}
	
	/**
	 * 主动/被动(同意)/拒绝购买端口
	 * @param accessToken token
	 * @param tel 手机号
	 * @param id_card 身份证
	 * @param name 姓名
	 * @param money 预约金额
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/ports/one/buy", method = RequestMethod.POST)
	public String buy(String accessToken,String portID ,String type,String payPassword) {
		UserInfo user = userDao.getUserByToken(accessToken);
		String code = "2";
		String msg = "处理异常！";
		if (user != null) {
			Port p = portDao.findByPortId(portID);
			if (portDao.saveOrUpdate(p) != null) {
				code = "1";
				msg = "申请成功！";
			}else {
				msg = "系统异常，申请失败！";
			}
		}else {
			msg = "未查询到用户信息！";
		}
		return resultMsg.mapToJson(code, msg, null);
	}
}
