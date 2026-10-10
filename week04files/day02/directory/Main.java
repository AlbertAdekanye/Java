
package week04files.day02.directory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) {
        
        // DIRECTORY AND FILE PATHS
        Path directory = Path.of("data");
        Path studentFile = directory.resolve("student.txt");
        Path courseFile = directory.resolve("courses.txt");

        try {

            //TASK 1: CREATE DIRECTORY
            Files.createDirectories(directory);
            System.out.println("directory created successfully.");

            // TASK 2: CREATE AND WRITE STUDENTS FILE
            Files.writeString(
                studentFile, 
                "101 - Albert\n" + 
                "102 - Adesoye\n" +
                "103 - John\n" +
                "104 - David\n" +
                "105 - Michael\n"
            );

            System.out.println("students file created successfully.");

            // TASK 3: APPEND A STUDENT
            Files.writeString(
                studentFile, 
                "Emmanuel\n",
                StandardOpenOption.APPEND
            );

            System.out.println("Student appended successfully");

            // TASK 5: READ STUDENTS FILE
            System.out.println("\n===== STUDENTS =====");
            String students = Files.readString(studentFile);
            System.out.println(students);

            // TASK 6: CREATE AND WRITE COURSE
            Files.writeString(
                courseFile, 
                "Java\n" + 
                "JavaScript\n" +
                "Python\n" + 
                "C++\n" +
                "SQL\n"
            );

            System.out.println("Course file written successfully");

            // READ COURSES FILE
            System.out.println("\n===== COURSES =====");
            String courses = Files.readString(courseFile);
            System.out.println(courses);

            // TASK 7: CHECK FILE EXISTENCE
            System.out.println("===== FILE EXISTENCE =====");
            System.out.println("Students file exists: " + Files.exists(studentFile));
            System.out.println("Courses file exists: " + Files.exists(courseFile));

            // Task 8: DELETE FILES
            System.out.println("\n===== DELETE FILES =====");

            if (Files.deleteIfExists(studentFile)) {
                System.out.println("Students file deleted successfully.");
            } else {
                System.out.println("Students file did not exist.");
            }

            if (Files.deleteIfExists(courseFile)) {
                System.out.println("Courses file deleted successfully.");
            } else {
                System.out.println("Courses file did not exist.");
            }

            // CONFIRM DIRECTORY REMAINS
            System.out.println("Data directory still exists: " + Files.exists(directory));

        } catch (IOException e) {
            // TODO: handle exception
            System.out.println("File operation failed: " + e.getMessage());
        }
    }
}
