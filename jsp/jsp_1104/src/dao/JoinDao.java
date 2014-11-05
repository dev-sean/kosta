package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import conn.ConnUtil;
import vo.MjoinVO;

public class JoinDao {
	private static JoinDao dao;

	public synchronized static JoinDao getDao() {
		if(dao == null){
			dao = new JoinDao();
		}
		return dao;
	}
	public boolean addJoin(MjoinVO vo) {
		Connection con = null;
		PreparedStatement pstm = null;
		StringBuffer sql = new StringBuffer();
		sql.append("insert into mjoin values(mjoin_seq.nextVal,");
		sql.append("?,?,?,?,sysdate)");
		try {
			con = ConnUtil.getDs();
			pstm = con.prepareStatement(sql.toString());
			pstm.setString(1, vo.getId());
			pstm.setString(2, vo.getPwd());
			pstm.setString(3, vo.getName());
			pstm.setString(4, vo.getInfo());
			pstm.executeUpdate();
			return true; //정상적으로 입력됬을때
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return false; //비정상적으로 입력되었을때
		} finally {

			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	//로그인 메서드
	public String login(Map<String, String> info){
		String result="";
		try {
			Connection con = null;
			PreparedStatement pstm = null;
			StringBuffer sql = new StringBuffer();
			ResultSet rs = null;
			con = ConnUtil.getDs();
			sql.append("select count(*) cnt from mjoin where id=? and pwd=?");
			pstm = con.prepareStatement(sql.toString());
			pstm.setString(1, info.get("ID"));
			pstm.setString(2, info.get("PWD"));
			rs = pstm.executeQuery();
			int cnt = 0;
			if(rs.next()){
				cnt = rs.getInt("cnt");
			}
			if(cnt==1){
				result = "success";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "fail";
		}
		
		return result;
	}
	public String getUserName(String userID){
		String userName="";
		try {
			Connection con = null;
			PreparedStatement pstm = null;
			StringBuffer sql = new StringBuffer();
			ResultSet rs = null;
			con = ConnUtil.getDs();
			sql.append("select name from mjoin where id=?");
			pstm = con.prepareStatement(sql.toString());
			pstm.setString(1, userID);
			rs = pstm.executeQuery();
			
			if(rs.next()){
				userName = rs.getString("name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userName;
	}
	
	public String idCheck(String userID){
		String result="";
		try {
			Connection con = null;
			PreparedStatement pstm = null;
			StringBuffer sql = new StringBuffer();
			ResultSet rs = null;
			con = ConnUtil.getDs();
			sql.append("select count(*) cnt from mjoin where id=?");
			pstm = con.prepareStatement(sql.toString());
			pstm.setString(1, userID);
			rs = pstm.executeQuery();
			int cnt = 0;
			if(rs.next()){
				cnt = rs.getInt("cnt");
			}
			if(cnt==1){
				result = "success";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "fail";
		}
		
		return result;
	}
}
