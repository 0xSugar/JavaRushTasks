package com.javarush.task.task21.task2101;

import java.math.BigInteger;
import java.util.Arrays;

/*
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] result = new byte[4];
        for (int i = 0; i < result.length; i++) {
            result[i] = (byte) (ip[i] & mask[i]);
        }
        return result;
    }

    public static void print(byte[] bytes) {
        String data_out = new BigInteger(1, bytes).toString(2);
        System.out.println(
                data_out.substring(0, data_out.length()-24) + " " +
                data_out.substring(data_out.length()-24, data_out.length()-16) + " " +
                data_out.substring(data_out.length()-16, data_out.length()-8) + " " +
                data_out.substring(data_out.length()-8));
    }
}
/*
for (int i = 0; i < bytes.length; i++) {
    StringBuilder line = new StringBuilder(Integer.toBinaryString(bytes[i]));
    String res;
    if (line.length() < 8) {
        while (line.length() < 8) {
            line.insert(0, "0");
        }
        res = line.toString();
    } else if (line.length() > 8) {
        res =  line.toString().substring(line.length()-8, line.length());
    } else {
        res =  line.toString();
    }
    if (i == bytes.length-1) {
        System.out.println(res);
        break;
    }
    System.out.print(res + " ");
}
 */