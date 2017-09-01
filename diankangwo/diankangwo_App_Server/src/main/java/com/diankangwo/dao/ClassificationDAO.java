package com.diankangwo.dao;

import java.util.List;

import com.diankangwo.domain.Classification;

public interface ClassificationDAO extends BaseDAO<Classification> {
	public List<Classification> findByTypeId(Integer id);
}
