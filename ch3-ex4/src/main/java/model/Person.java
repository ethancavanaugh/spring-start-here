package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    //@Autowired - Field injection, not recommended
    private Parrot parrot;
    private String name = "Ethan";

    //Constructor injection
    //@Autowired is not required if there is only one constructor
    public Person(Parrot parrot){
        this.parrot = parrot;
    }
    @Override
    public String toString(){
        return "Person: " + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    //@Autowired - Setter injection - really not recommended
    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }
}
