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
    //핵심 : ServletContext는 모든 어플리케이션에서 사용되는 범위
    //ServletConfig는 설정된 서블릿에서만 유효하다.
    @Override
    public void init() throws ServletException {
        //init-param으로 등록한 내용은 ServletConfig에 저장된다.
        admin_id = getServletConfig().getInitParameter("admin_id");
        test_id = getServletContext().getInitParameter("admin_id");
        //context-param으로 등록한 내용은 ServletContext에 저장된다.
        address = getServletContext().getInitParameter("address");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //PrintWriter : 브릿지 스트림이 필요없음. 1차에 바로 연결이 가능
        //AutoFlush 기능
        //2차 문자 스트림!
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter(); //스트림!
        out.println("Admin:"+ admin_id+"<br/>");
        out.println("Admin test:"+ test_id+"<br/>");
        out.println("address:"+ address+"<br/>");
    }
    
}
