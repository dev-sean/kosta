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
        System.out.println("ù��° ������ !");
        //request ��ü�� ���� ����
        String cmd = req.getParameter("cmd");
        req.setAttribute("val", "value1"+cmd);
        //forward ��ų �ּҸ� RequestDispatcher�� ����ؼ� ����
        RequestDispatcher rd = req.getRequestDispatcher("SecondForward");
        //���� ������ request, response�� ���� - A�� B�� ������ �����ֱ��� 
        //request�� ����!
        rd.forward(req, resp);
    }
    
}
