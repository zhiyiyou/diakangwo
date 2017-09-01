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
 * 收藏夹
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "Favorite")
@Table(name = "td_Favorite")
public class Favorite implements Serializable {
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
	 * 用户ID
	 */
	@ManyToOne
	@JoinColumn(name="userId") 
	private UserInfo user;
	/**
	 * 商品名称
	 */
	@Column(name = "commodityName")
	private String commodityName;
	/**
	 * 商品市场价
	 */
	@Column(name = "commodityPriceShop")
	private long commodityPriceShop;
	/**
	 * 商品优惠价
	 */
	@Column(name = "commodityPriceUser")
	private long commodityPriceUser;
	/**
	 * 商品收藏时间
	 */
	@Column(name = "favoriteTime")
	private Timestamp favoriteTime;

	public Favorite() {
	}

	public Favorite(int id, Commodity commodity, UserInfo user, String commodityName, long commodityPriceShop,
			long commodityPriceUser, Timestamp favoriteTime) {
		this.id = id;
		this.commodity = commodity;
		this.user = user;
		this.commodityName = commodityName;
		this.commodityPriceShop = commodityPriceShop;
		this.commodityPriceUser = commodityPriceUser;
		this.favoriteTime = favoriteTime;
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

	public UserInfo getUser() {
		return this.user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public String getCommodityName() {
		return this.commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public long getCommodityPriceShop() {
		return this.commodityPriceShop;
	}

	public void setCommodityPriceShop(long commodityPriceShop) {
		this.commodityPriceShop = commodityPriceShop;
	}

	public long getCommodityPriceUser() {
		return this.commodityPriceUser;
	}

	public void setCommodityPriceUser(long commodityPriceUser) {
		this.commodityPriceUser = commodityPriceUser;
	}

	public Timestamp getFavoriteTime() {
		return this.favoriteTime;
	}

	public void setFavoriteTime(Timestamp favoriteTime) {
		this.favoriteTime = favoriteTime;
	}

}
