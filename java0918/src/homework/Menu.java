package homework;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author 오세현 Document : Menu Created on : 2014. 9. 19, 오전 9:09:29
 */
public class Menu extends JFrame implements ActionListener{

    private JButton btn1, btn2, btn3;
    private JPanel p1;
    private Body body;

    public Menu(Body body) {
        this.body = body;//다른 메서드에서 사용하기 위해
        p1 = new JPanel();
        p1.add(btn1 = new JButton("RED"));
        p1.add(btn2 = new JButton("BLUE"));
        p1.add(btn3 = new JButton("GREEN"));

        btn1.setBackground(Color.red);
        btn2.setBackground(Color.blue);
        btn3.setBackground(Color.green);
        add(p1);
        setBounds(300, 10, 300, 200);
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        //메뉴객체가 생성시 전달받은 body의 주소로 접근해서
        //body의 jPanel에 색상을 동적으로 변경한다.
        Color col = btn.getBackground();
        body.getJp1().setBackground(col);
        body.getJp2().setBackground(col);        
    }
}