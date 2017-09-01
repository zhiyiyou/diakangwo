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
 * 在线支付记录
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "OnlinePaylog")
@Table(name = "td_OnlinePaylog")
public class OnlinePaylog implements Serializable {
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
	@JoinColumn(name="userID") 
	private UserInfo userinfo;
	/**
	 * 订单号
	 */
	@Column(name = "billNo")
	private String billNo;
	/**
	 * 创建时间
	 */
	@Column(name = "createTimestamp")
	private Timestamp createTimestamp;
	/**
	 * 创建人
	 */
	@Column(name = "createUser")
	private String createUser;
	/**
	 * key
	 */
	@Column(name = "idKey")
	private String idKey;
	/**
	 * 支付状态
	 */
	@Column(name = "payStatus")
	private String payStatus;
	/**
	 * 支付类型
	 */
	@Column(name = "payType")
	private String payType;
	/**
	 * 返回类型
	 */
	@Column(name = "returnType")
	private String returnType;
	/**
	 * 标题
	 */
	@Column(name = "title")
	private String title;
	/**
	 * 总金额
	 */
	@Column(name = "totalFee")
	private int totalFee;
	/**
	 * 更新时间
	 */
	@Column(name = "updateDate")
	private Timestamp updateDate;
	/**
	 * 更新人
	 */
	@Column(name = "updateUser")
	private String updateUser;
	/**
	 * 用户支付状态
	 */
	@Column(name = "userPayStatus")
	private String userPayStatus;
	/**
	 * 第三方返回支付状态
	 */
	@Column(name = "webhookStatus")
	private String webhookStatus;

	public OnlinePaylog() {
	}

	public OnlinePaylog(int id, Commodity commodity, UserInfo userinfo, String billNo, String idKey, String payType,
			String returnType, String title, int totalFee) {
		this.id = id;
		this.commodity = commodity;
		this.userinfo = userinfo;
		this.billNo = billNo;
		this.idKey = idKey;
		this.payType = payType;
		this.returnType = returnType;
		this.title = title;
		this.totalFee = totalFee;
	}

	public OnlinePaylog(int id, Commodity commodity, UserInfo userinfo, String billNo, Timestamp createTimestamp,
			String createUser, String idKey, String payStatus, String payType, String returnType, String title,
			int totalFee, Timestamp updateDate, String updateUser, String userPayStatus, String webhookStatus
			) {
		this.id = id;
		this.commodity = commodity;
		this.userinfo = userinfo;
		this.billNo = billNo;
		this.createTimestamp = createTimestamp;
		this.createUser = createUser;
		this.idKey = idKey;
		this.payStatus = payStatus;
		this.payType = payType;
		this.returnType = returnType;
		this.title = title;
		this.totalFee = totalFee;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
		this.userPayStatus = userPayStatus;
		this.webhookStatus = webhookStatus;
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

	public UserInfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

	public String getBillNo() {
		return this.billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public Timestamp getCreateTimestamp() {
		return this.createTimestamp;
	}

	public void setCreateTimestamp(Timestamp createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getIdKey() {
		return this.idKey;
	}

	public void setIdKey(String idKey) {
		this.idKey = idKey;
	}

	public String getPayStatus() {
		return this.payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public String getPayType() {
		return this.payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getReturnType() {
		return this.returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTotalFee() {
		return this.totalFee;
	}

	public void setTotalFee(int totalFee) {
		this.totalFee = totalFee;
	}

	public Timestamp getUpDateDate() {
		return this.updateDate;
	}

	public void setUpDateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpDateUser() {
		return this.updateUser;
	}

	public void setUpDateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getUserPayStatus() {
		return this.userPayStatus;
	}

	public void setUserPayStatus(String userPayStatus) {
		this.userPayStatus = userPayStatus;
	}

	public String getWebhookStatus() {
		return this.webhookStatus;
	}

	public void setWebhookStatus(String webhookStatus) {
		this.webhookStatus = webhookStatus;
	}

}
