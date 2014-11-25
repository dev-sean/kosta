package kosta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.Bbs1Dao;
import vo.Bbs1CommVO;
import vo.Bbs1VO;

@Controller
public class HomeController {
	@Autowired
	private Bbs1Dao dao;

	@RequestMapping(value = "/home.kosta")
	public String home(Model model) {
		System.out.println("Ÿ���� Ȩ ����!");
		model.addAttribute("msg", "���� ù��°  Ÿ����!");
		return "home";
	}

	@RequestMapping(value = "/bbs1In.kosta", method = RequestMethod.POST)
	public ModelAndView insert(Bbs1VO vo) {
		dao.insertBbs1(vo);
		// list�� �̵��� ���� redirect�� �̵�!
		return new ModelAndView("redirect:/list.kosta");
	}

	@RequestMapping(value = "/list.kosta", method = RequestMethod.GET)
	public ModelAndView list() {
		List<Bbs1VO> list = dao.getList();
		System.out.println("�Ѿ����?");
		ModelAndView mav = new ModelAndView("list");
		mav.addObject("list", list);

		return mav;
	}

	// Detail �������� Comment
	@RequestMapping(value = "/detail.kosta", method = RequestMethod.GET)
	public ModelAndView detail(int num) {
		Bbs1VO vo = dao.getDetail(num);
		// ����� ���� ����Ʈ�� ��� �۾�
		List<Bbs1CommVO> cList = dao.getCommList(num);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("detail");
		mav.addObject("vo", vo);
		mav.addObject("cList", cList);
		return mav;
	}

	// insert Comment
	@RequestMapping(value = "/bbs1Comm.kosta", method = RequestMethod.POST)
	public ModelAndView bbsCommin(Bbs1CommVO vo) {
		dao.insertComm(vo);
		// Deatil�� �̵� �� get������� ���� detail�� �ĺ�����
		// kcode������ �����ؾ� �Ѵ�.!
		StringBuffer redirect = new StringBuffer();
		redirect.append("redirect:detail.kosta?num=");
		redirect.append(vo.getKcode());
		return new ModelAndView(redirect.toString());
	}
	
	
	
}
