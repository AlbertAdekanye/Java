package week03collections.day03;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        HashMap<Integer, String> students = new HashMap<>();

        // Add students
        students.put(101, "Albert");
        students.put(102, "Adesoye");
        students.put(103, "John");
        students.put(103, "David");
        students.put(103, "Michael");

        // Display students
        System.out.println("Students: " + students);

        System.out.println();

        // Get student
        System.out.println("Student 103: " + students.get(103));

        System.out.println();

        // Check key
        if (students.containsKey(104)) {
            System.out.println("Student 104 exists");
        } else {
            System.out.println("Student 104 does not exist");
        }

        // Check value
        if (students.containsValue("Albert")) {
            System.out.println("Albert is in the map");
        }

        System.out.println();

        // Number of students
        System.out.println("Number of students: " + students.size());

        System.out.println();

        // Remove student
        students.remove(105);

        System.out.println("After removing student 105:");
        System.out.println(students);

        System.out.println();

        // Check if empty
        if (students.isEmpty()) {
            System.out.println("The map is empty");
        } else {
            System.out.println("The map is not empty");
        }
    }
}