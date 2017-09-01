package com.diankangwo.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 * 定义一些数据库操作
 *
 * @param <T>
 */
public class GenericDAOSupport<T>{
	private static final Logger LOG = Logger.getLogger(GenericDAOSupport.class);
	
	// 通过外部设置session
	private Session session;
	
	@SuppressWarnings("unchecked")
	public List<T> getAll(final Class<T> entityClass) {
		LOG.debug("");
		Criteria criteria = session.createCriteria(entityClass);
		return criteria.list();
	}
	
	public void setSession(Session session) {
		this.session = session;
	}
	
	public Session getSession() {
		return this.session;
	}
}
