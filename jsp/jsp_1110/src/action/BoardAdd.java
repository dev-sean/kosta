package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.BoardVO;
import control.ActionForward;
import dao.BoardDao;

public class BoardAdd implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		//title writer groupno content
		BoardVO bvo = new BoardVO();
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String groupno = req.getParameter("groupno");
		String content = req.getParameter("content");
		bvo.setTitle(title);
		bvo.setContent(content);
		bvo.setWriter(writer);
		bvo.setGroupno(Integer.parseInt(groupno));
		
		BoardDao.getDao().insert(bvo);
		
		return new ActionForward("board.kosta?query=boardList&page=1", true);
	}

}
