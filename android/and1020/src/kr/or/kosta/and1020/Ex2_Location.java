package kr.or.kosta.and1020;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

// 위치 제공자(Location Provider)
// 위치 매니저(Location Manager)를 생성해서
// 위치 서비스를 받을 수 있다.
// ACCESS_FINE_LOCATION : 앱에서 GPS센서의 기능을 사용할 수 있도록 해주는 설정
// READ_PHONE_STATE : 전화기의 상태를 알 수 있게 해주는 설정
// ACCESS_COARSE_LOCATION : Call-ID/와이파이
public class Ex2_Location extends Activity {
	private TextView text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.ex2_gps);
		text = (TextView) findViewById(R.id.ex2_text);
		//GPS를 사용해서 위치 정보를 받기 위해서 꼭 필요한 객체
		//상수값을 통해 객체 생성
		LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		//다형성은 사용하지 않는다.
		List<String> proviList = manager.getAllProviders();
		StringBuffer sb = new StringBuffer();
		int sizev = proviList.size();
		for(int i=0; i<sizev; i++){
			sb.append("Location Manger : ").append(proviList.get(i));
			sb.append(", Status : ").append(manager.isProviderEnabled(proviList.get(i)));
			sb.append("\n");
		}
		text.setText(sb.toString());
	}
}
