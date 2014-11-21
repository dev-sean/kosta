package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vo.Bbs1CommVO;
import vo.Bbs1VO;
import dao.Bbs1Dao;

//Bbs1과 관련된 모든 작업을 정의한다.
@Controller
public class Bbs1ActionController {
	@Autowired
	private Bbs1Dao dao;

	@RequestMapping(value = "/bbs1In.kosta", method = RequestMethod.POST)
	public ModelAndView insert(Bbs1VO vo) {
		dao.insertBbs1(vo);
		// list로 이동할 때는 redirect로 이동!
		return new ModelAndView("redirect:/bbs1List.kosta");
	}

	@RequestMapping(value = "/bbs1List.kosta", method = RequestMethod.GET)
	public ModelAndView list() {
		List<Bbs1VO> list = dao.getList();

		ModelAndView mav = new ModelAndView("bbs1List");
		mav.addObject("list", list);

		return mav;
	}

	// Detail 페이지와 Comment
	@RequestMapping(value = "/bbs1detail.kosta", method = RequestMethod.GET)
	public ModelAndView detail(int num) {
		Bbs1VO vo = dao.getDetail(num);
		// 댓글을 위한 리스트도 출력 작업
		List<Bbs1CommVO> cList = dao.getCommList(num);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("bbs1Detail");
		mav.addObject("vo", vo);
		mav.addObject("cList", cList);
		return mav;
	}

	// insert Comment
	@RequestMapping(value="/bbs1Comm.kosta", method=RequestMethod.POST)
	public ModelAndView bbsCommin(Bbs1CommVO vo){
		dao.insertComm(vo);
		// Deatil로 이동 시 get방식으로 실제 detail의 식별자인
		// kcode값으로 지정해야 한다.!
		StringBuffer redirect = new StringBuffer();
		redirect.append("redirect:bbs1detail.kosta?num=");
		redirect.append(vo.getKcode());				
		return new ModelAndView(redirect.toString());
	}
}
