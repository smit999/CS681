package edu.umb.cs681.hw01;

public class MyObserverDemo {

    public static void main (String args[]){

        StockQuoteObservable stock = new StockQuoteObservable();
        stock.addObserver((Observable o, Object obj) -> {System.out.println("stock Obs 1 notified.");}	);
        
        stock.changeQuote("TATA", 1416); //STOCK : OBS 1 -> notif
        
        stock.addObserver((Observable o, Object obj) -> {System.out.println("stock Obs 2 notified.");}	);
        stock.changeQuote("JIO", 150);

        DjiaQuoteObservable djia = new DjiaQuoteObservable();
        djia.addObserver((Observable o, Object obj) -> {System.out.println("DJIA Obs 1 notified");}	);
        
        djia.changeQuote("PAYTM", 450); //DJIA : OBS 1 -> notif
        
        djia.addObserver((Observable o, Object obj) -> {System.out.println("DJIA Obs 2 notified");}	);
        djia.changeQuote("NIFTY", 160);
    }
}
