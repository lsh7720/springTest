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
	
	
	// ȸ�� ���
	@Override
	public List<MemberVO> memberList(){
		return memberDao.memberList();
	}

	// ȸ�� �Է�
	@Override
	public void insertMember(MemberVO vo) {
		memberDao.insertMember(vo);
	}

	// ȸ�� ���� �󼼺���
	@Override
	public MemberVO viewMember(String userId) {
		return memberDao.viewMember(userId);
	}

	// ȸ������
	@Override
	public void deleteMember(String userId) {
		memberDao.deleteMember(userId);
	}


	// ȸ������ ����
	public void updateMember(MemberVO vo) {
		memberDao.updateMember(vo);
	}
}
