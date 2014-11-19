package ex2.controller;

import java.text.SimpleDateFormat;
import java.util.Date;





import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
public class BeforeAdvice {
	@Autowired
	private SimpleDateFormat f;
	@Autowired
	private Date d;

	@Before("execution(* ex1.Today*.today(..))")
	public void before() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		
		request.setAttribute("date", f.format(d));

	}
}
