package exam3;

/**
 * @author 오세현 Document : A Created on : 2014. 9. 11, 오후 2:16:21
 */
public class BoardControl {

    private BoardVO vo;
    /*
     public void info(BoardVO vo) {
     //boolean flag = true;
     if (vo.getGender().equals("M")) {
     System.out.println("경고경고");
     //    flag = false;
     }else if(vo.getGender().equals("F")){
     System.out.println("경고경고");
     //    flag = false;
     }else if(vo.getGender().equals("m")){
     System.out.println("경고경고");
     //     flag = false;
     }else if(vo.getGender().equals("f")){
     System.out.println("경고경고");
     //    flag = false;
     }else{
     this.vo = vo;
     }      

     //return flag;
     }
     */

    public boolean info(BoardVO vo) {

        if (!vo.getGender().equalsIgnoreCase("m") && !vo.getGender().equalsIgnoreCase("f")) {
            return false;
        } else {
            this.vo = vo;
            return true;
        }
    }

    public BoardVO getVo() {
        return vo;
    }
}
