package exam3;

/**
 * @author ������ Document : A Created on : 2014. 9. 11, ���� 2:16:21
 */
public class BoardControl {

    private BoardVO vo;

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
