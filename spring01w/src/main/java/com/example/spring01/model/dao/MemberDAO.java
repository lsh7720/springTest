package com.example.spring01.model.dao;

import java.util.List;

import com.example.spring01.model.dto.MemberVO;

public interface MemberDAO {
	public List<MemberVO> memberList();
	public void insertMember(MemberVO vo);
	public MemberVO viewMember(String userId);
	public void deleteMember(String userId);
	public void updateMember(MemberVO vo);
}
