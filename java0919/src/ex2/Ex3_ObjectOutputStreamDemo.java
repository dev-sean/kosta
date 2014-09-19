package ex2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * @author 오세현
 * Document : Ex3_ObjectOutputStreamDemo 
 * Created on : 2014. 9. 19, 오전 11:24:31
 */
public class Ex3_ObjectOutputStreamDemo {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectOutput oos = new ObjectOutputStream(new FileOutputStream("C:\\kosta86\\mytext.txt"));
        //전송할 객체 생성 및 값 설정
        MemberVO vo = new MemberVO();
        vo.setName("김길동");
        vo.setAge(30);
        vo.setAddr("서울");
        vo.setTimes(System.currentTimeMillis());
        vo.setFlag(true);
        //스트림을 통해서 객체를 전송(마샬링 - 직렬화)
        oos.writeObject(vo);
        //역직렬화로 읽어오기
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\kosta86\\mytext.txt"));
        MemberVO v1 = (MemberVO) ois.readObject();
        System.out.println(v1.getName());
        System.out.println(v1.getAge());
        System.out.println(v1.getAddr());
        System.out.println(v1.getTimes());
        System.out.println(v1.isFlag());
    }
}