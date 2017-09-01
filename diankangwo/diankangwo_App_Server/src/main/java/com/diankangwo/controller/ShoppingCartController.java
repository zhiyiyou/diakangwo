package com.diankangwo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.diankangwo.constant.resultMsg;
import com.diankangwo.dao.ShoppingCartDAO;
import com.diankangwo.dao.UserDAO;
import com.diankangwo.domain.ShoppingCart;
import com.diankangwo.domain.UserInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 购物车控制器
 * 
 * @author xiaoyu
 *
 */
@Controller
public class ShoppingCartController {
	@Autowired
	private ShoppingCartDAO shoppingCartDao;
	@Autowired
	private UserDAO userDao;

	/**
	 * 获取我的购物车列表
	 * 
	 * @param accessToken
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/shopping_cart", method = RequestMethod.GET)
	public String list(String accessToken) {
		UserInfo user = userDao.getUserByToken(accessToken);
		String code = "2";
		String msg = "处理异常！";
		List<ShoppingCart> scList = null;
		if (user != null) {
			scList = shoppingCartDao.findByUserId(user.getId());
			if (scList != null) {
				code = "1";
				msg = "获取成功！";
			}else {
				msg = "未查询到购物车记录！";
			}
			
		} else {
			msg = "未查询到用户信息！";
		}
		return resultMsg.mapToJson(code, msg, scList);
	}
	
	/**
	 * 添加购物车
	 * 
	 * @param uid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/shopping_cart", method = RequestMethod.POST)
	public String add(String accessToken,String goods_id,String selected,String number) {
		UserInfo user = userDao.getUserByToken(accessToken);
		String code = "2";
		String msg = "处理异常！";
		List<ShoppingCart> scList = null;
		if (user != null) {
			scList = shoppingCartDao.findByUserId(user.getId());
			if (scList != null) {
				code = "1";
				msg = "获取成功！";
			}else {
				msg = "未查询到购物车记录！";
			}
			
		} else {
			msg = "未查询到用户信息！";
		}
		return resultMsg.mapToJson(code, msg, scList);
	}
	
	/**
	 * 删除我的购物车数据
	 * @param accessToken
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/shopping_cart/del", method = RequestMethod.POST)
	public String del(String accessToken,String id) {
		UserInfo user = userDao.getUserByToken(accessToken);
		String code = "2";
		String msg = "处理异常！";
		if (user != null) {
			try {
				JSONArray json = JSONArray.fromObject(id); // 首先把字符串转成 JSONArray 对象
				List l = JSONArray.toList(json);
				for (Object object : l) {
					shoppingCartDao.deleteById(id);
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
	 * 修改我的购物车列表信息
	 * @param accessToken
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/shopping_cart/update", method = RequestMethod.POST)
	public String update(String accessToken,String data) {
		UserInfo user = userDao.getUserByToken(accessToken);
		String code = "2";
		String msg = "处理异常！";
		if (user != null) {
			try {
				JSONArray json = JSONArray.fromObject(data ); // 首先把字符串转成 JSONArray  对象
				if(json.size()>0){
				  for(int i=0;i<json.size();i++){
				    JSONObject job = json.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
				    ShoppingCart sc = shoppingCartDao.find(job.get("id").toString());
				    sc.setCommodityNumber(Integer.parseInt(job.get("number").toString()));
				    shoppingCartDao.saveOrUpdate(sc);
				  }
				}
				code = "1";
				msg = "删除成功！";
			} catch (Exception e) {
				msg = "系统异常，删除失败！";
			}
		} else {
			msg = "未查询到用户信息！";
		}
		return resultMsg.mapToJson(code, msg, null);
	}
}
