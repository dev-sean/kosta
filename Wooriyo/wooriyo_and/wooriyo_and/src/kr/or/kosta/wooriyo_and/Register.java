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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


 public class Register extends Activity {
	private EditText idtext, pwtext, adtext;
	private Button dBtn, mBtn;
	private Intent intent;
	private AlertDialog.Builder builder;
	private boolean flag;
	
	@SuppressLint("NewApi") 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
		idtext = (EditText) findViewById(R.id.register_id);
		pwtext = (EditText) findViewById(R.id.register_pw);
		adtext = (EditText) findViewById(R.id.register_ad);
		dBtn = (Button) findViewById(R.id.register_dBtn);		
		mBtn = (Button) findViewById(R.id.register_login);
		
		builder = new AlertDialog.Builder(this);
		dBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {				
				String url = "http://192.168.7.120:8084/wooriyo_jsp/idcheck.jsp";
				ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("id", idtext.getText()
						.toString().trim()));
				builder.setTitle("중복체크");
				builder.setMessage(getHttpPost(url, params));
				builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Log.d("Example", "ok");
						
					}
				});
				builder.show();
				getHttpPost(url, params);

			}

			protected String getHttpPost(String url,
					ArrayList<NameValuePair> params) {
				HttpClient client = new DefaultHttpClient();
				HttpPost httpPost = new HttpPost(url);
				StringBuffer idsb = new StringBuffer();
				try {
					httpPost.setEntity(new UrlEncodedFormEntity(params));
					HttpResponse response = client.execute(httpPost);
					StatusLine statusLine = response.getStatusLine();
					int statusCode = statusLine.getStatusCode();
					if(statusCode == 200){
						InputStream content = response.getEntity().getContent();
						BufferedReader br = new BufferedReader(new InputStreamReader(content));
						String c ="";
						while((c=br.readLine())!= null){
							if(c.equals("true")){
								flag=true;
							}else{
								flag=false;
							}
						}
						if(flag){
							idsb.append("사용할 수 있습니다.");
						}else{
							idsb.append("사용할 수 없는 아이디입니다.");
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
				return idsb.toString();

			}
		});
		mBtn.setOnClickListener(new OnClickListener() {
			String url = "http://192.168.7.120:8084/wooriyo_jsp/register.jsp";
			ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
			@Override
			public void onClick(View v) {
				intent = new Intent(Register.this, Login.class);
				params.add(new BasicNameValuePair("id", idtext.getText().toString().trim())) ;
				params.add(new BasicNameValuePair("pw", pwtext.getText().toString().trim())) ;
				params.add(new BasicNameValuePair("email", adtext.getText().toString().trim())) ;
				builder.setTitle("축하합니다.");
				builder.setMessage("회원가입 성공!");
				builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						getHttpPost(url, params);
						startActivity(intent);
					}
				});
				builder.show();
				
				
				

				
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
					if(statusCode == 200){
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
		});
	}

}
