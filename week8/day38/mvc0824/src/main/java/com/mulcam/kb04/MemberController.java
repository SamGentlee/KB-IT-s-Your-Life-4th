package com.mulcam.kb04;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mulcam.kb04.dto.MemberDto;

@Controller
public class MemberController {
	
	//로그인action
	@PostMapping("/login_action")
	public String login_action(
			@RequestParam String mid,
			@RequestParam String passwd,
			Model model) {
		
		if(!mid.equals("abc")) {
			model.addAttribute("errmsg", "로그인 실패:아이디가 일치하지 않습니다");
			return "member/login_form";
		}
		if(!passwd.equals("123")) {
			model.addAttribute("errmsg", "로그인 실패:비밀번호가 일치하지 않습니다");
			return "member/login_form";
		}
		
		return "member/login_member";
	}
	
	//로그인폼
	@GetMapping("/login_form")
	public String login_form() {
		return "member/login_form";
	}
	
	//회원관리
	@GetMapping("/login_main")
	public String login_main(HttpSession session) {
		
		String mid = (String) session.getAttribute("mid");
		if(mid != null && !mid.trim().equals("")) {
			//로그인 한상태라면 /login_member로 리다이렉팅
			return "redirect:/login_member";
		}
		return "member/login_main";
	}
	
	//회원가입폼
	@GetMapping("/member_insert_form")
	public String member_insert_form() {
	
		return "member/insert_form";
	}
	
	//회원등록
	@PostMapping("/member_insert_action")
	public String member_insert_action(MemberDto dto) {
		
		System.out.println("dto="+dto);
		
		return "member/insert_ok";
	}
	
}