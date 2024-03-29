package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 오세현 Document : insertDemo Created on : 2014. 9. 29, 오후 2:14:37
 */
public class insertDemo {

    private Connection con;
    private PreparedStatement pstm;
    private StringBuffer sql;
    private ResultSet rs;

    public insertDemo() {
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("드라이버 로딩 성공");
            //jdbc:oracle:this -> protocol
            String url = "jdbc:oracle:thin:@localhost:1521/pdborcl";
            String user = "sqlexam";
            String pass = "new14";
            con = DriverManager.getConnection(url, user, pass);

            sql = new StringBuffer();

        } catch (ClassNotFoundException ex) {
            System.out.println("드라이버 로딩 실패");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("오라클 에러");
            ex.printStackTrace();
        }

    }

    public void setContent(String id, String pass, String name, String birth, String mail) {

        try {
            sql.append("insert into bord values(");

            sql.append(" bord_seq.nextVal,?,?,?,?,?)");

            pstm = con.prepareStatement(sql.toString());

            pstm.setString(1, id);
            pstm.setString(2, pass);
            pstm.setString(3, name);
            pstm.setString(4, birth);
            pstm.setString(5, mail);
            pstm.executeUpdate();// insert, delete, update일때 사용
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pstm.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void getList(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("드라이버 로딩 성공");
            String url = "jdbc:oracle:thin:@localhost:1521/pdborcl";
            String user = "sqlexam";
            String pass = "new14";
            con = DriverManager.getConnection(url, user, pass);
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public String printContent() {
        String msg = null;

        sql.append("select * from member");
        sql.append(" order by 1 desc");//내림차순 desc 1 - num
        try {
            //쿼리 전송
            pstm = con.prepareStatement(sql.toString());
            //Cursor를 돌려받기 위한 메서드를 호출
            rs = pstm.executeQuery();
            //돌려받은 Cursor를 사용해서 데이터를 출력
            //rs.next( ) Cursor가 있을 경우 true를 리턴
            while (rs.next()) {
                //listView.append("번호" + rs.getInt("num")+"\n";
            }
            System.out.println(msg);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return msg;
    }

    public boolean checkid(String id) {
        String idmsg = null;
        try {
            sql.append("select bid from bord where bid=?");
            pstm = con.prepareStatement(sql.toString());

            pstm.setString(1, id);

            rs = pstm.executeQuery();

            while (rs.next()) {
                idmsg = rs.getString("bid");
            }

            if (idmsg.equals(id)) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    /*
    public int findIdResult(){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String url = "jdbc:oracle:thin:@localhost:1521/pdborcl";
        String user = "sqlexam";
        String pass = "new14";
        int resN = 0;
        //requestFocus();
    
        try {
            con = DriverManager.getConnection(url,user,pass);
            StringBuffer sql = new StringBuffer();
            sql.append("select count(*) cnt from member ");
            sql.append(" where rid=?");
            pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, ridv.getText().trim());
            rs = pstmt.executeQuery();
            if(rs.next()){
                resN = rs.getInt("cnt");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resN;
    }
    */
}
