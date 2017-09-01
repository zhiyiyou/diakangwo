package com.diankangwo.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.diankangwo.dao.CollectionDAO;
import com.diankangwo.domain.Collection;

@Repository
public class CollectionDAOImpl extends BaseDaoImpl<Collection> implements CollectionDAO {

	@Override
	public List<Collection> getCollectionByUid(String uid) {
		List<Collection> collectionList = new ArrayList<Collection>();
		collectionList = findByQuery("from Collection conn where conn.uid = ?", uid);
		if (collectionList == null || collectionList.size() == 0) {
			return null;
		} else {
			return collectionList;
		}
	}

	@Override
	public boolean deleteByCid(String goods_id) {
		List<Collection> collectionList = new ArrayList<Collection>();
		collectionList = findByQuery("from Collection conn where conn.goods_id = ?", goods_id);
		try {
			if (collectionList != null) {
				for (Collection collection : collectionList) {
					delete(collection);
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
