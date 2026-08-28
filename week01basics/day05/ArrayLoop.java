package week01basics.day05;

public class ArrayLoop {
  public static void main(String[] args) {
      
    // String[] technologies = {
    //   "Java",
    //   "Spring Boot",
    //   "Docker",
    //   "AWS"
    // };

    // for (int index = 0; index < technologies.length; index++) {
    //   System.out.println(index + ": " + technologies[index]);
    // }

    String[] technologies = {
        "Java",
        "Spring Boot",
        "Docker",
        "AWS"
    };

    for (String technology : technologies) {
        System.out.println(technology);
    }
  }
}
