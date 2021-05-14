package edu.umb.cs681.hw15;

public class MultipleThread {

	public static void main(String[] args) {

		AdmissionControl admission = new AdmissionControl();
		EntranceHandler entrance = new EntranceHandler(admission);
		ExitHandler exit_handler = new ExitHandler(admission);
		AdmissionMonitor monitor = new AdmissionMonitor(admission);

		Thread TEnt = new Thread(entrance);
		Thread TExit = new Thread(exit_handler);
		Thread TMon = new Thread(monitor);

		TEnt.start();
		TExit.start();
		TMon.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		entrance.setDone();
		exit_handler.setDone();
		monitor.setDone();

		TEnt.interrupt();
		TExit.interrupt();
		TMon.interrupt();

		try {
			TEnt.join();
			TExit.join();
			TMon.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}