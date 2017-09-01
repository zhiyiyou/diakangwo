package com.diankangwo.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 商品二级分类
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "Border")
@Table(name = "td_Border")
public class Border implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;					
	/**
	 * 一级分类ID
	 */
	@ManyToOne
	@JoinColumn(name="typeID")
	private Type type;				//一级分类
	/**
	 * 二级分类名称
	 */
	@Column(name = "borderName")
	private String borderName;		//二级分类名称
	/**
	 * 二级分类描述
	 */
	@Column(name = "borderText")
	private String borderText;		//二级分类描述
	/**
	 * 二级分类排序
	 */
	@Column(name = "borderOrder")
	private Integer borderOrder;	//二级分类排序
	/**
	 * 是否显示
	 */
	@Column(name = "borderCheck")
	private Integer borderCheck;	//是否显示
	/**
	 * 时间
	 */
	@Column(name = "borderTime")
	private Date borderTime;		//时间

	public Border() {
	}

	public Border(int id, String borderName, Date borderTime) {
		this.id = id;
		this.borderName = borderName;
		this.borderTime = borderTime;
	}

	public Border(int id, Type type, String borderName, String borderText, Integer borderOrder, Integer borderCheck,
			Date borderTime) {
		this.id = id;
		this.type = type;
		this.borderName = borderName;
		this.borderText = borderText;
		this.borderOrder = borderOrder;
		this.borderCheck = borderCheck;
		this.borderTime = borderTime;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getBorderName() {
		return this.borderName;
	}

	public void setBorderName(String borderName) {
		this.borderName = borderName;
	}

	public String getBorderText() {
		return this.borderText;
	}

	public void setBorderText(String borderText) {
		this.borderText = borderText;
	}

	public Integer getBorderOrder() {
		return this.borderOrder;
	}

	public void setBorderOrder(Integer borderOrder) {
		this.borderOrder = borderOrder;
	}

	public Integer getBorderCheck() {
		return this.borderCheck;
	}

	public void setBorderCheck(Integer borderCheck) {
		this.borderCheck = borderCheck;
	}

	public Date getBorderTime() {
		return this.borderTime;
	}

	public void setBorderTime(Date borderTime) {
		this.borderTime = borderTime;
	}

}
