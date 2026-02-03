
// Every bank account holds an account no and a calculateInterest method. A customer can have a 
// “SavingsAccount”  and/or a  “CurrentAccount”.  For current  account,  there  is  a  method  called 
// displayOverdraftAmount(). Different accounts can have different interest rates. User should be able 
// to verify the existence of an account, adding new account and displaying all accounts. Implement 
// appropriate objects utilizing inheritance and show its behavior from the parent class. 

import java.util.Scanner;

abstract class Account {
    String acno;
    float interest_rate;
    float balance;

    Account(String acno) {
        this.acno=acno;
        interest_rate=6;
        balance=0;
    }
    
    float calculateInterest() {
        return interest_rate*balance/100;
    }

    abstract void displayAccountDetails();

}

class CurrentAccount extends Account {

    float overdraftAmount;

    CurrentAccount(String acno) {
        super(acno);
        overdraftAmount=10000;
        interest_rate=0;
    }

    float displayOverdraftAmount() {
        return overdraftAmount;
    }

    void displayAccountDetails() {
        System.out.println("-----Current Account Details-----");
        System.out.println("Account Number: " + acno);
        System.out.println("Balance: " + balance);
        System.out.println("Interest Rate: " + calculateInterest());
        System.out.println("Overdraft Amount: " + displayOverdraftAmount());
    }
}

class SavingsAccount extends Account {
    SavingsAccount(String acno) {
        super(acno);
    }

    float calculateInterest() {
        return 5.8f;
    }

    void displayAccountDetails() {
        System.out.println("-----Savings Account Details-----");
        System.out.println("Account Number: " + acno);
        System.out.println("Balance: " + balance);
        System.out.println("Interest Rate: " + calculateInterest());
    }

}
public class Bank {
    Account accounts[];
    int count;

    Bank() {
        accounts=new Account[100];
        count=0;
    }

    boolean accountExists(String acno) {
        for (int i=0; i<count; i++) {
            if (accounts[i].acno.equals(acno)) 
                return true;
        }
        return false;
    }

    void displayAllAccounts() {

        if (count==0) {
            System.out.println("No accounts to display.");
            return;
        }

        for (int i=0; i<count; i++) {
            accounts[i].displayAccountDetails();
        }
    }

    void addAccount(Scanner sc) {
        System.out.println("Enter type of Account - Savings(s) or Current(c) : ");
        char ch=sc.next().charAt(0);
        System.out.println("Enter Account Number: ");
        String acno=sc.next();

        System.out.println("Enter initial balance: ");
        float balance=sc.nextFloat();

        if (accountExists(acno)) {
            System.out.println("Account already exists.");
            return;
        }

        if (ch=='s') {
            accounts[count]=new SavingsAccount(acno);
            accounts[count].balance=balance;
        } else if (ch=='c') {
            accounts[count]=new CurrentAccount(acno);
            accounts[count].balance=balance;
        }
        count++;
    }

    void addBalance(String acno, float amount) {
        if (accountExists(acno)) {
            for (int i=0; i<count; i++) {
                if (accounts[i].acno.equals(acno)) {
                    accounts[i].balance+=amount;
                    System.out.println("Balance added successfully.");
                    return;
                }
            }
        } else {
            System.out.println("Account does not exist.");
        }
    }

    public static void main(String[] args) {

        System.out.println("Banking System");
        Bank bank=new Bank();
        Scanner sc=new Scanner(System.in);
        
        while (true) {
            int choice;
            System.out.println("1. Add Account \t 2. Display All Accounts \t 3. Check Account Existence \t 4. Add Balance \t 5. Exit");

            switch (choice = sc.nextInt()) {
                case 1:
                    bank.addAccount(sc);
                    break;
                case 2:
                    bank.displayAllAccounts();
                    break;
                case 3:
                    System.out.println("Enter Account Number to check existence: ");
                    String acno = sc.next();
                    if (bank.accountExists(acno)) {
                        System.out.println("Account exists.");
                    } else {
                        System.out.println("Account does not exist.");
                    }
                    break;
                case 4:
                    System.out.println("Enter Account Number to add balance: ");
                    String accno = sc.next();
                    System.out.println("Enter amount to add: ");
                    float amount = sc.nextFloat();
                    bank.addBalance(accno, amount);
                    break;
                case 5:
                    System.out.println("Exiting Banking System.");
                    sc.close();
                    return; 
            
                default:
                    break;
            }
        }
    }
}
