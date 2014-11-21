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
	// jsonView�� ���Թ޴´�.
	@Autowired
	private View JsonView;

	@RequestMapping(value = "/testJson.kosta")
	public View testJson1(String command, String name, ModelMap map) {
		System.out.println("Command :" + command);
		System.out.println("name :" + name);
		ModelAndView mav = new ModelAndView();
		// �����̳ʿ� JsonView�� ����� �̸��� �Ǿ�� �Ѵ�.
		mav.setViewName("JsonView");
		// Dao���� �����͸� ����
		ArrayList<String> list = new ArrayList<String>();
		list.add("ġ��");
		list.add(command);
		list.add(name);
		list.add("�Ұ��");
		list.add("�۾������!");
		map.addAttribute("menu", list);
		System.out.println("����Ʈ ���Ͷ� ����");
		return JsonView;
	}
}