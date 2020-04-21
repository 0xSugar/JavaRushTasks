package com.javarush.task.task20.task2003;

import java.util.*;
import java.io.*;

/*
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file = rd.readLine();
        rd.close();

        FileInputStream fis = new FileInputStream(file);
        load(fis);

        FileOutputStream fos = new FileOutputStream(file);
        save(fos);
        fos.flush();

        fis.close();
        fos.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            prop.setProperty(entry.getKey(), entry.getValue());
        }
        prop.store(outputStream, "");

//        PrintWriter writer = new PrintWriter(outputStream);
//        for (Map.Entry<String, String> enter : properties.entrySet()) {
//            writer.println(enter.getKey() + "=" + enter.getValue());
//        }
//        writer.flush();
    }

    public void load(InputStream inputStream) throws Exception {
        Properties prop = new Properties();
        prop.load(inputStream);
        for (String key : prop.stringPropertyNames()) {
            properties.put(key, prop.getProperty(key));
        }
//        for (Map.Entry<Object, Object> entry : prop.entrySet()) {
//            properties.put((String) entry.getKey(), (String) entry.getValue());
//        }
    }

    public static void main(String[] args) {

    }
}

//    public void fillInPropertiesMap() throws IOException {
//        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
//        String file = rd.readLine();
//        rd.close();
//        if (file.matches("^.+\\.properties$")) {
//            rd = new BufferedReader(new FileReader(file));
//            while (rd.ready()) {
//                String line = rd.readLine();
//                if (line.charAt(0) == '!' || line.charAt(0) == '#') {
//                    continue;
//                }
//                String[] split = (line.contains("=") ? line.split("=") : line.split(":"));
//                String key = split[0].trim();
//                String value = split[1].trim();
//                properties.put(key, value);
//            }
//            rd.close();
//        }
//    }