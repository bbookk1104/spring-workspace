package kr.or.dm.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.dm.model.dao.DirectMessageDao;
import kr.or.dm.model.vo.DirectMessage;

@Service
public class DirectMessageService {
	@Autowired
	private DirectMessageDao dao;
	
	@Transactional
	public int sendDm(DirectMessage dm) {
		return dao.sendDm(dm);
	}

	public ArrayList<DirectMessage> getReceiveDm(DirectMessage dm) {
		return dao.getReceiveDm(dm);
	}

	public ArrayList<DirectMessage> getSendDm(DirectMessage dm) {
		return dao.getSendDm(dm);
	}

	public ArrayList<DirectMessage> selectDmList(DirectMessage dm) {
		return dao.selectDmList(dm);
	}
	
	@Transactional
	public DirectMessage selectOneDm(int dmNo) {
		DirectMessage dm = dao.selectOneDm(dmNo);
		if(dm.getReadCheck()==0) {
			dao.updateReadCheck(dmNo);
		}
		return dm;
	}

	public int dmCount(String memberId) {
		return dao.dmCount(memberId);
	}
}
