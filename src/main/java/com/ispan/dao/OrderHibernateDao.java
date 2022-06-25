package com.ispan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.dao.OrderDaoFace;
import com.ispan.model.OrderBean;

@Repository
@Transactional
public class OrderHibernateDao implements OrderDaoFace {
	
	@Autowired
	private	SessionFactory factory;
	
	
	@Override
	public List<OrderBean> selectAll() throws Exception {
		List<OrderBean> orderBeans;
		
		Session session = factory.getCurrentSession();
		String hql = "FROM OrderBean";
		orderBeans = session.createQuery(hql, OrderBean.class)
								.getResultList();
		
		return orderBeans;
		
	}

	@Override
	public void insert(OrderBean orderBean) throws Exception {
		Session session = factory.getCurrentSession();
		session.save(orderBean);
		
	}

	@Override
	public OrderBean selectOne(int orderId) throws Exception {
		
		Session session = factory.getCurrentSession();
		String hql = "FROM OrderBean o WHERE o.orderId = :orderid";
		OrderBean orderBean = session.createQuery(hql, OrderBean.class)
						.setParameter("orderid", orderId)
						.getSingleResult();
		
		return orderBean;
	}

	@Override
	public void update(OrderBean orderBean) throws Exception {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(orderBean);
		
	}

	@Override
	public void delete(int orderid) throws Exception {
		Session session = factory.getCurrentSession();
		OrderBean orderBean = new OrderBean();
		orderBean.setOrderId(orderid);
		session.delete(orderBean);
		
	}

}
