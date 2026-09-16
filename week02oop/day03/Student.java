package week02oop.day03;

public class Student {

    private String name;
    private int age;
    private String course;

    public Student(String name, int age, String course) {
        this.name = name;

        if (age >= 0 && age <= 120) {
            this.age = age;
        } else {
            this.age = 0;
        }

        this.course = course;
    }

    // GETTERS

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    // SETTERS

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 120) {
            this.age = age;
        }
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void displayStudent() {
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);
        System.out.println("Course: " + course);
    }
}