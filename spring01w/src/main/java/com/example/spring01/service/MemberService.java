package com.example.spring01.service;

import java.util.List;

import com.example.spring01.model.dto.MemberVO;

public interface MemberService {
    // ȸ�� ��� 
    public List<MemberVO> memberList();
    // ȸ�� �Է�
    public void insertMember(MemberVO vo);
    // ȸ�� ���� �󼼺���
    public MemberVO viewMember(String userId);
    // ȸ������
    public void deleteMember(String userId);
    // ȸ������ ����
    public void updateMember(MemberVO vo);
}
