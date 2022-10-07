package kr.or.board.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.board.model.dao.BoardDao;
import kr.or.board.model.vo.Board;
import kr.or.board.model.vo.BoardPageData;

@Service
public class BoardService {
	@Autowired
	private BoardDao dao;

	public BoardPageData selectBoardList(int reqPage) {
		//한 페이지당 보여줄 게시물 수
		int numPerPage = 5;
		//reqPage 1 -> 1~5, reqPage 2 -> 6~10
		int end = reqPage * numPerPage;
		int start = end-numPerPage+1;
		//계산한 start, end이용해서 게시물 목록 조회
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("start",start);
		map.put("end",end);
		ArrayList<Board> list = dao.selectBoardList(map);
		//pageNavi 시작
		//전체 페이지 수 계산 필요 -> 전체 게시물 수 조회
		int totalCount = dao.selectBoardCount();
		//전체페이지 수 계산
		int totalPage = 0;
		if(totalCount%numPerPage==0) {
			totalPage = totalCount/numPerPage;
		}else {
			totalPage = totalCount/numPerPage+1;
		}
		//pageNavi 사이즈 지정
		int pageNaviSize = 5;
		//pageNavi 시작번호 지정
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize+1;
		//pageNavi 선언
		String pageNavi = "<ul>";
		//이전버튼
		if(pageNo != 1) {
			pageNavi += "<li><a href='/boardList.do?reqPage="+(pageNo-1)+"'>이전</a></li>";
		}
		//페이지숫자
		for(int i=0; i<pageNaviSize; i++) {
			pageNavi += "<li><a href='/boardList.do?reqPage="+pageNo+"'>"+pageNo+"</a></li>";
			pageNo++;
			if(pageNo>totalPage) {
				break;
			}
		}
		//다음버튼
		if(pageNo <= totalPage) {
			pageNavi += "<li><a href='/boardList.do?reqPage="+pageNo+"'>다음</a></li>";
		}
		pageNavi += "</ul>";
		BoardPageData bpd = new BoardPageData(list,pageNavi);
		return bpd;
	}
}
