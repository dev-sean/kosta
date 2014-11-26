package kosta.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.AdminVO;

//�̰��� ������ ������� �ʰ� �ڵ����� autowired�ǰ� �ϰڴ�. ��� �ϸ� repository�� ����Ѵ�.
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
