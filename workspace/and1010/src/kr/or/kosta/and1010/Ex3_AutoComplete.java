package kr.or.kosta.and1010;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

public class Ex3_AutoComplete extends Activity {
	private static final String[] DATA = { "Java", "JavaBook", "Android", "AD",
			"AK", "BB", "BBBBBBBB", "CC", "CCCCCC" };
	private AutoCompleteTextView act;
	private Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.ex3_auto1);
		act = (AutoCompleteTextView) findViewById(R.id.ex3_autoComplete);
		btn = (Button) findViewById(R.id.ex4_btn1);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line, DATA);
		
		act.setAdapter(adapter);
	}
}
