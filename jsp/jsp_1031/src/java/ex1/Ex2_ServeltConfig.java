/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kosta
 */
public class Ex2_ServeltConfig extends HttpServlet {
    private String admin_id,test_id,address;
    //�ٽ� : ServletContext�� ��� ���ø����̼ǿ��� ���Ǵ� ����
    //ServletConfig�� ������ ���������� ��ȿ�ϴ�.
    @Override
    public void init() throws ServletException {
        //init-param���� ����� ������ ServletConfig�� ����ȴ�.
        admin_id = getServletConfig().getInitParameter("admin_id");
        test_id = getServletContext().getInitParameter("admin_id");
        //context-param���� ����� ������ ServletContext�� ����ȴ�.
        address = getServletContext().getInitParameter("address");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //PrintWriter : �긴�� ��Ʈ���� �ʿ����. 1���� �ٷ� ������ ����
        //AutoFlush ���
        //2�� ���� ��Ʈ��!
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter(); //��Ʈ��!
        out.println("Admin:"+ admin_id+"<br/>");
        out.println("Admin test:"+ test_id+"<br/>");
        out.println("address:"+ address+"<br/>");
    }
    
}
