package ex1;

public class Ex2_ServiceImple implements Service{
	private int num;
	private String name,str;
	
	public Ex2_ServiceImple(String str) {
		this.str = str;
		System.out.println("String �� �����ڰ� ȣ���� �Ǿ����ϴ�.");
	}

	public Ex2_ServiceImple(int num) {
		this.num = num;
		System.out.println("int �� �����ڰ� ȣ���� �Ǿ����ϴ�.");
	}

	@Override
	public String print() {
		int res = num*10;
		System.out.println("Num :"+(num+10));
		return String.valueOf(res);
	}

	public Ex2_ServiceImple(int num, String str) {
	
		this.num = num;
		this.str = str;
	}

	@Override
	public String call() {
		StringBuffer s = new StringBuffer();
		s.append(str).append("��");
		System.out.println("Str :" + str);
		return s.toString();
		
	}

	@Override
	public String moniter() {
		StringBuffer s = new StringBuffer();
		s.append("Num :"+(num+10)).append("<br/>");
		s.append("Str :" + str);
		return s.toString();
	}

}
