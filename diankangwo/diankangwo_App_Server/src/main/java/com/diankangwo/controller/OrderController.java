package com.diankangwo.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.filter.HttpPutFormContentFilter;

import com.diankangwo.constant.resultMsg;
import com.diankangwo.dao.AddressDAO;
import com.diankangwo.dao.CityDAO;
import com.diankangwo.dao.DistrictDAO;
import com.diankangwo.dao.OrderDAO;
import com.diankangwo.dao.ProvinceDAO;
import com.diankangwo.dao.UserDAO;
import com.diankangwo.domain.Address;
import com.diankangwo.domain.City;
import com.diankangwo.domain.District;
import com.diankangwo.domain.Order;
import com.diankangwo.domain.Province;
import com.diankangwo.domain.UserInfo;
import com.diankangwo.util.GuidUtil;
import com.diankangwo.util.OrderUtil;

/**
 * 购物订单控制器
 * @author xiaoyu
 *
 */
@Controller
public class OrderController {
	
	@Autowired
	private UserDAO userDao;

	@Autowired
	private OrderDAO orderDao;
	
	@Autowired
	private AddressDAO addressDao;
	
	@Autowired
	private CityDAO cityDao;
	
	@Autowired
	private DistrictDAO districtDao;
	
	@Autowired
	private ProvinceDAO provinceDao;
	
	/**
	 * 创建商品订单
	 * @param accessToken token
	 * @param address_id 收货地址ID
	 * @param coupon_id 使用用户领取的优惠券ID
	 * @param cart_data_id 购物车数据ID
	 * @param bill 	是否开发票 1为是 0为否
	 * @param bill_type 发票类型 enterprise 企业 personal 个人
	 * @param bill_content 公式名称或个人名称
	 * @return json
	 */
	@ResponseBody
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String show(String accessToken,Integer addressID,Integer couponID,String cartDataID,Integer bill,String billType,String billContent) {
		UserInfo user = userDao.getUserByToken(accessToken);
		Order order = new Order();
		String code = "2";
		String msg = "处理异常！";
		if (user != null) {
			order.setUserinfo(user);
			Address address = addressDao.find(addressID);
			if (address != null) {
				Province pv = provinceDao.find(address.getProvinceId());
				District dr = districtDao.find(address.getDistrictId());
				City city = cityDao.find(address.getCityId());
				order.setProvince(pv.getProvinceName());
				order.setCity(city.getCityName());
				order.setArea(dr.getDistrictName());
				order.setAddress(address.getDetailedAddress());
				order.setUserinfo(user);
				order.setCreateDate(new Date());
				order.setOrderNo(OrderUtil.getOrderNo());
				order.setCoiUid(GuidUtil.getGuid());
				orderDao.saveOrUpdate(order);
			}
			//拼接收货地址
			
			
			code = "1";
			msg = "查询成功！";
			user.setPassword("");
			user.setSalt_value("");
		}else {
			msg = "未查询到用户信息！";
		}
		return resultMsg.mapToJson(code, msg, user);
	}
	
}
