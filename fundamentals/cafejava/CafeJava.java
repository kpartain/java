import java.util.*;
import java.util.HashMap;
import java.text.DecimalFormat;

public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        HashMap<String, Double> allDrinks = new HashMap<String, Double>();
        allDrinks.put("Drip coffee", 0.99);
        allDrinks.put("Latte", 1.50);
        allDrinks.put("Cappucino", 4.00);
        
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
        
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = false;
        
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        //Cindhuri ordered a coffee. Show her the correct status message.
        System.out.println("One " + allDrinks.keySet().toArray()[0] + " for " + customer1 + ". " + displayTotalMessage + allDrinks.get("Drip coffee") );
        if(isReadyOrder1 == false) {
            System.out.println(customer1 + pendingMessage);
        }

        //change to display trailing zeros - example above is not formatted for comparison
        DecimalFormat moneyFormat = new DecimalFormat("#.00");

        //Noah ordered a cappucino. Check the status of his order and let him know. If it is ready, also tell him his total.
        System.out.println("One " + allDrinks.keySet().toArray()[2] + " for " + customer4 + ". ");
        if(isReadyOrder2 == true) {
            System.out.println(customer2 + readyMessage + ". " + displayTotalMessage + allDrinks.get("Cappucino"));
        }

        //Sam just order 2 lattes, and would like the total up front. Also give them their order status.
        System.out.println("Two lattes will cost $" + moneyFormat.format((2.00 * allDrinks.get("Latte"))) + ".");
        if(isReadyOrder3 == false) {
            System.out.println(customer3 + pendingMessage);
        }
        //Jimmy just realized he was charged for a coffee but had ordered a latte. Tell him his new total (what he owes) to make up the difference.
        double theDifference = (2 * allDrinks.get("Latte")) - (2 * allDrinks.get("Drip coffee"));
        
        System.out.println("Your new total is $" + moneyFormat.format(theDifference));
    }
}
