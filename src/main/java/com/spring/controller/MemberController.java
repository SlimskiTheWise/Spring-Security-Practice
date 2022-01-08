package com.spring.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.spring.dao.MemberDAO;
import com.spring.dto.MemberDTO;
import com.spring.service.MemberService;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member/")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("join")
	public String memberJoin() {
		System.out.println("join 페이지 동작..");
		return "member/join";
		}
	
	@ResponseBody
	@RequestMapping(value="idDuplCheck",produces="text/html;charset=utf8")
	public String idDuplCheck(String id) throws Exception {
		
		Integer result  = memberService.idDupleCheck(id);
	
		System.out.println(result);
		
		return String.valueOf(result);
		
	}
	
	@RequestMapping(value="joinProc", method=RequestMethod.POST )
	public String join(MemberDTO memberDTO) {

	       
		int result = memberService.joinMember(memberDTO);
		
		return "home";
	}
	
	
	@RequestMapping("deleteAccount")
	public String deleteAccount() {
		String id = (String) session.getAttribute("loginID");
		int result = memberService.deleteAccount(id);
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("mypage")
	public String mypage(Model model) throws Exception {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		
		String id = ((UserDetails)principal).getUsername(); 
			
		MemberDTO member = memberService.findById(id);
		model.addAttribute("member", member);
			
		return "/member/mypage";
		
	}
	
	@RequestMapping("updateProc")
	public String updateProc(MemberDTO memberDTO) {
	int result = memberService.update(memberDTO);
		
		return "redirect:/";
	}
}	
