package kosta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kosta.dao.BoardDao;
import kosta.vo.Board2VO;

@Transactional
@Service
public class uptest {

	@Autowired
	private BoardDao bdao;

	public void reupboard(Board2VO vo) {
	//	bdao.tx_addBoard(vo);
		System.out.println("insert OK");
		
		System.out.println(vo.getSeq() + " : " + vo.getRef());
	//	bdao.tx_upBoard(vo);
		System.out.println("update OK");
	}
}
