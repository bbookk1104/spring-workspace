package kr.or.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.or.member.model.service.MemberService;
import kr.or.member.model.vo.Member;

@Controller
public class MemberController {
	@Autowired
	MemberService service;
	
	@RequestMapping(value="/login.do")
	public String login(Member member, HttpSession session) {
		Member m = service.selectOneMember(member);
		if(m!=null) {
			session.setAttribute("m", m);
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="/selectAllMember.do")
	public String selectAllMember(Model model) {
		ArrayList<Member> list = service.selectAllMember();
		model.addAttribute("list",list);
		return "member/memberList";
	}
	
	@RequestMapping(value="/joinFrm.do")
	public String joinFrm() {
		return "member/joinFrm";
	}
	
	@RequestMapping(value="join.do")
	public String join(Member m) {
		int result = service.insertMember(m);
		if(result>0) {
			return "redirect:/";
		}else {
			return "member/joinFrm";
		}
	}
	
	@RequestMapping(value="/searchMemberId.do")
	public String searchMemberId(Member member, Model model) {
		Member m = service.selectOneMember(member);
		if(m!=null) {
			model.addAttribute("m", m);
			return "member/searchMember";
		}else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/mypage.do")
	public String mypage() {
		return "member/mypage";
	}
	
	@RequestMapping(value="/updateMember.do")
	public String updateMember(Member m, Model model, HttpSession session) {
		Member member = service.updateMember(m);
		if(member!=null) {
			session.setAttribute("m", member);
			return "redirect:/mypage.do";
		}else {
			model.addAttribute("msg","회원정보수정");
			return "member/failMsg";
		}
	}
	
	@RequestMapping(value="/deleteMember.do")
	public String deleteMember(@SessionAttribute Member m, Model model) {
		int result = service.deleteMember(m.getMemberNo());
		if(result>0) {
			return "redirect:/logout.do";
		}else {
			model.addAttribute("msg","회원탈퇴");
			return "member/failMsg";
		}
	}
	
	@RequestMapping(value="/searchMemberName.do")
	public String searchMemberName(String memberName, Model model) {
		ArrayList<Member> list = service.selectAllMemberName(memberName);
		if(list.isEmpty()) {
			model.addAttribute("msg","회원검색");
			return "member/failMsg";
		}else {
			model.addAttribute("list",list);
			return "member/memberList";
		}
	}
	
	@RequestMapping(value="/searchMember1.do")
	public String searchMember(String type, String keyword, Model model) {
		ArrayList<Member> list = service.searchMember1(type,keyword);
		model.addAttribute("list",list);
		return "member/memberList";
	}
	
	@RequestMapping(value="/searchMember2.do")
	public String searchMember2(Member m, Model model) {
		ArrayList<Member> list = service.searchMember2(m);
		model.addAttribute("list",list);
		return "member/memberList";
	}
	
	@RequestMapping(value="/idList.do")
	public String idList(Model model) {
		ArrayList<String> list = service.selectIdList();
		model.addAttribute("list",list);
		return "member/idList";
	}
	
	@RequestMapping(value="searchMember3.do")
	public String searchMember3(String[] memberId, Model model) {
		ArrayList<Member> list = service.searchMember3(memberId);
		model.addAttribute("list",list);
		return "member/memberList";
	}
	
	@RequestMapping(value="/searchMember4.do")
	public String searchMember4(Model model) {
		ArrayList<Member> list = service.searchMember4();
		model.addAttribute("list",list);
		return "member/memberList";
	}
}
