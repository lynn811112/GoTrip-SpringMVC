package com.ispan.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.model.Comment;

@Repository
@Transactional
public class CommentDaoImpl implements CommentDao {

	@Autowired
	private SessionFactory factory;

	@Override
	public List<Comment> getAllComments() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Comment";
		List<Comment> comments = new ArrayList<>(); 
		comments = session.createQuery(hql, Comment.class).list();
		return comments;
	}

	@Override
	public Comment getComment(int id) {
		Session session = factory.getCurrentSession();
		Comment comment = session.get(Comment.class, id);
		return comment;
	}

	@Override
	public void saveComment(Comment comment) {
		Session session = factory.getCurrentSession();
		session.save(comment);
	}

	@Override
	public void deleteComment(int id) {
		Session session = factory.getCurrentSession();
		Comment comment = new Comment();
		comment.setId(id);
		session.delete(comment);
	}

	@Override
	public void updateComment(Comment comment) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(comment);
	}

}
