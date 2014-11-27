package kosta.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import resource.vo.VoteVO;

@Repository
public class VoteDao {
	@Autowired
	private SqlSessionTemplate ss;
	
	public void voteAdd(VoteVO vo){
		ss.insert("vote.voteadd",vo);
	}
	
	public List<VoteVO> voteList(){
		return ss.selectList("vote.voteList");
	}
	
	public VoteVO getDetail(int num){
		return ss.selectOne("vote.voteDetail",num);
	}
	
	public void voteUp(VoteVO vo){
		ss.update("vote.voteUp",vo);
	}
}
