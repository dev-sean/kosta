package ex2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * @author ������
 * Document : Ex3_ObjectOutputStreamDemo 
 * Created on : 2014. 9. 19, ���� 11:24:31
 */
public class Ex3_ObjectOutputStreamDemo {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectOutput oos = new ObjectOutputStream(new FileOutputStream("C:\\kosta86\\mytext.txt"));
        //������ ��ü ���� �� �� ����
        MemberVO vo = new MemberVO();
        vo.setName("��浿");
        vo.setAge(30);
        vo.setAddr("����");
        vo.setTimes(System.currentTimeMillis());
        vo.setFlag(true);
        //��Ʈ���� ���ؼ� ��ü�� ����(������ - ����ȭ)
        oos.writeObject(vo);
        //������ȭ�� �о����
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\kosta86\\mytext.txt"));
        MemberVO v1 = (MemberVO) ois.readObject();
        System.out.println(v1.getName());
        System.out.println(v1.getAge());
        System.out.println(v1.getAddr());
        System.out.println(v1.getTimes());
        System.out.println(v1.isFlag());
    }
}