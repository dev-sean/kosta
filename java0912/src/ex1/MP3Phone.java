package ex1;
/**
 * @author ������
 * Document : MP3Phone 
 * Created on : 2014. 9. 12, ���� 9:59:47
 */
public class MP3Phone extends Ex1_Super{
    private int size; // ����뷮
    public MP3Phone(String model, String num, int chord, int size){
        super.chord = chord;
        super.model = model;
        setNumber(num);
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
