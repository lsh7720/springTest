package com.example.spring01.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.spring01.model.dao.MemberDAOImpl;
import com.example.spring01.model.dto.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Inject
	MemberDAOImpl memberDao;
	
	
	// 회원 목록
	@Override
	public List<MemberVO> memberList(){
		return memberDao.memberList();
	}

	// 회원 입력
	@Override
	public void insertMember(MemberVO vo) {
		memberDao.insertMember(vo);
	}

	// 회원 정보 상세보기
	@Override
	public MemberVO viewMember(String userId) {
		return memberDao.viewMember(userId);
	}

	// 회원삭제
	@Override
	public void deleteMember(String userId) {
		memberDao.deleteMember(userId);
	}


	// 회원정보 수정
	public void updateMember(MemberVO vo) {
		memberDao.updateMember(vo);
	}
}
