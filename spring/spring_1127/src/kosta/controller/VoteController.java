package kosta.controller;

import java.util.List;

import kosta.dao.VoteDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import resource.vo.VoteVO;

@Controller
public class VoteController {
	
	@Autowired
	private VoteDao dao;
	
	@RequestMapping(value="/votein.kosta", method=RequestMethod.POST)
	public ModelAndView addVote(VoteVO vo){
		System.out.println(vo.getSub());
		System.out.println(vo.getCode());
		ModelAndView mav = new ModelAndView();
		dao.voteAdd(vo);
		mav.setViewName("redirect:/voteList.kosta");
		return mav;
	}
	
	
	@RequestMapping(value="/voteList.kosta")
	public ModelAndView list(){
		List<VoteVO> list = dao.voteList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("voteList");
		return mav;
	}
	
	@RequestMapping(value="/voteDetail.kosta")
	public ModelAndView voteDetail(int num){
		VoteVO v = dao.getDetail(num);
		ModelAndView mav = new ModelAndView();
		mav.addObject("v",v);
		mav.setViewName("voteDetail");
		return mav;
	}
	
	@RequestMapping(value="/voteUp.kosta", method=RequestMethod.POST)
	public ModelAndView voteUpdate(VoteVO vo){
		dao.voteUp(vo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/voteList.kosta");
		return mav;
	}
}
