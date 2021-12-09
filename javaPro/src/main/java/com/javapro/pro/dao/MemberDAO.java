/**
 * 
 */
package com.javapro.pro.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javapro.pro.domain.MemberVO;



/**
 *
 * @author Administrator
 *
 */
@Repository
public class MemberDAO {
	private static final Logger log = LoggerFactory.getLogger(MemberDAO.class);
@Autowired
SqlSession sqlSession;

private static final String MAPPER_NS="com.javapro.pro.mapper.member_mapper";
	
/**
 * 로그인 인증 점검
 * 
 * @param id 회원 아이디
 * @param pw 회원 패쓰워드
 * @return 로그인 메시지 
 *   ex) 존재하지 않는 회원입니다.
 *   ex) 패쓰워드가 일치하지 않습니다.
 *   ex) 로그인에 성공하였습니다.  
 * @throws SQLException 
 */
public String checkLogin(String id, String pw) throws SQLException {
	
	log.info("MemberDAO.checkLogin");
	String msg = ""; // 에러 메시지
	MemberVO member = null;
	boolean flag = this.isMember(id);
	
	if (flag ==true) { // 회원일 경우

		member = new MemberVO();
		member.setUserid(id);
		member.setPwd(pw);
		msg = (int)(sqlSession.selectOne(MAPPER_NS+".checkLogin", member))==1 ?
			   "로그인에 성공하였습니다" : "패쓰워드가 일치하지 않습니다";
		
	} else { // 회원이 아닐 경우
		msg = "존재하지 않는 회원입니다";
	} //
	
	return msg;		
} //

/**
 * 회원 존재 여부 점검
 * 
 * @param id 회원 아이디
 * @return 회원 존재 여부 
 * @throws SQLException
 */
public boolean isMember(String id ) throws SQLException {
	
	log.info("회원 존재 여부 점검");
	
	return (int)(sqlSession.selectOne(MAPPER_NS+".isMember", id))==1 ? true : false; 
} //


public MemberVO getMember(String userid) throws SQLException {
	log.info("MemberDAO.getMember");
	return sqlSession
			.selectOne(MAPPER_NS+".getMember", 
					   userid);
	
	
}//
public void insertMember(MemberVO member) throws SQLException{
	log.info("MemberDAO.insertMember");
	
	sqlSession.insert(MAPPER_NS+".insertMember",member);
	
	
}
	
	
}

