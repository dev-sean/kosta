package ex1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 오세현
 * Document : ExamConst 
 * Created on : 2014. 9. 11, 오후 3:59:06
 */
public class ExamConst {
    private String name;
    private int age;
    private String date;
    public boolean insert(String name, int age){
        if(age > 19){
            System.out.println(name+" 통과");
            return true;
        }else{
            System.out.println(name+" 접근금지");
            return false;
        }
    }
    //객체를 생성하기 위한 다양한 방법을 오버로딩으로 제공해줘야 한다.
    public ExamConst(String name) {
        this.name = name;
        age = 19;
        //익명으로 객체를 생성해서 사용하는 방법의 예
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
