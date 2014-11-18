package dao;

import java.sql.SQLException;

import vo.MjoinVO;

public interface DaoService {
	public void transactionTest(MjoinVO vo) throws SQLException;
}
