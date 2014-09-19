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
 * @author 오세현 Document : BufferedRWDemo Created on : 2014. 9. 18, 오후 3:03:35
 */
public class BufferedRWDemo {

    public static void main(String[] args) {
        //작성 후 읽어 내는 형태로 사용
        Scanner sc = new Scanner(System.in);
        System.out.print("입력 내용 :");
        String content = sc.nextLine();
        //작성하기 위한 스트림 생성
        //append mode : 파일을 지속적으로 저장하겠다.
        BufferedWriter bw = null;
        BufferedReader br = null;
        try {
            //new FileWriter("c:\\kosta86\\mytxt.txt",true);
            bw = new BufferedWriter(new FileWriter("c:\\kosta86\\mytext.txt", true));
            bw.write(content + "\r\n");
            bw.flush();
            System.out.println("작성하기 완료!");

            //읽기
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