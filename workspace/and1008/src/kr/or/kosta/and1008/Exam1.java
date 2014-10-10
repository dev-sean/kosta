package kr.or.kosta.and1008;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

// onclick �ڵ鸵
public class Exam1 extends Activity implements OnClickListener {
	// Button, Text ��ü ����
	private Button btn1, btn2, btn3;
	private LinearLayout lay;
	private ImageView iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		/*
		 * �޼��� ���� ���� : �� �ޱ�!!
		 */
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exam1);
		// ��ư�� �ؽ�Ʈ�並 �ҷ�����
		btn1 =  (Button) findViewById(R.id.examBtn1);
		btn2 = (Button) findViewById(R.id.examBtn2);
		btn3 = (Button) findViewById(R.id.examBtn3);
		lay = (LinearLayout) findViewById(R.id.lo);
		iv = (ImageView) findViewById(R.id.imgv);

		btn1.setTextColor(Color.WHITE);
		btn1.setBackgroundColor(Color.RED);
		btn2.setTextColor(Color.WHITE);
		btn2.setBackgroundColor(Color.BLUE);
		btn3.setTextColor(Color.WHITE);
		btn3.setBackgroundColor(Color.GREEN);
		// ��ư�� �̺�Ʈ������ ������ ����ϱ�(ClickEvent)
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v == btn1) {
			lay.setBackgroundColor(Color.RED);
			// ��ϵ� �̹��� ��ü�� ����ؼ� �����ϰ� ���� �̹����� ����
			iv.setImageResource(R.drawable.sin);
		} else if (v == btn2) {
			lay.setBackgroundColor(Color.BLUE);
			iv.setImageResource(R.drawable.sin2);
		} else {
			lay.setBackgroundColor(Color.GREEN);
			iv.setImageResource(R.drawable.sin3);
		}
	}
}