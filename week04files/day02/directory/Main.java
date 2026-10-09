
package week04files.day02.directory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Main {

    public static void main(String[] args) {

        // DIRECTORY AND FILE PATHS
        Path directory = Path.of("data");
        Path studentsFile = directory.resolve("students.txt");
        Path coursesFile = directory.resolve("courses.txt");

        try {

            // TASK 1: CREATE DIRECTORY
            Files.createDirectories(directory);
            System.out.println("Directory created or already exists.");

            // TASK 2 & 3: CREATE AND WRITE STUDENTS FILE
            Files.writeString(
                studentsFile,
                "101 - Albert\n" +
                "102 - Adesoye\n" +
                "103 - John\n" +
                "104 - David\n" +
                "105 - Michael\n"
            );

            System.out.println("Students file written successfully.");

            // TASK 4: APPEND A STUDENT
            Files.writeString(
                studentsFile,
                "106 - Emmanuel\n",
                StandardOpenOption.APPEND
            );

            System.out.println("Student appended successfully.");

            // TASK 5: READ STUDENTS FILE
            System.out.println("\n===== STUDENTS =====");
            String students = Files.readString(studentsFile);
            System.out.println(students);

            // TASK 6: CREATE AND WRITE COURSES FILE
            Files.writeString(
                coursesFile,
                "Java\n" +
                "JavaScript\n" +
                "Python\n" +
                "C++\n" +
                "SQL\n"
            );

            System.out.println("Courses file written successfully.");

            // READ COURSES FILE
            System.out.println("\n===== COURSES =====");
            String courses = Files.readString(coursesFile);
            System.out.println(courses);

            // TASK 7: CHECK FILE EXISTENCE
            System.out.println("===== FILE EXISTENCE =====");
            System.out.println(
                "Students file exists: " + Files.exists(studentsFile)
            );
            System.out.println(
                "Courses file exists: " + Files.exists(coursesFile)
            );

            // TASK 8: DELETE FILES
            System.out.println("\n===== DELETE FILES =====");

            if (Files.deleteIfExists(studentsFile)) {
                System.out.println("Students file deleted successfully.");
            } else {
                System.out.println("Students file did not exist.");
            }

            if (Files.deleteIfExists(coursesFile)) {
                System.out.println("Courses file deleted successfully.");
            } else {
                System.out.println("Courses file did not exist.");
            }

            // CONFIRM DIRECTORY REMAINS
            System.out.println(
                "Data directory still exists: " + Files.exists(directory)
            );

        } catch (IOException e) {
            System.out.println("File operation failed: " + e.getMessage());
        }
    }
}
