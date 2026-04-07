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

class FizzBuzz {
    private int n;
    private int i = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    public synchronized void fizz() throws InterruptedException {
        while (i <= n) {
            if (i % 3 == 0 && i % 5 != 0) {
                System.out.println("fizz");
                i++;
                notifyAll();
            } else wait();
        }
    }

    public synchronized void buzz() throws InterruptedException {
        while (i <= n) {
            if (i % 5 == 0 && i % 3 != 0) {
                System.out.println("buzz");
                i++;
                notifyAll();
            } else wait();
        }
    }

    public synchronized void fizzbuzz() throws InterruptedException {
        while (i <= n) {
            if (i % 15 == 0) {
                System.out.println("fizzbuzz");
                i++;
                notifyAll();
            } else wait();
        }
    }

    public synchronized void number() throws InterruptedException {
        while (i <= n) {
            if (i % 3 != 0 && i % 5 != 0) {
                System.out.println(i);
                i++;
                notifyAll();
            } else wait();
        }
    }
}

public class Q6 {
    public static void main(String[] args) throws InterruptedException {
        int n = 20;
        FizzBuzz fb = new FizzBuzz(n);

        Thread A = new Thread(() -> {
            try { fb.fizz(); } catch (Exception e) {}
        });

        Thread B = new Thread(() -> {
            try { fb.buzz(); } catch (Exception e) {}
        });

        Thread C = new Thread(() -> {
            try { fb.fizzbuzz(); } catch (Exception e) {}
        });

        Thread D = new Thread(() -> {
            try { fb.number(); } catch (Exception e) {}
        });

        A.start(); B.start(); C.start(); D.start();

        A.join(); B.join(); C.join(); D.join();
    }
}