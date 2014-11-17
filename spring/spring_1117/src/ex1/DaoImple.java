package ex1;

public class DaoImple implements Dao {

	@Override
	public void fifth() {
		String[] ar = { "¾Æ¾Æ¾Æ", "¾î¾î¾î", "À¸À¸À¸", "Ä«Ä«¯—", "ÇÏÇÏÇÏ" };
		for (int i = 0; i <= ar.length; i++) {
			System.out.println("ºñÁö´Ï½º ·ÎÁ÷! :" + ar[i]);
		}

	}

}
