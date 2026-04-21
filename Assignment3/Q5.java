// 5. One thread takes an input from user and increments an integer variable by that amount. 
// Another thread reduces the variable by a fixed amount. Execute two versions of each thread 
// simultaneously and all working on same variable. Once all threads are over display the value 
// of the variable. Repeat the threads unless different results emerge for repeated executions 
// as a consequence of parallel programming. Don’t use lambda functions. 
// Modify the problem stated in ensuring mutual exclusion on shared variable.  
// Sajjad Ahmed Shaaz, 002410501093

import java.util.*;

class Shared {
    volatile int value = 0;
}

class Increment extends Thread {
    Shared s;
    int amount;
    Increment(Shared s, int amount) {
        this.s = s;
        this.amount = amount;
    }
    public void run() {
        // Simulate user input by using the amount passed in
        for (int i = 0; i < 1000; i++)   // more iterations → more race chances
            s.value += amount;
    }
}

class Decrement extends Thread {
    Shared s;
    int amount;
    Decrement(Shared s, int amount) {
        this.s = s;
        this.amount = amount;
    }
    public void run() {
        for (int i = 0; i < 1000; i++)
            s.value -= amount;
    }
}

// Safe versions using synchronized methods
class SharedSafe {
    private int value = 0;
    synchronized void increment(int x) { value += x; }
    synchronized void decrement(int x) { value -= x; }
    int getValue() { return value; }
}

class IncrementSafe extends Thread {
    SharedSafe s;
    int amount;
    IncrementSafe(SharedSafe s, int amount) {
        this.s = s;
        this.amount = amount;
    }
    public void run() {
        for (int i = 0; i < 1000; i++)
            s.increment(amount);
    }
}

class DecrementSafe extends Thread {
    SharedSafe s;
    int amount;
    DecrementSafe(SharedSafe s, int amount) {
        this.s = s;
        this.amount = amount;
    }
    public void run() {
        for (int i = 0; i < 1000; i++)
            s.decrement(amount);
    }
}

public class Q5 {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter increment amount: ");
        int incAmount = sc.nextInt();
        int decAmount = 2; // fixed reduction amount

        // === Without Synchronization — loop until different results emerge ===
        System.out.println("\n=== Without Synchronization ===");
        int prev = Integer.MIN_VALUE;
        int run = 1;
        while (true) {
            Shared s = new Shared();
            Thread t1 = new Increment(s, incAmount);
            Thread t2 = new Decrement(s, decAmount);
            Thread t3 = new Increment(s, incAmount);
            Thread t4 = new Decrement(s, decAmount);
            t1.start(); t2.start(); t3.start(); t4.start();
            t1.join(); t2.join(); t3.join(); t4.join();
            System.out.println("Run " + run + " Value: " + s.value);
            if (prev != Integer.MIN_VALUE && s.value != prev) {
                System.out.println("Different result detected at run " + run + "! Race condition confirmed.");
                break;
            }
            prev = s.value;
            run++;
        }

        // === With Synchronization — should always give same result ===
        System.out.println("\n=== With Synchronization ===");
        prev = Integer.MIN_VALUE;
        for (int i = 1; i <= 5; i++) {
            SharedSafe s = new SharedSafe();
            Thread t1 = new IncrementSafe(s, incAmount);
            Thread t2 = new DecrementSafe(s, decAmount);
            Thread t3 = new IncrementSafe(s, incAmount);
            Thread t4 = new DecrementSafe(s, decAmount);
            t1.start(); t2.start(); t3.start(); t4.start();
            t1.join(); t2.join(); t3.join(); t4.join();
            System.out.println("Run " + i + " Value: " + s.getValue());
            if (prev != Integer.MIN_VALUE && s.getValue() != prev)
                System.out.println("WARNING: Unexpected difference — synchronization failed!");
            prev = s.getValue();
        }
        System.out.println("Synchronized results are consistent.");
    }
}
