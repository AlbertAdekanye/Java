package week02oop.day07;

public class Member {
  
  private String name;
  private int memberId;

  public Member(String name, int memberId) {
    this.name = name;
    this.memberId = memberId;
  }

  public String getName() {
    return name;
  }

  public int getMemberId() {
    return memberId;
  }

  public void displayMembers() {
    System.out.println(
      "Member ID: " + memberId + 
      " | Name: " + name
    );
  }
}
