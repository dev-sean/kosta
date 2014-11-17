package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import control.ActionForward;
import ex3.PlayMeVO;
import ex3.Service;

public class DetailModel implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		request.setCharacterEncoding("euc-kr");
		String num = request.getParameter("num");

		ApplicationContext ctx = new GenericXmlApplicationContext(
				"ex3/jdbc.xml");
		Service bean = ctx.getBean("jdbcDao", Service.class);
		PlayMeVO vo = new PlayMeVO();
		vo = bean.getView(Integer.parseInt(num));
		ArrayList<PlayMeVO> list = new ArrayList<PlayMeVO>();
		list.add(vo);
		request.setAttribute("list", list);
		return new ActionForward("/WEB-INF/playDetail.jsp", false);
	}

}
