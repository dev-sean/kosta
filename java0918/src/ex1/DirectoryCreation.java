package ex1;

import java.io.File;

/**
 * @author 오세현
 * Document : DirectoryCreation 
 * Created on : 2014. 9. 18, 오전 11:55:06
 */
public class DirectoryCreation {
    public static void main(String[] args) {
        String baseDir = ".\\src\\";
        
        File dir1 = new File(baseDir + "dir1");
        boolean isMade = dir1.mkdir();
        System.out.println("new directory is made : "+isMade);
        
        File dir2 = new File(baseDir +"parent\\dir2");
        isMade = dir2.mkdirs();
        System.out.println("new directory is made : "+isMade);
        
        
        dir2.delete();
                
        dir1.delete();
    }
}