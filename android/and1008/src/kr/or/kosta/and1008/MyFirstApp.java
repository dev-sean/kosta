package kr.or.kosta.and1008;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

//1. �ȵ���̵� ȭ���� ���� ��ü�� ��ӹ޴´�.
//   JFrameó��!!
public class MyFirstApp extends Activity{
	//2. Android�� JVM�� ���θ޼���ó�� ȣ��!
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// 3. ���� �ϸ� �ȵ�!(main�� ������ �Ѵ�.)
		super.onCreate(savedInstanceState);
		// 4. ����� ���̾ƿ� �ҷ�����
		setContentView(R.layout.activity_main);
		// 5. �������� �˾Ƽ� ���...
		//id�� ex1_msg�� TextView�� ���α׷��� ������ �� 
		TextView text1 = (TextView) findViewById(R.id.ex1_msg);
		text1.setTextColor(Color.RED);
		text1.setText("������������");
		
	}
}
