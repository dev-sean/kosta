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

	// ��� insert
	public void addBoard(Board2VO vo) {
		ss.insert("kosta.addboard", vo);
	}

	// ��� list
	public List<Board2VO> listBoard(Board2VO vo) {
		return ss.selectList("kosta.listboard", vo);
	}

	// ��� detail
	public Board2VO detailBoard(int no) {
		return ss.selectOne("kosta.detailboard", no);
	}

	// ������
	// ���� ��� insert
	public void reupBoard(Board2VO vo) {
		System.out.println("update�� :" + vo.getRef() + ", " + vo.getSeq());
		ss.update("kosta.upboard", vo);
		ss.insert("kosta.reboard", vo);
		System.out.println("update�� :" + vo.getRef() + ", " + vo.getSeq());
	}
	//
	// // ���� ��� tx_insert��
	// public void tx_addBoard(Board2VO vo) {
	// ss.insert("kosta.txreinboard", vo);
	// }
	//
	// // ���� ��� tx_update
	// public void tx_upBoard(Board2VO vo) {
	// ss.update("kosta.txreupboard", vo);
	// }
}
