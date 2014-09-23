package exam;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author 오세현 Document : Main Created on : 2014. 9. 23, 오후 1:04:10
 */
public class Main extends JFrame {

    private JPanel p1;
    private JButton btn1;
    //Canvas, Arc의 각도, Thread를 공유해서 사용하기 위해서
    //static으로 선언!!
    public static Canvas can;
    public static int angle2;
    public static int angle3;
    public static Thread1 th1;//상속을 활용한 쓰레드
    public static Thread2 th2;//Runnable 인터페이스를 활용한 쓰레드
    public static Thread th3;

    public Main() {
        setTitle("쓰레드 && 캔버스 테스트");
        p1 = new JPanel();
        p1.add(btn1 = new JButton("Click"));
        add(p1, "North");
        setBounds(200, 200, 600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true); //GUI 생성!!
        add(can = new Canvas() {
            //그림을 그리기 위한 그래픽적 요소와 그려주는 동작
            @Override
            public void paint(Graphics g) {
                //원을 그린다.
                g.setColor(Color.blue);
                g.drawArc(160, 100, 100, 100, 0, angle2);
                g.setColor(Color.black);
                g.drawArc(270, 100, 100, 100, 0, angle3);
            }

            @Override
            public void update(Graphics g) {
                paint(g);
            }
        });

        btn1.addActionListener(new ActionListener() {
            //버튼 이벤트!!
            @Override
            public void actionPerformed(ActionEvent e) {
                //첫번째 쓰레드를 생성시키고 시작한다.
                th1 = new Thread1();
                th1.start();
                //두번째 쓰레드를 생성시키고 시작한다.
                th3 = new Thread(new Thread2());
                th3.start();
            }
        });
    }

    public static void main(String[] args) {
        new Main();
    }
}