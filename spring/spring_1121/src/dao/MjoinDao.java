package dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import vo.MjoinVO;

public class MjoinDao {
	@Autowired
	private SqlSessionTemplate template;
	
	public int idChk(String id){
		System.out.println("id:"+id);
		return template.selectOne("mjoin.check",id);
	}
	
	public int login(MjoinVO vo){
		return template.selectOne("mjoin.loginChk", vo);
	}
}
