package com.ispan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.dao.CommentDao;
import com.ispan.model.Comment;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;
	
	@Override
	public List<Comment> getAllComments() {
		return commentDao.getAllComments();
	}

	@Override
	public Comment getComment(int id) {
		return commentDao.getComment(id);
	}

	@Override
	public void saveComment(Comment comment) {
		commentDao.saveComment(comment);
	}

	@Override
	public void deleteComment(int id) {
		commentDao.deleteComment(id);
	}

	@Override
	public void updateComment(Comment comment) {
		commentDao.updateComment(comment);
	}

}
