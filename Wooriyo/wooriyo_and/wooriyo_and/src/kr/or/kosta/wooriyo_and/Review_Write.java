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

		// RatingBar Ŭ�� �ɼ�
		addListenerOnRatingBar();
		// Submit ��ư Ŭ�� �ɼ�
		addListenerOnButton();
		// Picture ��ư Ŭ�� �ɼ�
		addListenerOnPicture();

	}

	public void addListenerOnPicture() {
		btnPicture.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// ���̾�α׸� �����ؼ� �����ش�.
				mDialog = createDialog();
				mDialog.show();
			}
		});
	}

	/**
	 * ���̾�α� ����
	 */
	private AlertDialog createDialog() {
		// image_crop_row.xml�� ���̾ƿ��� ������ innerView�� �����Ѵ�.
		final View innerView = getLayoutInflater().inflate(
				R.layout.select_picture, null);

		// ī�޶� ��ư, ��������ư ����
		Button camera = (Button) innerView.findViewById(R.id.btn_camera_crop);
		Button gellary = (Button) innerView.findViewById(R.id.btn_gellary_crop);

		// ī�޶� ��ư�� Ŭ���ϸ�
		camera.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// doTakePhotoAction�� �����ϰ� ���̾�α׸� �����Ų��.
				doTakePhotoAction();
				setDismiss(mDialog);
			}
		});
		// ������ ��ư�� Ŭ���ϸ�
		gellary.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// doTakeAlbumAction�� �����ϰ� ���̾�α׸� �����Ų��.
				doTakeAlbumAction();
				setDismiss(mDialog);
			}
		});

		// ���̾�α� ��ü�� �����ؼ�
		AlertDialog.Builder ab = new AlertDialog.Builder(this);
		// Title�� �����ϰ�
		ab.setTitle("Image Crop");
		// ���巷 ���� innerView�� setView �޼��带 �̿��ؼ� �����Ѵ�.
		ab.setView(innerView);

		// ���̾�α׸� �������Ŀ� ��ȯ�Ѵ�.
		return ab.create();
	}

	/**
	 * ���̾�α� ����
	 */
	private void setDismiss(AlertDialog dialog) {
		if (dialog != null && dialog.isShowing()) {
			dialog.dismiss();
		}
	}

	/**
	 * ī�޶󿡼� �̹��� ��������
	 */
	private void doTakePhotoAction() {
		/*
		 * ���� �غ��� http://2009.hfoss.org/Tutorial:Camera_and_Gallery_Demo
		 * http://stackoverflow
		 * .com/questions/1050297/how-to-get-the-url-of-the-captured-image
		 * http://www.damonkohler.com/2009/02/android-recipes.html
		 * http://www.firstclown.us/tag/android/
		 */

		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

		// �ӽ÷� ����� ������ ��θ� ����
		String url = "tmp_" + String.valueOf(System.currentTimeMillis())
				+ ".jpg";
		mImageCaptureUri = Uri.fromFile(new File(Environment
				.getExternalStorageDirectory(), url));

		intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT,
				mImageCaptureUri);
		// Ư����⿡�� ������ ������ϴ� ������ �־� ������ �ּ�ó�� �մϴ�.
		// intent.putExtra("return-data", true);
		startActivityForResult(intent, PICK_FROM_CAMERA);
	}

	/**
	 * �ٹ����� �̹��� ��������
	 */
	private void doTakeAlbumAction() {
		// �ٹ� ȣ��
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
			// ũ���� �� ������ �̹����� �Ѱ� �޽��ϴ�.
			// �̹����信 �̹����� �����شٰų� �ΰ����� �۾� ���Ŀ�
			// �ӽ� ������ �����մϴ�.
			final Bundle extras = data.getExtras();

			if (extras != null) {
				Bitmap photo = extras.getParcelable("data");
				mPhotoImageView.setImageBitmap(photo);
			}

			// �ӽ� ���� ����
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
			// �̹����� ������ ������ ���������� �̹��� ũ�⸦ �����մϴ�.
			// ���Ŀ� �̹��� ũ�� ���ø����̼��� ȣ���ϰ� �˴ϴ�.

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
								.setTitle("���� �ۼ�")
								.setMessage("���� �ۼ� �Ϸ�!")
								.setPositiveButton("Ȯ��",
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