package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ������
 * Document : ConnUtil 
 * Created on : 2014. 10. 15, ���� 4:00:44
 */
public class ConnUtil {
    //static �ʱ�ȭ : ���θ޼��庸�� ���� ����ȴ�.
    //JVM�� �������ش�.
    static{
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    public static Connection getConn() throws SQLException{
        String url = "jdbc:oracle:thin:@localhost:1521/pdborcl";
        String user = "kosta86";
        String pass = "new14";
        return DriverManager.getConnection(url, user, pass);
    }
}
