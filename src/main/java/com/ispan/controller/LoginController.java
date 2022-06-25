//package com.ispan.controller;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.ObjectError;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.ispan.model.MemberBean;
//import com.ispan.service.MemberService;
//
//@Controller
//public class LoginController {
//
//    @Autowired
//    private MemberService mService;
//
//    @GetMapping("/login")
//    public String toLogin(Model model) {
//    	MemberBean member = new MemberBean();
//        model.addAttribute("member",member);
//        return "login";
//    }
//    
//    @GetMapping("/logout")
//    public String logout(HttpServletRequest request) {
//        System.out.println("logout()");
//        HttpSession httpSession = request.getSession();
//        httpSession.invalidate();
//        return "redirect:login";
//    }
//
//    @PostMapping("/login.do")
//    public String doLogin(@ModelAttribute @Validated MemberBean member, 
//            BindingResult bindingresult,HttpSession session ) {
//        if(!bindingresult.hasErrors()){
//            if(!mService.authenticateUser(member)){
//                bindingresult.addError(new ObjectError("invalid", "Invalid Credentials!!!"));
//                return new ModelAndView("error");
//            }
//            else{
//                session.setAttribute("login", member);
//                view.setViewName("success");
//            }
//        }
//
//         return "index";
//}
//
//    @RequestMapping("/logout")
//      public String logout(HttpSession session ) {
//         session.invalidate();
//         return "redirect:/login.html";
//      }
//
//}
