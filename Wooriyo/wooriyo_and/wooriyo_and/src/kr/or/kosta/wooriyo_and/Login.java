package kr.or.kosta.wooriyo_and;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends Activity {
	private EditText idetext, pwetext;
	private Button loginBtn, membershipBtn;
	private boolean flag;
	private AlertDialog.Builder builder;
	private Intent intent;
	private final String url ="http://192.168.7.120:8084/wooriyo_jsp/login.jsp";
	private String result;
			
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
		idetext = (EditText) findViewById(R.id.login_id);
		pwetext = (EditText) findViewById(R.id.login_pw);
		loginBtn = (Button) findViewById(R.id.login_login);
		membershipBtn = (Button) findViewById(R.id.login_membershipBtn);
		
		membershipBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				intent = new Intent(Login.this, Register.class);

				startActivity(intent);
				
			}
		});
		
		builder = new AlertDialog.Builder(this);
		loginBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// http://192.168.7.120:8084/semi/login.jsp
				ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("id", idetext.getText()
						.toString().trim()));
				params.add(new BasicNameValuePair("password", pwetext.getText()
						.toString().trim()));
			    result=getHttpPost(url, params);
				builder.setTitle("로그인");
				builder.setMessage(getHttpPost(url, params));
				builder.setPositiveButton("OK",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								if(result.equals("성공")){
									Intent intent1 = new Intent(Login.this, Category.class);
									String bundleId=idetext.getText().toString().trim();
									Bundle mybundle = new Bundle();
									mybundle.putString("id", bundleId);
									intent1.putExtras(mybundle);
									startActivity(intent1);
								}else{
									
								}
								

							}
						});
				builder.show();
				

			}
		});
	}

	protected String getHttpPost(String url, ArrayList<NameValuePair> params) {
		HttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		StringBuffer str = new StringBuffer();
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			HttpResponse response = client.execute(httpPost);
			StatusLine statusline = response.getStatusLine();
			int statusCode = statusline.getStatusCode();
			if (statusCode == 200) {
				InputStream content = response.getEntity().getContent();
				BufferedReader br = new BufferedReader(new InputStreamReader(
						content));
				String c = "";
				while ((c = br.readLine()) != null) {
					if (c.equals("true")) {
						flag = true;
					} else {
						flag = false;
					}
				}
				if (flag) {
					str.append("성공");
				} else {
					str.append("실패");
				}

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
		return str.toString();

	}

}
