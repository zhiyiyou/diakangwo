package com.diankangwo.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户日志
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "Userlog")
@Table(name = "td_Userlog")
public class Userlog implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	/**
	 * 用户名
	 */
	@Column(name = "userName")
	private String userName;
	/**
	 * ip地址
	 */
	@Column(name = "ipAddress")
	private String ipAddress;
	/**
	 * 时间
	 */
	@Column(name = "datetime")
	private Timestamp datetime;
	
	/**
	 * 内容
	 */
	@Column(name = "content")
	private String content;

	public Userlog() {
	}

	public Userlog(int id, String userName, String ipAddress, String content,Timestamp datetime) {
		this.id = id;
		this.userName = userName;
		this.ipAddress = ipAddress;
		this.datetime = datetime;
		this.content = content;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Date getDatetime() {
		return this.datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
