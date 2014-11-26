package kosta.controller;

import java.security.Principal;
import java.util.Map;

import javax.annotation.Resource;

import kosta.service.MemberService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SercurityController {
	@Resource(name = "memberService")
	private MemberService service;

	@RequestMapping("/login.kosta")
	public void login(@RequestParam Map<String, Object> paramMap, ModelMap model)
			throws Throwable {
	}

	@RequestMapping("/loginFail.kosta")
	public void loginFail(@RequestParam Map<String, Object> paramMap,
			ModelMap model) throws Throwable {
	}

	@RequestMapping("/main.kosta")
	public void main(@RequestParam Map<String, Object> paramMap,
			ModelMap model, Principal principal) throws Throwable {
		String name = principal.getName();
		System.out.println("Name : " + name);
		model.addAttribute("username", name);
	}

	@RequestMapping("/logout.kosta")
	public void logout(@RequestParam Map<String, Object> paramMap,
			ModelMap model) throws Throwable {

	}

	public void setService(MemberService service) {
		this.service = service;
	}

}
