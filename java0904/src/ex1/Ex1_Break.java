package ex1;

/**
 * @author 오세현 Document : Ex1_Break Created on : 2014. 9. 4, 오전 10:10:35
 */
public class Ex1_Break {

    public static void main(String[] args) {
        //break : 특정 조건을 갖추면 반복문을 탈출 하는 제어문
        //break label문 : jdk5부터 지원 break에 라벨 붙여서 
        //라벨이 있는 곳으로 탈출
        xx: for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 3) {
                    break xx;
                }
                System.out.println(i + " : " + j);
            }
        }
    }
}
