package ex2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author ������
 * Document : MultiSocketServer 
 * Created on : 2014. 9. 25, ���� 1:47:08
 */
public class MultiSocketServer {
     //���� ����
    private ServerSocket ss;
    //���ӵ� Ŭ���̾�Ʈ�� ����
    private Socket s;
    //Ŭ���̾�Ʈ ������ ������ Collection
    private ArrayList<ServerThread> clientList;
    //���� ���ӽ� ��ȭ���� ������ ArrayList
    private ArrayList<String> conClientList;
    //�������� ip
    private String reip;

    public MultiSocketServer() {
        try {
            ss = new ServerSocket(9999);
            System.out.println("**Server Strat**");
            //Socket�� �ּҸ� ������, ������ ����
            //Thread�� �ּҵ��� ������ ArrayList ����
            clientList = new ArrayList<ServerThread>();
            conClientList = new ArrayList<>();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void execute(){
        //������ �׻� ������
        while(true){
            try {
                s = ss.accept();
                reip = s.getInetAddress().getHostAddress();
                System.out.println("Client Connected : [ " + reip + " ]");
                //Thread ��ü ����
                ServerThread ct = new ServerThread(s, this);
                clientList.add(ct);
                System.out.println("Connect number of clients : "+ clientList.size());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    void sendMsg(String str1, ServerThread aThis) {
        
        String type1 = str1;
        String str ="";
        //ArrayList�� ��ϵ� ��� client�� �о�ͼ� �ϳ��� ������ ���Ͽ� 
        //����� ��Ʈ���� ���� str�޼����� �����Ѵ�.
        str = "[" + reip +"]"+type1;
        System.out.println("msg : "+str);
        //��� �������� �ϼ��� str�� ����
        for(ServerThread c : clientList){
            c.getPw().println(str);
        }
                
    }
    public static void main(String[] args) {
        MultiSocketServer mss = new MultiSocketServer();
        mss.execute();
    }
}
