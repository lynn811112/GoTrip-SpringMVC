package com.ispan.dao;

import java.util.List;

//import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.model.TicketBean;

@Repository
@Transactional
public class TicketDaoImpl implements TicketDao {

	//Logger logger = Logger.getLogger(TicketDaoImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	TicketBean ticketBean;

//	  @Autowired
//	  public TicketDaoImpl(SessionFactory sessionFactory) {
//	        this.sessionFactory = sessionFactory;
//	    }

	@Override
	public Object save(TicketBean ticketBean) {
		Session session = sessionFactory.openSession();
		System.out.println("TicketDaoImp line:31");
//		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		//session.beginTransaction();
		session.save(ticketBean);
		session.getTransaction().commit();
		System.out.println("TicketDaoImpl的save工作囉!");
		return ticketBean;
	}

	@Override
	public TicketBean findById(int ticketNo) {
		TicketBean ticketBean = null;
		Session session = sessionFactory.openSession();
//		Session session = sessionFactory.getCurrentSession();
		Integer ipk = Integer.valueOf(ticketNo);
		ticketBean = session.get(TicketBean.class, ipk);
		System.out.println("ticketBean" + ticketBean + "ticketNo: "+ipk + "我走到ticketDaoImpl囉 line48");
		return ticketBean;
	}

	@Override
	public void update(TicketBean ticketBean) {
		System.out.println("TicketDaoImp line:54");
//		Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.update("TicketBean", ticketBean);
		session.getTransaction().commit();
		System.out.println("TicketDaoImp line:60");
	}

	@Override
	public void delete(int ticketNo) {
		Session session = sessionFactory.openSession();
		//Session session = sessionFactory.getCurrentSession();
		TicketBean ticketBean = findById(ticketNo);
			System.out.println("ticketNo:"+ ticketNo);
			System.out.println(ticketBean +"我走到TicketDaoImpl囉 line 57");
			
		if (ticketBean == null) {
			System.out.println("key不存在" + ticketBean);
		} else {
			System.err.println("ticketNo"+ticketBean.getTicketNo());
			session.getTransaction().begin();
			session.delete(ticketBean);
			session.getTransaction().commit();
			System.out.println(ticketBean +"我走到session.delete囉");
			session.close();
		}
	}

	@Override
	public List<TicketBean> findAll() {
		String hql = "FROM TicketBean";
		List<TicketBean> allTicketList = null;
		Session session = sessionFactory.openSession();
//		Session session = sessionFactory.getCurrentSession();
		allTicketList = session.createQuery(hql, TicketBean.class).getResultList();
		return allTicketList;
	}

	@Override
	public void close() {
//		Session session = sessionFactory.openSession();
		Session session = sessionFactory.getCurrentSession();
		session.close();
	}

}

//	
//	@Override
//	public TicketBean selectOne(int prod_no) {
//		Session session = sessionFactory.openSession();
////		Session session = factory.getCurrentSession();
//		String hql = "FROM ViewBean p WHERE p.prod_no = :pid";
//		List<TicketBean> view_prods = session.createQuery(hql, TicketBean.class).setParameter("pid", prod_no).getResultList();
//		return view_prods.get(0);
//	}
//
//	
//
//	@Override
//	public TicketBean getProd(int pk) {
//		Session session = sessionFactory.openSession();
//		Integer ipk = Integer.valueOf(pk);
//		TicketBean view = session.get(TicketBean.class,pk);
//		return view;
//	}

//原始碼
//package dao;
//
//import java.util.List;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import model.TicketBean;
//
//@Repository
//@Transactional
//public class TicketDaoImpl implements TicketDao {
//	
//	@Autowired
//	SessionFactory sessionFactory;
//	@Autowired
//	TicketBean ticketBean;
//	
//	@Override
//	public TicketBean selectOne(int prod_no) {
//		Session session = sessionFactory.openSession();
////		Session session = factory.getCurrentSession();
//		String hql = "FROM ViewBean p WHERE p.prod_no = :pid";
//		List<TicketBean> view_prods = session.createQuery(hql, TicketBean.class).setParameter("pid", prod_no).getResultList();
//		return view_prods.get(0);
//	}
//
//	@Override
//	public Object save(TicketBean tBean) {
//		Session session = sessionFactory.openSession();
//		session.save(tBean);
//		return tBean;
//	}
//
//	@Override
//	public List<TicketBean> findAll() {
//		String hql = "FROM TicketBean";
//		List<TicketBean> allTicketList = null;
//		Session session = sessionFactory.openSession();
//		allTicketList = session.createQuery(hql,TicketBean.class).getResultList();
//		return allTicketList;
//	}
//
//	@Override
//	public TicketBean getProd(int pk) {
//		Session session = sessionFactory.openSession();
//		Integer ipk = Integer.valueOf(pk);
//		TicketBean view = session.get(TicketBean.class,pk);
//		return view;
//	}
//
//	//int最好寫void
//	@Override
//	public void delete(int pk) {
//		Session session = sessionFactory.openSession();
//		TicketBean one = getProd(pk);
//		System.out.println(one +"我抓到囉 台大安尼亞");
//		if (one==null) {
//			System.out.println("key不存在"+one);
//		}else {
//			session.delete(one);
//			session.close();
//		}
//	}
//
//	@Override
//	//int最好寫void
//	public int update(TicketBean t) {
//		Session session = sessionFactory.openSession();
////		Session session = factory.getCurrentSession();
//		session.update(p);
//		return 1;
//	}
//
//	@Override
//	public void close() {
//		sessionFactory.close();
//	}
//
//	@Override
//	public TicketBean findById(int ticketNo) {
//		TicketBean ticketBean = null;
//		Session session = sessionFactory.openSession();
//		Integer ipk = Integer.valueOf(ticketNo);
//		ticketBean = session.get(TicketBean.class, ipk);
//		return ticketBean;
//	}
//
//	@Override
//	public List<TicketBean> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void update(TicketBean tBean) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//
//}
