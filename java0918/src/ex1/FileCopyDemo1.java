package ex1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ������
 Document : FileCopyDemo1 
 Created on : 2014. 9. 18, ���� 1:43:52
 */
public class FileCopyDemo1 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        //��� ���� �о�ͼ� Ư�� �ٸ� ���丮�� �����ϴ� �۾�
        //�о���� ���� ��Ʈ�� - FileInputStream
        //�ۼ��ϱ� ���� ��Ʈ�� - FileOutputStream
        FileInputStream fis = null;
        FileOutputStream fos = null;
        //���� ���
        String path = "C:\\kosta86.zip";
        //�ű� ���
        String path2 = "C:\\kosta86\\javaStudy\\backup\\kosta86Backup.zip";
        try {
            fis = new FileInputStream(path);
            fos = new FileOutputStream(path2);
            int rv = 0;
            while((rv = fis.read()) != -1){//1byte�� �о���� �۾�
                //�ѹ���Ʈ�� ���� ������ �ѹ���Ʈ�� �ۼ�
                fos.write(rv);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch(IOException ex){
            ex.printStackTrace();
        }finally{//��Ʈ�� ����!
            try {
                if(fis!=null)fis.close();
                if(fos!=null)fos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}