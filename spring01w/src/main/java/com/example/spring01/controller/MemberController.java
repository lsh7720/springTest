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
    
    // 01 ȸ�� ���
    // url pattern mapping
    @RequestMapping("member/list.do")
    public String memberList(Model model){
    // controller => service => dao ��û
    	logger.info("member/list called");
        List<MemberVO> list = memberService.memberList();
        model.addAttribute("list", list);
        return "member/member_list";
    }
    
    // 02_01 ȸ�� ��� �������� �̵�
    @RequestMapping("member/write.do")
    public String memberWrite(){
        
        return "member/member_write";
    }
    
    // 02_02 ȸ�� ��� ó�� �� ==> ȸ��������� �����̷�Ʈ
    // @ModelAttribute�� ������ �Է��� �����Ͱ� ����ȴ�.
    @RequestMapping("member/insert.do")
    // * ������ �Է��� �����͸� �޾ƿ��� �� 3���� 
    //public String memberInsert(HttpServlet request){
    //public String memberInsert(String userId, String userPw, String userName, String userEmail){
    public String memberInsert(@ModelAttribute MemberVO vo){

        memberService.insertMember(vo);
        
        return "redirect:/member/list.do";
    }
    
    // 03 ȸ�� ������ ��ȸ
    @RequestMapping("member/view.do")
    public String memberView(@RequestParam("userId") String userId, Model model){
    	

        model.addAttribute("dto", memberService.viewMember(userId));
        
        logger.info("Ŭ���� ���̵� : "+userId);
        
        if( memberService.viewMember(userId) ==null)
        	logger.info("���� ������ ����");
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
