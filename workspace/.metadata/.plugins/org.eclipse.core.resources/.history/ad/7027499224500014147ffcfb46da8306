package kr.or.kosta.and1010;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Ex2_Spinner extends Activity implements OnItemSelectedListener {
	String[] items={"star1","star2","star3"};
	ArrayAdapter<String> aa;
	TextView resultText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ex1_sp);
		resultText = (TextView) findViewById(R.id.resultText);
		Spinner spin = (Spinner) findViewById(R.id.ex1_select1);
		
		spin.setOnItemSelectedListener(this);

		aa = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, items);

		aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spin.setAdapter(aa);

	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		Toast.makeText(Ex2_Spinner.this, "Select:" + aa.getItem(position), 3000)
				.show();
		if(aa.getItem(position).equals("star1")){
			resultText.setText("¡Ú");
		}else if(aa.getItem(position).equals("star2")){
			resultText.setText("¡Ú¡Ú");
		}else if(aa.getItem(position).equals("star3")){
			resultText.setText("¡Ú¡Ú¡Ú");
		}

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

	}
}
