package conversions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import conversions.service.ConversionBean;

@Configuration
public class AppConfig {

    //Bean instantiation for the Conversion functionality.
    @Bean
    public ConversionBean converter(){
        return new ConversionBean();
    }

}
