package week02oop.day05;

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.name = "Chase";

        Cat cat = new Cat();
        cat.name = "Bub";

        dog.makeSound();
        cat.makeSound();
    }
}