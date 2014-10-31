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
        System.out.println("생성자 호출!");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("서비스가 호출 되었음"+req.getRemoteAddr()+"에서 ");
        System.out.println("요청방식 : "+req.getMethod());
        doGet(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get메서드가 호출되었음");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("초기화 init 메서드가 호출되었음!");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("초기화 destroy 메서드 호출!");
    }

}
