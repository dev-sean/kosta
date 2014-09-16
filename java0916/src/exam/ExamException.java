package exam;

import java.util.Scanner;

/**
 * @author ������ Document : ExamException Created on : 2014. 9. 16, ���� 9:45:07
 */
public class ExamException {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("�� �Է� :");
        int num = 0, com = 0, res = 0;
        try {
            //NumberFormatException
            num = Integer.parseInt(sc.nextLine());

            com = (int) (Math.random() * 3);
            //ArithmeticException
            res = num / com;
            System.out.println("��µ� ��� : " + res);
            System.out.println("�ڿ��ݳ�");
        } catch (NumberFormatException e) {
            System.out.println(e+"���ڸ� �־�~");
            return;
        } catch(ArithmeticException e ){
            System.out.println(e+"0�̳�?");
        } catch(Exception e){ //�ֻ��� exception
            System.out.println(e);
        } finally{//������ ����Ǵ� ����! 
            System.out.println("������ �ڿ���ȯ");
        }
    }
}