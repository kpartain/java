import javax.xml.transform.TransformerConfigurationException;

public class HumanTest {
    public static void main(String[] args) {
        Human humanOne = new Human();
        Human humanTwo = new Human();
        System.out.println("Before humanOne attacks humanTwo, humanTwo health: " + humanTwo.getHealth());
        humanOne.attack(humanTwo);
        System.out.println("After humanOne attacks humanTwo, humanTwo health: " + humanTwo.getHealth());
        Wizard testWizard = new Wizard();
        Ninja testNinja = new Ninja();
        Samurai testSamurai = new Samurai();
        testSamurai.attack(humanOne);
        testSamurai.dealthBlow(humanOne);
        testSamurai.meditate();
        testWizard.attack(testNinja);
        testWizard.fireball(humanTwo);
        testNinja.attack(testSamurai);
        testNinja.runAway();
        testNinja.steal(humanTwo);
    }
}
