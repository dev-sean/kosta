package ex1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 오세현
 * Document : PropertiesUtil 
 * Created on : 2014. 10. 6, 오후 3:08:04
 */
public class PropertiesUtil {
    private String protocol;
    private String userid;
    private String pass;
    private String f;

    public PropertiesUtil(String f) {
        this.f = f;
        propertiesValue();
    }

    private void propertiesValue() {
        Properties pt = new Properties();
        try {
            pt.load(new FileInputStream(f));
            //Map 에 저장
            HashMap<String,String> map = new HashMap<>();
            //향상된 for문을 사용해서 pt에서 읽어들인값을 map에 저장하시오.
            //반복문을 사용해서 map에 저장!
            for(Map.Entry<Object,Object> e : pt.entrySet()){
                map.put(e.getKey().toString(), e.getValue().toString());
            }
            protocol=map.get("protocol");
            userid=map.get("user");
            pass=map.get("pass");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getProtocol() {
        return protocol;
    }

    public String getUserid() {
        return userid;
    }

    public String getPass() {
        return pass;
    }
    
}
