package main;

import config.AppConfig;
import model.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        Parrot p = new Parrot();
        p.setName("Perry");
        Supplier<Parrot> parrotSupplier = () -> p;

        context.registerBean("parrot1",
                Parrot.class,
                parrotSupplier,
                bd -> bd.setPrimary(true));

        System.out.println(context.getBean("parrot1", Parrot.class).getName());
    }
}
