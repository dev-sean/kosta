package kosta.controller;

import java.util.List;

import kosta.dao.BoardDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import resource.vo.BoardVO;

@Controller
public class BoardController {
	@Autowired
	private BoardDao dao;
	
	@RequestMapping(value="/list.kosta", method=RequestMethod.GET)
	public ModelAndView search(){

		BoardVO vo = new BoardVO();
		List<BoardVO> list = dao.getList(vo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("boardlist");
		mav.addObject("list",list);

		return mav;
	}
	
	@RequestMapping(value="/search.kosta", method=RequestMethod.POST)
	public ModelAndView search(BoardVO vo){
		List<BoardVO> list = dao.getList(vo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("boardlist");
		mav.addObject("list",list);
		return mav;
	}
}
