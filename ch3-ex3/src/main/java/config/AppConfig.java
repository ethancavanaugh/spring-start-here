package config;

import model.*;
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
    public Person person(Parrot parrot){
        Person p = new Person();
        p.setName("Ethan");
        p.setParrot(parrot);
        return p;
    }
}
