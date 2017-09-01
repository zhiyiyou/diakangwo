package com.diankangwo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.diankangwo.domain.UserInfo;

public interface UserService extends UserDetailsService{
	
	public UserInfo getUserByUid(String uid);
	public UserInfo getUserByTel(String tel);
	public UserInfo getUserByToken(String token);
	public UserInfo getUserByCid(String cid);
}
