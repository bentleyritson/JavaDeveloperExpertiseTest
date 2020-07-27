package consoleRoulette.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("Player")
public class Player {

    String name;
    Integer bet;
    float amount;
    float winnings;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBet() {
        return bet;
    }

    public void setBet(Integer bet) {
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
