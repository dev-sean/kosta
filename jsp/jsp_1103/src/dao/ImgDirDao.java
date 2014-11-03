package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.ConnUtil;
import vo.ImgDirVO;

public class ImgDirDao {
	// 현재 ImgDirDao 객체는 서블릿이나 JSP에서 Model1방식으로 설계되었다.
	// Thread가 접근할 자원이기 때문에 동기화 처리가 되어야 하고
	// 자원이 한정된 Connection을 받아서 사용해야 하기 때문에
	// 싱글톤 디자인 패턴을 사용해서 처음에 생성시 static 영역에 하나만 생성시켜놓고
	// 그 후에는 이미 생성된 주소로 사용하도록 한다.
	// 안드로이드에서 GridView일 때 이미 여러분은 싱글톤의 경험이 있어요.
	private static ImgDirDao dao;

	// 동기화 처리
	public synchronized static ImgDirDao getDao() {
		if (dao == null) {
			dao = new ImgDirDao();
		}
		return dao;
	}

	// 재사용성에 입각한 SQL문을 관리하는 메서드를 만들어 보자.
	//add
	public void addImg(ImgDirVO vo) {
		Connection con = null;
		PreparedStatement pstm = null;
		StringBuffer sql = new StringBuffer();
		sql.append("insert into imgdir values(imgdir_seq.nextVal,");
		sql.append("?,?,0,?,sysdate)");
		try {
			con = ConnUtil.getDs();
			pstm = con.prepareStatement(sql.toString());
			pstm.setString(1, vo.getWriter());
			pstm.setString(2, vo.getImgpath());
			pstm.setString(3, vo.getReip());
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	//list
	public ArrayList<ImgDirVO> getList(){
		Connection con= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		//저장할 데이터VO의 주소를 기억시킬 컬렉션 생성
		ArrayList<ImgDirVO> ar = new ArrayList<ImgDirVO>();
		StringBuffer sql = new StringBuffer();
		sql.append("select num, writer, imgpath, hit, edate from imgdir order by 1 desc");
		
		try {
			con = ConnUtil.getDs();
			pstm = con.prepareStatement(sql.toString());
			rs = pstm.executeQuery();
			while(rs.next()){
				//하나의 row를 저장할 VO 객체
				ImgDirVO v = new ImgDirVO();
				v.setNum(rs.getInt("num"));
				v.setWriter(rs.getString("writer"));
				v.setImgpath(rs.getString("imgpath"));
				v.setHit(rs.getInt("hit"));
				v.setEdate(rs.getString("edate"));
				//ArrayList에 각각의 데이터를 저장한 VO의 주소를 기억시킨다.
				ar.add(v);
			}
			rs.close();
			pstm.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ar;//그 주소를 반환한다.
	}
	
}
