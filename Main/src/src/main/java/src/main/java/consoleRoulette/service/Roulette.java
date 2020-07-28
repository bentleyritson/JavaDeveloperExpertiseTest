package consoleRoulette.service;


import consoleRoulette.model.Player;
import consoleRoulette.model.Verdict;

import java.io.IOException;
import java.util.ArrayList;

public interface Roulette {

   Verdict game() throws IOException;

   ArrayList<Player> getInput() throws IOException;

   Player displayWinnings() throws IOException;
}
