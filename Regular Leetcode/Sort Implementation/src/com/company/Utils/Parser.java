package com.company.Utils;

import java.util.ArrayList;

public class Parser {

    private static boolean checkLegal(char c) {
        return (c >= '0' && c <='9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public static ArrayList<String> parseLine(String line) {
        ArrayList<String> result = new ArrayList<>();
        char[] chars = line.toCharArray();
        StringBuilder currentWord = new StringBuilder();
        for (int index = 0; index < chars.length; index++) {
            if (checkLegal(chars[index]))
                currentWord.append(chars[index]);
            else {
                if (currentWord.length() > 0)
                    result.add(currentWord.toString());
                currentWord = new StringBuilder();
            }
        }
        if (currentWord.length() > 0)
            result.add(currentWord.toString());
        return result;
    }
}