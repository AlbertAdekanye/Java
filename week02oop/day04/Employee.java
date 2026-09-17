package week02oop.day04;

public class Employee {
  
  String name;
  double salary;

  void work() {
    System.out.println(name + " is working.");
  }

  void displayWorkerInfo() {
    System.out.println("Name: " + name);
    System.out.println("Salary: " + salary);
  }
}
