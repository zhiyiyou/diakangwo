package com.diankangwo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.diankangwo.constant.resultMsg;
import com.diankangwo.dao.AddressDAO;
import com.diankangwo.dao.CityDAO;
import com.diankangwo.dao.DistrictDAO;
import com.diankangwo.dao.ProvinceDAO;
import com.diankangwo.dao.UserDAO;
import com.diankangwo.domain.Address;
import com.diankangwo.domain.City;
import com.diankangwo.domain.District;
import com.diankangwo.domain.Province;
import com.diankangwo.domain.UserInfo;
import net.sf.json.JSONArray;

/**
 * 用户地址控制器
 * 
 * @author xiaoyu
 */
@Controller
public class AddressController {
	@Autowired
	private UserDAO userDao;
	@Autowired
	private AddressDAO addressDao;
	@Autowired
	private CityDAO cityDao;
	@Autowired
	private ProvinceDAO provinceDao;
	@Autowired
	private DistrictDAO districtDao;

	/**
	 * 获取我的收货地址列表
	 * 
	 * @param accessToken
	 *            token
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/address/getInfo", method = RequestMethod.GET)
	public String getInfo(String accessToken) {
		UserInfo user = userDao.getUserByToken(accessToken);
		String code = "2";
		String msg = "处理异常！";
		List<Address> addressList = null;
		if (user != null) {
			addressList = addressDao.findByUid(user.getUid());
			if (addressList != null) {
				code = "1";
				msg = "查询成功！";
			} else {
				msg = "未查询到用户收货地址信息！";
			}
		} else {
			msg = "未查询到用户信息！";
		}
		return resultMsg.mapToJson(code, msg, addressList);
	}

	/**
	 * 新增我的收货地址信息
	 * 
	 * @param accessToken
	 * @param name
	 *            名称
	 * @param tel
	 *            电话
	 * @param province_id
	 *            省份ID
	 * @param city_id
	 *            城市ID
	 * @param county_id
	 *            区县ID
	 * @param address
	 *            详细地址
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/address/add", method = RequestMethod.POST)
	public String add(String accessToken, String name, String tel, Integer provinceID, Integer cityID, Integer countyID,
			String address) {
		String code = "2";
		String msg = "处理异常！";
		if (accessToken == null || name == null || tel == null || provinceID == null || cityID == null
				|| countyID == null || address == null) {
			msg = "数据不完整！";
		} else {
			UserInfo user = userDao.getUserByToken(accessToken);
			if (user != null) {
				Address arss = new Address();
				arss.setPhone(tel);
				arss.setUid(user.getUid());
				arss.setDetailedAddress(address);
				arss.setCityId(cityDao.find(cityID));
				arss.setDistrictId(districtDao.find(countyID));
				arss.setProvinceId(provinceDao.find(provinceID));
				City city = cityDao.find(cityID);
				arss.setPostcode(city.getZipCode());
				if (addressDao.saveOrUpdate(arss) != null) {
					code = "1";
					msg = "增加成功！";
				} else {
					msg = "系统异常，增加失败！";
				}
			} else {
				msg = "未查询到用户信息！";
			}
		}
		return resultMsg.mapToJson(code, msg, null);
	}

	/**
	 * 更新我的某条地址信息
	 * 
	 * @param accessToken
	 *            token
	 * @param id
	 *            id
	 * @param name
	 *            姓名
	 * @param tel
	 *            电话号码
	 * @param province_id
	 *            省ID
	 * @param city_id
	 *            市ID
	 * @param county_id
	 *            区域ID
	 * @param address
	 *            详细地址
	 * @param defaultAdress
	 *            是否默认地址
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/address/update", method = RequestMethod.POST)
	public String update(String accessToken, Integer id, String name, String tel, Integer provinceID, Integer cityID,
			Integer countyID, String address, String defaultAdress) {
		String code = "2";
		String msg = "处理异常！";
		if (accessToken == null || id == null || name == null || tel == null || provinceID == null || cityID == null
				|| countyID == null || address == null || defaultAdress == null) {
			msg = "数据不完整！";
		} else {
			UserInfo user = userDao.getUserByToken(accessToken);
			if (user != null) {
				Address add = new Address();
				District dis = districtDao.find(countyID);
				Province pro = provinceDao.find(provinceID);
				City city = cityDao.find(cityID);
				if (dis != null && pro != null && city != null) {
					add.setCityId(city);
					add.setDistrictId(dis);
					add.setProvinceId(pro);
					add.setDetailedAddress(address);
					add.setPhone(tel);
					add.setPostcode(city.getZipCode());
					add.setUid(user.getUid());
					if (addressDao.saveOrUpdate(add) != null) {
						code = "1";
						msg = "更新成功！";
					} else {
						msg = "系统异常，更新失败!";
					}
				} else {
					msg = "查询地址信息失败！";
				}
			} else {
				msg = "未查询到用户信息！";
			}
		}
		return resultMsg.mapToJson(code, msg, null);
	}

	/**
	 * 删除我的指定地址信息
	 * 
	 * @param accessToken
	 *            token
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/address/del", method = RequestMethod.POST)
	public String del(String accessToken, String id) {
		UserInfo user = userDao.getUserByToken(accessToken);
		String code = "2";
		String msg = "处理异常！";
		if (user != null) {
			try {
				JSONArray json = JSONArray.fromObject(id); // 首先把字符串转成 JSONArray
															// 对象
				List l = JSONArray.toList(json);
				for (Object object : l) {
					addressDao.deleteById(id);
				}
				code = "1";
				msg = "删除成功！";
			} catch (Exception e) {
				msg = "删除异常!";
			}
		} else {
			msg = "未查询到用户信息！";
		}
		return resultMsg.mapToJson(code, msg, null);
	}

	/**
	 * 获取地址列表接口
	 * 
	 * @param province_id
	 *            省份ID
	 * @param city_id
	 *            城市ID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/address/get_info_list", method = RequestMethod.GET)
	public String getInfoList(Integer provinceID, Integer cityID) {
		String code = "2";
		String msg = "处理异常！";
		List<Province> proList = null;
		List<City> cityList = null;
		List<District> districtList = null;
		if (provinceID != null) {
			cityList = cityDao.findByProId(provinceID);
			code = "1";
			msg = "查询城市数据成功！";
			return resultMsg.mapToJson(code, msg, cityList);
		} else if (cityID != null) {
			districtList = districtDao.findByCityId(cityID);
			code = "1";
			msg = "查询区域数据成功！";
			return resultMsg.mapToJson(code, msg, districtList);
		} else {
			proList = provinceDao.findAll();
			msg = "查询省份数据成功！";
			return resultMsg.mapToJson(code, msg, proList);
		}
	}
}
