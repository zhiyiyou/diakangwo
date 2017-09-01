package com.diankangwo.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户积分类
 * 
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "Integral")
@Table(name = "td_Integral")
public class Integral implements Serializable {
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
	 * 内容
	 */
	@Column(name = "text")
	private String text;

	/**
	 * 时间
	 */
	@Column(name = "date")
	private Timestamp date;

	/**
	 * 金额
	 */
	@Column(name = "money")
	private Double money;

	/**
	 * 类型
	 */
	@Column(name = "type")
	private String type;

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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
