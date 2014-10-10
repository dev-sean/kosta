package kr.or.kosta.and1010;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Ex1_Spinner extends Activity {
	private Spinner sp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ex1_sp);
		sp = (Spinner) findViewById(R.id.ex1_select1);
		// UI���� �������ִ� �����͸� �ٽ� �о�ͼ� ArrayAdapter�� ��ü�� ����
		final ArrayAdapter<CharSequence> adspin = ArrayAdapter
				.createFromResource(this, R.array.list1,
						android.R.layout.simple_spinner_item);
		//dropdownUI ����
		adspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//�ƴ�Ÿ �����ϱ�
		sp.setAdapter(adspin);
		// spinner�� �������� �� selectedlistener
		sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(Ex1_Spinner.this,
						"Select:" + adspin.getItem(position), 3000).show();

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});
	}

}