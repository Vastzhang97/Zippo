package util;

import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * 生成临时文件
 */
public class TempFolderGenerator {

    private static String prePath = "./临时文件/";
    private static String suffixPath = prePath + "resources\\META-INF\\resources\\static\\console\\js\\eip\\link\\company";

    public static void main(String[] args) throws UnsupportedEncodingException {
        File file = new File(new String(suffixPath.getBytes(), "utf-8"));
        System.out.println(file.mkdirs());
    }
}
