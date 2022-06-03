package com.company;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] addScore = {8, 5, 2};
    ArrayList<Record> records = new ArrayList<Record>();
    HashMap<Pair<String, String>, ArrayList<Record>> specificRecords = new HashMap<>();

    public void printRecords() {
        System.out.println("记录：");
        for (Record record : records) {
            System.out.println(record.getPlayerName() + "\t" + record.getScore().getMonsterName() + "\t" +
                    record.getScore().getWeapon() + "\t" + record.getScore().getTime());
        }
    }

    private void analyzeScores() {
        specificRecords = new HashMap<>();
        for (Record record : records) {
            String monsterName = record.getScore().getMonsterName(), weapon = record.getScore().getWeapon();
            Pair<String, String> monsterWeaponPair = new Pair<String, String>(monsterName, weapon);
            if (!specificRecords.containsKey(monsterWeaponPair))
                specificRecords.put(monsterWeaponPair, new ArrayList<Record>());
            specificRecords.get(monsterWeaponPair).add(record);
        }
    }
    public void calculateScore() {
        analyzeScores();
        for (HashMap.Entry<Pair<String, String>, ArrayList<Record>> entry : specificRecords.entrySet()) {
            Pair<String, String> weaponMonsterPair = entry.getKey();
            ArrayList<Record> specificRecordList = entry.getValue();
            System.out.print(weaponMonsterPair.getValue() + " " + weaponMonsterPair.getKey() + ":\t");
            Collections.sort(specificRecordList);
            for (Record record : specificRecordList) {
                System.out.print(record.getPlayerName() + " " + record.getScore().getTime() + "\t");
            }
            System.out.println();
        }
    }

    public void calculatePlayerScore() {
        analyzeScores();
        HashMap<String, Integer> playerScore = new HashMap<>();
        for (HashMap.Entry<Pair<String, String>, ArrayList<Record>> entry : specificRecords.entrySet()) {
            Pair<String, String> weaponMonsterPair = entry.getKey();
            ArrayList<Record> specificRecordList = entry.getValue();
            Collections.sort(specificRecordList);
            int count = 0;
            for (Record record : specificRecordList) {
                if (!playerScore.containsKey(record.getPlayerName()))
                    playerScore.put(record.getPlayerName(), 0);
                 playerScore.put(record.getPlayerName(), playerScore.get(record.getPlayerName()) + addScore[count]);
                 count++;
                 if (count == 3)
                     break;
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(playerScore.entrySet());
        Collections.sort(list, new Comparator<HashMap.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        System.out.println("玩家榜单：");
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + "\t得分: " + entry.getValue());
        }
    }

    public void addRecord() {
        try {
            FileWriter writer = new FileWriter("records.txt", true);
            System.out.print("输入玩家名称：");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String playerName = br.readLine();
            System.out.print("输入怪物名称：");
            String monsterName = br.readLine();
            System.out.print("输入武器：");
            String weapon = br.readLine();
            System.out.print("输入时间：");
            String time = br.readLine();
            records.add(new Record(playerName, monsterName, weapon, time));
            writer.append(playerName + " " + monsterName + " " + weapon + " " + time + "\n");
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Main() {
        Reader reader = new Reader();
        reader.read();
        records = reader.records;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                System.out.println("输入指令：0.退出 1.添加记录 2.查看记录 3.统计榜单 4.分数排名");
                String input = br.readLine();
                if (input.equals("0"))
                    System.exit(0);
                if (input.equals("1"))
                    addRecord();
                if (input.equals("2"))
                    printRecords();
                if (input.equals("3"))
                    calculateScore();
                if (input.equals("4"))
                    calculatePlayerScore();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
	// write your code here
        new Main();
    }
}
