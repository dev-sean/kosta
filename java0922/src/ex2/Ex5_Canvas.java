package ex2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

/**
 * @author ������ Document : Ex5_Canvas Created on : 2014. 9. 22, ���� 2:44:20
 */
//Canvas����
public class Ex5_Canvas extends JFrame {

    private Canvas can;
    private int x,y;

    public Ex5_Canvas() {
        //Canvas�� ����Ŭ������ �����ϱ�
        add(can = new Canvas() {
            //�׸��� �׸��� ���� �׷����� ��ҿ� �׷��ִ� ����
            @Override
            public void paint(Graphics g) {
                //�� �׷�����
                g.setColor(Color.red);
                g.fillOval(x, y, 50, 50);
                g.setColor(Color.red);
                g.drawArc(200, 100, 100, 100, 0, 0);
            }

            @Override
            public void update(Graphics g) {
                paint(g);
            }
        });
        can.setBackground(Color.pink);
        can.addMouseMotionListener(new MouseMotionAdapter() {
            //Adapter�� ����ϸ� �߻�Ŭ�����̱� ������
            //empty�޼��带 ���� �س��� �̰��� ���, �͸���Ŭ������
            //���� �� ���� �� �� ����ڰ� �ʿ��� �͸� ������ ����
            @Override
            public void mouseDragged(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                System.out.println(x+":"+y);
                //paint�� JVM�� ȣ�� - �׷��� ����� ���� 
                //repaint()�� ȣ��
                //����) repaint() -> JVM -> update() -> paint();
                //update() : ������ ĵ������ �����ִ� ����
                can.repaint();
            }
            
        });
        setBounds(100, 100, 400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ex5_Canvas();
    }
}
