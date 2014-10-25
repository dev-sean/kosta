/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Soo
 */
public class ConnUtil {

    static {
        try {
            // static 초기화- 메인 메서드보다 먼저 JVM이 실행해준다.
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    public static Connection getConn() throws SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521/pdborcl";
        String user = "Bjo";
        String pass = "fighting";
        return DriverManager.getConnection(url, user, pass);
    }
}
