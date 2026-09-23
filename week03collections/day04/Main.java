package week03collections.day04;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();

        names.add("Albert");
        names.add("Adesoye");
        names.add("John");
        names.add("David");
        names.add("King");

        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

    }
}