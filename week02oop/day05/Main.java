package week02oop.day05;

public class Main {

    public static void main(String[] args) {

        Animal animal1 = new Dog();
        Animal animal2 = new Cat();
        Animal animal3 = new Bird();

        animal1.name = "Chase";
        animal2.name = "Bob";
        animal3.name = "Eagle";

        animal1.makeSound();
        animal2.makeSound();
        animal3.makeSound();

        // banking system polymorphism
        System.out.println();

        Payment payment1 = new CardPayment();
        Payment payment2 = new BankTransfer();

        payment1.processPayment();
        payment2.processPayment();
    }
}