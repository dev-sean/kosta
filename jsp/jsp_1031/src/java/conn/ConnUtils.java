package conn;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @author ������
 * Document : ConnUtils 
 * Created on : 2014. 10. 31, ���� 3:13:11
 */
public class ConnUtils {
    //Coonnection Pool���� Connection�� ȹ���ؿ��� ��ü.
    private static DataSource ds;
    static{
        try {
            //context.xml�� ������ JNDI�� �о� ���� ���� ��ü
            
            InitialContext ctx = new InitialContext();
            //ctx�� Context�� ��η� Resouce�� ȹ��(java:comp/env/...)
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/myora");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }

    }
    //����� Resource���� Connection�� ȹ���ؼ� ����
    public static Connection getConn() throws SQLException{
        return ds.getConnection();
    }
    
}
