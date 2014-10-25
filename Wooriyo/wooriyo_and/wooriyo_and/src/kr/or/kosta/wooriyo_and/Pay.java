package kr.or.kosta.wooriyo_and;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Pay extends Activity {
	private LayoutInflater inflater;
	private TextView restext;
	private String result;
	private boolean cdnumber;
	private boolean monthnumber;
	private boolean yearnumber;
	private boolean passnumber;
	private boolean juminnumber;
	final static int DIALOG_1 = 0;


	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pay);
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
		inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
		restext = (TextView) findViewById(R.id.dialogtext);
	}

	
	@SuppressWarnings("deprecation")
	public void mOnClick(View v) {
		showDialog(DIALOG_1);
	}

	@Override
	@Deprecated
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DIALOG_1:
			final LinearLayout linear = (LinearLayout) inflater.inflate(
					R.layout.pay_dialog_layout, null);
			// linear에서 지정한 View를 가지고 Card 정보를 입력하는
			// Dialog를 띄운다.
			return new AlertDialog.Builder(Pay.this)
					.setTitle("Card Check")
					.setView(linear)
					.setPositiveButton("OK",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {

									EditText editCardNumber = (EditText) linear
											.findViewById(R.id.editcardnumber);
									EditText editValidMonth = (EditText) linear
											.findViewById(R.id.editvalidmonth);
									EditText editValidYear = (EditText) linear
											.findViewById(R.id.editvalidyear);
									EditText editPassword = (EditText) linear
											.findViewById(R.id.editpassword);
									EditText editJumin = (EditText) linear
											.findViewById(R.id.editjumin);

									String url = "http://192.168.7.120:8084/wooriyo_jsp/pay.jsp";
									ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
									params.add(new BasicNameValuePair(
											"editCardNumber", editCardNumber
													.getText().toString()
													.trim()));
									params.add(new BasicNameValuePair(
											"editValidMonth", editValidMonth
													.getText().toString()
													.trim()));
									params.add(new BasicNameValuePair(
											"editValidYear", editValidYear
													.getText().toString()
													.trim()));
									params.add(new BasicNameValuePair(
											"editPassword", editPassword
													.getText().toString()
													.trim()));
									params.add(new BasicNameValuePair(
											"editJumin", editJumin.getText()
													.toString().trim()));
									getHttpPost(url, params);
									Log.d("Here", "hereere");
								}
							}).setNegativeButton("Cancle", null).create();

		}
		return null;
	}

	public void getHttpPost(String url, ArrayList<NameValuePair> params) {
		HttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			HttpResponse response = client.execute(httpPost);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			Log.d("Here", "9877978");
			if (statusCode == 200) {
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();

				String c = "";
				BufferedReader br = new BufferedReader(new InputStreamReader(
						content));
				while ((c = br.readLine()) != null) {
					// 올바른 카드정보 입력인지 확인하기 위해서
					// 각각의 항목에 true, false값을 지정한다.
					Log.d("Here", "123123");
					if (c.equals("cardnumbertrue")) {
						cdnumber = true;
					}
					if (c.equals("cardnumberfalse")) {
						cdnumber = false;
					}
					if (c.equals("monthtrue")) {
						monthnumber = true;
					}
					if (c.equals("monthfalse")) {
						monthnumber = false;
					}
					if (c.equals("yeartrue")) {
						yearnumber = true;
					}
					if (c.equals("yearfalse")) {
						yearnumber = false;
					}
					if (c.equals("passtrue")) {
						passnumber = true;
					}
					if (c.equals("passfalse")) {
						passnumber = false;
					}
					if (c.equals("jumintrue")) {
						juminnumber = true;
					}
					if (c.equals("juminfalse")) {
						juminnumber = false;
					}
				}
				check();// 결제 정보 확인 메서드
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void check() {
		// 결제 정보가 한군데라도 실패했을 시
		Log.d("Here", "heree45435345");
		if (cdnumber == false || monthnumber == false || yearnumber == false
				|| passnumber == false || juminnumber == false) {
			new AlertDialog.Builder(Pay.this).setTitle("카드 확인")
					.setMessage("결제에 실패했습니다. 다시 입력해주세요.").setPositiveButton("OK", null)
					.create().show();
		}
		// 결제가 모두 성공했을 시
		if (cdnumber == true && monthnumber == true && yearnumber == true
				&& passnumber == true && juminnumber == true) {
			new AlertDialog.Builder(Pay.this).setTitle("카드 확인")
					.setMessage("결제에 성공했습니다.").setPositiveButton("OK", null)
					.create().show();
			Intent intent = new Intent(Pay.this, Timer.class);
			startActivity(intent);
		}
	}
}