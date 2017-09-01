package com.diankangwo.dao;

import java.util.List;

import com.diankangwo.domain.Address;

public interface AddressDAO extends BaseDAO<Address> {
	public List<Address> findByUid(String uid);
}
