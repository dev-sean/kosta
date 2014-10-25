package kr.or.kosta.wooriyo_and;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
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

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

@SuppressLint("NewApi")
public class Category extends Activity {
	private GridView gv;
	private Button btn;
	private EditText search;
	private int[] arrImg = { R.drawable.chicken, R.drawable.china_categ,
			R.drawable.pizza_category, R.drawable.hansik_category,
			R.drawable.jjim, R.drawable.japan, R.drawable.bunsik,
			R.drawable.jokbal };
	private String userid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_category);
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
		search = (EditText) findViewById(R.id.store);
		btn = (Button) findViewById(R.id.search_btn1);
		gv = (GridView) findViewById(R.id.m_grid);
		gv.setAdapter(new ImageAdapter(this));

		Intent intent = getIntent();
		Bundle myBundle = intent.getExtras();
		userid = myBundle.getString("id");

		btn.setOnClickListener(new OnClickListener() {
			// 사용자가 상점명을 검색했을 때
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// String url =
				// "http://192.168.7.120:8084/wooriyo_jsp/menu.jsp";
				// ArrayList<NameValuePair> params = new
				// ArrayList<NameValuePair>();
				String str = search.getText().toString().trim();
				Log.d("asdf", str);

				// params.add(new BasicNameValuePair("store_name", str));
				// getHttpPost(url, params);
				Intent intent1 = new Intent(Category.this, Search_Store.class);
				Bundle myBundle1 = new Bundle();
				myBundle1.putString("id", userid);
				myBundle1.putString("search_store", str);
				intent1.putExtras(myBundle1);
				startActivity(intent1);

			}
		});

		gv.setOnItemClickListener(new OnItemClickListener() {
			// 카테고리를 선택했을 때
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String select_category = null;
				switch (position) {
				case 0:
					select_category = "치킨";
					break;
				case 1:
					select_category = "중식";
					break;
				case 2:
					select_category = "피자";
					break;
				case 3:
					select_category = "한식";
					break;
				case 4:
					select_category = "찜,탕";
					break;
				case 5:
					select_category = "일식";
					break;
				case 6:
					select_category = "분식";
					break;
				case 7:
					select_category = "족발,보쌈";
					break;
				default:
					break;

				}

				Intent intent2 = new Intent(Category.this, Store_List.class);
				Bundle myBundle2 = new Bundle();
				myBundle2.putString("id", userid);
				myBundle2.putString("category", select_category);
				intent2.putExtras(myBundle2);
				startActivity(intent2);
			}
		});
	}

	public class ImageAdapter extends BaseAdapter {
		private Context context;

		public ImageAdapter(Context context) {
			// TODO Auto-generated constructor stub
			this.context = context;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return arrImg.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ImageView imageView;
			if (convertView == null) {
				imageView = new ImageView(context);

				imageView.setLayoutParams(new GridView.LayoutParams(310, 310));

				imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

				imageView.setPadding(2, 2, 2, 2);
			} else {
				imageView = (ImageView) convertView;
			}
			imageView.setImageResource(arrImg[position]);

			return imageView;
		}

	}

	protected String getHttpPost(String url, ArrayList<NameValuePair> params) {
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
