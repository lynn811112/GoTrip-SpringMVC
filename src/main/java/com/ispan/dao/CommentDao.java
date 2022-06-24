package com.ispan.dao;

import java.util.List;

import com.ispan.model.Comment;

public interface CommentDao {

	List<Comment> getAllComments();
	
	Comment getComment(int id);

	void saveComment(Comment comment);

	void deleteComment(int id);

	void updateComment(Comment comment);
}
