package ex4;
/**
 * @author ������
 * Document : OddGame 
 * Created on : 2014. 9. 17, ���� 4:26:57
 */
public class OddGame {
    public String cpuTurn(){
         String[] m = {"","Ȧ","¦"};
         int cNum = (int) (Math.random()*2)+1;
          return m[cNum];
    }
}