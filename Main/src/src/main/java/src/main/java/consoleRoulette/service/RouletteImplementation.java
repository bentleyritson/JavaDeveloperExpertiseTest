package consoleRoulette.service;


import consoleRoulette.model.Player;
import consoleRoulette.model.Verdict;

import java.io.*;
import java.util.*;


public class RouletteImplementation implements Roulette{
    //Initializations for the Game

    ArrayList<Player> allPlays = new ArrayList<Player>();       //Arrays of player records.
    Verdict verdict = new Verdict();                            //Archive of games played
    Verdict.verdictArchive verdictArchive = new Verdict.verdictArchive();

    //Variables needed to keep track of rounds.
    int round = 0;
    int randomNumber = 1;

    //The actual game play logic.
    @Override
    public Verdict game() throws IOException {

        Scanner in = new Scanner(System.in);

        int upperBound = 37;


        Random random = new Random();
        randomNumber = random.nextInt(upperBound);
        ArrayList<Player> playerVerdicts = new ArrayList<Player>();

        //Get user bets from console.

        //Timer for round
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                round++;
                System.out.println("Round " + round + " will now begin");
                randomNumber = random.nextInt(upperBound);
                System.out.println("The random number is : " + randomNumber);

                for (Player selectedPlayer : allPlays) {


                    if (Integer.parseInt(selectedPlayer.getBet()) == randomNumber) {

                        selectedPlayer.setWinnings(selectedPlayer.getAmount() * 36);
                        selectedPlayer.setWinLoose("WIN");
                        System.out.println( selectedPlayer.getName()+ " " +selectedPlayer.getWinLoose() + "'S " + selectedPlayer.getWinnings());

                    } else if (selectedPlayer.getBet().equalsIgnoreCase("even")) {

                        selectedPlayer.setWinnings(selectedPlayer.getAmount() * 2);
                        selectedPlayer.setWinLoose("WIN");
                        System.out.println( selectedPlayer.getName()+ " " +selectedPlayer.getWinLoose() + "'S " + selectedPlayer.getWinnings());

                    } else if (selectedPlayer.getBet().equalsIgnoreCase("odd")) {

                        selectedPlayer.setWinnings(selectedPlayer.getAmount() * 2);
                        selectedPlayer.setWinLoose("WIN");
                        System.out.println( selectedPlayer.getName()+ " " +selectedPlayer.getWinLoose() + "'S " + selectedPlayer.getWinnings());
                    } else {
                        selectedPlayer.setWinnings(0.00f);
                        selectedPlayer.setWinLoose("LOSE");
                        System.out.println( selectedPlayer.getName()+ " " +selectedPlayer.getWinLoose() + "ES " + selectedPlayer.getWinnings());
                    }

                    playerVerdicts.add(selectedPlayer);

                }
                verdict.setRoundNumber(round);
                verdict.setPlays(playerVerdicts);

                verdict.setGameWinNumber(randomNumber);


                verdictArchive.verdictList.add(verdict);

                System.out.println("");
                System.out.println("Do does anyone wish to change bets? 'Y' for YES 'N' for NO. To Exit the game type exit.");

                if (in.next().equalsIgnoreCase("y")) {
                    timer.cancel();
                    try {
                        getInput();
                        displayWinnings();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (in.next().equalsIgnoreCase("n")) {
                    System.out.println(" ");
                    System.out.println("The game shall continue");
                    System.out.println(" ");
                    try {
                        displayWinnings();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (in.next().equalsIgnoreCase("exit")) {
                    try {
                        timer.cancel();
                        displayWinnings();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }


            }


        };
        timer.scheduleAtFixedRate(task, 1000, 3000); // I have made this 3 seconds for demo purposes.






        return verdict;
    }


   /* //Check to see if the bet is numeric or a ODD or EVEN bet.
    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
*/
    //Getting the user input from the Command Line.
    @Override
    public ArrayList<Player> getInput() throws IOException {


        String line;
        ArrayList<String> players = new ArrayList<String>();

        FileReader file = new FileReader("Main/src/src/main/java/src/main/java/consoleRoulette/resource/inputFile1.txt");
        BufferedReader bufferedReader = new BufferedReader(file);

        while((line = bufferedReader.readLine()) != null)
        {
            players.add(line);

        }

        Scanner in = new Scanner(System.in);


        for(String  player: players){

            Player playRecord1 = new Player();

            String response;

            System.out.println("Welcome :" + player);
            playRecord1.setName(player);
            System.out.println("Please state your bet number from 1 to 36 or 'ODD' and 'EVEN' to beat the odds.");
            playRecord1.setBet(in.next());
            System.out.println("You entered " + playRecord1.getBet());

            System.out.println("Please state the amount to bet on : " + playRecord1.getBet());
            playRecord1.setAmount(in.nextFloat());
            System.out.println("You entered " + playRecord1.getAmount());


            System.out.println("Do you wish to place another bet? reply 'Y' for yes and 'N' for no.");
            response = in.next();
            System.out.println("You entered " + response);

            System.out.println("Goodbye " + playRecord1.getName());
            allPlays.add(playRecord1);

            if (response.equalsIgnoreCase("Y")) {

               do  {
                   Player playRecord2 = new Player();
                    playRecord2.setName(player);
                    System.out.println("Please state your bet number from 1 to 36 or 'ODD' and 'EVEN' to beat the odds.");
                    playRecord2.setBet(in.next());
                    System.out.println("You entered " + playRecord2.getBet());

                    System.out.println("Please state the amount to bet on : " + playRecord2.getBet());
                    playRecord2.setAmount(in.nextFloat());
                    System.out.println("You entered " + playRecord2.getAmount());

                    allPlays.add(playRecord2);


                    System.out.println("Do you wish to place another bet? reply 'Y' for yes and 'N' for no.");
                    response = in.next();
                    System.out.println("You entered " + response);

                }while (response.equalsIgnoreCase("Y"));

            }

        }



        System.out.println("All Bets are closed the game will now begin");
        System.out.println("");
        System.out.println("");
        System.out.println("");

        return allPlays;
    }

    //Method to display winnings on the console.
    @Override
    public Player displayWinnings() throws IOException {
        System.out.println("The results of the game are: ");
        System.out.println(" ");

        Player p = new Player();
        allPlays.add(p);
        allPlays.add(p);
        verdict.setPlays(allPlays);


        float winning ;
        String outcome ;
        String bet;
        String name;

        String column1Format = "%-15s";
        String column2Format = "%-15s";
        String column3Format = "%-15s";
        String column4Format = "%-15s";
        String formatInfo = column1Format + " " + column2Format + " " + column3Format + " " + column4Format;

        FileWriter writer = new FileWriter("Main/src/src/main/java/src/main/java/consoleRoulette/resource/outPut1.txt",false); //File writing object
        BufferedWriter bWriter = new BufferedWriter(writer);

        writer.write("Winning Number is : " + verdict.getGameWinNumber());
        writer.write("\r\n");
        writer.write(String.format(formatInfo,"Player " , "Bet" , "Outcome" ,"Winnings" ));
        writer.write("\r\n");
        writer.write("---------------------------------------------------------------");
        writer.write("\r\n");

        System.out.format(String.format(formatInfo, "Player", "Bet", "Outcome", "Winnings"));
        System.out.println(" ");


        for(Verdict eachVerdict : verdictArchive.verdictList)

        {

            for(int i = 0; i < eachVerdict.getPlays().size()-2; i++)
            {

                            name = eachVerdict.getPlays().get(i).getName();
                            winning = eachVerdict.getPlays().get(i).getWinnings();
                            outcome = eachVerdict.getPlays().get(i).getWinLoose();
                            bet = eachVerdict.getPlays().get(i).getBet();

                        String format = String.format(formatInfo, name, bet, outcome, winning);
                        System.out.format(format);
                        System.out.println(" ");

                        writer.write("\r\n");
                        writer.write(format);
                        writer.write("\r\n");

                }


            }



        writer.close();
        return null;
    }

    //Optional question displaying input to and from the console.
    public void inputOutput() throws IOException {
        FileReader reader = new FileReader("Main/src/src/main/java/src/main/java/consoleRoulette/resource/inputFile2.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line = null;

        String column1Format = "%-15s";
        String column2Format = "%-10s";
        String column3Format = "%-10s";
        String formatInfo = column1Format + " " + column2Format + " " + column3Format;

        System.out.format(String.format("Player Name" + "\t" + "Total Win" + "\t" + "Total Bet"));

        while ((line = bufferedReader.readLine()) != null) {

            String[] values = line.split(",");


            System.out.println(" ");

            int i = 0;

            System.out.format(String.format(formatInfo,values[i] , values[i+1] , values[i+2]));


        }
        bufferedReader.close();


    }



}
