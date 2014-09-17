package ex1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ������
 * Document : TestArrayList 
 * Created on : 2014. 9. 17, ���� 11:34:53
 */
public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> numr1 = new ArrayList<>();
        LinkedList<Integer> numr2 = new LinkedList<>();
        
        add(numr1);
        add(numr2);
        System.out.println("�ҿ�ð�");
        System.out.println("ArrayList : "+getList(numr1));
        System.out.println("LinkedList : " + getList(numr2));
    }
    public static void add(List list){
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
    }
    public static long getList(List list){
        //�ý����� ��
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list.get(i);
        }
        long end = System.currentTimeMillis();
        return end-start;
    }
}