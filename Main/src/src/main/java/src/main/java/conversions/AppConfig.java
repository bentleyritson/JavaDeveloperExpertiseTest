package conversions;

import conversions.model.Metric;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.ConversionBean;

@Configuration
public class AppConfig {

    //Bean instantiation for the Conversion functionality.
    @Bean
    public ConversionBean converter(){
        return new ConversionBean();
    }

}
