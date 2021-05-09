package edu.umb.cs681.hw14;

public class MultipleThread {

	public static void main(String[] args) {
		
		ThreadSafeBankAccount account = new ThreadSafeBankAccount();
		WithdrawRunnable withdraw = new WithdrawRunnable(account);
		DepositRunnable deposit= new DepositRunnable(account);
		
        Thread dep1  = new Thread(deposit);	
        Thread wit1  = new Thread(withdraw);
        Thread dep2  = new Thread(deposit);	
        Thread wit2  = new Thread(withdraw);
        Thread dep3  = new Thread(deposit);	
        Thread wit3  = new Thread(withdraw);
        Thread dep4  = new Thread(deposit);	
        Thread wit4  = new Thread(withdraw);
        Thread dep5  = new Thread(deposit);	
        Thread wit5  = new Thread(withdraw);
        Thread dep6  = new Thread(deposit);	
        Thread wit6  = new Thread(withdraw);
        Thread dep7  = new Thread(deposit);	
        Thread wit7  = new Thread(withdraw);
        Thread dep8  = new Thread(deposit);	
        Thread wit8  = new Thread(withdraw);
        Thread dep9  = new Thread(deposit);	
        Thread wit9  = new Thread(withdraw);
        Thread dep10 = new Thread(deposit);	
        Thread wit10 = new Thread(withdraw);
			
		
        dep1.start();			
        wit1.start();		
        dep2.start();			
        wit2.start();
        dep3.start();			
        wit3.start();		
        dep4.start();			
        wit4.start();		
        dep5.start();			
        wit5.start();		
        dep6.start();			
        wit6.start();		
        dep7.start();			
        wit7.start();
        dep8.start();			
        wit8.start();
        dep9.start();			
        wit9.start();
        dep10.start();		
        wit10.start();
			
		
		deposit.setDone();
		withdraw.setDone();
		
        dep1.interrupt();		
        wit1.interrupt();
        dep2.interrupt();		
        wit2.interrupt();
        dep3.interrupt();		
        wit3.interrupt();
        dep4.interrupt();		
        wit4.interrupt();
        dep5.interrupt();		
        wit5.interrupt();
        dep6.interrupt();		
        wit6.interrupt();
        dep7.interrupt();		
        wit7.interrupt();
        dep8.interrupt();		
        wit8.interrupt();
        dep9.interrupt();		
        wit9.interrupt();
        dep10.interrupt();	
        wit10.interrupt();
				
		
		try {
			dep1.join();
			dep2.join();
			dep3.join();
			dep4.join();
			dep5.join();
			dep6.join();
			dep7.join();
			dep8.join();
			dep9.join();
			dep10.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 		
	}
}