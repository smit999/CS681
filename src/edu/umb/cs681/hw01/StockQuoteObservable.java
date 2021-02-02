package edu.umb.cs681.hw01;

public class StockQuoteObservable extends Observable{

    public void changeQuote(String tick, float quote) {
        this.setChange();
        this.notifyObservers(new StockEvent(tick, quote));
    }
}