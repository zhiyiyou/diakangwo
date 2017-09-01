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
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * 购物订单记录
 * @author xiaoyu
 *
 */
@SuppressWarnings("serial")
@Entity(name = "Order")
@Table(name = "td_Order")
public class Order implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	/**
	 * 用户信息
	 */
	@ManyToOne
	@JoinColumn(name="userinfoId") 
	private UserInfo userinfo;
	/**
	 * 送货方式
	 */
	@Column(name = "orderGoodsSendType")
	private String orderGoodsSendType;
	/**
	 * 客户订单 UID
	 */
	@Column(name = "coi_uid", nullable = false)
	private String coiUid; 
	/**
	 * 订单编号
	 */
	@Column(name = "order_no", unique = true, nullable = false)
	private String orderNo; 
	/**
	 * 客户名称
	 */
	@Column(name = "user_name", nullable = false)
	private String userName; 
	/**
	 * 客户电话
	 */
	@Column(name = "user_phone", nullable = false)
	private String userPhone; 
	/**
	 * 下单渠道
	 */
	@Column(name = "order_chanel")
	private String orderChanel;

	/**
	 * 省
	 */
	@Column(name = "province",nullable = false)
	private String Province;
	/**
	 * 市
	 */
	@Column(name = "city",nullable = false)
	private String City;
	/**
	 * 区
	 */
	@Column(name = "area",nullable = false)
	private String Area;
	/**
	 * 服务地址
	 */
	@Column(name = "address", nullable = false)
	private String Address;
	/**
	 * 订单状态
	 */
	@Column(name = "order_status", nullable = false)
	private String orderStatus;
	/**
	 * 是否取消
	 */
	@Column(name="cancel" , nullable = false)
	private boolean cancel = false;
	/**
	 * 取消时间
	 */
	@Column(name="cancel_date")
	private Date cancelDate;
	/**
	 * 取消原因
	 */
	@Column(name="cancel_reason")
	private String cancelReason;
	/**
	 * 取消备注
	 */
	@Column(name="cancel_remarks",length=2000)
	private String cancelRemarks;
	/**
	 * 订单创建时间
	 */
	@OrderBy("create_date desc")
	@Column(name = "create_date", nullable = false)
	private Date createDate;
	/**
	 * 订单最后修改者
	 */
	@Column(name = "update_user",nullable = false)
	private String updateUser;
	/**
	 * 订单最后修改时间
	 */
	@Column(name = "update_date",nullable = false)
	private Date updateDate;
	/**
	 * 支付类型
	 */
	@Column(name = "payType")
	private String payType;
	/**
	 * 支付时间
	 */
	@Column(name = "payDate")
	private Date payDate;
	/**
	 * 是否支付
	 */
	@Column(name="isPay")
	private String isPay = "0";
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserInfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
	public String getOrderGoodsSendType() {
		return orderGoodsSendType;
	}
	public void setOrderGoodsSendType(String orderGoodsSendType) {
		this.orderGoodsSendType = orderGoodsSendType;
	}
	public String getCoiUid() {
		return coiUid;
	}
	public void setCoiUid(String coiUid) {
		this.coiUid = coiUid;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getOrderChanel() {
		return orderChanel;
	}
	public void setOrderChanel(String orderChanel) {
		this.orderChanel = orderChanel;
	}
	public String getProvince() {
		return Province;
	}
	public void setProvince(String province) {
		Province = province;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public boolean isCancel() {
		return cancel;
	}
	public void setCancel(boolean cancel) {
		this.cancel = cancel;
	}
	public Date getCancelDate() {
		return cancelDate;
	}
	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}
	public String getCancelReason() {
		return cancelReason;
	}
	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}
	public String getCancelRemarks() {
		return cancelRemarks;
	}
	public void setCancelRemarks(String cancelRemarks) {
		this.cancelRemarks = cancelRemarks;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public String getIsPay() {
		return isPay;
	}
	public void setIsPay(String isPay) {
		this.isPay = isPay;
	}
	
}
