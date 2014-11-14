package ex1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AutoWiredService {
	//어노테이션 : 실행 가능한 주석, 스프링 3.0에서부터 지원
	//빈의 설정을 간소화 할 수 있다.
	//자동으로 빈을 묶어 주는 어노테이션이다.
	//이름으로 먼저 찾고 없을 때는 타입으로 찾아준다.
	//타입일 때는 모든 빈을 검색하기 때문에 속도가 느려질 수 있다.
	//단) 이름이든 타입이든 유일해야 되고 타입일 경우 Qualifier어노테이션으로 지정해야 한다.
	@Autowired //스프링 전용, AOP개념이다
	//@Autowired(required=false) null값을 넣기 위해서 사용
	@Qualifier("hold")
	private String name;
	//setter를 사용하지 않고 자동으로 name을 찾아서 값을 넣어준다.
	public String printName(){
		StringBuffer s = new StringBuffer();
		return s.append("당신의 이름은").append(name).append("입니다.").toString();
	}
}
