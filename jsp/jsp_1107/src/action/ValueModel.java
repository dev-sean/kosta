package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.ActionForward;

public class ValueModel implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		String v = req.getParameter("val");
		StringBuffer sb = new StringBuffer();
		sb.append("����� ��û�� ���� ").append(v).append("�Դϴ�.");
		//request ��ü�� ���ؼ� ���� �����Ѵ�.
		req.setAttribute("msg", sb.toString());
		return new ActionForward("/WEB-INF/value1.jsp", false);
	}

}
