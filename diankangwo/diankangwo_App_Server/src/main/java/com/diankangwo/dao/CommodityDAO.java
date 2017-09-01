package com.diankangwo.dao;

import java.util.List;
import com.diankangwo.domain.Commodity;

public interface CommodityDAO extends BaseDAO<Commodity> {
	
	public List<Commodity> findCommodityByCondition(Integer primary_classification_id, Integer secondary_classification, String search_key, String sort_order, Float price_max, Float price_min);

}
