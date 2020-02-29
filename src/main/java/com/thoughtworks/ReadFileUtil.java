package com.thoughtworks;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ReadFileUtil {
    public static String readFile(String path) {
        File file = new File(path);
        StringBuilder result = new StringBuilder();
        try (InputStream input = new FileInputStream(file)
        ) {
            int byteRead;
            while ((byteRead = input.read()) != -1) {
                if(byteRead > 0xf){
                    result.append((char) byteRead);
                }
            }
            return result.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
