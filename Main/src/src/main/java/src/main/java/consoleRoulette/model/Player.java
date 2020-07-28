package consoleRoulette.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component()
public class Player {

    String name = "";
    String bet = "";
    float amount = 0.0f;
    float winnings = 0.0f;
    String winLoose = " ";




    public String getWinLoose() {
        return winLoose;
    }

    public void setWinLoose(String winLoose) {
        this.winLoose = winLoose;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBet() {
        return bet;
    }

    public void setBet(String bet) {
        this.bet = bet;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getWinnings() {
        return winnings;
    }

    public void setWinnings(float winnings) {
        this.winnings = winnings;
    }








}
