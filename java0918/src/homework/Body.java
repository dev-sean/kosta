package homework;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author 오세현
 * Document : Body 
 * Created on : 2014. 9. 19, 오전 9:04:51
 */
public class Body extends JFrame{
    private JPanel jp1, jp2;
    private JButton btn1;
    private Menu menu;

    public JPanel getJp1() {
        return jp1;
    }

    public JPanel getJp2() {
        return jp2;
    }
    
    public Body(){
        menu = new Menu(this);
        menu.setVisible(false);
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp1.add(btn1 = new JButton("View"));
        btn1.setBackground(Color.BLUE);
        btn1.setBackground(Color.WHITE);
        add(jp1,"North");
        add(jp2);
        setBounds(300,210,300,450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        //인터페이스를 내부클래스로 정의
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                //메뉴 정의 활성화 여부에 따라 버튼의 문자 변경
                //및 메뉴창을 활성화 비활성화 구현
                if(menu.isVisible()){
                    btn1.setText("View");
                    btn1.setBackground(Color.red);
                    menu.setVisible(false);
                }else{  
                    btn1.setText("Close");
                    menu.setVisible(true);
                }
            }
        });
    }
    public static void main(String[] args) {
        Body body = new Body();
    }
}
