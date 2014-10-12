package kr.or.kosta.and1010;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Ex6_Form extends Activity {
	private Button btn1;
	private EditText edit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ex6_form);
		btn1 = (Button) findViewById(R.id.ex6_btn);
		edit = (EditText) findViewById(R.id.ex6_edit);
		
		btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Ex6_Form.this, Ex7_Res.class);
				//edit로 부터 입력한 값을 Ex7_Res로 전달하기 위해서
				//Bundle 객체를 생성해서 사용한다.
				Bundle myBundle = new Bundle();
				myBundle.putString("va", edit.getText().toString());
				//intent에게 전달
				intent.putExtras(myBundle);
				startActivity(intent);
				
			}
		});
		
	}
}
