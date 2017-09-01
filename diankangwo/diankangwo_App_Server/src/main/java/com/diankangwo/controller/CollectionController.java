package com.diankangwo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.diankangwo.constant.resultMsg;
import com.diankangwo.dao.CollectionDAO;
import com.diankangwo.dao.UserDAO;
import com.diankangwo.domain.Collection;
import com.diankangwo.domain.UserInfo;

/**
 * 用戶收藏控制器
 * 
 * @author xiaoyu
 *
 */
@Controller
public class CollectionController {
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private CollectionDAO collectionDao;
	
	/**
	 * 获取我的收藏列表
	 * @param accessToken token
	 * @param classification 分类
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/collection/list", method = RequestMethod.GET)
	public String list(String accessToken,String classification) {
		UserInfo user = userDao.getUserByToken(accessToken);
		String code = "2";
		String msg = "处理异常！";
		List<Collection> connList = null;
		if (user != null) {
			connList = collectionDao.getCollectionByUid(user.getUid());
			if (connList != null) {
				code = "1";
				msg = "查询成功！";
			}else {
				msg = "未查询到收藏信息！";
			}
		}else {
			msg = "未查询到用户信息！";
		}
		return resultMsg.mapToJson(code, msg, connList);
	}
	
	/**
	 * 删除指定收藏
	 * @param accessToken
	 * @param goods_id 商品ID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/collection/del", method = RequestMethod.POST)
	public String del(String accessToken,String commodityID) {
		UserInfo user = userDao.getUserByToken(accessToken);
		String code = "2";
		String msg = "处理异常！";
		if (user != null) {
			if (collectionDao.deleteByCid(commodityID)) {
				code = "1";
				msg = "删除成功！";
			}else {
				msg = "操作异常，删除失败！";
			}
		}else {
			msg = "未查询到用户信息！";
		}
		return resultMsg.mapToJson(code, msg, null);
	}
}
