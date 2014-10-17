package kr.or.kosta.and1010_homework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Homework extends Activity {
	private EditText id,name,age,location,tel;
	private Button join_btn;
	private MemberVO mvo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homework);
		id = (EditText) findViewById(R.id.hw_id);
		name = (EditText) findViewById(R.id.hw_name);
		age = (EditText) findViewById(R.id.hw_age);
		location = (EditText) findViewById(R.id.hw_location);
		tel = (EditText) findViewById(R.id.hw_tel);
		join_btn = (Button) findViewById(R.id.hw_join_btn);
		
		join_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//사용자가 입력한 정보를 MemberVO에 저장한다.
				mvo = new MemberVO();
				mvo.setId(id.getText().toString());
				mvo.setName(name.getText().toString());
				mvo.setAge(age.getText().toString());
				mvo.setLocation(location.getText().toString());
				mvo.setTel(tel.getText().toString());
				//Intent 객체를 생성해서 MemberVO 객체를 Homework_Res 객체로 전달한다.
				Intent intent = new Intent(Homework.this, Homework_Res.class);
				intent.putExtra("mvo", mvo);
				startActivity(intent);
			}
		});
	}
}
