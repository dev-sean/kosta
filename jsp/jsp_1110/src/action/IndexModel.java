package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.ActionForward;

// 모델은 비지니스 로직을 수행해야 하고, 반드시 컨트럴러에 의한 요청이 있을 때 수행 되어야 하기
// 때문에 컨트럴러에게 메뉴로 제공될  인터페이스를 구현해야한다.
public class IndexModel implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		System.out.println("IndexModel이 수행되었음");
		System.out.println("데이터 베이스 관련 작업도 여기서 함!");
		return new ActionForward("index.jsp", false);
	}
}




