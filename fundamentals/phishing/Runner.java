package fundamentals.phishing;

public class Runner {
    public static void main(String[] args) {
        Person karaAsPerson = new Person("Kara", "Partain", 28, "Yuma, AZ");
        String karasAboutMe = karaAsPerson.getAboutMe();
        System.out.println(karasAboutMe);
    }
}
