package com.maintec.fincore.util;

public class Util {

    public static String fixLength(String code, int length) {
        if(code.length() > length)
            return null;

        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < length - code.length(); i++) {
            buffer.append("0");
        }
        code = buffer.append(code).toString();
        return code;
    }
}
