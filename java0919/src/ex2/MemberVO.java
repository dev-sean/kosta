package ex2;

import java.io.Serializable;

/**
 * @author ������
 * Document : MemberVO 
 * Created on : 2014. 9. 19, ���� 11:22:48
 */
public class MemberVO implements Serializable{
    private String name;
    //����ȭ�� ���ܽ��Ѷ�
    transient private String addr;
    private int age;
    private boolean flag;
    private long times;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public long getTimes() {
        return times;
    }

    public void setTimes(long times) {
        this.times = times;
    }
}
