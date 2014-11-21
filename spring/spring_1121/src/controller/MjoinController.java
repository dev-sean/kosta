package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vo.MjoinVO;
import dao.MjoinDao;

@Controller
public class MjoinController {
	@Autowired
	private MjoinDao dao;
	
	@RequestMapping(value="/idcheck.kosta", method=RequestMethod.POST)
	public ModelAndView idcheck(String id){
		System.out.println("Cid : "+id);
		int num = dao.idChk(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("idchk");
		String msg="";
		if(num > 0){
			msg="�̹� �����ϴ� ���̵��Դϴ�.";
		}else{
			msg = "��� ������ ���̵� �Դϴ�.";
		}
		System.out.println("num : "+num);
		mav.addObject("idv",id);
		mav.addObject("res",num);
		mav.addObject("msg",msg);
		return mav;
	}
	@RequestMapping(value="/login.kosta", method=RequestMethod.POST)
	public ModelAndView login(MjoinVO vo, HttpSession session){
		ModelAndView mav = new ModelAndView();
		int res = dao.login(vo);
		String msg="";
		if(res > 0){ //�α��� ����
			msg="�α��� ����";
			session.setAttribute("uid", vo.getId());
		}else{//�α��� ����
			msg = "�α��� ����";
			
		}
		mav.setViewName("index");
		mav.addObject("msg",msg);
		return mav;
	}
	@RequestMapping(value="/logout.kosta", method=RequestMethod.GET)
	public ModelAndView logout(HttpSession session){
		session.invalidate();
		return new ModelAndView("login");
	}
}
