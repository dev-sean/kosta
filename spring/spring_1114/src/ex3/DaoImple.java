package ex3;

public class DaoImple implements Dao{
	
	@Override
	public void first() {
		for (int i = 0; i <=5; i++) {
			try {
				Thread.sleep(1000);
				System.out.println(i);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
			
		}
		System.out.println("연결끝");
	}

	@Override
	public String second() {
		StringBuffer sb = new StringBuffer();
		sb.append("------------").append("\n");
		sb.append("김길동").append("\n");
		sb.append("------------").append("\n");
		return sb.toString();
	}

}
