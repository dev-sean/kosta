package controller;

import java.util.ArrayList;

import org.codehaus.jackson.map.annotate.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
public class TestJsonController {
	// jsonView를 주입받는다.
	@Autowired
	private View JsonView;

	@RequestMapping(value = "/testJson.kosta")
	public View testJson1(String command, String name, ModelMap map) {
		System.out.println("Command :" + command);
		System.out.println("name :" + name);
		ModelAndView mav = new ModelAndView();
		// 컨테이너에 JsonView로 등록한 이름이 되어야 한다.
		mav.setViewName("JsonView");
		// Dao에서 데이터를 구현
		ArrayList<String> list = new ArrayList<String>();
		list.add("치맥");
		list.add(command);
		list.add(name);
		list.add("불고기");
		list.add("송아지고기!");
		map.addAttribute("menu", list);
		System.out.println("리스트 나와라 오바");
		return JsonView;
	}
}