package ex1;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
//@Controller : 현재 클래스가 Spring MVC의 컨트롤러를 구현한 클래스란 것을 지정
// 여기서 비지니스 로직을 수행한다.

@Controller
public class TodayController {
//	@Autowired
//	private SimpleDateFormat f;
//	@Autowired
//	private Date d;
	
	@RequestMapping(value = "/today.kosta", method = RequestMethod.GET)
	public ModelAndView today() {
		System.out.println("Log : 비지니스 로직 수행!");

		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("today"); 
		
		mav.addObject("msg", "test");
		return mav;
	}
}
