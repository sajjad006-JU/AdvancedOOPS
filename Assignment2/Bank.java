
// Every bank account holds an account no and a calculateInterest method. A customer can have a 
// “SavingsAccount”  and/or a  “CurrentAccount”.  For current  account,  there  is  a  method  called 
// displayOverdraftAmount(). Different accounts can have different interest rates. User should be able 
// to verify the existence of an account, adding new account and displaying all accounts. Implement 
// appropriate objects utilizing inheritance and show its behavior from the parent class. 

abstract class Account {
    String acno;
    float interest_rate;

    Account(String acno) {
        this.acno=acno;
        interest_rate=6;
    }
    
    abstract float calculateInterest();

}

class CurrentAccount extends Account {
    CurrentAccount(String acno) {
        super(acno);
    }

    float calculateInterest() {
        return 5.8f;
    }

    float displayOverdraftAmount() {

    }
}

class SavingsAccount {
    float calculateInterest() {
        return 5.8f;
    }

}
public class Bank {
    public static void main(String[] args) {
        Account acc=new Account();;
    }
}
