package tb;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vo.TBboardVO;
import dao.TvoDao;

@Controller
public class TvoListController {
	@Autowired
	private TvoDao dao;

	@RequestMapping(value = "/list.kosta", method = RequestMethod.GET)
	public ModelAndView list() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("list");
		List<TBboardVO> listvo = dao.getList();
		mav.addObject("list", listvo);
		return mav;
	}
}
