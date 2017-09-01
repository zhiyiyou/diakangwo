package com.diankangwo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.diankangwo.dao.UserDAO;
import com.diankangwo.domain.UserInfo;

@Repository
public class UserDAOImpl extends BaseDaoImpl<UserInfo> implements UserDAO {
	@Resource
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eshop.consumer.dao.impl.UserDao#getUserByUserName(java.lang.String)
	 */
	@Override
	public UserInfo getUserByUserName(String username) {
		try {
			String hql = "from User u where u.username = :username";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter("username", username);
			UserInfo user = (UserInfo) query.uniqueResult();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean addUser(UserInfo user) {
		try {

			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateUser(UserInfo user) {
		try {
			sessionFactory.getCurrentSession().merge(user.getClass().getSimpleName(), user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public UserInfo getUserByUid(String uid) {
		List<UserInfo> userList = new ArrayList<UserInfo>();
		userList =  findByQuery("from UserInfo user where user.uid = ?", uid);
		if (userList == null || userList.size() ==0) {
			return null;
		}else{
			return userList.get(0);
		}
	}

	@Override
	public UserInfo getUserByTel(String tel) {
		List<UserInfo> userList = new ArrayList<UserInfo>();
		userList =  findByQuery("from UserInfo user where user.tel = ?", tel);
		if (userList == null || userList.size() ==0) {
			return null;
		}else{
			return userList.get(0);
		}
	}

	@Override
	public UserInfo getUserByToken(String token) {
		List<UserInfo> userList = new ArrayList<UserInfo>();
		userList =  findByQuery("from UserInfo user where user.accessToken = ?", token);
		if (userList == null || userList.size() ==0) {
			return null;
		}else{
			return userList.get(0);
		}
	}

	@Override
	public UserInfo getUserByCid(String cid) {
		List<UserInfo> userList = new ArrayList<UserInfo>();
		userList =  findByQuery("from UserInfo user where user.getui_cid = ?", cid);
		if (userList == null || userList.size() ==0) {
			return null;
		}else{
			return userList.get(0);
		}
	}
}
