package org.duckdns.ja2pyc;

import java.util.Locale;

import org.duckdns.dto.MemberDTO;
import org.duckdns.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	@Autowired
	MemberMapper memberMapper;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String memberLogin(Locale locale, Model model) {
		return "/member/login";
	}

	@PostMapping(value = "/login")
	public String memberLoginPost(MemberDTO mdto) {
		System.out.println(mdto);
		System.out.println("getMember : " + memberMapper.getMember());
		MemberDTO loginResult = memberMapper.loginMember(mdto);
		System.out.println("loginMember : " + loginResult);
		
		if (loginResult != null) {
			
		} else {
			
		}
		return "/member/login";
	}
}