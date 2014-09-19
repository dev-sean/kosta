package ex2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 오세현 Document : StudentRecord Created on : 2014. 9. 18, 오후 5:10:32
 */
public class StudentRecord {

    public static void main(String[] args) {
        int studentNo = 20011601;
        char grade = 'C';
        float score = (float) 72.9;
        short rank = 65;
        
        saveScore(studentNo, grade, score, rank);
        printScore(studentNo);
    }

    private static void saveScore(int studentNo, char grade, float score, short rank) {
        File dataFile = new File("record_" + studentNo + ".dat");
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(dataFile));
            dos.writeInt(studentNo);
            dos.writeChar(grade);
            dos.writeFloat(score);
            dos.writeShort(rank);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException ex) {
            }
        }
    }

    private static void printScore(int studentNo) {
        File dataFile = new File("record_" + studentNo + ".dat");
        if (!dataFile.exists()) {
            System.out.println("a record file is not exist.");
        }
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream(dataFile));
            System.out.println("studentNo : " + dis.readInt());
            System.out.println("grade : " + dis.readChar());
            System.out.println("score : " + dis.readFloat());
            System.out.println("rank : " + dis.readShort());
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dis != null) {
                    dis.close();
                }
            } catch (IOException ex) {
            }
        }
    }
}