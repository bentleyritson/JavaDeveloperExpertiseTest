package consoleRoulette;

import consoleRoulette.model.Player;
import consoleRoulette.service.Roulette;
import consoleRoulette.service.RouletteImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ConsoleRoulette {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(ConsoleRoulette.class, args);

        RouletteImplementation newGame = new RouletteImplementation();
        newGame.getInput();
        newGame.game();
        //newGame.inputOutput();                    //Optional Question method call
    }
}
