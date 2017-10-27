package com.example.spring01.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.spring01.model.dto.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<MemberVO> memberList(){
		logger.info("member.memberList Called!");
		return sqlSession.selectList("member.memberList");
	}
	
	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert("member.insertMember", vo);
	}
	
	@Override
	public MemberVO viewMember(String userId) {
		logger.info("member.viewMember Called!" + userId);
		return sqlSession.selectOne("member.viewMember", userId);
	}
	
	@Override
	public void deleteMember(String userId) {
		sqlSession.delete("member.deleteMember",userId);
	}
	
	@Override
	public void updateMember(MemberVO vo) {
		logger.info(vo.getUserId() +" Transferred!");
		sqlSession.update("member.updateMember",vo);
	}
	
}
