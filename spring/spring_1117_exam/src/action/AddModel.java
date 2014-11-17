package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import control.ActionForward;
import ex3.PlayMeDao;
import ex3.PlayMeVO;
import ex3.Service;

public class AddModel implements Action{
	private String url;
	private boolean method;
	
	@Autowired
	private PlayMeDao dao;
	
	@Override
	public ActionForward execute(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("euc-kr");
		PlayMeVO vo = new PlayMeVO();
		vo.setPname(req.getParameter("pname"));
		vo.setPrice(Integer.parseInt(req.getParameter("price")));
		vo.setUsers(req.getParameter("users"));
		
		dao.add(vo);
		return new ActionForward(url, method);
	}
}