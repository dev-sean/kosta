package ex1;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class PCServer2 {

    private ServerSocket sS;
    private Socket s;
    private Vector<PCClient2> clientList; // Ŭ���̾�Ʈ ����Ʈ

    public PCServer2(int port) {
        System.out.println("**������ �����մϴ�");
        try {
            sS = new ServerSocket(port); // ���޹��� ��Ʈ�� �������� ����
            
            clientList = new Vector<PCClient2>(); // ������ ����Ʈ ������ ���� ����
        } catch (IOException ex) {
            System.out.println("�������� ������ IOException ����ó��");
        }
    }

    public void exe() {

        while (true) {
            // ���� Ŭ���̾�Ʈ�� ��ٸ�
            try {
                s = sS.accept();
                System.out.println("Client ����");

            } catch (IOException ex1) {
            }

            // ������ �Ǹ� ������ �����Ͽ� Ŭ���̾�Ʈ ��ü ����
            PCClient2 ct = new PCClient2(s, this);
            clientList.add(ct); // ������ ����Ʈ�� ���� Ŭ���̾�Ʈ ��ü �߰�
        }
    }

    // Ŭ���̾�Ʈ ���� �޼���
    public void removeClient(PCClient2 c) {
        clientList.remove(c);
    }

    // ���� ������ ��ȭ����� ������ ����
    Vector<String> conClientList = new Vector<String>();

    // �޽��� ���� �޼���
    public void sendMsg(String s1, String s2, String s3, String s4, PCClient2 ct) {
        String type1 = s1; // enter, exit, draw, whisper, talk
        String type2 = s2; // nickName, color, all, someone
        String type3 = s3; // none, x, speaker
        String type4 = s4; // none, y, say
        String str = "";
        PCClient2 client = ct;

        System.out.println("type1:::::::::::::::"+type1+"x:"+type3+"y"+type4);
           if (type1.equals("draw")) { // �׸���
                str = "draw/" + type2 + "/" + type3 + "/" + type4;
                System.out.println("STR:"+str);
            } 

            // ��� �������� �ϼ��� �޽����� ����
            for (PCClient2 c : clientList) {
                c.getPw().println(str);
            }
     //   }

    }

    public static void main(String[] args) {
        PCServer2 sv = new PCServer2(7777);
        sv.exe();
    }


}
