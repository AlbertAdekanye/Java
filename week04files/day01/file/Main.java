package week04files.day01.file;

import java.io.File;
// import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
  
  // CREATE FILE
  public static void main(String[] args) {
      
    File file = new File("notes.txt");

    try {

      if (file.createNewFile()) {
        System.out.println("File created successfully.");
      } else {
        System.out.println("File already exits");
      }

    } catch (IOException e) {
      System.out.println("Something went wrong.");
    }

    System.out.println(file.getName());
    System.out.println(file.exists());
    System.out.println(file.getAbsolutePath());

    fileWriter();
    appendFile();
    fileReader();
    // deleteFile();
  }

  // WRITE FILE
  public static void fileWriter() {

    try {

        FileWriter writer = new FileWriter("notes.txt");

        writer.write("Name: Albert Adekanye\n");
        writer.write("Profession: Software Developer\n");
        writer.write("Background: Physics\n");
        writer.write("Language: Java\n");

        writer.close();

        System.out.println("Data written successfully.");

    } catch (IOException e) {

      System.out.println("Something went wrong");
    }
  }

  // READ File
  public static void fileReader() {

    try {
        
      File file = new File("notes.txt");

      Scanner scanner = new Scanner(file);

      while (scanner.hasNextLine()) { 

          String line = scanner.nextLine();

          System.out.println(line);
      }

      scanner.close();

    } catch (IOException e) {

      System.out.println("Something went wrong.");
    }
  }

  // APPEND FILE
  public static void appendFile() {

    try {
      
      FileWriter writer = new FileWriter("notes.txt", true);

      writer.write("Goal: Backend Development\n");

      writer.close();

      System.out.println("Data appended successfully.");

    } catch (IOException e) {
      // TODO: handle exception

      System.out.println("Something went wrong.");
    }
  }

  // DELETE FILE
  public static void deleteFile() {

    File file = new File("notes.txt");

    if (file.delete()) {

      System.out.println("File deleted successfully..");

    } else {

      System.out.println("File could not be deleted");
    }
  }
}
