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
 * @author 오세현 Document : Ex1_ProcedureDemo Created on : 2014. 10. 6, 오후 2:35:01
 */
public class Ex1_ProcedureDemo {

    //static 초기화 : main 메서드보다 먼저 수행이 되는 
    //말 그대로 초기화를 수행하는 영역이다.
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        //연습문제 : conn.properties 파일을 읽어와서
        //UI
        Scanner sc = new Scanner(System.in);
        System.out.print("부서번호 : ");
        int deptno = Integer.parseInt(sc.nextLine());
        String path = "C:\\kosta86\\javaStudy\\workspace\\jdbc1006\\src\\ex1\\conn.properties";
        PropertiesUtil pu = new PropertiesUtil(path);
        String protocol = pu.getProtocol();
        String user = pu.getUserid();
        String pass = pu.getPass();
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
   //select를 입력 받을 수 없다. out이 없으면
        //select를 돌출 시킬 수 없다. in이 없으면
        try {
            con = DriverManager.getConnection(protocol, user, pass);
            //프로시져를 호출
            cs = con.prepareCall("begin my_sawon(?,?); end;");
            //입력 파라미터 설정
            cs.setInt(1, deptno);
            //출력 파라미터 설정 - out모드의 SYSREFCURSOR 타입을 지정
            cs.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            while(rs.next()){
                System.out.println("사원번호 : " + rs.getInt("sabun"));
                System.out.println("사원이름 : "+ rs.getString("saname"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
