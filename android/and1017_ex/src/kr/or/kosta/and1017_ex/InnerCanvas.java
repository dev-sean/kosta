package kr.or.kosta.and1017_ex;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Paint.Style;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

//Canvas를 extends하는 내부클래스
public class InnerCanvas extends View {
	private Path path;
	private Paint paint;
	private ArrayList<Path> pathList;
	private ArrayList<Paint> paintList;
	private int color, weight;
	private String motion;
	private int color_s, size_s;
	private BufferedReader in;
	private PrintWriter out;
	private Socket s;
	private float x,y;
	private Handler networkHandler = new Handler();
	// 네트워크
	private String proto1, proto2, proto3, proto4, proto5, proto6, proto7,
			proto8;

	public InnerCanvas(Context context, Socket s) {
		super(context);
		// 초기화 : 선을 그을 때 사용
		this.s = s;
		path = new Path();
		paint = new Paint();
		try {
			out = new PrintWriter(
					new BufferedOutputStream(s.getOutputStream()), true);
			in = new BufferedReader(new InputStreamReader(s
					.getInputStream(), "UTF-8"));
		} catch (IOException e) {

			e.printStackTrace();
		}

		t.start();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		setBackgroundColor(Color.WHITE);
		paint.setAntiAlias(true);

		// 선 굵기, 스타일 지정
		paint.setColor(Color.RED);
		paint.setStrokeWidth(weight);
		paint.setStyle(Style.STROKE);

		color_s = Color.BLACK;
		size_s = 10;

		// 저장된 선을 그려주는 영역
		// for (int a = 0; a < pathList.size(); a++) {
		canvas.drawPath(path, paint);
		// }
	}

	// onTouchEvent일 때 터치 시에 시작점을 호출하고 Move일 때 그리기를 구현
	@Override
	public boolean onTouchEvent(MotionEvent event) {

		
			StringBuffer sb = new StringBuffer();

			// 터치 시에 X와 Y값을 얻어와서 저장한다
			float x = event.getX();
			float y = event.getY();

			// Action이 있을 때
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				motion = "start";
			} else if (event.getAction() == MotionEvent.ACTION_MOVE) {
				motion = "drag";
			}

			sb.append("room/draw/").append(color_s).append("/");
			sb.append(x).append("/").append(y).append("/");
			sb.append(motion).append("/").append(size_s).append("/")
					.append("writer");

			out.println(sb.toString());
		
		// invalidate();
		return true;
	}

	Thread t =new Thread(new Runnable() {
		// 스트림을 통해서 받아온 프로토콜을 받아냄

		@Override
		public void run() {
			try {
			
				while (true) {

					String protocol = in.readLine();

					Log.d("Msg", protocol);

					StringTokenizer st = new StringTokenizer(protocol, "/");

					// 프로토콜 가져오기
					proto1 = st.nextToken();
					proto2 = st.nextToken();
					proto3 = st.nextToken();
					proto4 = st.nextToken();
					proto5 = st.nextToken();
					proto6 = st.nextToken();
					proto7 = st.nextToken();
					proto8 = st.nextToken();

					// 프로토콜 판별

					networkHandler.post(new Runnable() {

						@Override
						public void run() {
							if (proto1.equals("room")
									&& proto2.equals("draw")) {
								// ---------

								Log.d("Msg", proto1);

								if (proto3.equals("RED")) {
									color = Color.RED;
								} else if (proto3.equals("GREEN")) {
									color = Color.GREEN;
								} else if (proto3.equals("YELLOW")) {
									color = Color.YELLOW;
								} else if (proto3.equals("BLUE")) {
									color = Color.BLUE;
								} else if (proto3.equals("BLACK")) {
									color = Color.BLACK;
								}

								if (proto7.equals("10")) {
									weight = 10;
								} else if (proto7.equals("15")) {
									weight = 15;
								} else if (proto7.equals("20")) {
									weight = 20;
								} else if (proto7.equals("25")) {
									weight = 25;
								} else if (proto7.equals("30")) {
									weight = 30;
								}
           						x = Float.parseFloat(proto4);
								y = Float.parseFloat(proto5);	
								if (proto6.equals("start")) {
									path.moveTo(x,y);	
								} else if (proto6.equals("drag")) {
									path.lineTo(x,y);
								}
								invalidate();
								// ---------
							}
						}
					});

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
	
	
	// add - ArrayList에 Path, Paint가 생성되어서 기억
	public void add() {
		pathList.add(new Path());
		path = pathList.get(pathList.size() - 1);

		paintList.add(new Paint());
		paint = paintList.get(paintList.size() - 1);
	}


}
