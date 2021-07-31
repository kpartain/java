import java.util.Random;

public class PuzzleJava {
    private Random randMachine = new Random();
//getTenRolls
// Write a method that will generate and return an array with 10 random numbers between 1 and 20 inclusive. 
    public ArrayList<Integer> getTenRolls(){
        ArrayList<Integer> tenNumbers = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++) {
            //max - min + 1
            tenNumbers.add(randMachine.nextInt((20 - 1) + 1));
        }
        return tenNumbers;
    }

// getRandomLetter
// Write a method that will:
// Create an array within the method that contains all 26 letters of the alphabet (this array must have 26 values). 
// Generate a random index between 0-25, and use it to pull a random letter out of the array.
// Return the random letter.
    public char getRandomLetter(){
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        //max - min + 1
        int randomIndex = randMachine.nextInt((25 - 0) + 1);
        return alphabet[randomIndex];

    }

// generatePassword
// Write a method that uses the previous method to create a random string of eight characters, 
//and return that string.
    public String generatePassword(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 8; i++) {
            sb.append(getRandomLetter());
        }
        String password = sb.toString();
        return password;
    }

// getNewPasswordSet
// Write a method that takes an int length as an argument and creates an array of random eight character words. The array should be the length passed in as an int.
    public ArrayList<String> getNewPasswordSet(int lengthOfReturn) {
        ArrayList<String> returnArray = new ArrayList<String>(lengthOfReturn);
        for(int i = 0; i < lengthOfReturn; i++) {
            returnArray.add(generatePassword());
        }
        return returnArray;
    }

}
