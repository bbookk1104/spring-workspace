package kr.or.board.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.or.board.model.service.BoardService;
import kr.or.board.model.vo.Board;
import kr.or.board.model.vo.BoardViewData;
import kr.or.board.model.vo.FileVO;

@Controller
public class BoardController {
	@Autowired
	private BoardService service;

	public BoardController() {
		super();
		System.out.println("BoardController생성");
	}
	
	@RequestMapping(value="boardList.do")
	public String boardList(Model model) {
		ArrayList<Board> list = service.selectAllBoard();
		model.addAttribute("list", list);
		return "board/boardList";
	}
	
	@RequestMapping(value="boardWriteFrm.do")
	public String boardWriteFrm(Model model, String memberId) {
		model.addAttribute("memberId", memberId);
		return "board/boardWriteFrm";
	}
	
	@RequestMapping(value="boardWrite.do")
	public String boardWrite(Board b, Model model) {
		int result = service.insertBoard(b);
		if(result>0) {
			model.addAttribute("message","게시글이 등록되었습니다.");
		}else {
			model.addAttribute("message","게시글 작성에 실패했습니다.");
		}
		return "board/boardWriteResult";
	}
	
	@RequestMapping(value="boardWriteFrm2.do")
	public String boardWriteFrm2(Model model, String memberId) {
		model.addAttribute("memberId", memberId);
		return "board/boardWriteFrm2";
	}
	
	@RequestMapping(value="/boardWrite2.do")
	public String boardWrite2(Board b, MultipartFile[] boardFile, HttpServletRequest request) {
		//파일목록을 저장할 리스트 생성
		ArrayList<FileVO> list = new ArrayList<FileVO>();
		//MultipartFile[]은 jsp에서 첨부한 파일 갯수만큼 길이가 생성
		//단, 첨부파일은 한 개도 첨부하지 않더라도 배열의 길이는 기본적으로 1
		//첨부파일이 없는 경우 배열 첫번째 인덱스의 value비어있음
		if(boardFile[0].isEmpty()) {
			//첨부파일이 없는 경우 수행할 로직 없음
		}else {
			//첨부파일이 있는 경우 파일업로드 수행
			//1. 파일업로드 경로 설정(getRealPath()까지가 webapp폴더)
			String savePath = request.getSession().getServletContext().getRealPath("/resources/upload/board/");
			//2. 반복문을 이용한 파일업로드
			for(MultipartFile file: boardFile) {
				//파일명이 기존 업로드한 파일명과 중복되는 경우 기존파일을 삭제하고 새 파일 남는 현상(덮어쓰기)
				//위 현상 방지위해 파일명 뒤에 숫자붙여서 중복처리
				//사용자가 업로드한 파일 이름 추출
				String filename = file.getOriginalFilename();
				//filename = test.txt라는 값을 추출
				String onlyFilename = filename.substring(0,filename.lastIndexOf("."));
				//test추출 (0번인덱스부터 .앞까지 자름)
				String extention = filename.substring(filename.lastIndexOf("."));
				//.txt추출 (매개변수 1개: lastIndexOf(".")부터 끝까지 다 추출)
				
				//실제 업로드할 파일명
				String filepath = null;
				//파일명이 중복되는 경우 뒤에 붙일 숫자
				int count = 0;
				while(true) {
					if(count==0) {
						//파일이름체크 반복 첫번째인 경우
						filepath = onlyFilename+extention;//test.txt
					}else {
						filepath = onlyFilename+"_"+count+extention;//test_1.txt
					}
					File checkFile = new File(savePath+filepath);//이 File은 java.io객체
					if(!checkFile.exists()) {
						//중복파일명이 아닌 경우 무한반복문 나감
						break;
					}
					count++;
				}
				//파일명 중복체크 끝 -> 파일업로드 진행
				
				//중복처리가 끝난 파일명으로 파일업로드 진행
				try {
					FileOutputStream fos = new FileOutputStream(new File(savePath,filepath));
					//속도개선을 위한 보조스트림 사용
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					//파일업로드
					byte[] bytes = file.getBytes();
					bos.write(bytes);
					bos.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//파일업로드 끝(파일 1개 업로드)
				FileVO fileVO = new FileVO();
				fileVO.setFilename(filename);
				fileVO.setFilepath(filepath);
				list.add(fileVO);
			}
		}
		//데이터베이스에 insert -> 비즈니스로직
		int result = service.insertBoard2(b,list);
		//성공인 경우 result == list.size()+1
		return "redirect:/boardList.do";
	}
	
	@RequestMapping(value="boardView.do")
	public String boardView(Model model, int boardNo) {
		BoardViewData bvd = service.selectOneBoard(boardNo);
		model.addAttribute("bvd",bvd);
		return "board/boardView";
	}
	
	@RequestMapping(value="updateBoardFrm.do")
	public String updateBoard(Model model, Board b) {
		model.addAttribute("b",b);
		return "board/updateBoardFrm";
	}
	
}
