package model;

public class Person {
    private String name;
    private Parrot parrot;

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
