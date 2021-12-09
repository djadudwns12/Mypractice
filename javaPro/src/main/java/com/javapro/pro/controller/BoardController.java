/**
 * 
 */
package com.javapro.pro.controller;





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javapro.pro.dao.BoardDAO;
import com.javapro.pro.domain.BoardVO;


/**
 * @author djadu
 *
 */
@Controller
@RequestMapping("board")
public class BoardController {
private static final Logger log=LoggerFactory.getLogger(BoardController.class);

@Autowired
BoardDAO boardDAO;

@RequestMapping("/board_write_form.do")
public String boardWriteForm() {
	log.info("게시글 등록");
	
	return "board/boardWrite";
	
	
} 
@RequestMapping(value="/board_write.do",method=RequestMethod.POST)
public String boardWrite(BoardVO boardVO,
						 RedirectAttributes ra) {
log.info("BoardWrite");
	String msg="";
	log.info("게시글 인자: "+boardVO);
	
	boardDAO.insertBoard(boardVO);
		msg="게시글 저장에 성공하였습니다.";
	
	ra.addAttribute("msg",msg);
	return"redirect:/board/board_write_form.do";
}




}
