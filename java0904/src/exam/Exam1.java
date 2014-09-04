package exam;

import java.util.Scanner;

/**
 * @author ������ Document : Exam1 Created on : 2014. 9. 4, ���� 1:48:15
 */
public class Exam1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int win = 0; //����ڰ� �̱� Ƚ��
        int total = 0; //����ڰ� �� ������ ���� ��
        String item; //��ǰ
        while (true) {
            int ran = (int) (Math.random() * 2); //0�� 1�� ��� 0=Ȧ��, 1=¦��
            System.out.print("1 - Ȧ, 2 - ¦, 3 - ���� :");
            int num = Integer.parseInt(sc.nextLine());

            if (num == 1) {
                if (ran == 0) {
                    total++;
                    win++;
                    System.out.println("TOTAL : " + total);
                    System.out.println("CPU : Ȧ");
                    System.out.println("YOU : Ȧ");
                    winning(win);
                } else {
                    total++;
                    System.out.println("TOTAL : " + total);
                    System.out.println("CPU : ¦");
                    System.out.println("YOU : Ȧ");
                    loosing(win);
                }
            } else if (num == 2) {
                if (ran == 1) {
                    total++;
                    System.out.println("TOTAL : " + total);
                    System.out.println("CPU : ¦");
                    System.out.println("YOU : Ȧ");
                    loosing(win);
                } else {
                    total++;
                    win++;
                    System.out.println("TOTAL : " + total);
                    System.out.println("CPU : ¦");
                    System.out.println("YOU : ¦");
                    winning(win);
                }
            } else if (num == 3) {
                break;
            } else {
                System.out.println("�߸��� ��!");
            }
        }
        System.out.println("--------------------");
        System.out.println("TOTAL : " + total);
        System.out.println("WIN : " + win);
        /*
         double totaldouble = total; //�·��� ����ϱ� ���� �ӽ� ����, ��ü ���� ��
         double windouble = win; // �·��� ����ϱ� ���� �ӽ� ����, �·�
         double winratedouble = (windouble / totaldouble) * 100; //�·�������ϱ� ���� �ӽ� ����, �·�
         int winrate = (int) Math.round(winratedouble);//double�� �·��� int������ �ٲ۴�.
         */
        int winrate = score(total, win);
        System.out.println("�·� : " + winrate + "%");
        System.out.println("��ǰ : " + gift(winrate, total));
    }

    public static void winning(int win) {
        System.out.println("--------------------");
        System.out.println("WIN : " + win);
        System.out.println("[�¸��ϼ̽��ϴ�.]");
    }

    public static void loosing(int win) {
        System.out.println("--------------------");
        System.out.println("WIN : " + win);
        System.out.println("[����� �����ϴ�.]");
    }

    public static int score(int total, int win) {
        int result = 0;
        result = (int) (((double) win / total) * 100);

        return result;
    }

    public static String gift(int score, int total) {
        String msg = "";

        if (total < 10) {
            System.out.println("10������ �������� �ʾҽ��ϴ�.");
        } else {
            if (score == 100) {
                msg = "����5��";
            } else if (score < 100 && score >= 90) {
                msg = "����4��";
            } else if (score < 90 && score >= 80) {
                msg = "����3��";
            } else if (score < 80 && score >= 70) {
                msg = "����2��";
            } else if (score < 70 && score >= 60) {
                msg = "����1��";
            } else {
                msg = "����";
            }
        }
        return msg;
    }
}
