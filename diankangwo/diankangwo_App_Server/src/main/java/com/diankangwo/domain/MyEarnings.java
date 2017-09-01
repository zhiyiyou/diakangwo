package com.diankangwo.domain;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 收益记录表
 * 
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "MyEarnings")
@Table(name = "td_MyEarnings")
public class MyEarnings implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	/**
	 * 用户UID
	 */
	@Column(name = "uid")
	private String uid;
	/**
	 * 我的本次收益
	 */
	@Column(name = "my_earnings")
	private Float my_earnings;
	/**
	 * 时间
	 */
	@Column(name = "date")
	private Date date;
	/**
	 * 订单号
	 */
	@Column(name = "order_id")
	private String order_id;
	/**
	 * 文本
	 */
	@Column(name = "text")
	private String text;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Float getMy_earnings() {
		return my_earnings;
	}

	public void setMy_earnings(Float my_earnings) {
		this.my_earnings = my_earnings;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
