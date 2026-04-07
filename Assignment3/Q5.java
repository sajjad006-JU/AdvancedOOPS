// 5. One thread takes an input from user and increments an integer variable by that amount. 
// Another thread reduces the variable by a fixed amount. Execute two versions of each thread 
// simultaneously and all working on same variable. Once all threads are over display the value 
// of the variable. Repeat the threads unless different results emerge for repeated executions 
// as a consequence of parallel programming. Don’t use lambda functions. 
// Modify the problem stated in ensuring mutual exclusion on shared variable.  
// Sajjad Ahmed Shaaz, 002410501093

class Shared {
    int value = 0;
}

class Increment extends Thread {
    Shared s;
    Increment(Shared s) { this.s = s; }

    public void run() {
        s.value += 5;
    }
}

class Decrement extends Thread {
    Shared s;
    Decrement(Shared s) { this.s = s; }

    public void run() {
        s.value -= 2;
    }
}

// Safe version
class SharedSafe {
    int value = 0;

    synchronized void increment(int x) {
        value += x;
    }

    synchronized void decrement(int x) {
        value -= x;
    }
}

public class Q5 {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("=== Without Synchronization ===");

        for (int i = 0; i < 5; i++) {
            Shared s = new Shared();

            Thread t1 = new Increment(s);
            Thread t2 = new Decrement(s);
            Thread t3 = new Increment(s);
            Thread t4 = new Decrement(s);

            t1.start(); t2.start(); t3.start(); t4.start();

            t1.join(); t2.join(); t3.join(); t4.join();

            System.out.println("Run " + (i+1) + " Value: " + s.value);
        }

        System.out.println("\n=== With Synchronization ===");

        for (int i = 0; i < 5; i++) {
            SharedSafe s = new SharedSafe();

            Thread t1 = new Thread(() -> s.increment(5));
            Thread t2 = new Thread(() -> s.decrement(2));
            Thread t3 = new Thread(() -> s.increment(5));
            Thread t4 = new Thread(() -> s.decrement(2));

            t1.start(); t2.start(); t3.start(); t4.start();

            t1.join(); t2.join(); t3.join(); t4.join();

            System.out.println("Run " + (i+1) + " Value: " + s.value);
        }
    }
}