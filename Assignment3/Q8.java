// Q8.java
// 8.  You are asked to create a notice board. Anybody can read the notice board parallelly but 
// when any one is writing on it, all others should wait for the modification to finish. So, the 
// waiting threads would display a suitable message to indicate that it is waiting for the update 
// to finish.
// Sajjad Ahmed Shaaz, 002410501093
import java.util.*;
import java.util.concurrent.locks.*;

class NoticeBoard {
    private String message = "No notice yet.";
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock  = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    void write(String msg) throws InterruptedException {
        // If write lock not available, other threads will just wait — notify them
        System.out.println(Thread.currentThread().getName() + " waiting to write...");
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " writing...");
            Thread.sleep(1000); // simulate writing time
            message = msg;
            System.out.println(Thread.currentThread().getName() + " finished writing: " + message);
        } finally {
            writeLock.unlock(); // always release in finally
        }
    }

    void read() throws InterruptedException {
        // Try to acquire read lock — if write in progress, this blocks
        System.out.println(Thread.currentThread().getName() + " waiting to read...");
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " reading: " + message);
            Thread.sleep(500); // simulate reading time
        } finally {
            readLock.unlock();
        }
    }
}

public class Q8 {
    public static void main(String[] args) throws InterruptedException {
        NoticeBoard nb = new NoticeBoard();

        Thread writer = new Thread(() -> {
            try { nb.write("Exam Tomorrow!"); }
            catch (Exception e) { e.printStackTrace(); }
        }, "Writer");

        Thread reader1 = new Thread(() -> {
            try { nb.read(); }
            catch (Exception e) { e.printStackTrace(); }
        }, "Reader1");

        Thread reader2 = new Thread(() -> {
            try { nb.read(); }
            catch (Exception e) { e.printStackTrace(); }
        }, "Reader2");

        Thread reader3 = new Thread(() -> {
            try { nb.read(); }
            catch (Exception e) { e.printStackTrace(); }
        }, "Reader3");

        // Writer goes first so readers wait for it
        writer.start();
        Thread.sleep(100); // slight delay so writer acquires lock first
        reader1.start();
        reader2.start();
        reader3.start();

        writer.join();
        reader1.join();
        reader2.join();
        reader3.join();
    }
}
