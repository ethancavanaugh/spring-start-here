package main;

import config.AppConfig;
import model.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());

        System.out.println(context.getBean(String.class));
        System.out.println(context.getBean(Integer.class));
    }
}
