package com.diankangwo.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 在线支付返回日志
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "OnlilnePaylogresult")
@Table(name = "td_OnlilnePaylogresult")
public class OnlilnePaylogresult implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	/**
	 * 订单号
	 */
	@Column(name = "billNo")
	private String billNo;
	/**
	 * 支付方式
	 */
	@Column(name = "channelType")
	private String channelType;
	/**
	 * 返回消息详情
	 */
	@Column(name = "messageDetail")
	private String messageDetail;
	/**
	 * 选择
	 */
	@Column(name = "optional")
	private String optional;
	/**
	 * 事件类型
	 */
	@Column(name = "subChannelType")
	private String subChannelType;
	/**
	 * 金额
	 */
	@Column(name = "transactionFee")
	private Integer transactionFee;
	/**
	 * 交易类型
	 */
	@Column(name = "transactionType")
	private String transactionType;
	/**
	 * 创建时间
	 */
	@Column(name = "createDate")
	private Timestamp createDate;

	public OnlilnePaylogresult() {
	}

	public OnlilnePaylogresult(int id, String billNo) {
		this.id = id;
		this.billNo = billNo;
	}

	public OnlilnePaylogresult(int id, String billNo, String channelType, String messageDetail, String optional,
			String subChannelType, Integer transactionFee, String transactionType,Timestamp createData) {
		this.id = id;
		this.billNo = billNo;
		this.channelType = channelType;
		this.messageDetail = messageDetail;
		this.optional = optional;
		this.subChannelType = subChannelType;
		this.transactionFee = transactionFee;
		this.transactionType = transactionType;
		this.createDate = createData;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBillNo() {
		return this.billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getChannelType() {
		return this.channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public String getMessageDetail() {
		return this.messageDetail;
	}

	public void setMessageDetail(String messageDetail) {
		this.messageDetail = messageDetail;
	}

	public String getOptional() {
		return this.optional;
	}

	public void setOptional(String optional) {
		this.optional = optional;
	}

	public String getSubChannelType() {
		return this.subChannelType;
	}

	public void setSubChannelType(String subChannelType) {
		this.subChannelType = subChannelType;
	}

	public Integer getTransactionFee() {
		return this.transactionFee;
	}

	public void setTransactionFee(Integer transactionFee) {
		this.transactionFee = transactionFee;
	}

	public String getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

}
