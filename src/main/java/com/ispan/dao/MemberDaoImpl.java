package com.ispan.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.model.MemberBean;

@Repository
@Transactional
public class MemberDaoImpl implements MemberDao<MemberBean> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	

	@Override
	public boolean isDup(String email) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM MemberBean mb WHERE mb.email = :email";
		List<MemberBean> memberBeans = session.createQuery(hql, MemberBean.class)
											  .setParameter("email", email)
											  .getResultList();
		if (memberBeans.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int saveOrUpdate(MemberBean mb) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(mb);
		return 1;
	}

	@Override
	public List<MemberBean> getAllMembers() {
		List<MemberBean> memberBeans = null; 
		
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM MemberBean";
		memberBeans = session.createQuery(hql, MemberBean.class)
				             .getResultList();
		return memberBeans;
	}

	@Override
	public MemberBean getMember(int user_no) {
		Session session = sessionFactory.getCurrentSession();
		MemberBean memberBean = session.get(MemberBean.class, user_no);
		return memberBean;
	}

	@Override
	public int deleteMember(int user_no) {
		Session session = sessionFactory.getCurrentSession();
		MemberBean memberBean = new MemberBean();
		memberBean.setUser_no(user_no);
		session.delete(memberBean);
		return 1;
	}

	@Override
	public int updateMember(MemberBean mb) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(mb);
		return 1;
	}
	



	


}
