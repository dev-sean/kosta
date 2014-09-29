package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ������ Document : insertDemo Created on : 2014. 9. 29, ���� 2:14:37
 */
public class insertDemo {

    private Connection con;
    private PreparedStatement pstm;
    private StringBuffer sql;
    private ResultSet rs;

    public insertDemo() {
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("����̹� �ε� ����");
            //jdbc:oracle:this -> protocol
            String url = "jdbc:oracle:thin:@localhost:1521/pdborcl";
            String user = "sqlexam";
            String pass = "new14";
            con = DriverManager.getConnection(url, user, pass);

            sql = new StringBuffer();

        } catch (ClassNotFoundException ex) {
            System.out.println("����̹� �ε� ����");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("����Ŭ ����");
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
            pstm.executeUpdate();// insert, delete, update�϶� ���
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

    public String printContent() {
        String msg = null;

        sql.append("select bordno, bid, bpwd, bname, bbirth, bemail from member");
        sql.append(" order by 1 desc");//�������� desc 1 - num
        try {
            //���� ����
            pstm = con.prepareStatement(sql.toString());
            //Cursor�� �����ޱ� ���� �޼��带 ȣ��
            rs = pstm.executeQuery();
            //�������� Cursor�� ����ؼ� �����͸� ���
            //rs.next( ) Cursor�� ���� ��� true�� ����
            while (rs.next()) {
                msg += rs.getInt("bordno");
                msg += rs.getString("bid");
                msg += rs.getString("bpwd");
                msg += rs.getString("bname");
                msg += rs.getString("bbirth");
                msg += rs.getString("bemail");
                
                return msg;
            }
            System.out.println(msg);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return msg;
    }
}
