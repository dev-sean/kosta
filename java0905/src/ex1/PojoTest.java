package ex1;

/**
 * @author ������ Document : PojoTest Created on : 2014. 9. 5, ���� 11:50:22
 */
public class PojoTest {

    private int num;
    private String name;
    private boolean flag;//get�� �ƴ϶� is��.
    //boolean�� getter�� isXX�����̴�.
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
