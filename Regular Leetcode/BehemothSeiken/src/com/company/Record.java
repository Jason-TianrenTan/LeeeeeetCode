package com.company;

public class Record implements Comparable<Record>{

    @Override
    public int compareTo(Record o) {
        return this.score.compareTo(o.score);
    }

    private String playerName;
    private Score score;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Record(String playerName, String monsterName, String weapon, String time) {
        this.playerName = playerName;
        this.score = new Score(monsterName, new SpeedRunTime(time), playerName, weapon);
    }

    public Record(String readString) {
        //aira 钢 弓箭 02'34''33
        String[] parts = readString.split(" ");
        playerName = parts[0];
        String monsterName = parts[1];
        String weapon = parts[2];
        String timeString = parts[3];
        try {
            score = new Score(monsterName, new SpeedRunTime(timeString), playerName, weapon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
