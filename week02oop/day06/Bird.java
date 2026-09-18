package week02oop.day06;

public class Bird implements Flyable {

    String name;

    public Bird(String name) {
        this.name = name;
    }

    @Override
    public void fly() {
        System.out.println(name + " is flying.");
    }
}
