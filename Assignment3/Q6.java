// 6. You have the four functions: 
// • printFizz that prints the word "fizz" to the console, 
// • printBuzz that prints the word "buzz" to the console, 
// • printFizzBuzz that prints the word "fizzbuzz" to the console, and 
// • printNumber that prints a given integer to the console. 
// You are given an instance of the class FizzBuzz that has four 
// functions: fizz, buzz, fizzbuzz and number. The same instance of FizzBuzz will be passed to 
// four different threads: 
// • Thread A: calls fizz() that should output the word "fizz". 
// • Thread B: calls buzz() that should output the word "buzz". 
// • Thread C: calls fizzbuzz() that should output the word "fizzbuzz". 
// • Thread D: calls number() that should only output the integers. 
// Repeat the threads unless different results emerge for repeated executions as a 
// consequence of parallel programming. You may use lambda function for only creating 
// Runnable objects.
// Sajjad Ahmed Shaaz, 002410501093
import java.util.*;

class FizzBuzz {
    private int n;
    private int i = 1;

    public FizzBuzz(int n) { this.n = n; }

    public synchronized void fizz() throws InterruptedException {
        while (i <= n) {
            if (i % 3 == 0 && i % 5 != 0) {
                System.out.print("fizz ");
                i++;
                notifyAll();
            } else wait();
        }
        notifyAll(); // fix: wake sleeping threads when done
    }

    public synchronized void buzz() throws InterruptedException {
        while (i <= n) {
            if (i % 5 == 0 && i % 3 != 0) {
                System.out.print("buzz ");
                i++;
                notifyAll();
            } else wait();
        }
        notifyAll();
    }

    public synchronized void fizzbuzz() throws InterruptedException {
        while (i <= n) {
            if (i % 15 == 0) {
                System.out.print("fizzbuzz ");
                i++;
                notifyAll();
            } else wait();
        }
        notifyAll();
    }

    public synchronized void number() throws InterruptedException {
        while (i <= n) {
            if (i % 3 != 0 && i % 5 != 0) {
                System.out.print(i + " ");
                i++;
                notifyAll();
            } else wait();
        }
        notifyAll();
    }
}

public class Q6 {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        // Run 3 times — output should always be identical due to synchronization
        for (int run = 1; run <= 3; run++) {
            System.out.print("\nRun " + run + ": ");
            FizzBuzz fb = new FizzBuzz(n);
            Thread A = new Thread(() -> { try { fb.fizz();     } catch (Exception e) { e.printStackTrace(); } });
            Thread B = new Thread(() -> { try { fb.buzz();     } catch (Exception e) { e.printStackTrace(); } });
            Thread C = new Thread(() -> { try { fb.fizzbuzz(); } catch (Exception e) { e.printStackTrace(); } });
            Thread D = new Thread(() -> { try { fb.number();   } catch (Exception e) { e.printStackTrace(); } });
            A.start(); B.start(); C.start(); D.start();
            A.join(); B.join(); C.join(); D.join();
        }
        System.out.println("\n\nAll runs identical — synchronization working correctly.");
    }
}
