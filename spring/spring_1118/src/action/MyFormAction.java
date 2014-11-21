package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.ActionForward;

public class MyFormAction implements Action{
	private String url;
	private boolean method;
	@Override
	public ActionForward execute(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		
		return new ActionForward(url,method);
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setMethod(boolean method) {
		this.method = method;
	}

}
