package ex1;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
//@Controller : ���� Ŭ������ Spring MVC�� ��Ʈ�ѷ��� ������ Ŭ������ ���� ����
// ���⼭ �����Ͻ� ������ �����Ѵ�.

@Controller
public class TodayController {
//	@Autowired
//	private SimpleDateFormat f;
//	@Autowired
//	private Date d;
	
	@RequestMapping(value = "/today.kosta", method = RequestMethod.GET)
	public ModelAndView today() {
		System.out.println("Log : �����Ͻ� ���� ����!");

		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("today"); 
		
		mav.addObject("msg", "test");
		return mav;
	}
}
