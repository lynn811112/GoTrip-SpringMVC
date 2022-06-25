package com.ispan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ispan.model.MemberBean;
import com.ispan.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping(path = "/membersmain.controller")
	public String processMainAction(Model m) {
		MemberBean mem = new MemberBean();
		m.addAttribute("members", mem);
		return "index";

	}
	
	//顯示所有會員資料
	@GetMapping("/member")
	public String showAllMembers(Model m) {
		List<MemberBean> MemberData = service.getAllMembers();
		m.addAttribute("MemberData", MemberData);
		return "MemberData";
	}
	
	//導向新增畫面
	@GetMapping(path = "/addMem")
	public String toAdd() {
		return "MemberData-insert";
	}
	
	//確定新增
	@PostMapping(path = "/SaveMem")
	public String add(MemberBean mb) {
		service.saveOrUpdate(mb);
		return "redirect:/member";
	}
	
	//導向更新畫面
	@GetMapping(path = "/mem/{user_no}")
	public String toUpdate(@PathVariable("user_no") Integer user_no, Model m) {
		MemberBean mem = service.getMember(user_no);
		m.addAttribute("MemberData", mem);
		return "MemberData-edit";
	}
	
	//刪除資料
	@PostMapping(path = "/memDel/{user_no}")
	public String delete(@PathVariable("user_no") Integer user_no, Model m) {
		service.deleteMember(user_no);
		return "redirect:/member";
	}

}
