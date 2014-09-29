package ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 오세현
 * Document : Ex2_JdbcExam 
 * Created on : 2014. 9. 29, 오후 3:44:01
 */
public class Ex2_JdbcExam {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521/pdborcl";
            String user = "kosta86";
            String pass = "new14";
            con = DriverManager.getConnection(url,user,pass);
            System.out.println("접속 성공");
            StringBuffer sql = new StringBuffer();
            sql.append("insert into bord values(");
            sql.append("bord_seq.nextVal, ?, ?, ?, sysdate) ");
            
            pstm = con.prepareStatement(sql.toString());
            
            pstm.setString(1, "HEllo");
            pstm.setString(2, "오세현");
            pstm.setString(3, "Hello World");
            
            pstm.executeUpdate();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}