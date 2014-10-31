/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kosta
 */
@WebServlet(name = "FirstForward", urlPatterns = {"/FirstForward"})
public class FirstForward extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("첫번째 페이지 !");
        //request 객체에 값을 설정
        String cmd = req.getParameter("cmd");
        req.setAttribute("val", "value1"+cmd);
        //forward 시킬 주소를 RequestDispatcher를 사용해서 생성
        RequestDispatcher rd = req.getRequestDispatcher("SecondForward");
        //현재 서블릿의 request, response를 주입 - A와 B의 범위의 생명주기인 
        //request가 구현!
        rd.forward(req, resp);
    }
    
}
