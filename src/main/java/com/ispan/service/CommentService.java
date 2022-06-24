package com.ispan.service;

import java.util.List;

import com.ispan.model.Comment;

public interface CommentService {

	List<Comment> getAllComments();
	
	Comment getComment(int id);

	void saveComment(Comment comment);

	void deleteComment(int id);

	void updateComment(Comment comment);
}
