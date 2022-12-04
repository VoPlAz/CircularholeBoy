package net.wind.core.Config;

import java.io.File;
import net.wind.BoyLoader;

/**
 * createTime 2022/11/19 0019
 * fileName MakeConfig
 *
 * @author WindStream
 */

public class MakeConfig {
    public static boolean isFirst(){
        File configFile = new File(BoyLoader.WorkingDir+BoyLoader.sqlitSigh+"Config");
        if(configFile.exists()){
            return true;
        }else {
            return false;
        }

    }
    public static void makeconfigDir(String configName){
        File configFile = new File(BoyLoader.WorkingDir+BoyLoader.sqlitSigh+configName);
        configFile.mkdir();
    }

}
