package ex1;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ������ Document : Ex2_Server Created on : 2014. 9. 24, ���� 10:53:16
 */
//���������� �и��� ��ǻ�Ϳ��� ���������� ������ ������ü�� �����Ѵ�.
//���񽺿� ����ϰ� �־�� �Ѵ�.
public class Ex2_Server {

    private ServerSocket ss;

    public Ex2_Server() {
        try {
            ss = new ServerSocket(8989);
            System.out.println("��������");
            while (true) {
                Socket s = ss.accept();//blocking
                //������ Ŭ���̾�Ʈ�� ������ �����Ǹ� ���
                String ip = s.getInetAddress().getHostAddress();
                System.out.println("Server Log1 :" + ip);
                
                //����� Socket�� ����ؼ� Ŭ���̾�Ʈ�� ��û�� �ޱ� ����
                //input ��Ʈ���� ������ �� �ٽ� Ŭ���̾�Ʈ����
                //������ ���ֱ� ���� output ��Ʈ���� �����ؼ�
                //response �Ѵ�.
                InputStream is =s.getInputStream();
                OutputStream os = s.getOutputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                // PrintWriter�� Ư¡
                // - 1�� ��Ʈ��, 2�� ��Ʈ��(Buffer�� ���)
                // - ����Ʈ ��Ʈ��, ���� ��Ʈ�� ���� ��� ����� ����
                //�����÷��� : �ڵ����� ���۸� ����ִ� ������ �Ѵ�.
                //���ڿ��� ���� ������ ����Ʈ��Ʈ������ ���� �ϴ� ���� ����!
                PrintWriter pw = new PrintWriter(new BufferedOutputStream(os),true);
                
                //Ŭ���̾�Ʈ�� ��û�� �޾Ƶ���.
                String msg = br.readLine();
                msg = "["+ip+"] : "+msg;
                System.out.println(msg);
                //(��û�� ���� ����)
                pw.println("�ݰ����ϴ�."+msg+"!");
            }
        } catch (IOException ex) {
            System.out.println("port�� ������Դϴ�.");
        }
    }
    public static void main(String[] args) {
        new Ex2_Server();
    }
}