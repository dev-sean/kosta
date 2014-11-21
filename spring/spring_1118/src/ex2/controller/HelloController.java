package ex2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
//@Controller : 현재 클래스가 Spring MVC의 컨트롤러를 구현한 클래스란 것을 지정
// 여기서 비지니스 로직을 수행한다.
@Controller
public class HelloController {
	// HandlerMapping
	// @RequestMapping : 값으로 요청의 url, method로 전송방식을 설정한다.
	@RequestMapping(value = "/hello.kosta", method = RequestMethod.GET)
	public ModelAndView hello() {
		System.out.println("Log : 비지니스 로직 수행!");

		// ModelAndView : 컨트롤러에게 처리결과를 보여줄 view, 값을 뜻한다.
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello"); // Controller -> ViewResolver에 의해
									// 특정위치/hello.jsp 형태로 제작이 됨!
		
		//ModelAndView를 통해서 값을 설정함.
		mav.addObject("msg", "hi ! My Name is 세현");
		return mav;
	}
}
