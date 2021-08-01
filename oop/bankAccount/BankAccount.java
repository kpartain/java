// Create a BankAccount class.
public class BankAccount {
    // ● The class should have the following attributes: (double) checking balance, (double) savings balance.
    private Double checkingBalance;
    private Double savingsBalance;
    // ● Create a class member (static) that has the number of accounts created thus far.
    public static int totalNumberOfAllAccounts = 0;
    // ● Create a class member (static) that tracks the total amount of money stored in every account created.
    public static int totalBalanceAllAccounts = 0;
    // ● In the constructor, be sure to increment the account count.
    public BankAccount(){
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        totalNumberOfAllAccounts++;
    }
    
    // ● Create a getter method for the user's checking account balance.
    public Double getCheckingBalance(){
        return this.checkingBalance;
    }
    private void setCheckingBalance(Double amountChanged){
        this.checkingBalance += amountChanged;
        totalBalanceAllAccounts += amountChanged;
    }
    // ● Create a getter method for the user's saving account balance.
    public Double getSavingsBalance(){
        return this.savingsBalance;
    }
    private void setSavingsBalance(Double amountChanged){
        this.savingsBalance += amountChanged;
        totalBalanceAllAccounts += amountChanged;
    }
    // ● Create a method that will allow a user to deposit money into either the checking or saving, be sure to add to total amount stored.
    public void deposit(String accountType, Double amountDeposited) {
        if(accountType.toLowerCase() == "checking") {
            this.setCheckingBalance(amountDeposited);
        } else if (accountType.toLowerCase() == "savings") {
            this.setSavingsBalance(amountDeposited);
        }
    }
    // ● Create a method to withdraw money from one balance. Do not allow them to withdraw money if there are insufficient funds.
    public void withdraw(String accountType, Double amountWithdrawn) {
        if(accountType.toLowerCase() == "checking"){
            Double currentBalance = this.getCheckingBalance();
            if(amountWithdrawn > currentBalance) {
                System.out.println("You're too poor for that.");
            } else {
                Double makeNegative = amountWithdrawn * -1;
                this.setCheckingBalance(makeNegative);
            }

        } else if (accountType.toLowerCase() == "savings") {
            Double currentBalance = this.getSavingsBalance();
            if(amountWithdrawn > currentBalance) {
                System.out.println("You're too poor for that.");
            } else {
                Double makeNegative = amountWithdrawn * -1;
                this.setSavingsBalance(makeNegative);
            }
        }
    }
    // ● Create a method to see the total money from the checking and saving.
    public Double seeTotalOfCheckingAndSaving(){
        Double total = this.getCheckingBalance() + this.getSavingsBalance();
        return total;
    }
    // ● Users should not be able to set any of the attributes from the class.
    
    // Ninja Bonus (Optional):
    
    // Add the the following class attribute: account number. The type is up to you, can be a String or a Long or another type.
    // Create a private method that returns a random ten digit account number.
    // In the constructor, call the private method from above so that each user has a random ten digit account.
}
