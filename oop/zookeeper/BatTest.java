public class BatTest {
    public static void main(String[] args) {
        Bat testBat = new Bat();
        for(int i = 1; i < 4; i++) {
         System.out.println("BEFORE: " + testBat.displayEnergy());
            testBat.attackTown();
            if(i % 2 != 0) {
                testBat.eatHumans();
                testBat.fly();
            } 
            System.out.println("AFTER: " + testBat.displayEnergy());
            
        } 
     }
}
