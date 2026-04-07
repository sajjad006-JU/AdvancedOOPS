// Q8.java
// 8.  You are asked to create a notice board. Anybody can read the notice board parallelly but 
// when any one is writing on it, all others should wait for the modification to finish. So, the 
// waiting threads would display a suitable message to indicate that it is waiting for the update 
// to finish.
// Sajjad Ahmed Shaaz, 002410501093

class NoticeBoard {
    private String message = "";
    private boolean writing = false;

    synchronized void write(String msg) throws InterruptedException {
        while (writing) wait();

        writing = true;
        System.out.println(Thread.currentThread().getName() + " writing...");
        message = msg;

        Thread.sleep(1000);

        writing = false;
        notifyAll();
    }

    synchronized void read() throws InterruptedException {
        while (writing) {
            System.out.println(Thread.currentThread().getName() + " waiting...");
            wait();
        }

        System.out.println(Thread.currentThread().getName() + " read: " + message);
    }
}

public class Q8 {
    public static void main(String[] args) {
        NoticeBoard nb = new NoticeBoard();

        Thread writer = new Thread(() -> {
            try {
                nb.write("Exam Tomorrow!");
            } catch (Exception e) {}
        }, "Writer");

        Thread reader1 = new Thread(() -> {
            try {
                nb.read();
            } catch (Exception e) {}
        }, "Reader1");

        Thread reader2 = new Thread(() -> {
            try {
                nb.read();
            } catch (Exception e) {}
        }, "Reader2");

        reader1.start();
        reader2.start();
        writer.start();
    }
}