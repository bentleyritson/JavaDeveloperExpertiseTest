package consoleRoulette;

import consoleRoulette.model.Player;
import consoleRoulette.service.RouletteImplementation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

    //Bean instantiation for the Conversion functionality.
    @Bean
    @Primary
    public RouletteImplementation gameStarter(){
        return new RouletteImplementation();
    }

}
