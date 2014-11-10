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
		// 사용자로 부터 요청을 받음
		String query = request.getParameter("query");
		// 객체들을 관리를 해주는 ActionFactory를 싱글톤으로 생성
		ActionFactory factory = ActionFactory.getFactory();
		// 요청에 따른 모델의 객체의 주소를 다형성으로 받아서
		Action action = factory.makeAction(query);
		// 요청에 따른 모델에게 일을 시키기위해서 인터페이스의 메서드를 호출하면
		// 구현된 XX모델 객체가 호출이됨 (오버라이딩 개념을 다시한번 생각해보기 바람)
		// 모델이 반환한 값을 분석하여 이동방식을 지정하면 끝!
		ActionForward af = action.execute(request, response);
		if(af.isMethod()){
			response.sendRedirect(af.getUrl());
		}else{
			//연습문제 forward로 구현해보기
			RequestDispatcher rd = request.getRequestDispatcher(af.getUrl());
			rd.forward(request, response);
		}
		
	}


}
