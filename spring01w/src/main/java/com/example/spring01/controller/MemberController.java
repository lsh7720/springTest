package com.example.spring01.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring01.model.dto.MemberVO;
import com.example.spring01.service.MemberService;
@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Inject
    MemberService memberService;
    
    // 01 회원 목록
    // url pattern mapping
    @RequestMapping("member/list.do")
    public String memberList(Model model){
    // controller => service => dao 요청
    	logger.info("member/list called");
        List<MemberVO> list = memberService.memberList();
        model.addAttribute("list", list);
        return "member/member_list";
    }
    
    // 02_01 회원 등록 페이지로 이동
    @RequestMapping("member/write.do")
    public String memberWrite(){
        
        return "member/member_write";
    }
    
    // 02_02 회원 등록 처리 후 ==> 회원목록으로 리다이렉트
    // @ModelAttribute에 폼에서 입력한 데이터가 저장된다.
    @RequestMapping("member/insert.do")
    // * 폼에서 입력한 데이터를 받아오는 법 3가지 
    //public String memberInsert(HttpServlet request){
    //public String memberInsert(String userId, String userPw, String userName, String userEmail){
    public String memberInsert(@ModelAttribute MemberVO vo){

        memberService.insertMember(vo);
        
        return "redirect:/member/list.do";
    }
    
    // 03 회원 상세정보 조회
    @RequestMapping("member/view.do")
    public String memberView(@RequestParam("userId") String userId, Model model){
    	

        model.addAttribute("dto", memberService.viewMember(userId));
        
        logger.info("클릭한 아이디 : "+userId);
        
        if( memberService.viewMember(userId) ==null)
        	logger.info("값이 들어오지 않음");
        //logger.info(member.getUserEmail());
        return "member/member_view";
    }
    
    @RequestMapping("member/update.do")
    public String memberUpdate(MemberVO vo) {
    	memberService.updateMember(vo);
    	logger.info(vo.toString());
    	return "redirect:/member/list.do";
    }
    
    @RequestMapping("member/delete.do")
    public String memberDelete(@RequestParam String userId) {
    	memberService.deleteMember(userId);
    	return "redirect:/member/list.do";
    }
}
