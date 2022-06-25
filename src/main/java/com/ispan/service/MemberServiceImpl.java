package com.ispan.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.dao.MemberDao;

import com.ispan.model.MemberBean;


@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired
	SessionFactory factory;
	@Autowired
	private MemberDao<?> DAO;
	
  
	@Override
	public boolean isDup(String email) {
		return DAO.isDup(email);
	}


	@Override
	public int saveOrUpdate(MemberBean mb) {
		return DAO.saveOrUpdate(mb);
	}


	@Override
	public List<MemberBean> getAllMembers() {
		return DAO.getAllMembers();
	}


	@Override
	public MemberBean getMember(int user_no) {
		return DAO.getMember(user_no);
	}


	@Override
	public int deleteMember(int user_no) {
		return DAO.deleteMember(user_no);
	}


	@Override
	public int updateMember(MemberBean mb) {
		return DAO.updateMember(mb);
	}

//	@Override
//	public boolean isDup(String id) {
//		boolean result = false;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			result = DAO.isDup(id);
//			tx.commit();
//		} catch (Exception ex) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(ex);
//		}
//		return result;
//	}

//	@Override
//	public int save(MemberBean mb) {
//		int n = 0;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			n = DAO.save(mb);
//			tx.commit();
//		} catch (Exception ex) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(ex);
//		}
//		return n;
//	}
//
//	@Override
//	public List<MemberBean> getAllMembers() {
//		List<MemberBean> memberBeans = null;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			memberBeans = DAO.getAllMembers();
//			tx.commit();
//		} catch (Exception ex) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(ex);
//		}
//		
//		return memberBeans;
//	}
//
//	@Override
//	public MemberBean getMember(int user_no) {
//		MemberBean memberBean = null;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			memberBean = DAO.getMember(user_no);
//			tx.commit();
//		} catch (Exception ex) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(ex);
//		}
//		return memberBean;
//	}
//
//	@Override
//	public int deleteMember(int user_no) {
//		
//		int n = 0;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			n = DAO.deleteMember(user_no);
//			tx.commit();
//		} catch (Exception ex) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(ex);
//		}
//		return n;
//	}
//
//	@Override
//	public int updateMember(MemberBean mb) {
//		
//		int n = 0;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			n = DAO.updateMember(mb);
//			tx.commit();
//		} catch (Exception ex) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(ex);
//		}
//		return n;
//	}

}
