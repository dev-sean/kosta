package ex1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@WebServlet(urlPatterns = {"/Ex1_LifeCycle"})
public class Ex1_LifeCycle extends HttpServlet {

    public Ex1_LifeCycle() {
        System.out.println("������ ȣ��!");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("���񽺰� ȣ�� �Ǿ���"+req.getRemoteAddr()+"���� ");
        System.out.println("��û��� : "+req.getMethod());
        doGet(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get�޼��尡 ȣ��Ǿ���");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("�ʱ�ȭ init �޼��尡 ȣ��Ǿ���!");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("�ʱ�ȭ destroy �޼��� ȣ��!");
    }

}
