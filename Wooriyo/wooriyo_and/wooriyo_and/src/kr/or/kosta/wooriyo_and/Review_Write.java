package kr.or.kosta.wooriyo_and;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

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

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class Review_Write extends Activity {

	private RatingBar ratingBar;
	private Button btnSubmit, btnPicture;
	private EditText reviewText;
	private float point;

	private static final String TAG = "Review_Write";

	private static final int PICK_FROM_CAMERA = 0;
	private static final int PICK_FROM_ALBUM = 1;
	private static final int CROP_FROM_CAMERA = 2;

	private Uri mImageCaptureUri;
	private ImageView mPhotoImageView;
	private Button mButton;

	private AlertDialog mDialog;

	@SuppressLint("NewApi")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.review_write);
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
		ratingBar = (RatingBar) findViewById(R.id.review_ratingBar);
		btnSubmit = (Button) findViewById(R.id.btnSubmit);
		btnPicture = (Button) findViewById(R.id.btnPicture);
		reviewText = (EditText) findViewById(R.id.review_edittext);
		mPhotoImageView = (ImageView) findViewById(R.id.img_bitmap);

		// RatingBar 클릭 옵션
		addListenerOnRatingBar();
		// Submit 버튼 클릭 옵션
		addListenerOnButton();
		// Picture 버튼 클릭 옵션
		addListenerOnPicture();

	}

	public void addListenerOnPicture() {
		btnPicture.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 다이어로그를 생성해서 보여준다.
				mDialog = createDialog();
				mDialog.show();
			}
		});
	}

	/**
	 * 다이얼로그 생성
	 */
	private AlertDialog createDialog() {
		// image_crop_row.xml의 레이아웃을 가지고 innerView를 생성한다.
		final View innerView = getLayoutInflater().inflate(
				R.layout.select_picture, null);

		// 카메라 버튼, 갤러리버튼 생성
		Button camera = (Button) innerView.findViewById(R.id.btn_camera_crop);
		Button gellary = (Button) innerView.findViewById(R.id.btn_gellary_crop);

		// 카메라 버튼을 클릭하면
		camera.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// doTakePhotoAction을 실행하고 다이얼로그를 종료시킨다.
				doTakePhotoAction();
				setDismiss(mDialog);
			}
		});
		// 갤러리 버튼을 클릭하면
		gellary.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// doTakeAlbumAction을 실행하고 다이얼로그를 종료시킨다.
				doTakeAlbumAction();
				setDismiss(mDialog);
			}
		});

		// 다이얼로그 객체를 생성해서
		AlertDialog.Builder ab = new AlertDialog.Builder(this);
		// Title을 설정하고
		ab.setTitle("Image Crop");
		// 만드렁 놓은 innerView를 setView 메서드를 이용해서 설정한다.
		ab.setView(innerView);

		// 다이얼로그를 생성한후에 반환한다.
		return ab.create();
	}

	/**
	 * 다이얼로그 종료
	 */
	private void setDismiss(AlertDialog dialog) {
		if (dialog != null && dialog.isShowing()) {
			dialog.dismiss();
		}
	}

	/**
	 * 카메라에서 이미지 가져오기
	 */
	private void doTakePhotoAction() {
		/*
		 * 참고 해볼곳 http://2009.hfoss.org/Tutorial:Camera_and_Gallery_Demo
		 * http://stackoverflow
		 * .com/questions/1050297/how-to-get-the-url-of-the-captured-image
		 * http://www.damonkohler.com/2009/02/android-recipes.html
		 * http://www.firstclown.us/tag/android/
		 */

		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

		// 임시로 사용할 파일의 경로를 생성
		String url = "tmp_" + String.valueOf(System.currentTimeMillis())
				+ ".jpg";
		mImageCaptureUri = Uri.fromFile(new File(Environment
				.getExternalStorageDirectory(), url));

		intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT,
				mImageCaptureUri);
		// 특정기기에서 사진을 저장못하는 문제가 있어 다음을 주석처리 합니다.
		// intent.putExtra("return-data", true);
		startActivityForResult(intent, PICK_FROM_CAMERA);
	}

	/**
	 * 앨범에서 이미지 가져오기
	 */
	private void doTakeAlbumAction() {
		// 앨범 호출
		Intent intent = new Intent(Intent.ACTION_PICK);
		intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
		startActivityForResult(intent, PICK_FROM_ALBUM);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode != RESULT_OK) {
			return;
		}

		switch (requestCode) {
		case CROP_FROM_CAMERA: {
			// 크롭이 된 이후의 이미지를 넘겨 받습니다.
			// 이미지뷰에 이미지를 보여준다거나 부가적인 작업 이후에
			// 임시 파일을 삭제합니다.
			final Bundle extras = data.getExtras();

			if (extras != null) {
				Bitmap photo = extras.getParcelable("data");
				mPhotoImageView.setImageBitmap(photo);
			}

			// 임시 파일 삭제
			File f = new File(mImageCaptureUri.getPath());
			if (f.exists()) {
				f.delete();
			}

			break;
		}

		case PICK_FROM_ALBUM: {
			mImageCaptureUri = data.getData();
		}

		case PICK_FROM_CAMERA: {
			// 이미지를 가져온 이후의 리사이즈할 이미지 크기를 결정합니다.
			// 이후에 이미지 크롭 어플리케이션을 호출하게 됩니다.

			Intent intent = new Intent("com.android.camera.action.CROP");
			intent.setDataAndType(mImageCaptureUri, "image/*");

			intent.putExtra("outputX", 90);
			intent.putExtra("outputY", 90);
			intent.putExtra("aspectX", 1);
			intent.putExtra("aspectY", 1);
			intent.putExtra("scale", true);
			intent.putExtra("return-data", true);
			startActivityForResult(intent, CROP_FROM_CAMERA);

			break;
		}
		}
	}

	public void addListenerOnRatingBar() {

		ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
			public void onRatingChanged(RatingBar ratingBar, float rating,
					boolean fromUser) {
				point = rating;

			}
		});
	}

	public void addListenerOnButton() {

		btnSubmit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String url = "http://192.168.7.120:8084/wooriyo_jsp/review.jsp";
				ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
				String searchedString = reviewText.getText().toString().trim();

				params.add(new BasicNameValuePair("content", searchedString));

				params.add(new BasicNameValuePair("starpoint", point + ""));

				getHttpPost(url, params);

			}
		});
	}

	public void getHttpPost(String url, ArrayList<NameValuePair> params) {
		HttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params, "euc-kr"));
			HttpResponse response = client.execute(httpPost);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			if (statusCode == 200) {
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();
				String c = "";
				BufferedReader br = new BufferedReader(new InputStreamReader(
						content));
				while ((c = br.readLine()) != null) {
					if (c.equals("success")) {
						new AlertDialog.Builder(Review_Write.this)
								.setTitle("리뷰 작성")
								.setMessage("리뷰 작성 완료!")
								.setPositiveButton("확인",
										new DialogInterface.OnClickListener() {

											@Override
											public void onClick(
													DialogInterface dialog,
													int which) {
												finish();

											}
										}).create().show();
					}
				}
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}