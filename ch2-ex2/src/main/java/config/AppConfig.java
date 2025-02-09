package config;

import model.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Parrot parrot(){
        Parrot p = new Parrot();
        p.setName("Perry");
        return p;
    }

    @Bean
    String helloWorld(){
        return "Hello world";
    }

    @Bean
    Integer ten(){
        return 10;
    }
}
