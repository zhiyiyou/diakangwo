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
 * 商品库存
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "Commoditysave")
@Table(name = "td_Commoditysave")
public class Commoditysave implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	/**
	 * 商品ID
	 */
	@ManyToOne
	@JoinColumn(name="commodityID") 
	private Commodity commodity;
	/**
	 * 商品名称
	 */
	@Column(name = "commodityName")
	private String commodityName;
	/**
	 * 库存数量
	 */
	@Column(name = "saveNum")
	private int saveNum;
	/**
	 * 增加数量
	 */
	@Column(name = "saveAddNum")
	private Integer saveAddNum;
	/**
	 * 入库时间 
	 */
	@Column(name = "saveTime")
	private Timestamp saveTime;
	/**
	 * 增加库存时间 
	 */
	@Column(name = "saveAddTime")
	private Timestamp saveAddTime;

	public Commoditysave() {
	}

	public Commoditysave(int id, Commodity commodity, String commodityName, int saveNum, Timestamp saveTime) {
		this.id = id;
		this.commodity = commodity;
		this.commodityName = commodityName;
		this.saveNum = saveNum;
		this.saveTime = saveTime;
	}

	public Commoditysave(int id, Commodity commodity, String commodityName, int saveNum, Integer saveAddNum,
			Timestamp saveTime, Timestamp saveAddTime) {
		this.id = id;
		this.commodity = commodity;
		this.commodityName = commodityName;
		this.saveNum = saveNum;
		this.saveAddNum = saveAddNum;
		this.saveTime = saveTime;
		this.saveAddTime = saveAddTime;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Commodity getCommodity() {
		return this.commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public String getCommodityName() {
		return this.commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public int getSaveNum() {
		return this.saveNum;
	}

	public void setSaveNum(int saveNum) {
		this.saveNum = saveNum;
	}

	public Integer getSaveAddNum() {
		return this.saveAddNum;
	}

	public void setSaveAddNum(Integer saveAddNum) {
		this.saveAddNum = saveAddNum;
	}

	public Timestamp getSaveTime() {
		return this.saveTime;
	}

	public void setSaveTime(Timestamp saveTime) {
		this.saveTime = saveTime;
	}

	public Timestamp getSaveAddTime() {
		return this.saveAddTime;
	}

	public void setSaveAddTime(Timestamp saveAddTime) {
		this.saveAddTime = saveAddTime;
	}

}
