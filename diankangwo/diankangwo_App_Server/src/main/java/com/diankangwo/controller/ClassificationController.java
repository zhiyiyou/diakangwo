package com.diankangwo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.diankangwo.constant.resultMsg;
import com.diankangwo.dao.ClassificationDAO;
import com.diankangwo.domain.Classification;

/**
 * 二级分类控制器
 * @author xiaoyu
 *
 */
@Controller
public class ClassificationController {

	@Autowired
	private ClassificationDAO classificationDao;
	
	/**
	 * 获取指定分类下的子分类列表
	 * @param class_id 一级分类ID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/classification/list", method = RequestMethod.GET)
	public String show(Integer classID) {
		List<Classification> cftList = classificationDao.findByTypeId(classID);
		String code = "2";
		String msg = "处理异常！";
		if (cftList != null) {
			code = "1";
			msg = "查询成功！";
		}else {
			msg = "未查询到分类信息！";
		}
		return resultMsg.mapToJson(code, msg, cftList);
	}
}
