package ex1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ������
 * Document : ExamConst 
 * Created on : 2014. 9. 11, ���� 3:59:06
 */
public class ExamConst {
    private String name;
    private int age;
    private String date;
    public boolean insert(String name, int age){
        if(age > 19){
            System.out.println(name+" ���");
            return true;
        }else{
            System.out.println(name+" ���ٱ���");
            return false;
        }
    }
    //��ü�� �����ϱ� ���� �پ��� ����� �����ε����� ��������� �Ѵ�.
    public ExamConst(String name) {
        this.name = name;
        age = 19;
        //�͸����� ��ü�� �����ؼ� ����ϴ� ����� ��
        date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public ExamConst(int age) {
        this.age = age;
    }

    public ExamConst(String name, int age) {
        this.name = name;
        this.age = age;
        date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
}
