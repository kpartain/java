package fundamentals.phishing;

public class Person {
    String firstName;
    String lastName;
    int age;
    String hometown;
    public Person(String firstName, String lastName, int age, String hometown) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.hometown = hometown;
    }
    public String getAboutMe() {
        String aboutMe = "My name is " + this.firstName + " " + this.lastName + "\nI am " + this.age + " years old. \n" + "My hometown is " + this.hometown;
        return aboutMe;
    }
}
