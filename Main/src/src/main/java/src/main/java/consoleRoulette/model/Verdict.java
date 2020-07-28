package consoleRoulette.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class Verdict {

    Integer roundNumber = 0;
    Integer gameWinNumber = 0;
    ArrayList<Player> plays = new ArrayList<Player>();

    public Integer getGameWinNumber() {
        return gameWinNumber;
    }

    public void setGameWinNumber(Integer gameWinNumber) {
        this.gameWinNumber = gameWinNumber;
    }

    public Integer getRoundNumber() {
        return roundNumber;
    }


    public void setRoundNumber(Integer roundNumber) {
        this.roundNumber = roundNumber;
    }

    public ArrayList<Player> getPlays() {
        return plays;
    }

    public void setPlays(ArrayList<Player> plays) {
        this.plays = plays;
    }

    static public class verdictArchive                                         //Verdict$verdictArchive
    {


        public ArrayList<Verdict> verdictList = new ArrayList<Verdict>();



        public ArrayList<Verdict> getVerdictList() {
            return verdictList;
        }

        public void setVerdictList(ArrayList<Verdict> verdictList) {
            this.verdictList = verdictList;
        }
    }
}

