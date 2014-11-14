package exam;

import org.springframework.beans.factory.annotation.Autowired;

public class BeforeAdvice{
	@Autowired
	private LoginTest ref;
	
	public void checkLogin(){
		if(!ref.isRes()){
			System.out.println("비밀번호 오류");
			System.exit(0);
		}else{
			System.out.println("인증완료");
		}
	}
}
