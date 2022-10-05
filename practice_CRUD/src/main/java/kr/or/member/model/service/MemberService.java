package kr.or.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.member.model.dao.MemberDao;
import kr.or.member.model.vo.Member;

@Service
public class MemberService {
	@Autowired
	private MemberDao dao;

	public MemberService() {
		super();
		System.out.println("MemberService생성!");
	}

	public int insertMember(Member m) {
		int result = dao.insertMember(m);
		return result;
	}

	public Member loginCheck(Member m) {
		Member loginMember = dao.loginCheck(m);
		return loginMember;
	}
	
}
