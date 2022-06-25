package com.ispan.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.ispan.model.OrderBean;
import com.ispan.service.OrderService;


//@WebServlet("/OrderServletOS")
@Controller
public class OrderServletOS extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
		@Autowired
		private	OrderService oService;
	

	@GetMapping(value = "/allquery")
	public String processAllQuery(Model m) throws Exception {
		System.out.println("爆炸");
		List<OrderBean> orderBeans = oService.selectAll();
		m.addAttribute("orderBeans", orderBeans);
		
		return "order";
	}
	
	@GetMapping(value = "/newform")
	public String processNewForm(Model m) {
		m.addAttribute("orderBean",new OrderBean());
		return "newOrderForm";
	}
	
	@PostMapping(value = "/insert")
	public String processInsertOrder(@ModelAttribute("orderBean") OrderBean orderBean,
															BindingResult result,Model m) throws Exception {
		
		orderBean.setOrderDatePlus(new SimpleDateFormat("yyyy/MM/dd HH:mm").format(Calendar.getInstance().getTime()));
		
		oService.insert(orderBean);
		
		return "redirect:allquery";
	}
	
	@GetMapping(value = "/edit/{orderId}")
	public String processEditForm(@PathVariable("orderId") Integer orderId,Model m) throws Exception {
					
		m.addAttribute("order", oService.selectOne(orderId));
					
		return "updateOrderForm";
	}
	
	@PutMapping(value = "/update")
	public String processUpdateOrder(@ModelAttribute("order") OrderBean orderBean,
													BindingResult result,Model m) throws Exception {
		
		
		oService.update(orderBean);
		
		
		return "redirect:allquery";
	}
 
	@GetMapping(value = "/delete/{orderId}")
	public String processDeleteOrder(@PathVariable("orderId") Integer orderid,Model m) throws Exception {

		oService.delete(orderid);
		List<OrderBean> orderBeans = oService.selectAll();
		m.addAttribute("orderBeans", orderBeans);
		
		return "order";
//		return "redirect:allquery";
		
	}
	

}
