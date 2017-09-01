package com.diankangwo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.diankangwo.constant.resultMsg;
import com.diankangwo.dao.CommodityDAO;
import com.diankangwo.dao.UserDAO;
import com.diankangwo.domain.Commodity;

/**
 * 商品控制器
 * 
 * @author xiaoyu
 *
 */
@Controller
public class CommodityController {

	@Autowired
	private UserDAO userDao;

	@Autowired
	private CommodityDAO commodityDao;

	/**
	 * 获取商品列表接口
	 * 
	 * @param primary_classification_id
	 *            一级分类ID
	 * @param secondary_classification
	 *            二级分类ID
	 * @param search_key
	 *            搜索关键词
	 * @param sort_order
	 *            排序方式
	 * @param price_max
	 *            最高价,仅当sort_order = price_max_min 时生效
	 * @param price_min
	 *            最低价,仅当sort_order = price_max_min 时生效
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/commodity/get_list_info", method = RequestMethod.GET)
	public String show(Integer primaryClassificationID, Integer secondaryClassificationID, String searchKey,
			String sortOrder, Float priceMax, Float priceMin) {
		String code = "2";
		String msg = "处理异常！";
		List<Commodity> commList = commodityDao.findCommodityByCondition(primaryClassificationID,
				secondaryClassificationID, searchKey, sortOrder, priceMax, priceMin);
		if (commList != null) {
			code = "1";
			msg = "获取成功！";
		}
		return resultMsg.mapToJson(code, msg, commList);
	}

}
