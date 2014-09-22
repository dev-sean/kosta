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
 * @author ������ Document : Ex4_Runnable Created on : 2014. 9. 22, ���� 11:44:51
 */
//����� �� �޾��� �� 2����
public class Ex4_CountTime extends JFrame {

    private JPanel p1, p2;
    private JButton btn1;
    private JTextArea res;
    private JLabel lb;
    private static boolean check;
    //�������� : ����ڰ� �Է��ϴ� �ð��� üũ�ؼ�
    //10�ʾȿ� �Է��ϵ��� �����Ͻÿ�.
    //��) �Է��� ������ ī��Ʈ�� ���ߵ��� �����Ǿ�� ��.
    // 10�ʸ� �ѱ��� ���޼����� ���!(2���� ������� ����, ��������!)
    public Ex4_CountTime() {

        setTitle("���� ������ �׽�Ʈ");
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
                        String input = JOptionPane.showInputDialog("���� �Է�");
                        res.append("�Է��Ͻ� ���� :" + input + "�Դϴ�.\n");
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
                        JOptionPane.showMessageDialog(Ex4_CountTime.this,"10�� ���� �Է��߾�� �Ѵ�.");
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
