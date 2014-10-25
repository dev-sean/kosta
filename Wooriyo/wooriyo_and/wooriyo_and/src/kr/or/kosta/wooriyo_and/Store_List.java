package kr.or.kosta.wooriyo_and;

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

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

//--------------------------해당카테고리의 상점들 
public class Store_List extends Activity {

	private TextView textv;

	private LinearLayout ll;
	private String userid;
	private String select_category;
	private String store_no;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.store);
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}

		textv = (TextView) findViewById(R.id.me_category);

		ll = (LinearLayout) findViewById(R.id.board);

		Intent intent = getIntent();
		Bundle myBundle = intent.getExtras();
		userid = myBundle.getString("id");
		select_category = myBundle.getString("category");
		Log.d("category", select_category);
		String url = "http://192.168.7.120:8084/wooriyo_jsp/store_list.jsp";

		ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();

		// 카테고리 화면에서 선택한 카테고리명을 woori에 저장
		params.add(new BasicNameValuePair("store_category", select_category));

		getHttpPost(url, params);

	}

	public void getHttpPost(String url, ArrayList<NameValuePair> params) {
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
						content, "euc-kr"));

				String m = "";
				while ((m = br.readLine()) != null) {
					jsonQuery.append(m).append("\r\n");
				}

				try {

					JSONArray data = new JSONArray(jsonQuery.toString());
					int size = data.length();
					for (int i = 0; i < size; i++) {
						
						JSONObject c = data.getJSONObject(i);
						store_no = c.getString("store_no");
						LinearLayout linear = new LinearLayout(Store_List.this);
						linear.setOrientation(LinearLayout.HORIZONTAL);
						ll.addView(linear);
						linear.setOnClickListener(new OnClickListener() {
							//상점 정보로 이동
							@Override
							public void onClick(View v) {
								Intent intent1 = new Intent(Store_List.this, Store_Info.class);
								Bundle myBundle1 = new Bundle();
								myBundle1.putString("id", userid);
								myBundle1.putString("store_no", store_no);
								intent1.putExtras(myBundle1);
								startActivity(intent1);
							}
						});
						// --------------------------------------------
						URL url2 = new URL(c.getString("store_image"));
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

						ImageView image = new ImageView(Store_List.this);
						image.setImageBitmap(resized);
						linear.addView(image);
						// -----------------------------

						LinearLayout linear2 = new LinearLayout(Store_List.this);
						linear2.setOrientation(LinearLayout.VERTICAL);
						linear.addView(linear2);

						// ------------------------

						StringBuffer sf = new StringBuffer();
						sf.append("               ")
								.append(c.getString("store_name"))
								.append("               ")
								.append(c.getString("store_time"))
								.append("\n\n");
						
						TextView text = new TextView(Store_List.this);
						text.setText(sf);
						linear2.addView(text);
						// ------------------------

					}

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				Log.d("Error", "접속실패");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
