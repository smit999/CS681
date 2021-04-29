package edu.umb.cs681.hw12;

public class MultipleThread implements Runnable {

    public void run() {
    	
        Customer customer = new Customer(new Address("999 Town Hill St", "Quincy", "MA", 2169 ));
        System.out.println("Original address : "+ customer.getAddress());
        customer.setAddress(customer.getAddress().change("1 Infinite Loop Cupertino", "cupertino", "CA", 95014));
        System.out.println("Changed address  : "+ customer.getAddress());
        customer.setAddress(new Address("3 Center Plaza", "Boston", "MA", 2108));
        System.out.println("New address      : "+ customer.getAddress());
    }

    public static void main(String[] args) {
    	
    	Thread T1 = new Thread(new MultipleThread());
		Thread T2 = new Thread(new MultipleThread());
		Thread T3 = new Thread(new MultipleThread());
		Thread T4 = new Thread(new MultipleThread());
		
		T1.start();
		T2.start();
		T3.start();
		T4.start();
		
		try {
			T1.join();
			T2.join();
			T3.join();
			T4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}        
    }
}