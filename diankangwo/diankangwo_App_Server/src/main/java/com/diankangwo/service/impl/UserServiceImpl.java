package com.diankangwo.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.diankangwo.dao.UserDAO;
import com.diankangwo.domain.UserInfo;
import com.diankangwo.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
	private static final Logger LOG = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDAO userDao;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		System.out.println("find the user name: " + username);
		UserInfo user = userDao.getUserByUserName(username);
		System.out.println(user == null);
		if (user == null) {
			System.out.println("username can't found");
			throw new UsernameNotFoundException("Username not found...");
		}
		LOG.debug(user.getUsername() + ": " + user.getPassword() + "| "
				+ user.isEnabled());
		return user;
	}

	@Override
	public UserInfo getUserByUid(String uid) {
		return userDao.getUserByUid(uid);
	}

	@Override
	public UserInfo getUserByTel(String tel) {
		return userDao.getUserByTel(tel);
	}

	@Override
	public UserInfo getUserByToken(String token) {
		return userDao.getUserByToken(token);
	}

	@Override
	public UserInfo getUserByCid(String cid) {
		return userDao.getUserByCid(cid);
	}

}
