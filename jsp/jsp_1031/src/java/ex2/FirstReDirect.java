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
        
        //��û �Ķ���� �ޱ�
        String v = req.getParameter("cmd");
        System.out.println("ù��° ������ �̵�!"+v);
        req.setAttribute("key", v);
        //�������� �̵�!, �Ķ���� �ʱ�ȭ
        resp.sendRedirect("SecondReDirect");
    }

}
