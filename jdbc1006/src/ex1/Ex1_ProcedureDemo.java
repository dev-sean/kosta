package ex1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ������ Document : Ex1_ProcedureDemo Created on : 2014. 10. 6, ���� 2:35:01
 */
public class Ex1_ProcedureDemo {

    //static �ʱ�ȭ : main �޼��庸�� ���� ������ �Ǵ� 
    //�� �״�� �ʱ�ȭ�� �����ϴ� �����̴�.
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        //�������� : conn.properties ������ �о�ͼ�
        //UI
        Scanner sc = new Scanner(System.in);
        System.out.print("�μ���ȣ : ");
        int deptno = Integer.parseInt(sc.nextLine());
        String path = "C:\\kosta86\\javaStudy\\workspace\\jdbc1006\\src\\ex1\\conn.properties";
        PropertiesUtil pu = new PropertiesUtil(path);
        String protocol = pu.getProtocol();
        String user = pu.getUserid();
        String pass = pu.getPass();
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
   //select�� �Է� ���� �� ����. out�� ������
        //select�� ���� ��ų �� ����. in�� ������
        try {
            con = DriverManager.getConnection(protocol, user, pass);
            //���ν����� ȣ��
            cs = con.prepareCall("begin my_sawon(?,?); end;");
            //�Է� �Ķ���� ����
            cs.setInt(1, deptno);
            //��� �Ķ���� ���� - out����� SYSREFCURSOR Ÿ���� ����
            cs.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            while(rs.next()){
                System.out.println("�����ȣ : " + rs.getInt("sabun"));
                System.out.println("����̸� : "+ rs.getString("saname"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
