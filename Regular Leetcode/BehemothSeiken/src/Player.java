import com.company.Score;
import com.company.SpeedRunTime;

import java.util.ArrayList;

public class Player {


    private String name;
    private ArrayList<Score> scores;

    public Player(String name) {
        this.name = name;
        this.scores = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Score> getScores() {
        return scores;
    }

    public void setScores(ArrayList<Score> scores) {
        this.scores = scores;
    }

    public void addScore(Score score) {
        this.scores.add(score);
    }
}
