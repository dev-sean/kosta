/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kosta
 */

@WebServlet(name = "FirstReDirect", urlPatterns = {"/FirstReDirect"})
public class FirstReDirect extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //요청 파라미터 받기
        String v = req.getParameter("cmd");
        System.out.println("첫번째 페이지 이동!"+v);
        req.setAttribute("key", v);
        //페이지가 이동!, 파라미터 초기화
        resp.sendRedirect("SecondReDirect");
    }

}
