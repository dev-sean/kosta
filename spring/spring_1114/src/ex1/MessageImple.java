package ex1;

public class MessageImple implements Message{
	private String message;
	
	public MessageImple() {
	
		message="��ſ� ���� �ð�!";
	}

	@Override
	public void print() {
		//���� ����
		System.out.println("[Message] "+message);
		//�Ŀ� ����
	}

	@Override
	public String message() {
		// TODO Auto-generated method stub
		return message;
	}

	@Override
	public void print2() {
		System.out.println("[Message2] "+message);
		
	}

}
