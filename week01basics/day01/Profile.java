package week01basics.day01;

public class Profile {

    public static void main(String[] args) {

        String name = "Albert Adekanye";
        int age = 24;
        String country = "Nigeria";
        String degree = "Physics";
        String profession = "Software Developer";
        int developmentExperience = 3;
        boolean isLearningJava = true;
        final int FAVORITE_NUMBER = 7;

        System.out.println("======== MY PROFILE ========");

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Country: " + country);
        System.out.println("Degree: " + degree);
        System.out.println("Profession: " + profession);
        System.out.println(
            "Development experience: " + developmentExperience + " years"
        );
        System.out.println("Learning Java: " + isLearningJava);

        System.out.print("Favorite number: ");
        System.out.println(FAVORITE_NUMBER);

        System.out.println("============================");
    }
}