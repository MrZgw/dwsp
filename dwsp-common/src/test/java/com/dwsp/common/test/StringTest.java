package com.dwsp.common.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StringTest {

    public static void main(String[] args) {
        System.out.println(testStr("{[]}{()}"));
    }

    public static Boolean testStr(String str) {
        if (str.isEmpty()) {
            return Boolean.TRUE;
        }
        if (str.length() % 2 != 0) {
            return Boolean.FALSE;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ')' && '(' == chars[i - 1]) {
                chars[i] = '0';
                chars[i - 1] = '0';
            }
            if (chars[i] == '}' && '{' == chars[i - 1]) {
                chars[i] = '0';
                chars[i - 1] = '0';
            }
            if (chars[i] == ']' && '[' == chars[i - 1]) {
                chars[i] = '0';
                chars[i - 1] = '0';
            }
        }
        str = new String(chars).replace("0", "");
        str = str.replace("()", "").replace("{}", "").replace("[]","");
        if (str.length() > 0) {
            return Boolean.FALSE;
        } else {
            return Boolean.TRUE;
        }

    }
}
