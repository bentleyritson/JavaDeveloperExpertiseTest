package consoleRoulette.service;

import consoleRoulette.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


@Service
public class RouletteImplementation implements Roulette{

    @Autowired
            @Qualifier("Player")
    Player gamePlayer = new Player();

    ArrayList<Player> allPlays = new ArrayList<Player>();

    int round = 0;
    int randomNumber = 0;

    @Override
    public ArrayList<Player> game() {

        int upperBound = 37;

        Random random = new Random();
        randomNumber = random.nextInt(upperBound);

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                 round++;
                System.out.println("Seconds passed " + round);
                 randomNumber = random.nextInt(upperBound);
            }
        };

        timer.scheduleAtFixedRate(task, 1000, 30000);



        for(Player selectedPlayer : allPlays){
            if (selectedPlayer.getBet() == randomNumber)
            {

                selectedPlayer.setWinnings(gamePlayer.getAmount() * 36);
            }
            else if (selectedPlayer.getBet() % 2 == 0 && randomNumber % 2 == 0){

                selectedPlayer.setWinnings(gamePlayer.getAmount() * 2);
            }
            else if (selectedPlayer.getBet() % 2 != 0 && randomNumber % 2 != 0){

                selectedPlayer.setWinnings(gamePlayer.getAmount() * 2);
            }
            else
            {
                selectedPlayer.setWinnings(0.00f);
            }
        }



        return allPlays;
    }



    @Override
    public Player getInput() throws IOException {
        game();

        String line;
        ArrayList<String> players = new ArrayList<String>();

        FileReader file = new FileReader("Main/src/src/main/java/src/main/java/consoleRoulette/resource/player.txt");
        BufferedReader bufferedReader = new BufferedReader(file);

        while((line = bufferedReader.readLine()) != null)
        {
            players.add(line);

        }

        Scanner in = new Scanner(System.in);




        for(String  player: players){

            int bet;
            float amount;
            String response;

            System.out.println(player);
            System.out.println("Please state your bet number from 1 to 36:");
            bet = in.nextInt();
            gamePlayer.setBet(bet);
            System.out.println(gamePlayer.getBet());

            System.out.println("Please state the amount to bet on number : " );
            gamePlayer.setAmount(in.nextFloat());
            System.out.println(gamePlayer.getAmount());

            allPlays.add(gamePlayer);

            System.out.println("Do you wish to place another bet? reply 'Y' for yes and 'N' for no.");
            response = in.next();
            System.out.println(response);

            if (response.equalsIgnoreCase("Y")) {

               do  {
                    System.out.println(player + "xxxxxxxxxx");
                    System.out.println("Please state your bet number from 1 to 36:");
                    gamePlayer.setBet(in.nextInt());
                    System.out.println(gamePlayer.getBet());

                    System.out.println("Please state the amount to bet on number : " /*+ gamePlayer.getBet()*/);
                    gamePlayer.setAmount(in.nextFloat());
                    System.out.println(gamePlayer.getAmount());

                    allPlays.add(gamePlayer);

                    System.out.println("Do you wish to place another bet? reply 'Y' for yes and 'N' for no.");
                    response = in.next();
                    System.out.println(response);

                }while (response.equalsIgnoreCase("Y"));

            }


        }



        System.out.println("Bets are closed the game will now begin");
        System.out.println("");
        game();



        return null;
    }

    @Override
    public Player displayWinnings() {
        return null;
    }
}
