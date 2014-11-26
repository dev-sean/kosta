package kosta.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.AdminVO;

//이것을 빈으로 등록하지 않고 자동으로 autowired되게 하겠다. 라고 하면 repository를 사용한다.
@Repository
public class MemberDaoImple implements MemberDaoInter {
	@Autowired
	private SqlSessionTemplate ss;

	public void setSs(SqlSessionTemplate ss) {
		this.ss = ss;
	}

	@Override
	public AdminVO getUserPassword(String userid) {
		System.out.println("MemberDaoImple" + userid);
		AdminVO rev = ss.selectOne("login.loginok", userid);
		System.out.println("rev:"+rev);
		return rev;
	}
}
