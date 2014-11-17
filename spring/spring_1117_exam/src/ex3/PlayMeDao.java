package ex3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class PlayMeDao implements Service {
	// spring에서 제공하는 Template를 사용
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void add(PlayMeVO vo) {
		StringBuffer sb = new StringBuffer();
		sb.append("insert into playme values(");
		sb.append("playme_seq.nextVal,?,?,?, sysdate)");
		// parameter
		Object[] param = { vo.getPname(), vo.getPrice(), vo.getUsers() };
		jdbcTemplate.update(sb.toString(), param);
		System.out.println("Insert OK");
	}

	@Override
	public List<PlayMeVO> getList() {
		StringBuffer sb = new StringBuffer();

		sb.append(" select num,pname,price,users ");
		sb.append(" ,to_char(rdate,'yyyy-mm-dd') rdate from playme ");
		sb.append(" order by 1 desc ");
		// jdbcTemplate를 사용해서 mapRow() 사용해서 cursor을 하나씩 받아서
		// List에 기억을 시켜놓자.
		List<PlayMeVO> list = jdbcTemplate.query(sb.toString(),
				new RowMapper<PlayMeVO>() {

					@Override
					public PlayMeVO mapRow(ResultSet rs, int arg1)
							throws SQLException {
							PlayMeVO vo = new PlayMeVO();
							vo.setNum(rs.getInt("num"));
							vo.setPname(rs.getString("pname"));
							vo.setUsers(rs.getString("users"));
							vo.setPrice(rs.getInt("price"));
							vo.setRdate(rs.getString("rdate"));
						return vo;
					}
				});

		return list;
	}

	@Override
	public PlayMeVO getView(int num) {
		StringBuffer sb = new StringBuffer();

		sb.append(" select num,pname,price,users ");
		sb.append(" ,to_char(rdate,'yyyy-mm-dd') rdate from playme ");
		sb.append(" where num=? ");
		
		
		PlayMeVO vo1 = jdbcTemplate.queryForObject(sb.toString(), new RowMapper<PlayMeVO>(){

			@Override
			public PlayMeVO mapRow(ResultSet rs, int arg1)
					throws SQLException {
				PlayMeVO vo = new PlayMeVO();
				vo.setNum(rs.getInt("num"));
				vo.setPname(rs.getString("pname"));
				vo.setUsers(rs.getString("users"));
				vo.setPrice(rs.getInt("price"));
				vo.setRdate(rs.getString("rdate"));
				return vo;
			}
			
		},num);
		return vo1;
	}

}
