package kr.or.kosta.wooriyo_and;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Logo extends Activity {
	private ProgressDialog progressBar;// ���α׷����� ��ü ����
	private int progressBarStatus; // ���α׷������� ���°� �ʱ�ȭ
	private Handler progressBarHandler;
	private ImageView iv;
	private View ly;
	
	private Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.logo_layout);
		iv = (ImageView) findViewById(R.id.logo_image);
		ly = findViewById(R.id.logolayout);
		ly.setBackgroundColor(Color.WHITE);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		progressBar();
		intent = new Intent(Logo.this, Login.class);
		
	}

	public void progressBar() {
		progressBarHandler = new Handler();

		// ���α׷����ٸ� ����
		progressBar = new ProgressDialog(this);
		progressBar.setCancelable(true);
		progressBar.setMessage("Loading");
		progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		progressBar.setProgress(0); // �ʱⰪ
		progressBar.setMax(100); // ���ᰪ
		progressBar.show();
		progressBarStatus = 0;
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (progressBarStatus < 100) {
					progressBarStatus = doSomeTask();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					progressBarHandler.post(new Runnable() {

						@Override
						public void run() {
							progressBar.setProgress(progressBarStatus);

						}
					});
				}
				startActivity(intent);
			}
		}).start();
	}

	public int doSomeTask() {
		// ���α׷������� ���°� ����
		progressBarStatus++;
		// ���α׷��� ���� MAX���� ���� ����,
		if (progressBarStatus < 100) {
			return progressBarStatus;
		}
		try {
			Thread.sleep(1000);
			progressBar.dismiss();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 100;
	}
}
