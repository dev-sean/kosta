package ex4;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class LifeCycleTest2 {
	private String msg;
	
	public LifeCycleTest2() {
		System.out.println("생성자 호출");
	}
	
	public void setMsg(String msg){
		this.msg=msg;//이거 해야 디스트로이 나오는 이유가 뭐얌 ?  카톡바람
		System.out.println("DI 호출: msg : "+msg);
	}
	@PostConstruct //초기화를 담당해줌
	public void init(){
		System.out.println("init호출");
	}
	public String getMsg() {
		return msg;
	}

	@PreDestroy //디스트로이
	public void destroy(){
		System.out.println("destroy호출");
	}

}
