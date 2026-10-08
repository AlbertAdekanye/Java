package week04files.day01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
  
  public static void main(String[] args) {
      
    File file = new File("data.txt");

    try {
        
      if (file.createNewFile()) {
        System.out.println("File created successfully.");
      } else {
        System.out.println("File already exists.");
      }

    } catch (IOException e) {
      System.out.println("Something went wrong.");
    }

    System.out.println(file.getName());
    System.out.println(file.getAbsolutePath());
    
    fileReader();
    fileWriter();
  }

  // Write file
  public static void fileWriter() {

    try {

      FileWriter writer = new FileWriter("data.txt", true);

      writer.write("Albert Adekanye\n");
      writer.write("Software Engineer\n");
      writer.write("Physics Graduate\n");
      writer.write("Java Developer\n");

      writer.close();

      System.out.println("Data written successfully");

    } catch (IOException e) {

      System.out.println("Something went wrong.");
    }
  }

  // read file
  public static void fileReader() {

    try {
        
      File file = new File("data.txt");

      Scanner scanner = new Scanner(file);

      while (scanner.hasNextLine()) {

        String line = scanner.nextLine();

        System.out.println(line);
      }
      
      scanner.close();

    } catch (IOException e) {

      System.out.println("Something went wrong");
    }
  }
}