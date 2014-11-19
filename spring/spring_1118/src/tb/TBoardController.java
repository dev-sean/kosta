package tb;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.TvoDao;
import vo.TBboardVO;

@Controller
public class TBoardController {
	@Autowired
	private TvoDao dao;

	@RequestMapping(value = "/save.kosta", method = RequestMethod.POST)
	// @ModelAttribute("tvo") : tvo가 request에(ModelAndView) forward된다.
	public ModelAndView save(@ModelAttribute("tvo") TBboardVO tvo,
			HttpServletRequest request) {

		HttpSession session = request.getSession();
		String r_path = session.getServletContext().getRealPath("/");
		System.out.println(r_path);
		String img_path = "\\img\\";
		System.out.println(img_path);
		StringBuffer path = new StringBuffer();
		path.append(r_path).append(img_path);
		String oriFn = tvo.getMfile1().getOriginalFilename();
		path.append(oriFn);
		System.out.println(path);

		// 파일 업로드
		File f = new File(path.toString());
		try {
			tvo.getMfile1().transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}

		tvo.setMfile(oriFn);
		dao.add(tvo);
		ModelAndView mav = new ModelAndView("success");
		return new ModelAndView("success");
	}
}
