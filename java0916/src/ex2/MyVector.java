package ex2;

import java.util.Vector;

/**
 * @author ������
 * Document : MyVector 
 * Created on : 2014. 9. 16, ���� 12:13:36
 */
public class MyVector {
    public String check(Object e){
        if(e instanceof Integer){
            return "Integer�Դϴ�.";
        }else if(e instanceof Character){
            return "Character�Դϴ�.";
        }else if(e instanceof String){
            return "String�Դϴ�.";
        }else if(e instanceof Float){
            return "Float�Դϴ�.";
        }else if(e instanceof Long){
            return "Long�Դϴ�.";
        }else{
            return "Boolean�Դϴ�.";
        }
    }
    public static void main(String[] args) {
        //�÷����� �ڷᱸ���̰�, ��ü�� ������ �ȴ�.
        MyVector myv= new MyVector();
        Vector v = new Vector();
        v.add(new String("Test"));
        v.add(10);
        v.add('A');
        v.add(true);
        v.add(3.14f);
        v.add(100L);
        for(Object e : v){ //���ʹ� ��ü�� ��� ���� �ڷᱸ���̱� ������ Type�� Object�̴�.
            System.out.print(e);
            String msg = myv.check(e);
            System.out.println(" "+msg);
        }
    }
}
