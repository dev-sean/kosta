package exam;

import java.util.Scanner;

/**
 * @author 오세현 Document : ExamException Created on : 2014. 9. 16, 오전 9:45:07
 */
public class ExamException {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("수 입력 :");
        int num = 0, com = 0, res = 0;
        try {
            //NumberFormatException
            num = Integer.parseInt(sc.nextLine());

            com = (int) (Math.random() * 3);
            //ArithmeticException
            res = num / com;
            System.out.println("출력된 결과 : " + res);
            System.out.println("자원반납");
        } catch (NumberFormatException e) {
            System.out.println(e+"숫자만 넣엉~");
            return;
        } catch(ArithmeticException e ){
            System.out.println(e+"0이네?");
        } catch(Exception e){ //최상위 exception
            System.out.println(e);
        } finally{//무조건 수행되는 개념! 
            System.out.println("무조건 자원반환");
        }
    }
}