package edu.umb.cs681.hw17;
import java.nio.file.Path;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class AccessCounter {
	
	ConcurrentHashMap <java.nio.file.Path, AtomicInteger> hashMap = new ConcurrentHashMap <java.nio.file.Path, AtomicInteger>();
	private static ReentrantLock sLock = new ReentrantLock();
	private static AccessCounter inst = null;
	
	private AccessCounter() {};	
	
	public static AccessCounter getInstance() {
		sLock.lock();
		try {
			if (inst == null)
				inst = new AccessCounter();
			return inst;
		}
		finally {	sLock.unlock();		}
	}
	
	public void increment(Path path) {
		
		hashMap.compute(path, (java.nio.file.Path i, AtomicInteger ai) -> {
			if(ai == null) {
				System.out.println(Thread.currentThread().getName() + "\t Increment : "+ path + "  "  + 1);
				return new AtomicInteger(1);
			} else {
				System.out.println(Thread.currentThread().getName() + "\t Increment : " + path + "  " + (ai.get()+1));
				return new AtomicInteger(ai.incrementAndGet());
			}
		});
	}
	
	public int getCount(Path path) {
		
		return hashMap.compute(path, (java.nio.file.Path i, AtomicInteger ai) -> {
			if(ai == null) {
				System.out.println(Thread.currentThread().getName() +  path + "\t Count " + 0);
				return new AtomicInteger(0);
			} else {
				System.out.println(Thread.currentThread().getName() +  path + "\t Count " + ai.get());
				return ai;
			}
		}).get();
	}	
}