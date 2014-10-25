package kr.or.android1021;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

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

import com.example.test.R;

import android.R.integer;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.TabActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;

public class CopyOfCopyOfCopyOfCopyOfHw_Json extends TabActivity {

	private TextView storeinf1, storeinf2, storeinf3, tu, untv;
	private TabHost tabHost;
	private ImageView imgv, imgheabogi;
	private LinearLayout board, ly;
	//----------------지도


// 추가	
	private ListView lv;


	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.copystore);

		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}

		// ------------------------------탭
		tabHost = (TabHost) findViewById(R.id.tabMode);
		tabHost = getTabHost();

		TabSpec spec1 = tabHost.newTabSpec("tag 1").setIndicator("정보");
		spec1.setContent(R.id.tab1);
		// 탭추가
		tabHost.addTab(spec1);

		TabSpec spec2 = tabHost.newTabSpec("tag 2").setIndicator("리뷰");
		spec2.setContent(R.id.tab2);
		tabHost.addTab(spec2);

		TabSpec spec3 = tabHost.newTabSpec("tag 2").setIndicator("지도");
		spec3.setContent(R.id.tab3);
		tabHost.addTab(spec3);

		tabHost.setCurrentTab(0);

		tabHost.setOnTabChangedListener(new OnTabChangeListener() {

			@Override
			public void onTabChanged(String tabId) {

				for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {

					// 탭안된부분의 배경색
					tabHost.getTabWidget().getChildAt(i)
							.setBackgroundColor(Color.parseColor("#d0d0d0"));// unselected
					// 탭안된부분의 글씨색상과 사이즈
					untv = (TextView) tabHost.getTabWidget().getChildAt(i)
							.findViewById(android.R.id.title);
					untv.setTextColor(Color.parseColor("#000000"));
					untv.setTextSize(10);
				}
				// 탭된부분의 배경색
				tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab())
						.setBackgroundColor(Color.parseColor("#ee0000")); // selected
				// 탭된부분의 글씨색상과 사이즈
				tu = (TextView) tabHost.getTabWidget()
						.getChildAt(tabHost.getCurrentTab())
						.findViewById(android.R.id.title);
				tu.setTextColor(Color.parseColor("#ffffff"));
				tu.setTextSize(15);

			}
		});

		// -----------------------------------------탭끝
/*****************************************************************************
 * 
 * 						component 초기화
 * 
 ****************************************************************************/
		storeinf1 = (TextView) findViewById(R.id.storeinfo1);
		storeinf2 = (TextView) findViewById(R.id.storeinfo2);
		storeinf3 = (TextView) findViewById(R.id.storeinfo3);
		imgv = (ImageView) findViewById(R.id.imageView1);
		
		lv = (ListView) findViewById(R.id.listView1);
		ly = (LinearLayout) findViewById(R.id.testview);
		board = (LinearLayout) findViewById(R.id.tab2);
		imgheabogi = (ImageView) findViewById(R.id.ImageView03);

		String url = "http://192.168.7.245:8084/server1016/store_json.jsp";
		String url2 = "http://192.168.7.245:8084/server1016/menu_json.jsp";

		String url3 = "http://192.168.7.245:8084/server1016/board_json.jsp";

		String url4 = "http://192.168.7.245:8084/server1016/imgheabogi.jsp";

		// 스토어json : http://192.168.7.245:8084/server1016/store_json.jsp
		// 메뉴json : http://192.168.7.245:8084/server1016/menu_json.jsp
		// 리뷰json: http://192.168.7.245:8084/server1016/menu_json_1.jsp
		// 이미지: http://localhost:8084/server1016/imgheabogi.jsp

		// parameter를 전송하기 위한 담당객체(NameValuePair)를 생성후 대입하자.

		ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("store_no", "34"));
		getHttpPost(url, params);

		ArrayList<NameValuePair> params2 = new ArrayList<NameValuePair>();
		params2.add(new BasicNameValuePair("store_no", "1"));
		getHttpPost2(url2, params2);

		ArrayList<NameValuePair> params3 = new ArrayList<NameValuePair>();
		params3.add(new BasicNameValuePair("store_no", "1"));
		getHttpPost3(url3, params3);

		ArrayList<NameValuePair> params4 = new ArrayList<NameValuePair>();
		params4.add(new BasicNameValuePair("id", "2"));
		getHttpPost4(url4, params4);

	}

	public void getHttpPost(String url, ArrayList<NameValuePair> params) {
		HttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		StringBuffer jsonQuery = new StringBuffer();
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			HttpResponse response = client.execute(httpPost);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();

			if (statusCode == 200) {
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();
				BufferedReader br = new BufferedReader(new InputStreamReader(
						content));

				String m = "";
				while ((m = br.readLine()) != null) {
					jsonQuery.append(m).append("\r\n");
				}

				try {

					JSONArray data = new JSONArray(jsonQuery.toString());

					StringBuffer sb = new StringBuffer();
					StringBuffer sbb = new StringBuffer();
					for (int i = 0; i < data.length(); i++) {
						JSONObject c = data.getJSONObject(i);
						// ----------------------사진과함께 나오는 1번째
						sb.append(c.getString("store_name") + "\n");

						sb.append(c.getString("store_time") + "\n");
						// ------------------별점
						if (0 <= (Float.parseFloat(c
								.getString("store_avgpoint")))
								&& (Float.parseFloat(c
										.getString("store_avgpoint"))) <= 1) {
							sb.append("★☆☆☆☆");
							sb.append(Float.parseFloat(c
									.getString("store_avgpoint")) + "\n");
						} else if (1 < (Float.parseFloat(c
								.getString("store_avgpoint")))
								&& (Float.parseFloat(c
										.getString("store_avgpoint"))) <= 2) {
							sb.append("★★☆☆☆");
							sb.append(Float.parseFloat(c
									.getString("store_avgpoint")) + "\n");
						} else if (2 < (Float.parseFloat(c
								.getString("store_avgpoint")))
								&& (Float.parseFloat(c
										.getString("store_avgpoint"))) <= 3) {
							sb.append("★★★☆☆");
							sb.append(Float.parseFloat(c
									.getString("store_avgpoint")) + "\n");
						} else if (3 < (Float.parseFloat(c
								.getString("store_avgpoint")))
								&& (Float.parseFloat(c
										.getString("store_avgpoint"))) <= 4) {
							sb.append("★★★★☆");
							sb.append(Float.parseFloat(c
									.getString("store_avgpoint")) + "\n");
						} else if ((Float.parseFloat(c
								.getString("store_avgpoint"))) <= 5) {
							sb.append("★★★★★");
							sb.append(Float.parseFloat(c
									.getString("store_avgpoint")) + "\n");
						}
						// ------------------배달시간 환산
						float deltime = (Float.parseFloat(c
								.getString("store_avg_delivery_time"))) / 60;
						double per = Double.parseDouble(String.format("%.0f",
								deltime));
						sb.append(per + "분");

						storeinf1.setText(sb);
						imgv.setImageResource(R.drawable.ddd);
						// ------------------------------2번째
						// ---------------------------
						sbb.append(c.getString("store_address") + "\n");
						sbb.append(c.getString("store_delivery_location")
								+ "\n");
						sbb.append(c.getString("store_tel"));
						storeinf2.setText(sbb);
						// -------------------------------지도의 상점정보
						storeinf3.setText(c.getString("store_name") + "\n"
								+ c.getString("store_address"));

					}

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				Log.d("Error", "접속실패!");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getHttpPost2(String url, ArrayList<NameValuePair> params) {
		Log.d("ss",
				"메뉴시작`````````````````````````````````````````````````````!");
		HttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		StringBuffer jsonQuery = new StringBuffer();
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			HttpResponse response = client.execute(httpPost);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			Log.d("ss", "66666666666666666666666666666666666666");
			if (statusCode == 200) {
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();
				BufferedReader br = new BufferedReader(new InputStreamReader(
						content));

				String m = "";
				while ((m = br.readLine()) != null) {
					jsonQuery.append(m).append("\r\n");
				}

				try {

					JSONArray data = new JSONArray(jsonQuery.toString());

					for (int i = 0; i < data.length(); i++) {
						JSONObject c = data.getJSONObject(i);
					
						
						
						LinearLayout linear = new LinearLayout(
								CopyOfCopyOfCopyOfCopyOfHw_Json.this);
						linear.setOrientation(LinearLayout.HORIZONTAL);
						ly.addView(linear);
						//-----------------------사진작업
						
						URL url2 = new URL(c.getString("menu_image"));
						HttpURLConnection conn = (HttpURLConnection) url2
								.openConnection();
						conn.setDoInput(true);
						conn.connect();
						Bitmap bitmap = BitmapFactory.decodeStream(conn
								.getInputStream());

						int height = bitmap.getHeight();
						int width = bitmap.getWidth();
						Bitmap resized = null;
						while (height > 170) {
							resized = Bitmap.createScaledBitmap(bitmap,
									(width * 170) / height, 170, true);
							height = resized.getHeight();
							width = resized.getWidth();
						}
						while (width > 170) {
							resized = Bitmap.createScaledBitmap(bitmap,
									(height * 170) / width, 170, true);
							height = resized.getHeight();
							width = resized.getWidth();
						}

						ImageView image = new ImageView(
								CopyOfCopyOfCopyOfCopyOfHw_Json.this);
						image.setImageBitmap(resized);
						linear.addView(image);
						//------------------
						StringBuffer sf = new StringBuffer();
						sf.append(c.getString("menu_name"))
								.append(c.getString("menu_price"));
						TextView text = new TextView(
								CopyOfCopyOfCopyOfCopyOfHw_Json.this);
						text.setText(sf);
						linear.addView(text);


					}

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				Log.d("Error", "접속실패!");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// ------------------------------------------리뷰
	public void getHttpPost3(String url, ArrayList<NameValuePair> params) {
		HttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		StringBuffer jsonQuery = new StringBuffer();
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			HttpResponse response = client.execute(httpPost);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();

			if (statusCode == 200) {
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();
				BufferedReader br = new BufferedReader(new InputStreamReader(
						content));

				String m = "";
				while ((m = br.readLine()) != null) {
					jsonQuery.append(m).append("\r\n");
				}

				try {

					JSONArray data = new JSONArray(jsonQuery.toString());

					for (int i = 0; i < data.length(); i++) {
						JSONObject c = data.getJSONObject(i);

						LinearLayout linear = new LinearLayout(
								CopyOfCopyOfCopyOfCopyOfHw_Json.this);
						linear.setOrientation(LinearLayout.HORIZONTAL);
						board.addView(linear);

						URL url2 = new URL(c.getString("image"));
						HttpURLConnection conn = (HttpURLConnection) url2
								.openConnection();
						conn.setDoInput(true);
						conn.connect();
						Bitmap bitmap = BitmapFactory.decodeStream(conn
								.getInputStream());

						int height = bitmap.getHeight();
						int width = bitmap.getWidth();
						Bitmap resized = null;
						while (height > 170) {
							resized = Bitmap.createScaledBitmap(bitmap,
									(width * 170) / height, 170, true);
							height = resized.getHeight();
							width = resized.getWidth();
						}
						while (width > 170) {
							resized = Bitmap.createScaledBitmap(bitmap,
									(height * 170) / width, 170, true);
							height = resized.getHeight();
							width = resized.getWidth();
						}

						ImageView image = new ImageView(
								CopyOfCopyOfCopyOfCopyOfHw_Json.this);
						image.setImageBitmap(resized);
						linear.addView(image);

						StringBuffer sf = new StringBuffer();
						sf.append(c.getString("id"))
								.append(c.getString("content"))
								.append("\n\n\n\n\n");

						TextView text = new TextView(
								CopyOfCopyOfCopyOfCopyOfHw_Json.this);
						text.setText(sf);
						linear.addView(text);

					}

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				Log.d("Error", "접속실패!");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ---------------------------------지도이미지--------------------------------
	public void getHttpPost4(String url, ArrayList<NameValuePair> params) {
		HttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		StringBuffer jsonQuery = new StringBuffer();
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			HttpResponse response = client.execute(httpPost);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();

			if (statusCode == 200) {
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();
				BufferedReader br = new BufferedReader(new InputStreamReader(
						content));

				String m = "";
				while ((m = br.readLine()) != null) {
					jsonQuery.append(m).append("\r\n");
				}

				try {

					JSONArray data = new JSONArray(jsonQuery.toString());

					for (int i = 0; i < data.length(); i++) {
						JSONObject c = data.getJSONObject(i);

						URL url2 = new URL(c.getString("url"));
						HttpURLConnection conn = (HttpURLConnection) url2
								.openConnection();
						conn.setDoInput(true);
						conn.connect();
						Bitmap bitmap = BitmapFactory.decodeStream(conn
								.getInputStream());
						imgheabogi.setImageBitmap(bitmap);

						// anjoo.addView(child)

					}

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				Log.d("Error", "접속실패!");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
