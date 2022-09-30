package kr.or.member.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getter,setter - 롬복이 자동으로 만듬
@NoArgsConstructor //매개변수없는 생성자
@AllArgsConstructor //매개변수 모두 있는 생성자
public class Member {
	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String phone;
	private String email;
}