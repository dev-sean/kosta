package ex2;

import java.util.Vector;

/**
 * @author 오세현
 * Document : MyVector 
 * Created on : 2014. 9. 16, 오후 12:13:36
 */
public class MyVector {
    public String check(Object e){
        if(e instanceof Integer){
            return "Integer입니다.";
        }else if(e instanceof Character){
            return "Character입니다.";
        }else if(e instanceof String){
            return "String입니다.";
        }else if(e instanceof Float){
            return "Float입니다.";
        }else if(e instanceof Long){
            return "Long입니다.";
        }else{
            return "Boolean입니다.";
        }
    }
    public static void main(String[] args) {
        //컬렉션은 자료구조이고, 객체만 저장이 된다.
        MyVector myv= new MyVector();
        Vector v = new Vector();
        v.add(new String("Test"));
        v.add(10);
        v.add('A');
        v.add(true);
        v.add(3.14f);
        v.add(100L);
        for(Object e : v){ //벡터는 객체를 담기 위한 자료구조이기 때문에 Type은 Object이다.
            System.out.print(e);
            String msg = myv.check(e);
            System.out.println(" "+msg);
        }
    }
}
