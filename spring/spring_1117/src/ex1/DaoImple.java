package ex1;

public class DaoImple implements Dao {

	@Override
	public void fifth() {
		String[] ar = { "아아아", "어어어", "으으으", "카카캌", "하하하" };
		for (int i = 0; i <= ar.length; i++) {
			System.out.println("비지니스 로직! :" + ar[i]);
		}

	}

}
