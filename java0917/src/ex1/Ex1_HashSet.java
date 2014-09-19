package ex1;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author 오세현
 * Document : Ex1_HashSet 
 * Created on : 2014. 9. 17, 오전 10:18:11
 */
//중복을 허용하지 않는 구조이다.
public class Ex1_HashSet {
    public static void main(String[] args) {
        String[] str = {"Java","Beans","Java","JSON"};
        
        HashSet<String> hs1 = new HashSet<>();
        System.out.println(hs1.size());
        for(String n : str){
            hs1.add(n);
        }
        System.out.println(hs1.size());
        for(String e : hs1){
            System.out.println(e);
        }
        hs1.remove("Beans");
        System.out.println(hs1.size());
        for(String e : hs1){
            System.out.println(e);
        }
        System.out.println("========================");
        HashSet<Integer> hs2 = new HashSet<>();
        int[] numr = {5,3,2,1,8,9,7,5};
        for(int n : numr){
            hs2.add(n);
        }
        System.out.println("배열크기: "+numr.length);
        System.out.println("크기 : "+hs2.size());
        //정렬도 됨, 배열이 아닐땐 정렬안됨
        //TresSet으로 변경하면 오름차순으로 정열을 보장받음
        Iterator<Integer> it = hs2.iterator();
        while(it.hasNext()){
            Integer integer = it.next();
            System.out.println(integer);
        }
    }
}