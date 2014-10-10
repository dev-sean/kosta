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
		text1.setText("������������");
		TextView text2 = (TextView) findViewById(R.id.today_msg);
		
		text2.setTextColor(Color.RED);
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		text2.setText(f.format(new Date()));
		
		
		
	}
}