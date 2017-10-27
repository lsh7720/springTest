package com.example.spring01.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring01.service.*;
@Controller
public class BoardController {

	@Inject
	MemberService memberService;
	
	@RequestMapping("board/list.do")
	public String boardList(Model model) {
		
		return "redirect:/board/list";
	}
	
}
