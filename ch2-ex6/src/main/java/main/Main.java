package main;

import config.AppConfig;
import model.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        Parrot p = context.getBean("parrot", Parrot.class);
        System.out.println(p.getName());
    }
}
