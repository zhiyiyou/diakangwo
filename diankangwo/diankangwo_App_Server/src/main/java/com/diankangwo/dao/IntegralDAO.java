package com.diankangwo.dao;

import java.util.List;

import com.diankangwo.domain.Integral;

public interface IntegralDAO extends BaseDAO<Integral> {
	
	public List<Integral> getUserByUid(String uid);
}
