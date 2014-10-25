package kr.or.kosta.wooriyo_and;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
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

import android.R.integer;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class Order extends Activity {
	private Button btn1, btn2, btn3;
	private CheckBox check1, check2, check3;
	private EditText edittext, edittext2;
	private TextView textv, textv2;
	private LinearLayout list;
	private ImageView imgv;
	String url = "http://192.168.7.120:8084/wooriyo_jsp/user.jsp";
	String url2 = "http://192.168.7.120:8084/wooriyo_jsp/order.jsp";
	String url3 = "http://192.168.7.120:8084/wooriyo_jsp/menu.jsp";
	ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
	ArrayList<NameValuePair> params2 = new ArrayList<NameValuePair>();
	ArrayList<NameValuePair> params3 = new ArrayList<NameValuePair>();

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.order);
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
		textv = (TextView) findViewById(R.id.adress1);
		textv2 = (TextView) findViewById(R.id.price);
		edittext = (EditText) findViewById(R.id.store);
		edittext2 = (EditText) findViewById(R.id.new_insert);
		check1 = (CheckBox) findViewById(R.id.checkBox1);
		check2 = (CheckBox) findViewById(R.id.checkBox2);
		check3 = (CheckBox) findViewById(R.id.checkBox3);
		btn1 = (Button) findViewById(R.id.btn_pay);
		btn2 = (Button) findViewById(R.id.btn_cancel);
		btn3 = (Button) findViewById(R.id.insert_btn);
		list = (LinearLayout) findViewById(R.id.recent);
		imgv = (ImageView) findViewById(R.id.imageView1);

		params.add(new BasicNameValuePair("user_no", "1"));
		params2.add(new BasicNameValuePair("id", "ko1"));
		params3.add(new BasicNameValuePair("menu_no", "1"));

//		getHttpPost3(url3, params3);

		btn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String url = "http://192.168.7.120:8084/wooriyo_jsp/address.jsp";
				ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
				String str = "";
				str = edittext2.getText().toString().trim();
				params.add(new BasicNameValuePair("new_address", str));
				getHttpPost4(url, params);
				Intent intent = new Intent(Order.this, Pay.class);
				startActivity(intent);

			}
		});
		btn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		btn3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				textv2.setText(getHttpPost3(url3, params3));
			}
		});

		check1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {

					String hunchul2 = getHttpPost(url, params);
					textv.setText(hunchul2);
				}
			}
		});
		check2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					StringBuffer hunchul = getHttpPost2(url2, params2);
					TextView txtv = new TextView(Order.this);
					txtv.setText(hunchul.toString());
					list.addView(txtv);
				}
			}
		});
	}

	private String getHttpPost(String url, ArrayList<NameValuePair> params) {
		// TODO Auto-generated method stub
		String str = "";

		HttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		StringBuffer jsonQuery = new StringBuffer();
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params, "euc-kr"));
			HttpResponse response = client.execute(httpPost);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();

			if (statusCode == 200) {
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();
				BufferedReader br = new BufferedReader(new InputStreamReader(
						content,"euc-kr"));

				String m = "";
				while ((m = br.readLine()) != null) {
					jsonQuery.append(m).append("\r\n");
				}

				try {
					JSONArray data = new JSONArray(jsonQuery.toString());
					for (int i = 0; i < data.length(); i++) {
						JSONObject c = data.getJSONObject(i);
						str = c.getString("address");
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				Log.d("Error", "立加角菩");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	private StringBuffer getHttpPost2(String url,
			ArrayList<NameValuePair> params) {
		// TODO Auto-generated method stub
		StringBuffer str = new StringBuffer();
		HttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		StringBuffer jsonQuery = new StringBuffer();
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params,"euc-kr"));
			HttpResponse response = client.execute(httpPost);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();

			if (statusCode == 200) {
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();
				BufferedReader br = new BufferedReader(new InputStreamReader(
						content,"euc-kr"));

				String m = "";
				while ((m = br.readLine()) != null) {
					jsonQuery.append(m).append("\r\n");
				}
				try {
					JSONArray data = new JSONArray(jsonQuery.toString());
					for (int i = 0; i < data.length(); i++) {
						JSONObject c = data.getJSONObject(i);
						str.append(c.getString("address")).append("\r\n");
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				Log.d("Error", "立加角菩");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	private String getHttpPost3(String url, ArrayList<NameValuePair> params) {
		// TODO Auto-generated method stub
		String str = "";
		String mm = "";
		HttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		StringBuffer jsonQuery = new StringBuffer();
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params,"euc-kr"));
			HttpResponse response = client.execute(httpPost);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();

			if (statusCode == 200) {
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();
				BufferedReader br = new BufferedReader(new InputStreamReader(
						content,"euc-kr"));

				String m = "";
				while ((m = br.readLine()) != null) {
					jsonQuery.append(m).append("\r\n");
				}

				try {
					JSONArray data = new JSONArray(jsonQuery.toString());
					for (int i = 0; i < data.length(); i++) {
						JSONObject c = data.getJSONObject(i);
						str = c.getString("menu_price");
						URL url1 = new URL(c.getString("menu_image"));
						HttpURLConnection conn = (HttpURLConnection) url1
								.openConnection();
						conn.setDoInput(true);
						conn.connect();
						Bitmap bitmap = BitmapFactory.decodeStream(conn
								.getInputStream());
						imgv.setImageBitmap(bitmap);
					}
					int price = Integer.parseInt(str);
					String str1 = edittext.getText().toString();
					int count = Integer.parseInt(str1);
					int in = price * count;
					mm = String.valueOf(in);

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				Log.d("Error", "立加角菩");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mm;
	}

	protected String getHttpPost4(String url, ArrayList<NameValuePair> params) {
		HttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		StringBuffer jsonQuery = new StringBuffer();
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			HttpResponse response = client.execute(httpPost);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			if (statusCode == 200) {
				InputStream content = response.getEntity().getContent();
				Scanner reader = new Scanner(content);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonQuery.toString();

	}
}
