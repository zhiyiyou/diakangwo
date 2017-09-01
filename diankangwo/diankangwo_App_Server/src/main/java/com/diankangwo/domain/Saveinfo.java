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
 * 库存配置信息
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "Saveinfo")
@Table(name = "td_Saveinfo")
public class Saveinfo implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	/**
	 * 满库数量
	 */
	@Column(name = "allNum")
	private int allNum;
	/**
	 * 预警数量
	 */
	@Column(name = "alertNum")
	private int alertNum;
	/**
	 * 添加时间
	 */
	@Column(name = "addTime")
	private Timestamp addTime;

	public Saveinfo() {
	}

	public Saveinfo(int id, int allNum, int alertNum, Timestamp addTime) {
		this.id = id;
		this.allNum = allNum;
		this.alertNum = alertNum;
		this.addTime = addTime;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAllNum() {
		return this.allNum;
	}

	public void setAllNum(int allNum) {
		this.allNum = allNum;
	}

	public int getAlertNum() {
		return this.alertNum;
	}

	public void setAlertNum(int alertNum) {
		this.alertNum = alertNum;
	}

	public Date getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

}
