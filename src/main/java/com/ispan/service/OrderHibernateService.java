package com.ispan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.dao.OrderDaoFace;
import com.ispan.model.OrderBean;

@Service
@Transactional
public class OrderHibernateService implements OrderService {
	
	@Autowired
	private	OrderDaoFace oFace;
	

	@Override
	public List<OrderBean> selectAll() throws Exception {
	
		
		return oFace.selectAll();
	}

	@Override
	public void insert(OrderBean orderBean) throws Exception {
	
			oFace.insert(orderBean);

	}

	@Override
	public OrderBean selectOne(int orderId) throws Exception {
		
	
		return oFace.selectOne(orderId);
	}

	@Override
	public void update(OrderBean orderBean) throws Exception {
	
			oFace.update(orderBean);
	
	}

	@Override
	public void delete(int orderid) throws Exception {
	
			oFace.delete(orderid);
	
	}

}
