package ex1;


import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * @author ������
 * Document : Ex1_BufferedWriter 
 * Created on : 2014. 9. 19, ���� 10:38:30
 */
public class Ex1_BufferedWriter {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        //���� ��Ʈ���� ����Ʈ ��Ʈ������ �����ϱ� ���ؼ�
        //�긴�� ��Ʈ���� �����ؼ� ����ؾ� �Ѵ�.
        //BufferedWriter bw = new BufferedWriter(new FileOutputStream("c:\\kosta86\text.txt")); ����
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\kosta86\\mytext.txt"),"euc-kr"));
        
        bw.write("�̰��� �׽�Ʈ�Դϴ�.����");
        bw.flush();
    }
}