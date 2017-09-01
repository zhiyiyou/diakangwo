package com.diankangwo.dao;

import java.util.List;
import com.diankangwo.domain.MyEarnings;

public interface MyEarningsDAO extends BaseDAO<MyEarnings> {
	public List<MyEarnings> getUserByUid(String uid);
}
