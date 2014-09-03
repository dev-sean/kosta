package ex2;

import java.util.Scanner;

/**
 * @author kosta
 * Document : Ex9_ForFor 
 * Created on : 2014. 9. 3, 오후 3:51:27
 */
public class Ex9_ForFor {
    public static void main(String[] args) {
        //다중 for문
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.print(j+" x "+i+" = "+(i*j)+"\t");                
            }
            System.out.println(" ");
        }
    }
}
