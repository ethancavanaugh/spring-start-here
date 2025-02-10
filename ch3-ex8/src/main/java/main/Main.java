package main;

import config.AppConfig;
import model.Parrot;
import model.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        Person person = context.getBean(Person.class);

        System.out.println(person);
        System.out.println("Person's parrot: " + person.getParrot());
    }
}
