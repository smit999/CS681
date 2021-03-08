package edu.umb.cs681.basics;

import java.util.LinkedList;

class MCTest{
  public static void main(String[] args) throws Exception {
    LinkedList<Thread> threads = new LinkedList<Thread>();

    long nMultiplications  = Long.parseLong(args[0]);
    int nThreads = Integer.parseInt(args[1]);
    Thread t;

    for (int i = 0; i < nThreads; i++) {
    	t = new Thread( ()->{ for(long j = 1; j < nMultiplications; j++){int product = 25*25;} } );
    	threads.add(t);
    	t.start();
    }
  }
}
