package config;

import model.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {
    @Bean
    public Parrot parrot1(){
        Parrot p = new Parrot();
        p.setName("Perry(1)");
        return p;
    }

    @Bean(name="p2")
    public Parrot parrot2(){
        Parrot p = new Parrot();
        p.setName("Perri(2)");
        return p;
    }

    @Bean
    @Primary
    public Parrot parrot3(){
        Parrot p = new Parrot();
        p.setName("PerPer(3)");
        return p;
    }

}
