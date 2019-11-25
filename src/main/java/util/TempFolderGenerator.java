package util;

import java.io.File;

/**
 * 生成临时文件
 */
public class TempFolderGenerator {

    private static String prePath = "./临时文件/";
    private static String path = prePath + "js/operation/qxh/operationlog";

    public static void main(String[] args) {
        File file = new File(path);
        System.out.println(file.mkdirs());
    }
}
