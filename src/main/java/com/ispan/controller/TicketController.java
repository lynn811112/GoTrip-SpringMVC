package com.ispan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.ispan.model.TicketBean;
import com.ispan.service.TicketService;

@Controller
public class TicketController {

	@Autowired
	TicketService ticketService;

//	@GetMapping("/ticket")
//	public String Action() {
//		return "ticket";
//	}

	@RequestMapping(path = "/ticket/ShowNewForm", method = RequestMethod.GET)
	public String ShowNewForm(@RequestParam("showNewForm") String showNewForm, Model m, SessionStatus status) {
		System.out.println("This is success transfer to new form");
		return "insertTicket";
	}
	
	//編輯還沒做
	@RequestMapping(path = "/ticket/showEditForm",method = RequestMethod.GET)
	public String showEditForm(@RequestParam("UpdateId")int UpdateId,Model m ,SessionStatus status){
		System.out.println("edit View_pro line:41");
		TicketBean editID = ticketService.findById(UpdateId);
		m.addAttribute("TicketBean", editID);
	System.out.println("This is success transfer to Edit form");
	m.addAttribute("UPDATE", 1);
	return "insertTicket";
	}

	@RequestMapping(path = "/ticket")
	public String list(Model m) {
		System.err.println("View_pro line 50 ");
		List<TicketBean> allTicketList = ticketService.findAll();

		StringBuilder sbOpen_week = new StringBuilder();
		Map<String, String> weekNameMap = new HashMap<String, String>();
		weekNameMap.put("1", "星期一");
		weekNameMap.put("2", "星期二");
		weekNameMap.put("3", "星期三");
		weekNameMap.put("4", "星期四");
		weekNameMap.put("5", "星期五");
		weekNameMap.put("6", "星期六");
		weekNameMap.put("7", "星期日");

		for (TicketBean ticketBean : allTicketList) { // 每筆record
			int i = 1;
			String Open_weekStr = ticketBean.getTicketOpenWeek() == null ? "" : ticketBean.getTicketOpenWeek();
//			System.out.println("Open_weekStr ->" + Open_weekStr);
			String[] Open_weekArr = Open_weekStr.split(",");
			for (String TicketOpenWeek : Open_weekArr) {
//				System.out.println("Open_week51 ->" + TicketOpenWeek);
				if ("".equals(TicketOpenWeek)) {
					break;
				}
				sbOpen_week.append(weekNameMap.get(TicketOpenWeek));
				if (i % 2 == 0) {
					sbOpen_week.append("<BR>");
				} else {
					sbOpen_week.append(",");
				}
				i++;
			}
			String TicketOpenWeek = sbOpen_week.length() > 0 ? sbOpen_week.substring(0, sbOpen_week.length() - 1) : "";
			ticketBean.setTicketOpenWeek(TicketOpenWeek);
			sbOpen_week.setLength(0);
		}
		m.addAttribute("list", allTicketList);
		return "ticket";
	}

	@RequestMapping(value = "/Ticket.Delete", method = RequestMethod.POST)
	public String delete(@RequestParam("Delete") int ticketNo ,Model m) {
		ticketService.delete(ticketNo);
		System.out.println("我走到你家controller囉!!!");
		System.out.println("Delete: " + ticketNo + "success!!!");
		this.reQuery(m);
		return "ticket";
	}


	// 更新
	@RequestMapping(path = "/Ticket.Update", method = RequestMethod.POST)
	public String Update( @RequestParam(name = "ticketNo") int ticketNo, 
			@RequestParam(name = "ticketName") String ticketName,
			@RequestParam(name = "ticketIntro") String ticketIntro,
			@RequestParam(name = "week1",required = false) String week1,
			@RequestParam(name = "week2",required = false) String week2,
			@RequestParam(name = "week3",required = false) String week3,
			@RequestParam(name = "week4",required = false) String week4,
			@RequestParam(name = "week5",required = false) String week5,
			@RequestParam(name = "week6",required = false) String week6,
			@RequestParam(name = "week7",required = false) String week7,
			@RequestParam(name = "ticketOpenTime") String ticketOpenTime,
			@RequestParam(name = "ticketEndTime") String ticketEndTime, @RequestParam(name = "phone") String phone,
			@RequestParam(name = "country") String country, @RequestParam(name = "city") String city,
			@RequestParam(name = "location") String location, @RequestParam(name = "address") String address,
			@RequestParam(name = "price") Integer price,
			Model m,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("開始UPDATE !!! ");
		
		StringBuilder sb = new StringBuilder();
		String ticketOpenWeek =  "";
		if(week1!=null) {			
			sb.append("1,");
		}
		if(week2!=null) {			
			sb.append("2,");
		}
		if(week3!=null) {			
			sb.append("3,");
		}
		if(week4!=null) {			
			sb.append("4,");
		}
		if(week5!=null) {			
			sb.append("5,");
		}
		if(week6!=null) {			
			sb.append("6,");
		}
		if(week7!=null) {			
			sb.append("7,");
		}
		ticketOpenWeek = sb.length() == 0 ? "" : sb.substring(0,sb.length()-1);
		
		TicketBean ticketBeanList = new TicketBean(ticketNo,ticketName, ticketIntro, ticketOpenWeek, ticketOpenTime,
				ticketEndTime, phone, country, city, location, address, price);
		ticketService.update(ticketBeanList);
		System.out.println("Update 成功囉!!! ");
		
		this.reQuery(m);
		return "ticket";
	}

	// 新增
	@RequestMapping(path = "/ticket/Ticket.Insert", method = RequestMethod.POST)
	public String Insert(@RequestParam(name = "ticketName") String ticketName,
			@RequestParam(name = "ticketIntro") String ticketIntro,
			@RequestParam(name = "week1", required = false) String week1,
			@RequestParam(name = "week2", required = false) String week2,
			@RequestParam(name = "week3", required = false) String week3,
			@RequestParam(name = "week4", required = false) String week4,
			@RequestParam(name = "week5", required = false) String week5,
			@RequestParam(name = "week6", required = false) String week6,
			@RequestParam(name = "week7", required = false) String week7,
			@RequestParam(name = "ticketOpenTime") String ticketOpenTime,
			@RequestParam(name = "ticketEndTime") String ticketEndTime, @RequestParam(name = "phone") String phone,
			@RequestParam(name = "country") String country, @RequestParam(name = "city") String city,
			@RequestParam(name = "location") String location, @RequestParam(name = "address") String address,
			@RequestParam(name = "price") Integer price, TicketBean ticketBean, Model m) {
		System.out.println("我來到insert囉 Line: 173");
		StringBuilder sb = new StringBuilder();
//		String ticketOpenWeek =  "";
		if(week1!=null) {			
			sb.append("1,");
		}
		if(week2!=null) {			
			sb.append("2,");
		}
		if(week3!=null) {			
			sb.append("3,");
		}
		if(week4!=null) {			
			sb.append("4,");
		}
		if(week5!=null) {			
			sb.append("5,");
		}
		if(week6!=null) {			
			sb.append("6,");
		}
		if(week7!=null) {			
			sb.append("7,");
		}
//		ticketOpenWeek = sb.length() == 0 ? "" : sb.substring(0,sb.length()-1);
		
		System.out.println("新增");
//		TicketBean ticketBeanList = new TicketBean(ticketName, ticketIntro, ticketOpenWeek, ticketOpenTime,
//				ticketEndTime, phone, country, city, location, address, price);
//		int status = Integer.parseInt((String)ticketService.save(ticketBeanList));
		System.out.println("新增成功");

		String open_week = sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
		System.out.println("open_week->" + open_week);
			this.reQuery(m);
			return "redirect:ticket";
	}
	
	private void reQuery(Model m) {
		System.err.println("View_pro line 211");
		List<TicketBean> allTicketList = ticketService.findAll();

		StringBuilder sbOpen_week = new StringBuilder();
		Map<String, String> weekNameMap = new HashMap<String, String>();
		weekNameMap.put("1", "星期一");
		weekNameMap.put("2", "星期二");
		weekNameMap.put("3", "星期三");
		weekNameMap.put("4", "星期四");
		weekNameMap.put("5", "星期五");
		weekNameMap.put("6", "星期六");
		weekNameMap.put("7", "星期日");

		for (TicketBean ticketBean : allTicketList) { // 每筆record
			int i = 1;
			String Open_weekStr = ticketBean.getTicketOpenWeek() == null ? "" : ticketBean.getTicketOpenWeek();
//			System.out.println("Open_weekStr ->" + Open_weekStr);
			String[] Open_weekArr = Open_weekStr.split(",");
			for (String TicketOpenWeek : Open_weekArr) {
//				System.out.println("Open_week51 ->" + TicketOpenWeek);
				if ("".equals(TicketOpenWeek)) {
					break;
				}
				sbOpen_week.append(weekNameMap.get(TicketOpenWeek));
				if (i % 2 == 0) {
					sbOpen_week.append("<BR>");
				} else {
					sbOpen_week.append(",");
				}
				i++;
			}
			String TicketOpenWeek = sbOpen_week.length() > 0 ? sbOpen_week.substring(0, sbOpen_week.length() - 1) : "";
			ticketBean.setTicketOpenWeek(TicketOpenWeek);
			sbOpen_week.setLength(0);
		}
		m.addAttribute("list", allTicketList);
	}
}
