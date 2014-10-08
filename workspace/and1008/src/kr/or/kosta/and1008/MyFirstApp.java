package kr.or.kosta.and1008;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

//1. 안드로이드 화면을 가진 객체를 상속받는다.
//   JFrame처럼!!
public class MyFirstApp extends Activity{
	//2. Android의 JVM이 메인메서드처럼 호출!
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// 3. 삭제 하면 안됨!(main의 역할을 한다.)
		super.onCreate(savedInstanceState);
		// 4. 사용할 레이아웃 불러오기
		setContentView(R.layout.activity_main);
		// 5. 이제부턴 알아서 사용...
		//id가 ex1_msg인 TextView에 프로그램이 시작이 될 
		TextView text1 = (TextView) findViewById(R.id.ex1_msg);
		text1.setTextColor(Color.RED);
		text1.setText("♥♡♥♡♥♡");
		
	}
}
