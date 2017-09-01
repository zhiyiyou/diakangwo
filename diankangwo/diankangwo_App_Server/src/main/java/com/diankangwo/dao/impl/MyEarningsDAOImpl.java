package com.diankangwo.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.diankangwo.dao.MyEarningsDAO;
import com.diankangwo.domain.MyEarnings;

@Repository
public class MyEarningsDAOImpl extends BaseDaoImpl<MyEarnings> implements MyEarningsDAO {

	@Override
	public List<MyEarnings> getUserByUid(String uid) {
		List<MyEarnings> meList = new ArrayList<MyEarnings>();
		meList =  findByQuery("from MyEarnings me where me.uid = ?", uid);
		if (meList == null || meList.size() ==0) {
			return null;
		}else{
			return meList;
		}
	}

}
 