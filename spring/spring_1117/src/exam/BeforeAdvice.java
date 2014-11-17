package exam;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
@Aspect
public class BeforeAdvice{
	@Autowired
	private LoginTest ref;
	
	@Before("execution(* security*(..))")
	public void checkLogin(){
		if(!ref.isRes()){
			System.out.println("비밀번호 오류");
			System.exit(0);
			
		}else{
			System.out.println("인증완료");
		}
	}
}
