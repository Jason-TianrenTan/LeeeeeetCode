package com.company;

public class Main {

    public String decodeCiphertext(String encodedText, int rows) {
        int len = encodedText.length();
        int cols = len / rows;
        char[][] charMap = new char[rows][cols];
        int pt = 0;
        for (int i=0;i<rows;i++) {
            for (int j = 0; j < cols; j++)
                charMap[i][j] = encodedText.charAt(pt++);
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<cols;i++) {
            int Row = 0, Col = i;
            for (int j=0;j<rows;j++) {
                System.out.println("At (" + Row + ", " + Col + ") = " + charMap[Row][Col]);
                sb.append(charMap[Row++][Col++]);
                if (Col == cols)
                    break;
            }
            if (Row < rows)
                break;
        }
        int tail = sb.length() - 1;
        while (tail >= 0 && sb.charAt(tail) == ' ')
            tail--;
        return sb.substring(0, tail + 1);
    }

    public void work() {
        String encodedText = "";
        System.out.println(decodeCiphertext(encodedText, 5));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}