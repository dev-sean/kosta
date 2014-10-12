package kr.or.kosta.and1010;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Ex7_Res extends Activity {
	private Button btn1;
	private TextView text1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ex7_res);
		
		btn1 = (Button) findViewById(R.id.ex7_btn);
		//Intent로부터 Bundle를 받아서 파라미터값(key)를 사용해서
		//값을 뽑아내자.
		Intent intent = getIntent();
		Bundle myBundle = intent.getExtras();
		String data = myBundle.getString("va");
		text1 = (TextView) findViewById(R.id.ex7_resv);
		text1.setText(data);
		
		btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
