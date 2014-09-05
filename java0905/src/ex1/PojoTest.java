package ex1;

/**
 * @author 오세현 Document : PojoTest Created on : 2014. 9. 5, 오전 11:50:22
 */
public class PojoTest {

    private int num;
    private String name;
    private boolean flag;//get이 아니라 is다.
    //boolean만 getter가 isXX형식이다.
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
