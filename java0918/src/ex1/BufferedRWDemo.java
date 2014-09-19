package ex1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ������ Document : BufferedRWDemo Created on : 2014. 9. 18, ���� 3:03:35
 */
public class BufferedRWDemo {

    public static void main(String[] args) {
        //�ۼ� �� �о� ���� ���·� ���
        Scanner sc = new Scanner(System.in);
        System.out.print("�Է� ���� :");
        String content = sc.nextLine();
        //�ۼ��ϱ� ���� ��Ʈ�� ����
        //append mode : ������ ���������� �����ϰڴ�.
        BufferedWriter bw = null;
        BufferedReader br = null;
        try {
            //new FileWriter("c:\\kosta86\\mytxt.txt",true);
            bw = new BufferedWriter(new FileWriter("c:\\kosta86\\mytext.txt", true));
            bw.write(content + "\r\n");
            bw.flush();
            System.out.println("�ۼ��ϱ� �Ϸ�!");

            //�б�
            System.out.println("====================================");
            br = new BufferedReader(new FileReader("c:\\kosta86\\mytext.txt"));
            String rv = null;
            while ((rv = br.readLine()) != null) {
                System.out.println(rv);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                 e.printStackTrace();
            }
        }
    }
}