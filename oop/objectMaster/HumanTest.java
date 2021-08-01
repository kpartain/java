public class HumanTest {
    public static void main(String[] args) {
        Human humanOne = new Human();
        Human humanTwo = new Human();
        System.out.println("Before humanOne attacks humanTwo, humanTwo health: " + humanTwo.getHealth());
        humanOne.attack(humanTwo);
        System.out.println("After humanOne attacks humanTwo, humanTwo health: " + humanTwo.getHealth());
    }
}
