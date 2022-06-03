package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    public void work() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean playing;
        while (true) {
            System.out.println("小胖子猜数字ver1.0 beta");
            System.out.println("我有一个数字(0-100)，每次猜一个数字我告诉你大了还是小了");
            System.out.println("如果能在5次内猜出来会有特殊奖励!");
            Random random = new Random();
            int ans = random.nextInt(101);
            int guess = 0;
            playing = true;
            while (playing) {
                try {
                    String str = reader.readLine();
                    if (!isNumber(str)) {
                        System.out.println("小笨蛋 只能输入数字");
                    } else {
                        int number = Integer.parseInt(str);
                        if (number < 0 || number > 100)
                            System.out.println("小笨蛋 只能是0-100啊");
                        else {
                            guess++;
                            if (number == ans) {
                                System.out.println("你猜对了！");
                                if (guess >= 10)
                                    System.out.println("加把劲，你可是花了" + guess + "次啊");
                                if (guess >=8)
                                    System.out.println("努努力，这次花了" + guess + "次");
                                if (guess >= 6)
                                    System.out.println("非常厉害了！你只花了" + guess + "次");
                                if (guess <= 5)
                                    System.out.println("太牛了 你可真是个小胖子！你只花了" + guess + "次!");
                                System.out.println("是否再来一轮？(Y/N)");
                                playing = false;
                                String res = reader.readLine();
                                if (res.equals("N") || res.equals("n"))
                                    System.exit(0);
                                guess = 0;
                            } else {
                                if (number > ans) {
                                    System.out.println("太大了");
                                } else System.out.println("小了哦");
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
