public class GorillaTest {
    public static void main(String[] args) {
       Gorilla testGorilla = new Gorilla();
       for(int i = 1; i < 4; i++) {
        System.out.println("BEFORE: " + testGorilla.displayEnergy());
           testGorilla.throwSomething();
           if(i % 2 != 0) {
               testGorilla.eatBananas();
           } 
           if (i == 3) {
               testGorilla.climb();
           }
           System.out.println("AFTER: " + testGorilla.displayEnergy());
           
       } 
    }
}
