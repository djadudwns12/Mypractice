package com.javapro.pro.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javapro.pro.domain.BoardVO;


/**
 * BoardDAO
 * 
 * @author djadu
 *
 */
@Repository
public class BoardDAO {
	private static final Logger log = LoggerFactory.getLogger(BoardDAO.class);

	@Autowired
	SqlSession session;

	String maperboard = "com.javapro.pro.mapper.board_mapper";

public void insertBoard(BoardVO boardVO) {

		log.info("게시글 생성");
		log.info("insertBoard");
	
	
	session.insert(maperboard+".insertBoard", boardVO);
	
}
	}
