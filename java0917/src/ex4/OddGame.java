package ex4;
/**
 * @author ¿À¼¼Çö
 * Document : OddGame 
 * Created on : 2014. 9. 17, ¿ÀÈÄ 4:26:57
 */
public class OddGame {
    public String cpuTurn(){
         String[] m = {"","È¦","Â¦"};
         int cNum = (int) (Math.random()*2)+1;
          return m[cNum];
    }
}