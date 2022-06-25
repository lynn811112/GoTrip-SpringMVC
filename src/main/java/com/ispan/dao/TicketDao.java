package com.ispan.dao;

import java.util.List;

import com.ispan.model.TicketBean;

public interface TicketDao {

	public TicketBean findById(int ticketNo);

	public Object save(TicketBean ticketBean);

	public List<TicketBean> findAll();

	public void update(TicketBean ticketBean);

	public void delete(int ticketNo);
	
	public void close();
//
//	TicketBean getProd(int ticketNo);
}


//原始碼
//package dao;
//
//import java.util.List;
//import model.TicketBean;
//
//public interface TicketDao {
//
//	public TicketBean findById(int prod_no);
//
//	public int save(TicketBean p);
//
//	List<TicketBean> selectAll();
//
//	TicketBean getProd(int prod_no);
//
//	void delete(int prod_no);
//
//	int update(TicketBean p);
//	
//	public void close();
//}