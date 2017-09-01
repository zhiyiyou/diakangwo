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
 * 商品信息
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "Commodity")
@Table(name = "td_Commodity")
public class Commodity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	/**
	 * 二级分类
	 */
	@Column(name = "border")
	private Border border;
	/**
	 * 一级分类
	 */
	@Column(name = "type")
	private Type type;
	/**
	 * 商品编号
	 */
	@Column(name = "commodityNo")
	private String commodityNo;
	/**
	 * 商品型号
	 */
	@Column(name = "commodityTypeCode")
	private String commodityTypeCode;
	/**
	 * 商品名称
	 */
	@Column(name = "commodityName")
	private String commodityName;
	/**
	 * 录入时间
	 */
	@Column(name = "commodityInTime")
	private Timestamp commodityInTime;
	/**
	 * 商品销售量
	 */
	@Column(name = "commodityBuyNum")
	private int commodityBuyNum;
	/**
	 * 商品下单数
	 */
	@Column(name = "commodityOrderNum")
	private int commodityOrderNum;
	/**
	 * 商品评论数
	 */
	@Column(name = "commodityReviews")
	private int commodityReviews;
	/**
	 * 商品点击数
	 */
	@Column(name = "commodityHits")
	private int commodityHits;
	/**
	 * 商品审核人
	 */
	@Column(name = "commodityCheckAdmin")
	private String commodityCheckAdmin;
	/**
	 * 商品是否审核
	 */
	@Column(name = "commodityCheck")
	private boolean commodityCheck;
	/**
	 * 商品显示级别
	 */
	@Column(name = "commodityOrder")
	private int commodityOrder;
	/**
	 * 商品是否推荐
	 */
	@Column(name = "commodityIsVouch")
	private boolean commodityIsVouch;
	/**
	 * 商品是否新品
	 */
	@Column(name = "commodityIsNew")
	private boolean commodityIsNew;
	/**
	 * 商品上市时间
	 */
	@Column(name = "commodityOnTime")
	private Timestamp commodityOnTime;
	/**
	 * 商品折扣数
	 */
	@Column(name = "commodityPricePer")
	private Double commodityPricePer;
	/**
	 * 商品VIP价
	 */
	@Column(name = "commodityPriceVip")
	private Long commodityPriceVip;
	/**
	 * 商品优惠价
	 */
	@Column(name = "commodityPriceUser")
	private Long commodityPriceUser;
	/**
	 * 商品市场价
	 */
	@Column(name = "commodityPriceShop")
	private long commodityPriceShop;
	/**
	 * 商品品牌
	 */
	@Column(name = "commodityPt")
	private String commodityPt;
	/**
	 * 商品大图
	 */
	@Column(name = "commodityPicLarge")
	private String commodityPicLarge;
	/**
	 * 商品缩略图
	 */
	@Column(name = "commodityPicSmall")
	private String commodityPicSmall;
	/**
	 * 商品描述
	 */
	@Column(name = "commodityContent")
	private String commodityContent;
	/**
	 * 商品简介
	 */
	@Column(name = "commodityText")
	private String commodityText;
	/**
	 * 商品关键字
	 */
	@Column(name = "commodityKeys")
	private String commodityKeys;
	public Commodity() {
	}

	public Commodity(int id, Border border, Type type, String commodityNo, String commodityTypeCode,
			String commodityName, Timestamp commodityInTime, int commodityBuyNum, int commodityOrderNum,
			int commodityReviews, int commodityHits, String commodityCheckAdmin, boolean commodityCheck,
			int commodityOrder, boolean commodityIsVouch, boolean commodityIsNew, Timestamp commodityOnTime,
			long commodityPriceShop, String commodityPt, String commodityPicLarge, String commodityPicSmall,
			String commodityContent, String commodityText, String commodityKeys) {
		this.id = id;
		this.border = border;
		this.type = type;
		this.commodityNo = commodityNo;
		this.commodityTypeCode = commodityTypeCode;
		this.commodityName = commodityName;
		this.commodityInTime = commodityInTime;
		this.commodityBuyNum = commodityBuyNum;
		this.commodityOrderNum = commodityOrderNum;
		this.commodityReviews = commodityReviews;
		this.commodityHits = commodityHits;
		this.commodityCheckAdmin = commodityCheckAdmin;
		this.commodityCheck = commodityCheck;
		this.commodityOrder = commodityOrder;
		this.commodityIsVouch = commodityIsVouch;
		this.commodityIsNew = commodityIsNew;
		this.commodityOnTime = commodityOnTime;
		this.commodityPriceShop = commodityPriceShop;
		this.commodityPt = commodityPt;
		this.commodityPicLarge = commodityPicLarge;
		this.commodityPicSmall = commodityPicSmall;
		this.commodityContent = commodityContent;
		this.commodityText = commodityText;
		this.commodityKeys = commodityKeys;
	}

	public Commodity(int id, Border border, Type type, String commodityNo, String commodityTypeCode,
			String commodityName, Timestamp commodityInTime, int commodityBuyNum, int commodityOrderNum,
			int commodityReviews, int commodityHits, String commodityCheckAdmin, boolean commodityCheck,
			int commodityOrder, boolean commodityIsVouch, boolean commodityIsNew, Timestamp commodityOnTime,
			Double commodityPricePer, Long commodityPriceVip, Long commodityPriceUser, long commodityPriceShop,
			String commodityPt, String commodityPicLarge, String commodityPicSmall, String commodityContent,
			String commodityText, String commodityKeys) {
		this.id = id;
		this.border = border;
		this.type = type;
		this.commodityNo = commodityNo;
		this.commodityTypeCode = commodityTypeCode;
		this.commodityName = commodityName;
		this.commodityInTime = commodityInTime;
		this.commodityBuyNum = commodityBuyNum;
		this.commodityOrderNum = commodityOrderNum;
		this.commodityReviews = commodityReviews;
		this.commodityHits = commodityHits;
		this.commodityCheckAdmin = commodityCheckAdmin;
		this.commodityCheck = commodityCheck;
		this.commodityOrder = commodityOrder;
		this.commodityIsVouch = commodityIsVouch;
		this.commodityIsNew = commodityIsNew;
		this.commodityOnTime = commodityOnTime;
		this.commodityPricePer = commodityPricePer;
		this.commodityPriceVip = commodityPriceVip;
		this.commodityPriceUser = commodityPriceUser;
		this.commodityPriceShop = commodityPriceShop;
		this.commodityPt = commodityPt;
		this.commodityPicLarge = commodityPicLarge;
		this.commodityPicSmall = commodityPicSmall;
		this.commodityContent = commodityContent;
		this.commodityText = commodityText;
		this.commodityKeys = commodityKeys;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Border getBorder() {
		return this.border;
	}

	public void setBorder(Border border) {
		this.border = border;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getCommodityNo() {
		return this.commodityNo;
	}

	public void setCommodityNo(String commodityNo) {
		this.commodityNo = commodityNo;
	}

	public String getCommodityTypeCode() {
		return this.commodityTypeCode;
	}

	public void setCommodityTypeCode(String commodityTypeCode) {
		this.commodityTypeCode = commodityTypeCode;
	}

	public String getCommodityName() {
		return this.commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public Date getCommodityInTime() {
		return this.commodityInTime;
	}

	public void setCommodityInTime(Timestamp commodityInTime) {
		this.commodityInTime = commodityInTime;
	}

	public int getCommodityBuyNum() {
		return this.commodityBuyNum;
	}

	public void setCommodityBuyNum(int commodityBuyNum) {
		this.commodityBuyNum = commodityBuyNum;
	}

	public int getCommodityOrderNum() {
		return this.commodityOrderNum;
	}

	public void setCommodityOrderNum(int commodityOrderNum) {
		this.commodityOrderNum = commodityOrderNum;
	}

	public int getCommodityReviews() {
		return this.commodityReviews;
	}

	public void setCommodityReviews(int commodityReviews) {
		this.commodityReviews = commodityReviews;
	}

	public int getCommodityHits() {
		return this.commodityHits;
	}

	public void setCommodityHits(int commodityHits) {
		this.commodityHits = commodityHits;
	}

	public String getCommodityCheckAdmin() {
		return this.commodityCheckAdmin;
	}

	public void setCommodityCheckAdmin(String commodityCheckAdmin) {
		this.commodityCheckAdmin = commodityCheckAdmin;
	}

	public boolean isCommodityCheck() {
		return this.commodityCheck;
	}

	public void setCommodityCheck(boolean commodityCheck) {
		this.commodityCheck = commodityCheck;
	}

	public int getCommodityOrder() {
		return this.commodityOrder;
	}

	public void setCommodityOrder(int commodityOrder) {
		this.commodityOrder = commodityOrder;
	}

	public boolean isCommodityIsVouch() {
		return this.commodityIsVouch;
	}

	public void setCommodityIsVouch(boolean commodityIsVouch) {
		this.commodityIsVouch = commodityIsVouch;
	}

	public boolean isCommodityIsNew() {
		return this.commodityIsNew;
	}

	public void setCommodityIsNew(boolean commodityIsNew) {
		this.commodityIsNew = commodityIsNew;
	}

	public Date getCommodityOnTime() {
		return this.commodityOnTime;
	}

	public void setCommodityOnTime(Timestamp commodityOnTime) {
		this.commodityOnTime = commodityOnTime;
	}

	public Double getCommodityPricePer() {
		return this.commodityPricePer;
	}

	public void setCommodityPricePer(Double commodityPricePer) {
		this.commodityPricePer = commodityPricePer;
	}

	public Long getCommodityPriceVip() {
		return this.commodityPriceVip;
	}

	public void setCommodityPriceVip(Long commodityPriceVip) {
		this.commodityPriceVip = commodityPriceVip;
	}

	public Long getCommodityPriceUser() {
		return this.commodityPriceUser;
	}

	public void setCommodityPriceUser(Long commodityPriceUser) {
		this.commodityPriceUser = commodityPriceUser;
	}

	public long getCommodityPriceShop() {
		return this.commodityPriceShop;
	}

	public void setCommodityPriceShop(long commodityPriceShop) {
		this.commodityPriceShop = commodityPriceShop;
	}

	public String getCommodityPt() {
		return this.commodityPt;
	}

	public void setCommodityPt(String commodityPt) {
		this.commodityPt = commodityPt;
	}

	public String getCommodityPicLarge() {
		return this.commodityPicLarge;
	}

	public void setCommodityPicLarge(String commodityPicLarge) {
		this.commodityPicLarge = commodityPicLarge;
	}

	public String getCommodityPicSmall() {
		return this.commodityPicSmall;
	}

	public void setCommodityPicSmall(String commodityPicSmall) {
		this.commodityPicSmall = commodityPicSmall;
	}

	public String getCommodityContent() {
		return this.commodityContent;
	}

	public void setCommodityContent(String commodityContent) {
		this.commodityContent = commodityContent;
	}

	public String getCommodityText() {
		return this.commodityText;
	}

	public void setCommodityText(String commodityText) {
		this.commodityText = commodityText;
	}

	public String getCommodityKeys() {
		return this.commodityKeys;
	}

	public void setCommodityKeys(String commodityKeys) {
		this.commodityKeys = commodityKeys;
	}

}
