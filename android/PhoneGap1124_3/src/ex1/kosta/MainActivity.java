package ex1.kosta;

import org.apache.cordova.DroidGap;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends DroidGap {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		//Hybrid로 구현될 페이지를 load해온다.
		super.onCreate(savedInstanceState);
		Log.d("ERROR1", "this error");
		super.loadUrl("file:///android_asset/www/index.html");
		Log.d("ERROR2", "this error");
	}
}
