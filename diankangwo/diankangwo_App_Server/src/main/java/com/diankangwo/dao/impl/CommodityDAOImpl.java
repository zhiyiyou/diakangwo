package com.diankangwo.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.diankangwo.dao.CommodityDAO;
import com.diankangwo.domain.Commodity;

@Repository
public class CommodityDAOImpl extends BaseDaoImpl<Commodity> implements CommodityDAO {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List<Commodity> findCommodityByCondition(Integer primary_classification_id, Integer secondary_classification,
			String search_key, String sort_order, Float price_max, Float price_min) {
		String sql = "from Commodity comm where 1=1";
		if (primary_classification_id != null) {
			sql += "and comm.type = " + primary_classification_id;
		}
		if (secondary_classification != null) {
			sql += "and comm.border = " + secondary_classification;
		}
		if (search_key != "") {
			sql += "and comm.search_key like %" + search_key + "%";
		}
		if (price_max != null && price_min != null) {
			sql += "and comm.commodityPriceShop between" + price_min + "and " + price_max;
		}
		if (sort_order != null) {
			switch (sort_order) {
			case "commodityIsNew":
				sql += "order by comm.commodityIsNew ASC";
				break;
			case "commodityBuyNum":
				sql += "order by comm.commodityBuyNum ASC";
				break;
			case "commodityReviews":
				sql += "order by comm.commodityReviews ASC";
				break;
			case "commodityPriceShop_low":
				sql += "order by comm.commodityPriceShop DESC";
				break;
			case "commodityPriceShop_high":
				sql += "order by comm.commodityPriceShop ASC";
				break;
			}
		}
		return findByQuery(sql);
	}

}
