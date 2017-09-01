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
 * 购物车
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "ShoppingCart")
@Table(name = "td_ShoppingCart")
public class ShoppingCart implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	/**
	 * 商品ID
	 */
	@Column(name = "commodityId")
	private Integer commodityId;
	/**
	 * 用户ID
	 */
	@Column(name = "userId")
	private Integer userId;
	/**
	 * 用户cookID
	 */
	@Column(name = "userCookId")
	private int userCookId;
	/**
	 * 用户IP
	 */
	@Column(name = "userIp")
	private String userIp;
	/**
	 * 商品名称
	 */
	@Column(name = "commodityName")
	private String commodityName;
	/**
	 * 购物时间
	 */
	@Column(name = "shoppingTime")
	private Timestamp shoppingTime;
	/**
	 * 是否审核
	 */
	@Column(name = "shoppingCheck")
	private Boolean shoppingCheck;
	/**
	 * 购买数量
	 */
	@Column(name = "commodityNumber")
	private int commodityNumber;
	/**
	 * 商品会员价
	 */
	@Column(name = "commodityPriceUser")
	private long commodityPriceUser;
	/**
	 * 商品市场价
	 */
	@Column(name = "commodityPriceShop")
	private long commodityPriceShop;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserCookId() {
		return this.userCookId;
	}

	public void setUserCookId(int userCookId) {
		this.userCookId = userCookId;
	}

	public String getUserIp() {
		return this.userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getCommodityName() {
		return this.commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public Date getShoppingTime() {
		return this.shoppingTime;
	}

	public void setShoppingTime(Timestamp shoppingTime) {
		this.shoppingTime = shoppingTime;
	}

	public Boolean getShoppingCheck() {
		return this.shoppingCheck;
	}

	public void setShoppingCheck(Boolean shoppingCheck) {
		this.shoppingCheck = shoppingCheck;
	}

	public int getCommodityNumber() {
		return this.commodityNumber;
	}

	public void setCommodityNumber(int commodityNumber) {
		this.commodityNumber = commodityNumber;
	}

	public long getCommodityPriceUser() {
		return this.commodityPriceUser;
	}

	public void setCommodityPriceUser(long commodityPriceUser) {
		this.commodityPriceUser = commodityPriceUser;
	}

	public long getCommodityPriceShop() {
		return this.commodityPriceShop;
	}

	public void setCommodityPriceShop(long commodityPriceShop) {
		this.commodityPriceShop = commodityPriceShop;
	}

	public Integer getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(Integer commodityId) {
		this.commodityId = commodityId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
