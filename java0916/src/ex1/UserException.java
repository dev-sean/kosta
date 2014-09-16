package ex1;
/**
 * @author 오세현
 * Document : UserException 
 * Created on : 2014. 9. 16, 오전 10:49:17
 */
public class UserException extends Exception{
    private int port = 772;
    
    public UserException(String message){//메세지를 받아 Exception에 전달
        super(message);//예외처리의 메세지!
    }

    public UserException(String message, int port) {//메세지와 port를 초기화
        super(message);
        this.port=port;
    }
    
    public int getPort(){
        return port;
    }
}