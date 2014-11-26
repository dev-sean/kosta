package kosta.dao;

import java.util.List;

import kosta.vo.Board2VO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {

	@Autowired
	private SqlSessionTemplate ss;

	// 답글 insert
	public void addBoard(Board2VO vo) {
		ss.insert("kosta.addboard", vo);
	}

	// 답글 list
	public List<Board2VO> listBoard(Board2VO vo) {
		return ss.selectList("kosta.listboard", vo);
	}

	// 답글 detail
	public Board2VO detailBoard(int no) {
		return ss.selectOne("kosta.detailboard", no);
	}

	// 수정중
	// 본격 답글 insert
	public void reupBoard(Board2VO vo) {
		System.out.println("update전 :" + vo.getRef() + ", " + vo.getSeq());
		ss.update("kosta.upboard", vo);
		ss.insert("kosta.reboard", vo);
		System.out.println("update후 :" + vo.getRef() + ", " + vo.getSeq());
	}
	//
	// // 본격 답글 tx_insert로
	// public void tx_addBoard(Board2VO vo) {
	// ss.insert("kosta.txreinboard", vo);
	// }
	//
	// // 본격 답글 tx_update
	// public void tx_upBoard(Board2VO vo) {
	// ss.update("kosta.txreupboard", vo);
	// }
}
