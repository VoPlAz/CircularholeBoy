package net.wind.utils.ResourcesUtils;

import net.wind.BoyLoader;

import java.io.InputStream;

/**
 * createTime 2023/1/17 0017
 * fileName ResourcesUtils
 *
 * @author WindStream
 */

public class ResourcesUtils {
    public static InputStream getResourceAsStream(String Path){
        InputStream inputStream = BoyLoader.class.getClassLoader().getResourceAsStream(Path);
        return inputStream;
    }

}
