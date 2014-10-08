package kr.or.kosta.game_exam;
/**
 * @author 오세현
 * Document : OddGame 
 * Created on : 2014. 10. 8, 오후 7:26:59
 */
public class OddGame {
    public int cpuRandom(){
        int cpunum = (int) (Math.random()*2+1);
        return cpunum;
    }
    
    public int calRate(int win, int total){
        int rate = (int) (((double)win/total)*100);        
        return rate;
    }
    
    public String printGift(int rate){
        String msg;
        if(rate == 100){
            msg = "Ferari";
        }else if(rate >= 90){
            msg = "Computer";
        }else if(rate >= 80){
            msg = "Keyboard";
        }else if(rate >= 70){
            msg = "Mouse";
        }else{
            msg = "Flower";
        }
        return msg;
    }
}
