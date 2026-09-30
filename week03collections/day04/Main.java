package week03collections.day04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Main {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();

        HashMap<Integer, String> students = new HashMap<>();

        names.add("Albert");
        names.add("Adesoye");
        names.add("John");
        names.add("David");
        names.add("King");

        for (String name : names) {
            System.out.println(name);
        }

        System.out.println();

        students.put(101, "Albert");
        students.put(102, "King");
        students.put(103, "Vickie");
        students.put(104, "John");

        for (Map.Entry<Integer, String> entry : students.entrySet()) {

            System.out.println(
                entry.getKey() + " -> " + entry.getValue()
            );
        }

        System.out.println(); 
        
        // print key
        for (Integer id : students.keySet()) {
            System.out.println(id);
        }

        System.out.println();
        
        // print value
        for (String name : students.values()) {
            System.out.println(name);   
        }

        System.out.println();
        
        // iterating with conditions IF
        for (String name : names) {
            if (name.startsWith("A")) {
                System.out.println(name);
            }
        }
    }
}