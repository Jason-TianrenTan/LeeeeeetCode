package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {

    public static void work() {
        double totalScore = 0, totalCredit =0;
        String input = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                input = reader.readLine();
                if (input.startsWith("/"))
                    break;
                String[] parts = input.split(" ");
                double score = Double.parseDouble(parts[0]), credit = Double.parseDouble(parts[1]);
                totalScore += score * credit;
                totalCredit += credit;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(totalScore/totalCredit);
    }


    public static void main(String[] args) {
	// write your code here
        work();
    }
}
