package com.diankangwo.dao;

import com.diankangwo.domain.UserInfo;

public interface UserDAO extends BaseDAO<UserInfo> {

	public abstract UserInfo getUserByUserName(String username);

	public boolean addUser(UserInfo user);

	public boolean updateUser(UserInfo user);
	
	public UserInfo getUserByUid(String uid);
	
	public UserInfo getUserByTel(String tel);
	
	public UserInfo getUserByToken(String token);

	public UserInfo getUserByCid(String cid);
}