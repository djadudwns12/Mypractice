/**
 * 
 */
package com.javapro.pro.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.javapro.pro.dao.MemberDAO;
import com.javapro.pro.domain.MemberVO;


/**
 * 로그인 화면 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("member")
public class LoginController {
private static final Logger log = LoggerFactory.getLogger(LoginController.class);

@Autowired
MemberDAO memberDAO;
@RequestMapping("/login.do")
public String loginForm(HttpSession session){
	log.info("로그인 폼(확인)");
	
	return session.getAttribute("SESS_LOGINFO") !=null ? "/member/homepage" : "/member/login";
	

	
}//
@PostMapping("/login_action.do")
/*@RequestMapping(value="login_action.do", method=RequestMethod.POST)*/
public String loginAction(@RequestParam("userid") String userid,
		   				  @RequestParam("pwd") String pwd,
		   				  HttpSession session,
		   				  Model model) {
	log.info("로그인 처리 페이지");
	
	log.info("아이디 : " + userid);
	log.info("패쓰워드 : " + pwd);
	
	String msg = ""; // 인증 (에러) 메시지
	MemberVO member = null; // 기존 회원 정보
	String forwardPage = ""; // 이동 페이지/주소
	
	try {
		msg=memberDAO.checkLogin(userid, pwd);
	} catch (SQLException e) {
		
		e.printStackTrace();
	}//
	
	log.info("인증메세지"+msg);
	if (msg.equals("로그인에 성공하였습니다")) {
		
		// 세션 생성
		if (session.getAttribute("SESS_LOGINFO") == null) { // 세션 생성 여부 점검
			
			MemberVO sessionVO = new MemberVO();
			try {
				member = memberDAO.getMember(userid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// 세션 : 아이디/관리자여부/이름
			sessionVO.setUserid(userid);			
			sessionVO.setAdmin(member.getAdmin());
			sessionVO.setName(member.getName());
			session.setAttribute("SESS_LOGINFO", sessionVO);
			
			// 관리자
			if (member.getAdmin() == 1) {
				forwardPage = "redirect:/admin/paging_action.do";
			} else { // 일반인
				forwardPage = "redirect:/";
			} //
			
		} //
	
	} else { // 비회원, 비밀번호 불일치
		forwardPage = "/error/error_msg";
		model.addAttribute("msg", msg);
		model.addAttribute("move_page", "member/login.do");
	} //
	
	return forwardPage;
} //


@RequestMapping("/logout_action.do")
public String logout_action(HttpSession session) {
	log.info("로그아웃");
	
	session.invalidate();
	
	return "redirect:/";
	
}

}



