// 7. Design a BankAcct class with account number, balance and interest rate as attribute.  Interest 
// rate is same for all account. Support must be there to initialize, change and display the interest rate.  
// Also supports are to be there to return balance and calculate interest. 
// Sajjad Ahmed Shaaz, 002410501093

public class BankAccount {
    int accountNumber;
    double balance;
    static double interestRate;

    BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    static void setInterestRate(double rate) {
        interestRate = rate;
    }

    static double getInterestRate() {
        return interestRate;
    }

    double getBalance() {
        return balance;
    }

    double calculateInterest() {
        return balance * interestRate / 100;
    }

    public static void main(String[] args) {
        BankAccount.setInterestRate(5.0);

        BankAccount account1 = new BankAccount(1001, 10000);
        BankAccount account2 = new BankAccount(1002, 20000);

        System.out.println("Account Number: " + account1.accountNumber);
        System.out.println("Balance: " + account1.getBalance());
        System.out.println("Interest Rate: " + BankAccount.getInterestRate() + "%");
        System.out.println("Calculated Interest: " + account1.calculateInterest());

        System.out.println();

        System.out.println("Account Number: " + account2.accountNumber);
        System.out.println("Balance: " + account2.getBalance());
        System.out.println("Interest Rate: " + BankAccount.getInterestRate() + "%");
        System.out.println("Calculated Interest: " + account2.calculateInterest());
    }
}
