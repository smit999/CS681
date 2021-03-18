package edu.umb.cs681.hw08;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentSingleton {
    private static ConcurrentSingleton instance = null;
    private static ReentrantLock lock = new ReentrantLock();

    private  ConcurrentSingleton(){ }

    public static ConcurrentSingleton getInstance(){
        lock.lock();
        try {
            if (instance == null)
                instance = new ConcurrentSingleton();
            return instance;
        } finally {
            lock.unlock();
        }
    }
}