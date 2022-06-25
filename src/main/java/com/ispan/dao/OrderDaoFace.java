package com.ispan.dao;

import java.util.List;

import com.ispan.model.OrderBean;

public interface OrderDaoFace {

	public List<OrderBean> selectAll() throws Exception;
	
	public void insert(OrderBean orderBean) throws Exception;
	
	public OrderBean selectOne(int orderId) throws Exception;
	
	public void update(OrderBean orderBean) throws Exception;
	
	public void delete(int orderid) throws Exception;
}
