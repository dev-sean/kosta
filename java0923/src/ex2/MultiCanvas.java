package ex2;

/**
 * @author kosta Document : MultiCanvas Created on : 2014. 9. 23, 오후 5:18:28
 */
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MultiCanvas extends JFrame implements ActionListener{
    private JPanel p;
    private JButton btn;
    private Canvas can;
    private int arcNum;
    private int arcNum2;
    private Thread t1,t2;
    //getter와 setter를 설정해서 다른 클래스에서
    //MultiCanvas의 멤버필드를 설정할 수 있도록 제공해줌.
    public Thread getT1() {
        return t1;
    }
    
    public Canvas getCan() {
        return can;
    }

    public void setCan(Canvas can) {
        this.can = can;
    }

    public int getArcNum() {
        return arcNum;
    }

    public void setArcNum(int arcNum) {
        this.arcNum = arcNum;
    }

    public int getArcNum2() {
        return arcNum2;
    }

    public void setArcNum2(int arcNum2) {
        this.arcNum2 = arcNum2;
    }

    public MultiCanvas() throws InterruptedException {
        //스레드를 생성하면서 현재 클래스(MultiCanvas)를 넘겨주면서 생성한다.
        //그렇게 되면 MyThread1, MyThread2에서 현재 클래스에 접근할 수 있다.
         t1 = new Thread(new MyThread1(this));
         t2 = new Thread(new MyThread2(this));
        can = new Canvas() {
            @Override
            public void paint(Graphics g) {
                g.drawArc(100, 100, 100, 100, 0, arcNum);
                g.drawArc(300, 100, 100, 100, 0, arcNum2);
            }//그림을 그려준다.

            @Override
            public void update(Graphics g) {
                paint(g);
            }
        };
        p=new JPanel();
        p.add(btn = new JButton("click"));
        add(can);
        setBounds(300, 100, 800, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(p,"South");
        btn.addActionListener(this);//버튼을 눌렀을 경우 이벤트를 실행한다.
               
    }

    public static void main(String[] args) throws InterruptedException {
        MultiCanvas ref = new MultiCanvas();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //버튼 이벤트가 발생하면 스레드를 실행시킨다.
        t1.start();
        t2.start();
    }
}
