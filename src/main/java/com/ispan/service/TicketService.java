package com.ispan.service;

import java.util.List;

import com.ispan.model.TicketBean;


public interface TicketService {
	public Object save(TicketBean ticketBean);

	public TicketBean findById(int ticketNo);

	public void update(TicketBean ticketBean);

	public void delete(int ticketNo);
	
	public List<TicketBean> findAll();

	public void close();
}