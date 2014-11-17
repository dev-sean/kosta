package ex1;
//예외를 받아서 처리하는 어드바이스
public class After_ThrowAdvice {
	public void commThrow(Exception ew){
		System.out.println("예외 처리 메세지:"+ew.getMessage());
	}
}
