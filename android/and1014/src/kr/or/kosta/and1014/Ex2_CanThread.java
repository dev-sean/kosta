package kr.or.kosta.and1014;

import android.app.Activity;
import android.os.Bundle;

public class Ex2_CanThread extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(new Ex2_MyView(this));
	}
}
