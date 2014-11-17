package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import control.ActionForward;
import ex3.PlayMeVO;
import ex3.Service;

public class ListModel implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {

		ApplicationContext ctx = new GenericXmlApplicationContext(
				"ex3/jdbc.xml");
		Service bean = ctx.getBean("jdbcDao", Service.class);
		List<PlayMeVO> list = bean.getList();
		
		req.setAttribute("list", list);
		return new ActionForward("/WEB-INF/playList.jsp", false);
	}

}
