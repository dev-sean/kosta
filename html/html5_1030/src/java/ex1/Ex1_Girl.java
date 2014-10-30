package ex1;
/**
 * @author 오세현
 * Document : Ex1_Girl 
 * Created on : 2014. 10. 30, 오후 1:37:07
 */
public class Ex1_Girl {
    public String[] getGirlGroup(String code) {
        if(code.equals("1")){
            String[] girl = {"유라","혜리","소진","민아"};
            return girl;
        }else{
            String[] girl = {"보람","찌연","효민","은정","큐리","소연"};
            return girl;
        }
    }     
}