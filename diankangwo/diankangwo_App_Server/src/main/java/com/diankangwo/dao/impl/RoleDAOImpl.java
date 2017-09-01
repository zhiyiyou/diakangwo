package com.diankangwo.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.diankangwo.dao.RoleDAO;
import com.diankangwo.domain.Role;

@Repository(value = "roleDAO")
public class RoleDAOImpl implements RoleDAO {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<Role> findAllRoles() {
		return sessionFactory.getCurrentSession().createQuery("from Role")
				.list();
	}
}
