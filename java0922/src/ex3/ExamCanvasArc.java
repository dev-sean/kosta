package ex3;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author 오세현 Document : ExamCanvasArc Created on : 2014. 9. 22, 오후 3:41:03
 */
//버튼을 클릭햇을 때 Arc를 0->10도씩 증가해서 360만큼 그리시오.
//즉 스레드 2개를 사용해서 원을 2개를 그리도록 한다.
public class ExamCanvasArc extends JFrame {

    private static int angle;
    private JPanel p1;
    private JButton btn1;
    private Canvas can;

    public ExamCanvasArc() {
        setTitle("쓰레드와 캔버스");
        p1 = new JPanel();
        p1.add(btn1 = new JButton("Click"));
        add(p1, "North");
        setBounds(200, 200, 600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        add(can = new Canvas() {

            @Override
            public void update(Graphics g) {
                paint(g);
            }

            @Override
            public void paint(Graphics g) {
                g.setColor(Color.red);
                g.drawArc(100, 100, 100, 100, 0, angle);
                g.setColor(Color.blue);
                g.drawArc(300, 100, 100, 100, 90, angle);
            }

        });
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread() {

                    @Override
                    public void run() {
                        for (angle = 0; angle <= 360; angle += 10) {
                            try {
                                Thread.sleep(100);
                                can.repaint();
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }.start();
            }
        });

    }

    public static void main(String[] args) {
        new ExamCanvasArc();
    }
}
