package com.diankangwo.controller;

import java.sql.Timestamp;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.diankangwo.constant.resultMsg;
import com.diankangwo.dao.CommentReplyDAO;
import com.diankangwo.dao.CommentsDAO;
import com.diankangwo.dao.CommodityDAO;
import com.diankangwo.dao.UserDAO;
import com.diankangwo.domain.CommentReply;
import com.diankangwo.domain.Comments;
import com.diankangwo.domain.UserInfo;

/**
 * 评论控制器
 * 
 * @author xiaoyu
 *
 */
@Controller
public class CommentsController {

	@Autowired
	private UserDAO userDao;

	@Autowired
	private CommodityDAO commDao;

	@Autowired
	private CommentsDAO cotsDao;
	
	@Autowired
	private CommentReplyDAO crDao;

	/**
	 * 评价某个商品
	 * @param accessToken
	 * @param CommodityId 商品ID
	 * @param order_id 订单ID
	 * @param comment_type 评价类型:差评,好评,中评
	 * @param pic 评价图片地址
	 * @param content 评价内容
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/comment", method = RequestMethod.GET)
	public String comment(String accessToken, String CommodityId, String orderID, String commentType, String pic,
			String content) {
		UserInfo user = userDao.getUserByToken(accessToken);
		String code = "2";
		String msg = "处理异常！";
		if (user != null) {
			Comments cots = new Comments();
			Date date = new Date();
			Timestamp nousedate = new Timestamp(date.getTime());
			cots.setAdd_date(nousedate);
			cots.setCommodity(commDao.find(CommodityId));
			cots.setContent(content);
			cots.setLike(cots.getLike() + 1);
			cots.setPic(pic);
			cots.setUserInfo(user);
			cots.setType(commentType);
			cots.setReply_number(cots.getReply_number() + 1);
			if (cotsDao.saveOrUpdate(cots) != null) {
				code = "1";
				msg = "查询成功！";
			}
		} else {
			msg = "未查询到用户信息！";
		}
		return resultMsg.mapToJson(code, msg, null);
	}

	/**
	 * 获取某条评论的回复列表
	 * @param accessToken token
	 * @param id 评论ID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/comment/reply", method = RequestMethod.GET)
	public String reply(String accessToken, Integer id) {
		String code = "2";
		String msg = "处理异常！";
		Comments cts = new Comments();
		if (accessToken == "" || id == null) {
			msg = "数据不完整!";
		}else{
			UserInfo user = userDao.getUserByToken(accessToken);
			cts = new Comments();
			if (user != null) {
				cts = cotsDao.find(id);
				if (cts != null) {
					code = "1";
					msg = "查询成功！";
				}else{
					msg="未查询到评价信息！";
				}
			} else {
				msg = "未查询到用户信息！";
			}
		}
		return resultMsg.mapToJson(code, msg, cts);
	}
	
	/**
	 * 回复某条评论
	 * @param accessToken token
	 * @param id 评论ID
	 * @param content 内容
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/comment/reply", method = RequestMethod.POST)
	public String reply(String accessToken, String id,String content) {
		UserInfo user = userDao.getUserByToken(accessToken);
		String code = "2";
		String msg = "处理异常！";
		Comments cts = cotsDao.find(id);
		if (user != null) {
			if (cts != null) {
				CommentReply cr = new CommentReply();
				Date date = new Date();
				Timestamp nousedate = new Timestamp(date.getTime());
				cr.setAdd_date(nousedate);
				cr.setCommentsId(cts.getId());
				cr.setUserInfo(user);
				cr.setContent(content);
				if (crDao.saveOrUpdate(cr) != null) {
					code = "1";
					msg = "回复成功！";
				}else{
					msg = "系统异常，回复失败!";
				}
			}else{
				msg="未查询到评价信息！";
			}
		} else {
			msg = "未查询到用户信息！";
		}
		return resultMsg.mapToJson(code, msg, null);
	}
}
