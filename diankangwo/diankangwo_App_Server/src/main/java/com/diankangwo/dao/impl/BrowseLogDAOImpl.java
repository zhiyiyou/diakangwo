package com.diankangwo.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.diankangwo.dao.BrowseLogDAO;
import com.diankangwo.domain.BrowseLog;

@Repository
public class BrowseLogDAOImpl extends BaseDaoImpl<BrowseLog> implements BrowseLogDAO {

	@Override
	public List<BrowseLog> getUserByUid(String uid,String sort) {
		List<BrowseLog> blList = new ArrayList<BrowseLog>();
		blList =  findByQuery("from BrowseLog bl where bl.uid = ? order by"+sort, uid);
		if (blList == null || blList.size() ==0) {
			return null;
		}else{
			return blList;
		}
	}

}
