package main;

import config.AppConfig;
import model.Parrot;
import model.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        Parrot parrot = context.getBean(Parrot.class);
        Person person = context.getBean(Person.class);

        System.out.println(parrot);
        System.out.println(person);
        System.out.println("Person's parrot: " + person.getParrot());
    }
}
