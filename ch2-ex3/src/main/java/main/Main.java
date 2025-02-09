package main;

import config.AppConfig;
import model.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        Parrot p1 = context.getBean("parrot1", Parrot.class);
        Parrot p2 = context.getBean("p2", Parrot.class);
        Parrot p3 = context.getBean(Parrot.class);


        System.out.println("1. " + p1.getName());
        System.out.println("2. " + p2.getName());
        System.out.println("3. " + p3.getName());
    }
}
