package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private Parrot parrot;
    private String name = "Ethan";

    public Person(@Qualifier("parrot2") Parrot parrot2){
        this.parrot = parrot2;
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

    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }
}
