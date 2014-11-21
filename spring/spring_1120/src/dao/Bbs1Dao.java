package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import vo.Bbs1CommVO;
import vo.Bbs1VO;

public class Bbs1Dao {
	@Autowired
	private SqlSessionTemplate template;

	// Spring에서 제공하는 template를 사용하면 commit, close를 자동으로 해준다.
	public void insertBbs1(Bbs1VO vo) {
		template.insert("bbs1.ins", vo);
	}
	
	public List<Bbs1VO> getList(){
		return template.selectList("bbs1.list");
	}
	
	public Bbs1VO getDetail(int num){
		return template.selectOne("bbs1.detail",num);
	}
	
	public void insertComm(Bbs1CommVO vo){
		template.insert("bbs1.commIn", vo);
	}
	
	public List<Bbs1CommVO> getCommList(int kcode){
		return template.selectList("commList", kcode);
		
	}
}
