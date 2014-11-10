package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

@WebServlet("*.kosta")
public class ControlServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	private void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		// ����ڷ� ���� ��û�� ����
		String query = request.getParameter("query");
		// ��ü���� ������ ���ִ� ActionFactory�� �̱������� ����
		ActionFactory factory = ActionFactory.getFactory();
		// ��û�� ���� ���� ��ü�� �ּҸ� ���������� �޾Ƽ�
		Action action = factory.makeAction(query);
		// ��û�� ���� �𵨿��� ���� ��Ű�����ؼ� �������̽��� �޼��带 ȣ���ϸ�
		// ������ XX�� ��ü�� ȣ���̵� (�������̵� ������ �ٽ��ѹ� �����غ��� �ٶ�)
		// ���� ��ȯ�� ���� �м��Ͽ� �̵������ �����ϸ� ��!
		ActionForward af = action.execute(request, response);
		if(af.isMethod()){
			response.sendRedirect(af.getUrl());
		}else{
			//�������� forward�� �����غ���
			RequestDispatcher rd = request.getRequestDispatcher(af.getUrl());
			rd.forward(request, response);
		}
		
	}


}
