package com.diankangwo.dao;

import java.util.List;

import com.diankangwo.domain.Collection;

public interface CollectionDAO extends BaseDAO<Collection> {
	public List<Collection> getCollectionByUid(String uid);
	public boolean deleteByCid(String goods_id);
}
