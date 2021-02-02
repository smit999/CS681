package edu.umb.cs681.hw01;

public class DjiaQuoteObservable extends Observable{
    void changeQuote(String ticker, float quote) {
        setChange();
        notifyObservers(new DjiaEvent(quote));
    }
}