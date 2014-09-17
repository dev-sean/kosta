package ex2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author ������
 * Document : Ex2_GUI 
 * Created on : 2014. 9. 17, ���� 1:43:57
 */
//1. Event ����
//2. Event�� ���� �������̽��� ����
//3. ������ �߻�޼��带 �������ؼ� ���� �����ϰ�
//4. Event�� ����� ���ü���� ������(addXXListener(this))�� ���·� �ۼ�
//5. �̿� ���� ����� ����Ŭ������ ���� �����ϴ�.
public class Ex2_GUI extends JFrame implements ActionListener{
    private JPanel p1,p2;//������Ʈ�̸鼭 �����̳� ��ü
    private JButton btn1,btn2,btn3; // ������Ʈ ��ư ��ü
    private JLabel lb; // text�� �������� ǥ�� �ϴ� ������Ʈ ��ü
    public Ex2_GUI(){
        //JPanel ��ü�� ����
        p1 = new JPanel();
        p2 = new JPanel();
        //p1�� ��ܸ޴�, ��ư�� ����
        p1.add(btn1 = new JButton("Red"));
        p1.add(btn2 = new JButton("Green"));
        p1.add(btn3 = new JButton("Blue"));
        
        //EventListener�� ���
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        
        //��ư�� ���� ����
        btn1.setBackground(Color.red);
        btn2.setBackground(Color.green);
        btn3.setBackground(Color.blue);
        //JFrame�� ���� - ����(North)
        add(p1,"North");
        //p2�� JLbael�� ����, �̺�Ʈ�� ���� Text�� ���
        p2.add(lb = new JLabel("^*^"));
        //JFrame�� ���� - �⺻��(Center)
        add(p2);
        //x,y,w,h
        setBounds(100, 100, 300, 400);
        //â����(x)�� ���α׷� ����(jdk5)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);//â�� Ȱ��ȭ
    }
    
    public static void main(String[] args) {
        new Ex2_GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //�̺�Ʈ�� �߻��� ������Ʈ�� �ּҸ� �޴� ���
        Object v = e.getSource();
        JButton vv = (JButton) e.getSource();
        String msg = "";
        if(v==btn1){
            msg = "red";
        }else if(v==btn2){
            msg = "green";  
        }else{
            msg = "blue"; 
        }
        lb.setText(msg+"�� ������ �����Ƿ� ���� ��� ��������");
        p1.setBackground(vv.getBackground());
        p2.setBackground(vv.getBackground());
    }
}

/*
1. View�� ������ ���ο� jFrame�� Ȱ��ȭ�ȴ�.(�޴��� Ȱ��ȭ)
2. View�� �ܾ�� close�� ����Ǿ�� �Ѵ�.
3. close�� ������ â�� ������� view�� �ٲ��� �Ѵ�.
������ ������ ��ü�� ������ ����� �ȵȴ�.
4. ���Ʒ� Ŭ������ jframe�� ��ӹ޴´�.
5. ��ư�� ������ view â�� ���� �ٲ��.
Call by reference
this - ���� ��ü�� �ּ�
*/