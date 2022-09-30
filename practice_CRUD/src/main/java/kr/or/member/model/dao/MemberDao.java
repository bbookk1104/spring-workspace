package kr.or.member.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.member.model.vo.Member;

@Repository
public class MemberDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public MemberDao() {
		super();
		System.out.println("MemberDao생성!");
	}

	public int insertMember(Member m) {
		String query = "insert into member_tbl values(member_seq.nextval,?,?,?,?,?)";
		Object[] params = {m.getMemberId(),m.getMemberPw(),m.getMemberName(),m.getPhone(),m.getEmail()};
		int result = jdbcTemplate.update(query,params);
		return result;
	}
	
}