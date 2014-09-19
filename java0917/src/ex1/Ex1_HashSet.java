package ex1;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author ������
 * Document : Ex1_HashSet 
 * Created on : 2014. 9. 17, ���� 10:18:11
 */
//�ߺ��� ������� �ʴ� �����̴�.
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
        System.out.println("�迭ũ��: "+numr.length);
        System.out.println("ũ�� : "+hs2.size());
        //���ĵ� ��, �迭�� �ƴҶ� ���ľȵ�
        //TresSet���� �����ϸ� ������������ ������ �������
        Iterator<Integer> it = hs2.iterator();
        while(it.hasNext()){
            Integer integer = it.next();
            System.out.println(integer);
        }
    }
}