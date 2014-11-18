package ex2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
//@Controller : ���� Ŭ������ Spring MVC�� ��Ʈ�ѷ��� ������ Ŭ������ ���� ����
// ���⼭ �����Ͻ� ������ �����Ѵ�.
@Controller
public class HelloController {
	// HandlerMapping
	// @RequestMapping : ������ ��û�� url, method�� ���۹���� �����Ѵ�.
	@RequestMapping(value = "/hello.kosta", method = RequestMethod.GET)
	public ModelAndView hello() {
		System.out.println("Log : �����Ͻ� ���� ����!");

		// ModelAndView : ��Ʈ�ѷ����� ó������� ������ view, ���� ���Ѵ�.
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello"); // Controller -> ViewResolver�� ����
									// Ư����ġ/hello.jsp ���·� ������ ��!
		
		//ModelAndView�� ���ؼ� ���� ������.
		mav.addObject("msg", "hi ! My Name is ����");
		return mav;
	}
}
