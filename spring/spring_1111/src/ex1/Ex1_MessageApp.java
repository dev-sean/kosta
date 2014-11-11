package ex1;

public class Ex1_MessageApp {
	private String msg;

	public void setMsg(String msg) {
		this.msg = msg;
	}//setter는 Property이다.
	//스프링은 외부조립기, 외부 주입기, 객체들을 맞춰주는 역할을한다.
	//스프링 컨테이너는 싱글톤 레지스터리가 있다. - 모든 개체를 싱글톤 레지스터리에 등록한다.
	// 그러면 싱글톤으로 생성해준다.
	
	public String printMsg(){
		StringBuffer sb = new StringBuffer();
		sb.append("당신이 입력한 메시지는").append(msg).append(" 입니다.");
		return sb.toString();
	}
	
	//두 객체가 스프링에 의해서 의존관계가 성립될 수 있도록 재설계해서 DI에 의해서 인정받아야 한다.
}
