package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 오세현
 * Document : ConnUtil 
 * Created on : 2014. 10. 15, 오후 4:00:44
 */
public class ConnUtil {
    //static 초기화 : 메인메서드보다 먼저 실행된다.
    //JVM이 실행해준다.
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
