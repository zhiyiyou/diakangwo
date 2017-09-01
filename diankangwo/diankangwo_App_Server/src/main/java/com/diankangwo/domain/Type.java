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
 * 一级分类
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "Type")
@Table(name = "td_Type")
public class Type implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	/**
	 * 分类名称
	 */
	@Column(name = "typeName")
	private String typeName;
	/**
	 * 分类描述
	 */
	@Column(name = "typeText")
	private String typeText;
	/**
	 * 显示级别
	 */
	@Column(name = "typeOrder")
	private Integer typeOrder;
	/**
	 * 一级分类显示
	 */
	@Column(name = "typeCheck")
	private Integer typeCheck;
	/**
	 * 录入时间
	 */
	@Column(name = "typeTime")
	private Timestamp typeTime;

	public Type() {
	}

	public Type(int id, String typeName, Timestamp typeTime) {
		this.id = id;
		this.typeName = typeName;
		this.typeTime = typeTime;
	}

	public Type(int id, String typeName, String typeText, Integer typeOrder, Integer typeCheck, Timestamp typeTime
			) {
		this.id = id;
		this.typeName = typeName;
		this.typeText = typeText;
		this.typeOrder = typeOrder;
		this.typeCheck = typeCheck;
		this.typeTime = typeTime;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeText() {
		return this.typeText;
	}

	public void setTypeText(String typeText) {
		this.typeText = typeText;
	}

	public Integer getTypeOrder() {
		return this.typeOrder;
	}

	public void setTypeOrder(Integer typeOrder) {
		this.typeOrder = typeOrder;
	}

	public Integer getTypeCheck() {
		return this.typeCheck;
	}

	public void setTypeCheck(Integer typeCheck) {
		this.typeCheck = typeCheck;
	}

	public Date getTypeTime() {
		return this.typeTime;
	}

	public void setTypeTime(Timestamp typeTime) {
		this.typeTime = typeTime;
	}

}
