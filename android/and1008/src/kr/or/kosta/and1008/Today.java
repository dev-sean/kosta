package kr.or.kosta.and1008;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class Today extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView text1 = (TextView) findViewById(R.id.ex1_msg);
		text1.setTextColor(Color.RED);
		text1.setText("♥♡♥♡♥♡");
		TextView text2 = (TextView) findViewById(R.id.today_msg);
		
		text2.setTextColor(Color.RED);
		//현재 날짜 시간은 원하는 포맷으로 설정한다.
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		//현재 시간(new Date)를 받아와서 원하는 포맷으로 화면에 출력한다.
		text2.setText(f.format(new Date()));
	}
}