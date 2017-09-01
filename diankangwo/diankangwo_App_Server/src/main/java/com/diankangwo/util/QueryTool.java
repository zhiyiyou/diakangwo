package com.diankangwo.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 封装常用的查询条件
 * 
 * @author xiaoyu
 *
 */
public class QueryTool {

	private Integer id; // id

	private String uidKey; // uuid/guid

	private String orderNo; // 订单号

	private Integer pageNo; // 分页-当前页

	private Integer pageSize; // 分页-当前码

	private String search; // 条件查询内容
	
	private Integer pid; // 地址 省级代码
	
	private Integer cid; // 地址 市级代码
	
	private Integer aid; // 地址 区级代码

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUidKey() {
		return uidKey;
	}

	public void setUidKey(String uidKey) {
		this.uidKey = uidKey;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getSearch() {
		if (search == null) {
			return "";
		} else {
			try {
				search = URLDecoder.decode(search, "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return search;
		}
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

}
