package com.diankangwo.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 分享记录表
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "Invitation")
@Table(name = "td_invitation")
public class Invitation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	/**
	 * id
	 */
	@Column(name = "uid")
	private Integer uid;
	
	/**
	 * 用户名
	 */
	@Column(name = "userName")
	private String userName;
	
	/**
	 * 内容
	 */
	@Column(name = "text")
	private String text;
	
	/**
	 * 时间
	 */
	@Column(name = "date")
	private Date date;
	
	/**
	 * 我本次的收益
	 */
	@Column(name = "my_earnings")
	private Double my_earnings;
	
	/**
	 * 消费总金额
	 */
	@Column(name = "spending_total")
	private Double spending_total;
	
	/**
	 * fuid
	 */
	@Column(name = "fuid")
	private String fuid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getMy_earnings() {
		return my_earnings;
	}
	public void setMy_earnings(Double my_earnings) {
		this.my_earnings = my_earnings;
	}
	public Double getSpending_total() {
		return spending_total;
	}
	public void setSpending_total(Double spending_total) {
		this.spending_total = spending_total;
	}
	public String getFuid() {
		return fuid;
	}
	public void setFuid(String fuid) {
		this.fuid = fuid;
	}
	
}
