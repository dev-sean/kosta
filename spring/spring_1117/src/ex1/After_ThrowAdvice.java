package ex1;
//���ܸ� �޾Ƽ� ó���ϴ� �����̽�
public class After_ThrowAdvice {
	public void commThrow(Exception ew){
		System.out.println("���� ó�� �޼���:"+ew.getMessage());
	}
}
