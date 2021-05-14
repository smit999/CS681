package edu.umb.cs681.hw15;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AdmissionControl {

	private int curVis = 0;
	private ReentrantLock lock = new ReentrantLock();
	private Condition sufficientCondition = lock.newCondition();
	private Condition lessThanLimitCondition = lock.newCondition();

	public void enter() {

		lock.lock();

		try {

			System.out.println(Thread.currentThread().getName() + "\tTotal Visitors Count (Current) : " + curVis);

			while (curVis >= 7) {
				try {
					System.out.println(Thread.currentThread().getName() + "\tVisitor Limit Full");
					sufficientCondition.await();
				} catch (InterruptedException e) {
					return;
				}
			}

			curVis++;
			System.out.println(Thread.currentThread().getName() + "\tTotal Visitors Count (Updated) : " + curVis);
			lessThanLimitCondition.signalAll();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			lock.unlock();
		}
	}

	public void exit() {

		lock.lock();

		try {
			System.out.println(Thread.currentThread().getName() + "\tTotal Visitors Count (Current) : " + curVis);

			while (curVis <= 0) {
				try {
					System.out.println(Thread.currentThread().getName() + "\tEmpty Waiting List!");
					lessThanLimitCondition.await();
				} catch (InterruptedException e) {
					return;
				}
			}

			curVis--;

			System.out.println(Thread.currentThread().getName() + "\tTotal Visitors Count (Updated) : " + curVis);
			sufficientCondition.signalAll();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public int visitorsCount() {
		lock.lock();
		try {
			return curVis;
		} finally {
			lock.unlock();
		}
	}
}