package ex1;

import java.io.File;
import java.io.IOException;

/**
 * @author 오세현
 * Document : FileCreateAndDelete 
 * Created on : 2014. 9. 18, 오전 11:49:21
 */
public class FileCreateAndDelete {
    public static void main(String[] args) throws IOException {
        File file = new File("newfile.txt");
        boolean isCreated=false;
        try {
            isCreated = file.createNewFile();
        } catch (Exception e) {
            System.out.println("Error");
        }
        
        System.out.println("new file is created : "+isCreated);
        System.out.println("file.exists() : "+file.exists());
        
        boolean isDeleted = file.delete();
        System.out.println("file is deleted : " + isDeleted);
        System.out.println("file.exits() : "+file.exists());
                
    }
}