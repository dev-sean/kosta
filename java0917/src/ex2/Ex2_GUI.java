package ex2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author 오세현
 * Document : Ex2_GUI 
 * Created on : 2014. 9. 17, 오후 1:43:57
 */
//1. Event 결정
//2. Event에 따른 인터페이스를 구현
//3. 구현된 추상메서드를 재정의해서 일을 정의하고
//4. Event가 적용될 대상객체에게 감지자(addXXListener(this))의 형태로 작성
//5. 이와 같은 방법을 내부클래스로 정의 가능하다.
public class Ex2_GUI extends JFrame implements ActionListener{
    private JPanel p1,p2;//컴포넌트이면서 컨테이너 객체
    private JButton btn1,btn2,btn3; // 컴포넌트 버튼 객체
    private JLabel lb; // text나 아이콘을 표시 하는 컴포넌트 객체
    public Ex2_GUI(){
        //JPanel 객체를 생성
        p1 = new JPanel();
        p2 = new JPanel();
        //p1은 상단메뉴, 버튼을 적재
        p1.add(btn1 = new JButton("Red"));
        p1.add(btn2 = new JButton("Green"));
        p1.add(btn3 = new JButton("Blue"));
        
        //EventListener를 등록
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        
        //버튼의 색상 지정
        btn1.setBackground(Color.red);
        btn2.setBackground(Color.green);
        btn3.setBackground(Color.blue);
        //JFrame에 적재 - 위쪽(North)
        add(p1,"North");
        //p2는 JLbael에 적재, 이벤트에 따른 Text를 출력
        p2.add(lb = new JLabel("^*^"));
        //JFrame에 적재 - 기본값(Center)
        add(p2);
        //x,y,w,h
        setBounds(100, 100, 300, 400);
        //창종료(x)시 프로그램 종료(jdk5)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);//창을 활성화
    }
    
    public static void main(String[] args) {
        new Ex2_GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //이벤트가 발생한 컴포넌트의 주소를 받는 방법
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
        lb.setText(msg+"에 공격이 왔으므로 총을 들고 대응하자");
        p1.setBackground(vv.getBackground());
        p2.setBackground(vv.getBackground());
    }
}

/*
1. View를 누르면 새로운 jFrame이 활성화된다.(메뉴의 활성화)
2. View의 단어는 close로 변경되어야 한다.
3. close를 누르면 창이 사라지고 view로 바뀌어야 한다.
여러번 눌러도 객체가 여러개 생기면 안된다.
4. 위아래 클래스는 jframe를 상속받는다.
5. 버튼을 누르면 view 창의 색이 바뀐다.
Call by reference
this - 현재 객체의 주소
*/