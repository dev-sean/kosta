package kr.or.kosta.and1010_homework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Homework_Res extends Activity{
	private TextView id,name,age,location,tel;
	private Button back_btn;
	private MemberVO mvo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homework_layout);
		id = (TextView) findViewById(R.id.hw_id_text);
		name = (TextView) findViewById(R.id.hw_name_text);
		age = (TextView) findViewById(R.id.hw_age_text);
		location = (TextView) findViewById(R.id.hw_location_text);
		tel = (TextView) findViewById(R.id.hw_tel_text);
		back_btn = (Button) findViewById(R.id.hw_back_btn);
		//Intent�� ���� �����´�.
		Intent intent = getIntent();
		//Intent�ȿ� �ִ� "mvo"��� Key���� �ִ� value ���� �����´�.
		//�̶� MemberVO�� ����ĳ������ �ϸ� MemberVO ��ü�� �ٷ� ����� �� �ִ�.
		mvo = (MemberVO) intent.getSerializableExtra("mvo");
		
		id.setText(mvo.getId());
		name.setText(mvo.getName());
		age.setText(mvo.getAge());
		location.setText(mvo.getLocation());
		tel.setText(mvo.getTel());
		
		
		back_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Back��ư
				Intent intent = new Intent(Homework_Res.this, Homework.class);
				startActivity(intent);
				
			}
		});		
	}
}
