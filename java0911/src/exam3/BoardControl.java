package exam3;

/**
 * @author ������ Document : A Created on : 2014. 9. 11, ���� 2:16:21
 */
public class BoardControl {

    private BoardVO vo;
    /*
     public void info(BoardVO vo) {
     //boolean flag = true;
     if (vo.getGender().equals("M")) {
     System.out.println("�����");
     //    flag = false;
     }else if(vo.getGender().equals("F")){
     System.out.println("�����");
     //    flag = false;
     }else if(vo.getGender().equals("m")){
     System.out.println("�����");
     //     flag = false;
     }else if(vo.getGender().equals("f")){
     System.out.println("�����");
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
