package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import action.Action;

@WebServlet("*.kosta")
public class ControlServlet extends HttpServlet {
	private ApplicationContext ctx;

	public ControlServlet() {
		ctx = new GenericXmlApplicationContext("control/factory.xml");
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");

		String query = request.getParameter("query");

		Action action = ctx.getBean(query, Action.class);

		ActionForward af = action.execute(request, response);
		StringBuffer path = new StringBuffer();
		path.append("/WEB-INF/").append(af.getUrl());
		if (af.isMethod()) {
			response.sendRedirect(af.getUrl());
		} else {
			RequestDispatcher rd = request
					.getRequestDispatcher(path.toString());
			rd.forward(request, response);
		}
	}
}
