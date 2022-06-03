package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    /**
     * P     I    N (0)
     * A   L S  I G (1, 5), 7, 11
     * Y A   H R    (2, 4), (8, 10), 14
     * P     I      (3)
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        int partLen = numRows * 2 - 2;
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i += partLen)
            sb.append(s.charAt(i));
        for (int row = 1; row < numRows - 1; row++) {
            //for row, mod = row or partLen - row
            int i = row;
            while (i < len) {
                sb.append(s.charAt(i));
                int next = i + (partLen - 2 * row);
                if (next < len)
                    sb.append(s.charAt(next));
                i += partLen;
            }
        }
        for (int i = numRows - 1; i < len; i += partLen)
            sb.append(s.charAt(i));
        return sb.toString();
    }

    public void work() {
        System.out.println(convert("PAYPALISHIRING", 9));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
