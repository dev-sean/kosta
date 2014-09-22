package ex2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author 오세현 Document : Ex4_Runnable Created on : 2014. 9. 22, 오전 11:44:51
 */
//상속을 못 받았을 때 2가지
public class Ex4_CountTime extends JFrame {

    private JPanel p1, p2;
    private JButton btn1;
    private JTextArea res;
    private JLabel lb;
    private static boolean check;
    //연습문제 : 사용자가 입력하는 시간을 체크해서
    //10초안에 입력하도록 구현하시오.
    //단) 입력을 했으면 카운트가 멈추도록 구현되어야 함.
    // 10초를 넘길경우 경고메세지가 출력!(2개의 스레드로 구현, 메인제외!)
    public Ex4_CountTime() {

        setTitle("단일 스레드 테스트");
        p1 = new JPanel();
        p1.add(btn1 = new JButton("Click"));
        p1.add(lb = new JLabel("10"));
        add(p1, "North");
        p2 = new JPanel();
        res = new JTextArea(20, 50);
        p2.add(res);
        add(p2);
        setBounds(200, 200, 600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread() {

                    @Override
                    public void run() {
                        check=true;
                        String input = JOptionPane.showInputDialog("값을 입력");
                        res.append("입력하신 값은 :" + input + "입니다.\n");
                        check=false;
                    }
                }.start();
                new Thread() {

                    @Override
                    public void run() {
                        for (int i = 10; i >= 0; i--) {
                            try {
                                if(check==false){
                                    return;
                                }
                                lb.setText(String.valueOf(i));
                                Thread.sleep(1000);
                                
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                        JOptionPane.showMessageDialog(Ex4_CountTime.this,"10초 동안 입력했어야 한다.");
                        System.exit(0);
                    }
                }.start();
            }
        });
    }
    public static void main(String[] args) {
        new Ex4_CountTime();
    }
}
