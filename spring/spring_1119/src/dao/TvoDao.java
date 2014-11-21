package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import vo.TBboardVO;

public class TvoDao implements TvoService {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void add(TBboardVO tvo) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into tvo ");
		sql.append(" values(tvo_seq.nextVal,?,?,?,?,?)");
		// parameter
		Object[] param = { tvo.getSub(), tvo.getWriter(), tvo.getContent(),
				tvo.getPwd(), tvo.getMfile() };
		jdbcTemplate.update(sql.toString(), param);
		System.out.println("Insert Ok");

	}

	@Override
	public List<TBboardVO> getList() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select sub,writer,content,pwd,mfile ");
		sql.append(" from tvo order by 1 desc ");

		List<TBboardVO> list = jdbcTemplate.query(sql.toString(),
				new RowMapper<TBboardVO>() {
					@Override
					public TBboardVO mapRow(ResultSet rs, int arg1)
							throws SQLException {
						TBboardVO tvo = new TBboardVO();
						tvo.setSub(rs.getString("sub"));
						tvo.setWriter(rs.getString("writer"));
						tvo.setContent(rs.getString("content"));
						tvo.setPwd(rs.getString("pwd"));
						tvo.setMfile(rs.getString("mfile"));
						return tvo;
					}
				});
		return list;
	}

}
