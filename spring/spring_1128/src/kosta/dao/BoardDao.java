package kosta.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import resource.vo.BoardVO;

@Repository
public class BoardDao {
	@Autowired
	private SqlSessionTemplate ss;
	
	public List<BoardVO> getList(BoardVO vo){
		return ss.selectList("board1.searchList", vo);
	}
}
