package com.diankangwo.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.diankangwo.dao.AddressDAO;
import com.diankangwo.domain.Address;

@Repository
public class AddressDAOImpl extends BaseDaoImpl<Address> implements AddressDAO {

	@Override
	public List<Address> findByUid(String uid) {
		List<Address> addressList = new ArrayList<Address>();
		addressList =  findByQuery("from Address address where address.uid = ?", uid);
		if (addressList == null || addressList.size() ==0) {
			return null;
		}else{
			return addressList;
		}
	}

}
