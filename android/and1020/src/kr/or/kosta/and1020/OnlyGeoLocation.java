package kr.or.kosta.and1020;

import android.app.Activity;
import android.app.Service;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class OnlyGeoLocation extends Activity{
	LocationManager manager;
	
	TextView txtTime, txtBearing, txtSpeed, txtAltitude, txtProvider;
	
	String locationProvider;
	String provider;
	String str_my_latitude, str_my_longitude;
	
	LocationListener sLocationListener = null;
	Location location;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.onlygeo);
		txtAltitude = (TextView) findViewById(R.id.altitude);
		txtSpeed = (TextView) findViewById(R.id.speed);
		txtBearing = (TextView) findViewById(R.id.bearing);
		txtTime = (TextView) findViewById(R.id.time);
		txtProvider = (TextView) findViewById(R.id.provider);
		//1. LocationManger 객체를 생성한다.
		if(manager == null){
			manager = (LocationManager) getSystemService(Service.LOCATION_SERVICE);
		}
		if(sLocationListener == null){
			sLocationListener = new MyLocationListener();
		}
		//크라이테리어를 생성해서
		Criteria criteria = new Criteria();
		//GPS로부터 정확한 정보를 구하기 위해서 정밀도를 높인다.
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
		criteria.setAltitudeRequired(true);
		criteria.setBearingRequired(true);
		criteria.setSpeedRequired(true);
		
		//3. 위의 설정을 프로바이더에게 넘겨준다.
		//2번째인자 true는 활성화 되었을 때만 정보를 얻어온다.
		provider = manager.getBestProvider(criteria, true);
		//provider, 주기, 거리, 감지자, 3초당 3미터 거리
		manager.requestLocationUpdates(provider, 3000, 3, sLocationListener);
		location = manager.getLastKnownLocation(provider);
	}
	class MyLocationListener implements LocationListener{

		@Override
		public void onLocationChanged(Location location) {
			double latitude = location.getLatitude();
			double longitude = location.getLongitude();
			
			str_my_latitude = Double.toString(location.getLatitude());
			str_my_longitude = Double.toString(location.getLongitude());
			
			Double Altitude = location.getAltitude();
			float Speed = location.getSpeed();
			float Bearing = location.getBearing();
			long Time = location.getTime();
			
			txtTime.setText(String.valueOf(Time));
			txtBearing.setText(String.valueOf(Speed));
			txtSpeed.setText(String.valueOf(Bearing));
			txtAltitude.setText(String.valueOf(Altitude));
			
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			//사용할 수 없게 된다면
			
		}

		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			//사용 가능하게 되면
			
		}

		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			//상태값이 바뀌게 되면
			
		}
		
	}
}
