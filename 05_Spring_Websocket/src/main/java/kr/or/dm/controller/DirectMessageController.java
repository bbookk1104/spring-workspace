package kr.or.dm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.dm.model.service.DirectMessageService;
import kr.or.dm.model.vo.DirectMessage;

@Controller
public class DirectMessageController {
	@Autowired
	private DirectMessageService service;
	
	@RequestMapping(value="/dmMain.do")
	public String dmMain() {
		return "dm/dmMain";
	}
	
	@ResponseBody
	@RequestMapping(value="/sendDm.do")
	public String sendDm(DirectMessage dm) {
		String dmInfo = dm.getSender()+dm.getReceiver()+dm.getDmContent();
		int result = service.sendDm(dm);
		if(result>0) {
			return dmInfo;
		}else {
			return "보내기 실패!";
		}
	}
}
