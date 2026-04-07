// 7. Modify the given class so that the ith token (1-indexed) of the series is: 
// • "fizzbuzz" if i is divisible by 5 and 7, 
// • "fizz" if i is divisible by 5 and not 9, 
// • "buzz" if i is divisible by 7 and not 3, or 
// • i if i is not divisible by 7 or 5. 
// If n=10 then the output will be [1,2,3,4,fizz,6,buzz,8,9,fizz]. You may use lambda function for 
// only creating Runnable objects
// Sajjad Ahmed Shaaz, 002410501093

class FizzBuzzModified {
    private int n;
    private int i = 1;

    public FizzBuzzModified(int n) {
        this.n = n;
    }

    public synchronized void fizz() throws InterruptedException {
        while (i <= n) {
            if (i % 5 == 0 && i % 9 != 0 && i % 7 != 0) {
                System.out.println("fizz");
                i++;
                notifyAll();
            } else wait();
        }
    }

    public synchronized void buzz() throws InterruptedException {
        while (i <= n) {
            if (i % 7 == 0 && i % 3 != 0 && i % 5 != 0) {
                System.out.println("buzz");
                i++;
                notifyAll();
            } else wait();
        }
    }

    public synchronized void fizzbuzz() throws InterruptedException {
        while (i <= n) {
            if (i % 5 == 0 && i % 7 == 0) {
                System.out.println("fizzbuzz");
                i++;
                notifyAll();
            } else wait();
        }
    }

    public synchronized void number() throws InterruptedException {
        while (i <= n) {
            if (!(i % 5 == 0 || i % 7 == 0)) {
                System.out.println(i);
                i++;
                notifyAll();
            } else wait();
        }
    }
}

public class Q7 {
    public static void main(String[] args) throws InterruptedException {
        int n = 20;
        FizzBuzzModified fb = new FizzBuzzModified(n);

        Thread A = new Thread(() -> { try { fb.fizz(); } catch (Exception e) {} });
        Thread B = new Thread(() -> { try { fb.buzz(); } catch (Exception e) {} });
        Thread C = new Thread(() -> { try { fb.fizzbuzz(); } catch (Exception e) {} });
        Thread D = new Thread(() -> { try { fb.number(); } catch (Exception e) {} });

        A.start(); B.start(); C.start(); D.start();

        A.join(); B.join(); C.join(); D.join();
    }
}