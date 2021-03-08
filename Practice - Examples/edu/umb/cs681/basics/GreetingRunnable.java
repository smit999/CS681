package edu.umb.cs681.basics;

import java.time.LocalDateTime;

public class GreetingRunnable implements Runnable{
	private String greetingMsg;
	
	public GreetingRunnable(String greetingMsg){
		this.greetingMsg = greetingMsg;
	}
	
	public void run(){
		try{
			for( int i=0; i<10; i++ ){
				System.out.println(LocalDateTime.now() + " " + this.greetingMsg);
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException ex){}
	}
}
