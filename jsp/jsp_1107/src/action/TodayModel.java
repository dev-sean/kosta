package action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.ActionForward;

public class TodayModel implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		req.setAttribute("date", date.format(new Date()));
		return new ActionForward("/WEB-INF/today.jsp",false);
	}
	
	

}
