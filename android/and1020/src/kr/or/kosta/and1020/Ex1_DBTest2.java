package kr.or.kosta.and1020;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class Ex1_DBTest2 extends Activity {
	private MyDbHelper mHelper;
	private Cursor cursor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dbtest2);
		mHelper = new MyDbHelper(this, "memo.db", null, 1);
		SQLiteDatabase db = mHelper.getWritableDatabase();
		cursor = db.rawQuery("select mid,  pwd from memo", null);
		String result = "";
		StringBuffer sql = new StringBuffer();
		while (cursor.moveToNext()) {
			sql.append("idv:" + cursor.getString(0)).append("\n");
			sql.append("pwdv:" + cursor.getString(1)).append("\n");
		}
		TextView res = (TextView) findViewById(R.id.text1);
		res.setText(sql.toString());
		cursor.close();
		mHelper.close();
	}
}
