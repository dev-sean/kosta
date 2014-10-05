package ex2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game extends JFrame implements KeyListener {

    private Canvas canvas; //Canvas
    private JPanel p; //Panel
    private JButton btn; //Start Button
    private final int CANVAS_W = 400; //Canvas의 폭
    private final int CANVAS_H = 600; //Canvas의 높이
    private int move_x = 5; //수평 이동 폭
    private int move_y = 5; //수직 이동 폭
    private boolean b_right = true; // 오른쪽 이동 중인가?
    private boolean b_down = true; // 아래로 이동 중인가?
    private boolean down_left = false, down_right = false; // bar의 이동
    private final int bar_w = 100; //Bar의 넓이
    private final int bar_h = 20; //Bar의 높이
    private int bar_x = (CANVAS_W / 2) - (bar_w / 2);//bar의 위치
    private int bar_y = (CANVAS_H / 2) + (bar_h * 10);//bar의 위치
    private final int B_RADIUS = 30; // 원의 지름
    private int ball_x = (CANVAS_W / 2) - (B_RADIUS / 2); //원의 위치 x좌표
    private int ball_y = (CANVAS_H / 2) - (B_RADIUS / 2); //원의 위치 y조표
    private ArrayList<String> mArrayList;
    private int up_bar_x;
    private int up_bar_y;

    public Game() {
        mArrayList = new ArrayList<>();
        addbar();
        p = new JPanel();

        canvas = new Canvas() {
            @Override
            public void paint(Graphics g) {
                if (down_left) {
                    if (bar_x > 0) {
                        bar_x -= 5;
                    }
                }
                if (down_right) {
                    if (bar_x < (CANVAS_W - bar_w - 1)) {
                        bar_x += 5;
                    }
                }
                g.setColor(Color.red);
                g.fillRect(bar_x, bar_y, bar_w, bar_h);
                g.setColor(Color.black);
                g.fillOval(ball_x, ball_y, B_RADIUS, B_RADIUS);
                g.setColor(Color.green);
                g.setColor(Color.black);
                g.drawRect(up_bar_x, up_bar_y, bar_w, bar_h);
            }

            
        };
        add(canvas);
        setBounds(0, 0, CANVAS_W + 30, CANVAS_H + 100);
        canvas.setBounds(0, 0, CANVAS_W, CANVAS_H);
        canvas.setBackground(Color.white);
        canvas.addKeyListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        new Thread() {
            //공이 움직이는 일을 처리하기 위한 스레드
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                while (true) {
                    collision_bar();
                    try {
                        //공이 좌우로 움직이게 한다.
                        ball_x = (b_right == true) ? (ball_x + move_x) : (ball_x - move_x);
                        Thread.sleep(10);
                        //좌우 충돌체크!
                        if (ball_x + B_RADIUS > CANVAS_W) {
                            ball_x = CANVAS_W - B_RADIUS;
                            b_right = false;
                        } else if (ball_x < 0) {
                            ball_x = B_RADIUS / 2;
                            b_right = true;
                        }
                        //공이 상하로 움직이게 한다.
                        ball_y = (b_down == true) ? (ball_y + move_y) : (ball_y - move_y);
                        //상하 충돌체크!!
                        if (ball_y + B_RADIUS > CANVAS_H) {
                            ball_y = CANVAS_H - B_RADIUS;
                            b_down = false;
                        } else if (ball_y < 0) {
                            ball_y = B_RADIUS / 2;
                            b_down = true;
                        }

                        canvas.repaint();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread() {
            //위의 bar를 그리기 위한 쓰레드
            @Override
            public void run() {
                while (true) {
                    for (String e : mArrayList) {
                        try {
                            Thread.sleep(100);
                            StringTokenizer st = new StringTokenizer(e, "/");
                            up_bar_x = Integer.parseInt(st.nextToken());
                            up_bar_y = Integer.parseInt(st.nextToken());
                            canvas.repaint();
                            System.out.println(up_bar_x + "l" + up_bar_y);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }

                }
            }
        }.start();
    }

    public void addbar() {
        //위쪽의 Bar의 좌표값을 mArrayList에 저장
        mArrayList.add("0/0");
        mArrayList.add("100/0");
        mArrayList.add("200/0");
        mArrayList.add("300/0");
        mArrayList.add("0/20");
        mArrayList.add("100/20");
        mArrayList.add("200/20");
        mArrayList.add("300/20");
        mArrayList.add("0/40");
        mArrayList.add("100/40");
        mArrayList.add("200/40");
        mArrayList.add("300/40");
    }

    public void init() {
        //초기화!!
        bar_x = (CANVAS_W / 2) - (bar_w / 2);//bar의 위치
        bar_y = (CANVAS_H / 2) + (bar_h * 10);//bar의 위치
        ball_x = (CANVAS_W / 2) - (B_RADIUS / 2); //원의 위치 x좌표
        ball_y = (CANVAS_H / 2) - (B_RADIUS / 2); //원의 위치 y조표
        b_right = true; // 오른쪽 이동 중인가?
        b_down = true;
        down_left = false;
        down_right = false; // bar의 이동
        canvas.repaint();
    }

    public void collision_bar() {
        //공의 충돌체크
        int base_y = ball_y + B_RADIUS;
        int base_x = ball_x + B_RADIUS;
        if (base_y >= bar_y) {
            //공이 bar의 윗 부분과 만나면 팅겨나간다.
            if (ball_x >= bar_x && ball_x <= (bar_x + bar_w)) {
                b_down = false;
            }
        }
        if (base_x == bar_x) {
            //공이 bar의 왼쪽 부분과 만나면 위로 튕겨나간다.
            if (base_y >= bar_y && base_y <= (bar_y + bar_h)) {
                b_right = false;
                b_down = false;
            }
        }
        if (base_x - B_RADIUS == bar_x + bar_w) {
            //공이 bar의 오른쪽 부분과 만나면 위로 튕겨나간다.
            if (base_y >= bar_y && base_y <= (bar_y + bar_h)) {
                b_right = true;
                b_down = false;
            }
        }
        if (base_y - B_RADIUS > bar_y + bar_h) {
            //공이 바닥으로 떨어졌을 때!
            //GameOver 메세지가 뜨고 프로그램이 종료된다.
            JOptionPane.showMessageDialog(this, "Game Over!!!");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Game();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int keycode = e.getKeyCode();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //key가 눌렸을 때 이벤트가 발생한다.
        int keycode = e.getKeyCode();

        switch (keycode) {
            case KeyEvent.VK_LEFT:
                down_left = true;
                canvas.repaint();
                break;

            case KeyEvent.VK_RIGHT:
                down_right = true;
                canvas.repaint();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //키가 떼어졌을 때 이벤트가 발생한다.
        int keycode = e.getKeyCode();
        switch (keycode) {
            case KeyEvent.VK_LEFT:
                down_left = false;
                canvas.repaint();
                break;

            case KeyEvent.VK_RIGHT:
                down_right = false;
                canvas.repaint();
                break;
        }
    }
}
