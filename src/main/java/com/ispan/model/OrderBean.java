package com.ispan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table(name = "orders")
@Component
public class OrderBean {
	@Id
	@GeneratedValue (strategy =  GenerationType.IDENTITY)
	private Integer orderId;
	private String orderCategory;
	private Integer userNo;
	private Integer orderTotal;
	private Integer orderDiscount;
	private Integer couponId;
	private Integer orderStatus;
	private Integer orderPayStatus;
	private String orderDatePlus;
	
	public OrderBean() {
		super();
	}
	
	public OrderBean(Integer orderId, String orderCategory, Integer userNo, Integer orderTotal, Integer orderDiscount,
			Integer couponId, Integer orderStatus, Integer orderPayStatus, String orderDatePlus) {
		super();
		this.orderId = orderId;
		this.orderCategory = orderCategory;
		this.userNo = userNo;
		this.orderTotal = orderTotal;
		this.orderDiscount = orderDiscount;
		this.couponId = couponId;
		this.orderStatus = orderStatus;
		this.orderPayStatus = orderPayStatus;
		this.orderDatePlus = orderDatePlus;
	}
	
	
	public OrderBean(String orderCategory, Integer userNo, Integer orderTotal, Integer orderDiscount, Integer couponId,
			Integer orderStatus, Integer orderPayStatus, String orderDatePlus) {
		super();
		this.orderCategory = orderCategory;
		this.userNo = userNo;
		this.orderTotal = orderTotal;
		this.orderDiscount = orderDiscount;
		this.couponId = couponId;
		this.orderStatus = orderStatus;
		this.orderPayStatus = orderPayStatus;
		this.orderDatePlus = orderDatePlus;
	}

	public OrderBean(Integer orderId) {
		super();
		this.orderId = orderId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderCategory() {
		return orderCategory;
	}

	public void setOrderCategory(String orderCategory) {
		this.orderCategory = orderCategory;
	}

	public Integer getUserNo() {
		return userNo;
	}

	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}

	public Integer getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(Integer orderTotal) {
		this.orderTotal = orderTotal;
	}

	public Integer getOrderDiscount() {
		return orderDiscount;
	}

	public void setOrderDiscount(Integer orderDiscount) {
		this.orderDiscount = orderDiscount;
	}

	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getOrderPayStatus() {
		return orderPayStatus;
	}

	public void setOrderPayStatus(Integer orderPayStatus) {
		this.orderPayStatus = orderPayStatus;
	}

	public String getOrderDatePlus() {
		return orderDatePlus;
	}

	public void setOrderDatePlus(String orderDatePlus) {
		this.orderDatePlus = orderDatePlus;
	}
	}
	