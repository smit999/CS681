package edu.umb.cs681.hw08;

public class RunnableConcurrentSingleton implements Runnable {

    public void run(){
        System.out.println("Instance of class ConcurrentSingleton : " + ConcurrentSingleton.getInstance());
    }

    public static void main(String args[]){
        new Thread(new RunnableConcurrentSingleton()).start();
        new Thread(new RunnableConcurrentSingleton()).start();
        new Thread(new RunnableConcurrentSingleton()).start();
    }
}