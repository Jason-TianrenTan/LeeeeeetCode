package com.company;

public class Score {
    private String monsterName;
    private SpeedRunTime time;
    private String playerName;
    private String weapon;

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String name) {
        this.playerName = name;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public SpeedRunTime getTime() {
        return time;
    }

    public void setTime(SpeedRunTime time) {
        this.time = time;
    }

    public int compareTo(Score o) {
        return this.time.compareTo(o.time);
    }
    public Score(String monsterName, SpeedRunTime time, String playerName, String weapon) {
        this.monsterName = monsterName;
        this.time = time;
        this.playerName = playerName;
        this.weapon = weapon;
    }
}
