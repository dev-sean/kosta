package ex1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 오세현
 * Document : FileCopyDemo1 
 * Created on : 2014. 9. 18, 오후 1:43:52
 */
public class FileCopyDemo1_1 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        //대상 파일 읽어와서 특정 다른 디렉토리에 복사하는 작업
        //읽어오기 위한 스트림 - FileInputStream
        //작성하기 위한 스트림 - FileOutputStream
//        FileInputStream fis = null;
//        FileOutputStream fos = null;
        //2차 스트림을 사용(버퍼기능이 내장된...)
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        //원본 경로
        String path = "C:\\kosta86.zip";
        //옮길 경로
        String path2 = "C:\\kosta86\\javaStudy\\backup\\kosta86Backup2.zip";
        try {
//            fis = new FileInputStream(path);
//            fos = new FileOutputStream(path2);
            //1차 스트림의 주소로 연결해서 생성
            bis = new BufferedInputStream(new FileInputStream(path));
            bos = new BufferedOutputStream(new FileOutputStream(path2));
            int rv = 0;
            while((rv = bis.read()) != -1){//1byte씩 읽어오는 작업
                //한바이트씩 읽을 때마다 한바이트씩 작성
                bos.write(rv);
                
            }
            bos.flush();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch(IOException ex){
            ex.printStackTrace();
        }finally{//스트림 종료!
            try {
//                if(fis!=null)fis.close();
//                if(fos!=null)fos.close();
                if(bis!=null)bis.close();
                if(bos!=null)bos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}