package kr.or.kosta.wooriyo_and;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Timer extends Activity {
	private TextView text1, text2;
	private Button btn1;
	private AlertDialog.Builder dia;

	private int secs, mins, hrs;
	private String hours, minutes, seconds;
	private Handler handler;
	private Thread timerT;
	private int i;
	private Boolean isRun;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.timer);
		
		text1 = (TextView) findViewById(R.id.text_timer);
		text2 = (TextView) findViewById(R.id.text_timerend);
		btn1 = (Button) findViewById(R.id.btn_timer_end);
		dia = new AlertDialog.Builder(this);
		isRun = true;
		handler = new Handler();

		btn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				isRun = false;
				handler.removeCallbacks(timerT);
				String str = "";
				if (hours != "00") {
					str = "배달시간은 " + hours + "시간 " + minutes + "분 입니다.";
				} else {

					str = "배달시간은 " + minutes + "분 입니다.";
				}
				text2.setText(str);
				dia.setTitle("주문완료");
				dia.setMessage("주문이 완료되었습니다.");
				dia.show();
				new AlertDialog.Builder(Timer.this).setTitle("주문완료")
				.setMessage("이용해 주셔서 감사합니다.").setPositiveButton("OK", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog,
							int which) {
						finish();
					}
				})
				.create().show();
				
			}
		});
		
		timerT = new Thread(new Runnable() {

			@Override
			public void run() {
				i = 0;
				while (isRun) {
					i += 1;
					secs = i;
					mins = i / 60;
					hrs = (i / 60) / 60;

					secs = secs % 60;
					seconds = String.valueOf(secs);
					if (secs == 0) {
						seconds = "00";
					} else if (secs < 10 && secs > 0) {
						seconds = "0" + seconds;
					}
					mins = mins % 60;
					minutes = String.valueOf(mins);
					if (mins == 0) {
						minutes = "00";
					} else if (mins < 10 && mins > 0) {
						minutes = "0" + minutes;
					}

					hours = String.valueOf(hrs);
					if (hrs == 0) {
						hours = "00";
					} else if (hrs < 10 && hrs > 0) {
						hours = "0" + hours;
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					handler.post(new Runnable() {

						@Override
						public void run() {
							text1.setText(hours + ":" + minutes + ":" + seconds);
						}
					});
				}
			}
		});

		timerT.setDaemon(true);
		timerT.start();
	}
}
