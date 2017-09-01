package com.diankangwo.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 端口交易记录
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "PortPayLog")
@Table(name = "td_PortPayLog")
public class PortPayLog implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	/**
	 * 用户信息
	 */
	@ManyToOne
	@JoinColumn(name="userID") 
	private UserInfo userinfo;
	/**
	 * 端口ID
	 */
	@Column(name = "portId")
	private int portId;
	/**
	 * 交易价格
	 */
	@Column(name = "price")
	private Float price;
	/**
	 * 交易时间
	 */
	@Column(name = "date")
	private Timestamp date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserInfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
	public int getPortId() {
		return portId;
	}
	public void setPortId(int portId) {
		this.portId = portId;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
}
