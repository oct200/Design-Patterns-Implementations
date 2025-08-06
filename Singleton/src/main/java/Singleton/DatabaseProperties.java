package Singleton;

import java.io.FileInputStream;
import java.util.Properties;

public class DatabaseProperties {
    String propPath = "db.config";
    private static DatabaseProperties instance = new DatabaseProperties();
    private Properties prop;

    private DatabaseProperties(){
        prop = new Properties();
        try{
            prop.load(new FileInputStream(propPath));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static DatabaseProperties getInstance(){
        if(instance == null){
            synchronized (DatabaseProperties.class){
                if(instance == null){
                    instance = new DatabaseProperties();
                }
            }
        }
        return instance;
    }

    public Properties getProp() {
        return prop;
    }
}
