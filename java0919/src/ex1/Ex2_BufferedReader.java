package ex1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ������
 * Document : Ex2_BufferedReader 
 * Created on : 2014. 9. 19, ���� 10:48:12
 */
public class Ex2_BufferedReader {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("c:\\kosta86\\mytext.txt")));
        String rv = null;
        while((rv = br.readLine()) != null){
            System.out.println(rv);
        }
        br.close();
    }
}