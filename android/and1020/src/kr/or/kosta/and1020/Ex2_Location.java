package kr.or.kosta.and1020;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

// ��ġ ������(Location Provider)
// ��ġ �Ŵ���(Location Manager)�� �����ؼ�
// ��ġ ���񽺸� ���� �� �ִ�.
// ACCESS_FINE_LOCATION : �ۿ��� GPS������ ����� ����� �� �ֵ��� ���ִ� ����
// READ_PHONE_STATE : ��ȭ���� ���¸� �� �� �ְ� ���ִ� ����
// ACCESS_COARSE_LOCATION : Call-ID/��������
public class Ex2_Location extends Activity {
	private TextView text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.ex2_gps);
		text = (TextView) findViewById(R.id.ex2_text);
		//GPS�� ����ؼ� ��ġ ������ �ޱ� ���ؼ� �� �ʿ��� ��ü
		//������� ���� ��ü ����
		LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		//�������� ������� �ʴ´�.
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
