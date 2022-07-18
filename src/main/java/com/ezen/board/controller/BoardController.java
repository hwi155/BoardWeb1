package com.ezen.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.board.domain.Board;
import com.ezen.board.domain.Member;
import com.ezen.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/getBoardList")
	public String getBoardList(//@ModelAttribute("member") Member member,
								Model model) {
		/*
		if(member.getId() == null) {
			return "redirect:login";
		}*/
		
		List<Board> pageList = boardService.getBoardList().getContent();
		
		model.addAttribute("boardList", pageList);
		
		return "/board/getBoardList";
		
	}
	
	@GetMapping("/insertBoard")
	public String insertBoardView(//@ModelAttribute("member") Member member
			) {
	/*	if(member.getId() == null) {
			return "redirect:system/login";
		}
	*/	
		return "board/insertBoard";		
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(@ModelAttribute("member") Member member,
								Board board) {
	/*	
		if(member.getId() == null) {
			return "redirect:system/login";
		}
	*/	
		boardService.insertBoard(board);
		
		return "redirect:board/getBoardList";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(//@ModelAttribute("member") Member member,
								Board board) {
		/*
		if(member.getId() == null) {
			return "redirect:login";
		}
		*/
		boardService.updateBoard(board);
		
		return "redirect:getBoardList";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(//@ModelAttribute("member") Member member,
								Board board) {
		/*
		if(member.getId() == null) {
			return "redirect:login";
		}
		*/
		boardService.deleteBoard(board);
		
		return "redirect:getBoardList";
	}
}
