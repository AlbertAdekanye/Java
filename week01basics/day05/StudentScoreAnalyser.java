package week01basics.day05;

import java.util.Scanner;

public class StudentScoreAnalyser {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== STUDENT SCORE ANALYSER =====");

        // Ask for the student's name
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        // Ask for the number of subjects
        System.out.print("Enter number of subjects: ");
        int subjectNumber = scanner.nextInt();

        if (subjectNumber <= 0) {
            System.out.println("Number of subjects must be greater than zero.");
            scanner.close();
            return;
        }

        // Create an array with the chosen size
        int[] scores = new int[subjectNumber];

        // Collect the scores
        for (int index = 0; index < scores.length; index++) {
            System.out.print("Enter score " + (index + 1) + ": ");
            scores[index] = scanner.nextInt();
        }

        int total = 0;
        int passedSubjects = 0;
        int highestScore = scores[0];
        int lowestScore = scores[0];

        // Analyse all scores
        for (int score : scores) {
            total += score;

            if (score > highestScore) {
                highestScore = score;
            }

            if (score < lowestScore) {
                lowestScore = score;
            }

            if (score >= 50) {
                passedSubjects++;
            }
        }

        double average = (double) total / scores.length;
        int failedSubjects = scores.length - passedSubjects;

        // Display the summary
        System.out.println();
        System.out.println("===== RESULT SUMMARY =====");
        System.out.println("Student: " + studentName);
        System.out.println("Total score: " + total);
        System.out.println("Average score: " + average);
        System.out.println("Highest score: " + highestScore);
        System.out.println("Lowest score: " + lowestScore);
        System.out.println("Subjects passed: " + passedSubjects);
        System.out.println("Subjects failed: " + failedSubjects);
        System.out.println("==========================");

        scanner.close();
    }
}