package com.javarush.task.task22.task2208;

import java.lang.reflect.Array;
import java.util.*;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);
        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder result = new StringBuilder();
        String name = null, country = null, city = null, age = null;
        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (pair.getKey() == null || pair.getValue() == null) {
                continue;
            }
//            if (pair.getKey().equalsIgnoreCase("name")) {
//                name = pair.getKey() + " = \'" + pair.getValue() + "\'" + " and ";
//            }
//            if (pair.getKey().equalsIgnoreCase("country")) {
//                country = pair.getKey() + " = \'" + pair.getValue() + "\'" + " and ";
//            }
//            if (pair.getKey().equalsIgnoreCase("city")) {
//                city = pair.getKey() + " = \'" + pair.getValue() + "\'" + " and ";
//            }
//            if (pair.getKey().equalsIgnoreCase("age")) {
//                age = pair.getKey() + " = \'" + pair.getValue() + "\'" + " and ";
//            }
            result.append(pair.getKey())
                    .append(" = ")
                    .append("\'")
                    .append(pair.getValue())
                    .append("\'")
                    .append(" and ");
        }
//        if (name != null) {
//            result.append(name);
//        }
//        if (country != null) {
//            result.append(country);
//        }
//        if (city != null) {
//            result.append(city);
//        }
//        if (age != null) {
//            result.append(age);
//        }

        return result.length() > 0 ? result.substring(0, result.length()-5) : "";
    }
}
