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
 * 在线退款记录
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "OnlineRefundlog")
@Table(name = "td_OnlineRefundlog")
public class OnlineRefundlog implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	/**
	 * 账户名称
	 */
	@Column(name = "accountName")
	private String accountName;
	/**
	 * 批号
	 */
	@Column(name = "batchNo")
	private String batchNo;
	/**
	 * 订单号
	 */
	@Column(name = "billNo")
	private String billNo;
	/**
	 * 创建时间
	 */
	@Column(name = "createDate")
	private Timestamp createDate;
	/**
	 * 创建人
	 */
	@Column(name = "createUser")
	private String createUser;
	/**
	 * 商品名称
	 */
	@Column(name = "commodityName")
	private String idKey;
	/**
	 * 退款金额
	 */
	@Column(name = "refundFee")
	private Integer refundFee;
	/**
	 * 退款编号
	 */
	@Column(name = "refundNo")
	private String refundNo;
	/**
	 * 退款状态
	 */
	@Column(name = "refundStatus")
	private String refundStatus;
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
	 * 用户退款状态
	 */
	@Column(name = "userRefundStatus")
	private String userRefundStatus;
	/**
	 * 第三方返回状态
	 */
	@Column(name = "webhookStatus")
	private String webhookStatus;

	public OnlineRefundlog() {
	}

	public OnlineRefundlog(int id, String idKey) {
		this.id = id;
		this.idKey = idKey;
	}

	public OnlineRefundlog(int id, String accountName, String batchNo, String billNo, Timestamp createDate,
			String createUser, String idKey, Integer refundFee, String refundNo, String refundStatus, Timestamp updateDate,
			String updateUser, String userRefundStatus, String webhookStatus) {
		this.id = id;
		this.accountName = accountName;
		this.batchNo = batchNo;
		this.billNo = billNo;
		this.createDate = createDate;
		this.createUser = createUser;
		this.idKey = idKey;
		this.refundFee = refundFee;
		this.refundNo = refundNo;
		this.refundStatus = refundStatus;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
		this.userRefundStatus = userRefundStatus;
		this.webhookStatus = webhookStatus;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getBatchNo() {
		return this.batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getBillNo() {
		return this.billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
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

	public Integer getRefundFee() {
		return this.refundFee;
	}

	public void setRefundFee(Integer refundFee) {
		this.refundFee = refundFee;
	}

	public String getRefundNo() {
		return this.refundNo;
	}

	public void setRefundNo(String refundNo) {
		this.refundNo = refundNo;
	}

	public String getRefundStatus() {
		return this.refundStatus;
	}

	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getUserRefundStatus() {
		return this.userRefundStatus;
	}

	public void setUserRefundStatus(String userRefundStatus) {
		this.userRefundStatus = userRefundStatus;
	}

	public String getWebhookStatus() {
		return this.webhookStatus;
	}

	public void setWebhookStatus(String webhookStatus) {
		this.webhookStatus = webhookStatus;
	}

}
