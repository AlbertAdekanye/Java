package week02oop.day06;

public class Main {

    public static void main(String[] args) {

        // ABSTRACT CLASS + POLYMORPHISM

        Animal dog = new Dog("Chase");
        Animal cat = new Cat("Bub");

        dog.makeSound();
        dog.sleep();

        System.out.println();

        cat.makeSound();
        cat.sleep();

        System.out.println();

        // INTERFACE

        Flyable bird = new Bird("Eagle");

        bird.fly();

        System.out.println();

        // INTERFACE + POLYMORPHISM

        PaymentMethod payment1 = new CardPayment();
        PaymentMethod payment2 = new BankTransfer();

        payment1.processPayment();
        payment2.processPayment();
    }
}