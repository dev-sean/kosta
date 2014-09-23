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
 * @author ������ Document : Main Created on : 2014. 9. 23, ���� 1:04:10
 */
public class Main extends JFrame {

    private JPanel p1;
    private JButton btn1;
    //Canvas, Arc�� ����, Thread�� �����ؼ� ����ϱ� ���ؼ�
    //static���� ����!!
    public static Canvas can;
    public static int angle2;
    public static int angle3;
    public static Thread1 th1;//����� Ȱ���� ������
    public static Thread2 th2;//Runnable �������̽��� Ȱ���� ������
    public static Thread th3;

    public Main() {
        setTitle("������ && ĵ���� �׽�Ʈ");
        p1 = new JPanel();
        p1.add(btn1 = new JButton("Click"));
        add(p1, "North");
        setBounds(200, 200, 600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true); //GUI ����!!
        add(can = new Canvas() {
            //�׸��� �׸��� ���� �׷����� ��ҿ� �׷��ִ� ����
            @Override
            public void paint(Graphics g) {
                //���� �׸���.
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
            //��ư �̺�Ʈ!!
            @Override
            public void actionPerformed(ActionEvent e) {
                //ù��° �����带 ������Ű�� �����Ѵ�.
                th1 = new Thread1();
                th1.start();
                //�ι�° �����带 ������Ű�� �����Ѵ�.
                th3 = new Thread(new Thread2());
                th3.start();
            }
        });
    }

    public static void main(String[] args) {
        new Main();
    }
}