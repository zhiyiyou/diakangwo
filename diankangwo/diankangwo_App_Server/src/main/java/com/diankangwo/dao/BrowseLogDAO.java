package com.diankangwo.dao;

import java.util.List;
import com.diankangwo.domain.BrowseLog;

public interface BrowseLogDAO extends BaseDAO<BrowseLog> {

	public List<BrowseLog> getUserByUid(String uid, String sort);
}
