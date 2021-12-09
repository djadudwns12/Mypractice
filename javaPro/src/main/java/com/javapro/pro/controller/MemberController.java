package com.javapro.pro.controller;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javapro.pro.dao.MemberDAO;

import com.javapro.pro.domain.MemberVO;

@Controller
@RequestMapping("member")
public class MemberController {
private static final Logger log=LoggerFactory.getLogger(MemberController.class);
	@Autowired
	MemberDAO memberDAO;
	
@RequestMapping("/join_form.do")
public String memberJoin() {
	log.info("회원 가입페이지");
	
	return "/member/join_form";
}

@RequestMapping(value="/join_action.do",method=RequestMethod.POST)
public String join_action(MemberVO member,
						  RedirectAttributes ra) {
	log.info("로그인 구현");
	String msg="";
	
	try {
		memberDAO.insertMember(member);
		msg="회원가입에 성공하였습니다.";
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		msg="회원가입에 실패하였습니다.";
	}
	msg="회원가입에 성공하였습니다.";
	log.info("msg : {}", msg);
	
	ra.addAttribute("msg",msg);
	
	return "redirect:/member/join_form.do";
	
	
}
	
}
