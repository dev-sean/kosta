package kr.or.kosta.and1017;

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
import android.view.MotionEvent;
import android.view.View;

public class InnerCanvas extends View {
	private Path path;
	private Paint paint;
	private ArrayList<Path> pathList;
	private ArrayList<Paint> paintList;
	private int color, weight;
	private String motion;
	private int color_s, size_s;
	private BufferedReader br;
	private PrintWriter pw;
	private Socket s;
	private float x, y;
	private Handler networkHandler;// ��Ʈ��ũ ��������
	private String proto1, proto2, proto3, proto4, proto5, proto6, proto7,
			proto8;

	public InnerCanvas(Context context, Socket s) {
		super(context);
		this.s = s;
		// �ʱ�ȭ : ���� ���� �� ���� ��ü
		path = new Path();
		paint = new Paint();
		// Socket���κ��� ����� ��Ʈ���� �ʱ�ȭ
		try {
			pw = new PrintWriter(new BufferedOutputStream(s.getOutputStream()),
					true);
			// ���ڵ� ����
			br = new BufferedReader(new InputStreamReader(s.getInputStream(),
					"UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		networkHandler = new Handler();
		t.start();
	}

	@Override
	protected void onDraw(Canvas canvas) {

		super.onDraw(canvas);
		setBackgroundColor(Color.WHITE);
		paint.setAntiAlias(true);

		// ���� ����, ��Ÿ�� ����
		paint.setColor(Color.RED); // ����
		paint.setStrokeWidth(20); // ���� ����
		paint.setStyle(Style.STROKE); // �� Ÿ��
		color_s = Color.BLACK; // �� ����
		size_s = 10;
		canvas.drawPath(path, paint);

	}

	// Touch�� �� x,y���� ����.
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		StringBuffer sb = new StringBuffer();
		// ��ġ�� ��ǥ ���
		float x = event.getX();
		float y = event.getY();
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			motion = "start";
		} else if (event.getAction() == MotionEvent.ACTION_MOVE) {
			motion = "drag";
		}
		// room/chat/
		// room/draw/color_s/x/y/motion/size_s/writer
		sb.append("room/draw/").append(color_s).append("/");
		sb.append(x).append("/").append(y).append("/");
		sb.append(motion).append("/").append(size_s).append("/");
		sb.append("writer");
		// ������ �����ϱ�
		pw.println(sb.toString());

		return true;
	}

	Thread t = new Thread(new Runnable() {

		@Override
		public void run() {
			try {
				// �о� �� ���� �޽����� �м�
				String protocol = br.readLine();
				StringTokenizer st = new StringTokenizer(protocol, "/");

				proto1 = st.nextToken();
				proto2 = st.nextToken();
				proto3 = st.nextToken();
				proto4 = st.nextToken();
				proto5 = st.nextToken();
				proto6 = st.nextToken();
				proto7 = st.nextToken();
				proto8 = st.nextToken();
				// UI Handler
				networkHandler.post(new Runnable() {
				
					@Override
					public void run() {
						// TODO Auto-generated method stub
						if (proto1.equals("room") && proto2.equals("draw")) {
							if (proto3.equals("RED")){
								color = Color.RED;	
							}else{
								color = Color.BLUE;
							}
							weight = 10;
							x = Float.parseFloat(proto4);
							y = Float.parseFloat(proto5);
							if(proto6.equals("start")){
								path.moveTo(x, y);
							}else if(proto6.equals("drag")){
								path.lineTo(x, y);
							}
							invalidate();
						}
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	});
}
