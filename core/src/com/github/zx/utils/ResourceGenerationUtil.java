package com.github.zx.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;

/**
 * @Author: zx
 * @Date: 2019/7/31 17:14
 */
public class ResourceGenerationUtil {

    static final String RESOURCE_PATH = "core/assets";
    static final String OUT_PATH = "src/com/github/zx/utils/";
    static final String GenClassName = "AssetsNameSpace";
    static Map<String, String> resourceMap = new HashMap<String, String>();

    public static void main(String[] args) throws Exception {
        File file = new File(RESOURCE_PATH);
        if (!file.exists()) {
            throw new Exception("The assets file is not found");
        }
        scanChildFile(RESOURCE_PATH);
        resourceGeneration();
    }

    public static void scanChildFile(String path) throws Exception {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    //System.out.println("目录：" + files[i].getPath());
                    scanChildFile(files[i].getPath());
                } else {
                    String key = files[i].getPath().replaceAll(" ","").replaceAll("-","").replaceAll("\\(","").replaceAll("\\)","").replaceAll(Matcher.quoteReplacement(File.separator), Matcher.quoteReplacement("$"))
                            .replaceAll("\\.",Matcher.quoteReplacement("$"));
                    if (resourceMap.containsKey(key)) {
                        throw new Exception("");
                    }
                    resourceMap.put(key,files[i].getPath().replaceAll("\\\\","/"));
                    System.out.println("文件：" + key);
                }

            }
        } else {
            //System.out.println("文件：" + file.getPath());
        }
    }

    public static boolean resourceGeneration(){
        String fieldFixedName = "public static final String";
        String targetPackage = "package com.github.zx.utils;";
        StringBuilder stringBuilder = new StringBuilder();
        String enterString = System.getProperty("line.separator");
        stringBuilder.append(targetPackage).append(enterString);
        stringBuilder.append("public class "+GenClassName+" {").append(enterString);

        Set<Map.Entry<String, String>> entries = resourceMap.entrySet();
        for(Map.Entry<String, String> entry:entries){
            String key=entry.getKey();
            String value=entry.getValue();
            stringBuilder.append(enterString);
            stringBuilder.append("\t").append(fieldFixedName).append(" ").append(key).append(" ").append("=").append(" ").append('"').append(value).append('"').append(";");
            stringBuilder.append(enterString);
        }
        stringBuilder.append("}");
        writeFile(new File(RESOURCE_PATH).getParentFile().getAbsolutePath()+File.separator+OUT_PATH+GenClassName+".java",stringBuilder.toString());
        return true;
    }

    public static boolean writeFile(String path, String txt) {
        File file = new File(path);

        try {
            file.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(file,false));
            out.write(txt);
            out.flush();
            out.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
