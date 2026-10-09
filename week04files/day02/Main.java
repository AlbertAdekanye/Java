package week04files.day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Main {

  public static void main(String[] args) {
    
    Path path = Path.of("note.txt");

    try {
      
      Files.createFile(path);

      System.out.println("File created");

      if (!Files.exists(path)) {

        Files.createFile(path);

        System.out.println("File created.");
      } else {

        System.out.println("File already exists.");
      }

    } catch (IOException e) {
      // TODO: handle exception

      System.out.println("Something went wrong");
    }

    System.out.println(path);
    System.out.println(path.toAbsolutePath());

    Files.exists(path);

    if (Files.exists(path)) {

      System.out.println("File exists");
    }

    // write files
    try {
      
      Files.writeString(
        path, 
        "Name: Albert Adekanye\n" +  
        "Profession: Software Developer\n" + 
        "Language: Java\n"
      );

      System.out.println("File written successfully...");

    } catch (IOException e) {
      // TODO: handle exception

      System.out.println("Something went wrong.");
    }

    // read files
    try {
      
      String content = Files.readString(path);

      System.out.println(content);

    } catch (IOException e) {
      // TODO: handle exception

      System.out.println("Something went wrong");
    }

    // append files
    try {
      
      Files.writeString(
        path, 
        "Goal: Backend Development.",
        StandardOpenOption.APPEND
      );

      System.out.println("Data appended successfully");

    } catch (Exception e) {
      // TODO: handle exception

      System.out.println("something went wrong");
    }

    // // delete with files
    // try {
      
    //   Files.deleteIfExists(path);
    //   System.out.println("Data deleted successfully");

    // } catch (IOException e) {
    //   // TODO: handle exception
    //   System.out.println("seomthing went wrong");
    // }

    // create directory
    Path directory = Path.of("data");

    try {
      
      Files.createDirectory(directory);

      System.out.println("Directory created.");
    } catch (IOException e) {
      // TODO: handle exception

      System.out.println("Something went wrong");
    }

    // create versus folder with files
    try {
      
      Files.createDirectories(Path.of("data/users/Contact"));
      
      System.out.println("Folder created.");
    } catch (IOException e) {
      // TODO: handle exception

      System.out.println("Something went wrong");
    } 
  }

}