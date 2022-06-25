package com.ispan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.dao.TicketDao;
import com.ispan.model.TicketBean;

@Transactional
@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketDao ticketDao;

	@Override
	public Object save(TicketBean ticketBean) {
		ticketDao.save(ticketBean);
		System.out.println("TicketServiceImpl的save工作囉!");
		return ticketBean;
	}
	
	@Override
	public TicketBean findById(int ticketNo) {
		TicketBean ticketBean = null;
		ticketBean = ticketDao.findById(ticketNo);
		return ticketBean;
	}	
	
	@Override
	public void update(TicketBean ticketBean) {
		ticketDao.update(ticketBean);
	}
	
	@Override
	public void delete(int ticketNo) {
		 ticketDao.delete(ticketNo);
	}
	
	@Override
	public List<TicketBean> findAll() {
		return ticketDao.findAll();
	}
	
	@Override
	public void close() {
		ticketDao.close();
	}

//	@Override
//	public TicketBean getProd(int pk) {
//		return vDao.getProd(pk);
//	}
}


	// 建構子
//	public HibernateServiceImpl() {
////		super();
//		this.factory = HibernateUtils.getSessionFactory();
//		this.viewDAO = new HibernateDaoImpl();
//	}

//	@Override
//	public ViewBean selectOne(int prod_no) {
//		return vDao.selectOne(prod_no);
//	}	
//		ViewBean viewBean = null;
//		//啟動交易一定要由SESSION啟動
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			viewBean = viewDAO.selectOne(prod_no);
//			tx.commit();
//		} catch (Exception ex) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(ex);
//		}

//	@Override
//	public int save(ViewBean p) {
//		return vDao.save(p);
//	}
//		// 黃色:區域變數 ; 淺藍:實體變數
//		int n = 0;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			n = viewDAO.save(p);
//			tx.commit();
//		} catch (Exception ex) {
//			if (tx != null) {
//				//dead code永遠run不到的敘述
//				tx.rollback();
//			} 
//			throw new RuntimeException(ex);
//		}
//		return n;

//	@Override
//	public List<ViewBean> selectAll() {
//		return vDao.selectAll();
//	}
//		List<ViewBean> viewBeans = null;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			viewBeans = viewDAO.selectAll();
//			tx.commit();
//		} catch (Exception ex) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(ex);
//		}
//		return viewBeans;

//	@Override
//	public ViewBean getProd(int pk) {
//		return vDao.getProd(pk);
//	}
//		ViewBean viewBean = null;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			viewBean = viewDAO.getProd(pk);
//			tx.commit();
//		} catch (Exception ex) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(ex);
//		}
//		return viewBean;

//	@Override
//	public void delete(int ticketNo) {
//		return ticketDao.delete(ticketNo);
//	}
//		int n = 0;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			n = ticketDao.delete(ticketNo);
//			tx.commit();
//		} catch (Exception ex) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(ex);
//		}
//		return n;
//		}
//		}

//	@Override
//	public int update(ViewBean p) {
//		return vDao.update(p);
//	}
//
//}
//		int n = 0;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			n = viewDAO.update(p);
//			System.out.println("update:" + p);
//			tx.commit();
//		} catch (Exception ex) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(ex);
//		}
//		return n;


//原始碼
//package Service;
//
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import dao.TicketDao;
//import dao.View_DAO;
//import model.TicketBean;
//
////@Component
//@Service
//@Transactional
//public class TicketServiceImpl implements TicketService {
//
////	有定義interface要寫出來
//	@Autowired
//	private TicketDao ticketDao;
//
//	
//	@Override
//	public TicketBean selectOne(int prod_no) {
//		return ticketDao.selectOne(prod_no);
//	}	
//	
//	@Override
//	public int save(TicketBean tBean) {
//		return vDao.save(p);
//	}
//	
//	@Override
//	public List<TicketBean> selectAll() {
//		return vDao.selectAll();
//	}
//	
//	@Override
//	public TicketBean getProd(int pk) {
//		return vDao.getProd(pk);
//	}
//	
//	@Override
//	public void delete(int prod_no) {
//		 vDao.delete(prod_no);
//	}
//	@Override
//	public int update(TicketBean p) {
//		return vDao.update(p);
//	}
//
//	@Override
//	public void close() {
//		vDao.close();
//	}
//
//}
