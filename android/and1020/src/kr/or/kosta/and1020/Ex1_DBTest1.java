package kr.or.kosta.and1020;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Ex1_DBTest1 extends Activity {
	private EditText txt, txt2;
	private Button btn1, btn2;
	private MyDbHelper mHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dbtest);
		txt = (EditText) findViewById(R.id.ex1_dbtest);
		txt2 = (EditText) findViewById(R.id.ex1_dbtest2);
		btn1 = (Button) findViewById(R.id.btn1);
		btn2 = (Button) findViewById(R.id.btn2);

		// DB 생성
		mHelper = new MyDbHelper(this, "memo.db", null, 1);

		btn1.setOnClickListener(new OnClickListener() {
			SQLiteDatabase db;
			ContentValues row;

			@Override
			public void onClick(View v) {

				db = mHelper.getWritableDatabase();
				String idv = txt.getText().toString();
				String pwdv = txt2.getText().toString();
				// insert 메서드 삽입
				// row = new ContentValues();
				// row.put("mid", idv);
				// row.put("pwd", pwdv);
				// db.insert("memo", null, row);
				// SQL 명령어로 삽입방법
				StringBuffer sql = new StringBuffer();
				sql.append("insert into memo values(null,'");
				sql.append(idv).append("','");
				sql.append(pwdv).append("');'");
				db.execSQL(sql.toString());

				mHelper.close();
			}
		});

		btn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Ex1_DBTest1.this, Ex1_DBTest2.class);
				startActivity(intent);

			}
		});
	}
}
