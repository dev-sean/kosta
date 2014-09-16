package ex1;
/**
 * @author ������
 * Document : UserException 
 * Created on : 2014. 9. 16, ���� 10:49:17
 */
public class UserException extends Exception{
    private int port = 772;
    
    public UserException(String message){//�޼����� �޾� Exception�� ����
        super(message);//����ó���� �޼���!
    }

    public UserException(String message, int port) {//�޼����� port�� �ʱ�ȭ
        super(message);
        this.port=port;
    }
    
    public int getPort(){
        return port;
    }
}