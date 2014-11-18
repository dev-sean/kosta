package dao;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import vo.MjoinVO;

public class DaoServiceImple implements DaoService {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void transactionTest(MjoinVO vo) throws SQLException {
		// ���� �۾��� ���ؼ� rollback ��Ȳ�� ���������� ������ �Ѵ�.
		StringBuffer[] sb = new StringBuffer[5];
		for (int i = 0; i < sb.length; i++) {
			sb[i] = new StringBuffer();
			sb[i].append("insert into mjoin ");
			sb[i].append(" values(mjoin_seq.nextVal, ?, ?,?,?,sysdate,?)");
			int number = (1000 + 1) * i;
			if (i == 3) {
				number = 1000 / 0;
			} else {

			}
			jdbcTemplate.update(sb[i].toString(), vo.getId(), vo.getPwd(),
					vo.getName(), vo.getInfo(), number);
		}

	}
}
