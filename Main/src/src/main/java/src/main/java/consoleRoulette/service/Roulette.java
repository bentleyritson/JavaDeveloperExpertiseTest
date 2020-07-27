package consoleRoulette.service;


import consoleRoulette.model.Player;

import java.io.IOException;
import java.util.ArrayList;

public interface Roulette {

   ArrayList<Player> game();

   Player getInput() throws IOException;

   Player displayWinnings();
}
