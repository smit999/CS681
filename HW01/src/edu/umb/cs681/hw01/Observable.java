package edu.umb.cs681.hw01;

import java.util.LinkedList;

public class Observable {
    protected boolean change;
    protected LinkedList<Observer> observer = new LinkedList<Observer>();

    public void addObserver(Observer obs){
        if (!observer.contains(obs)){
            observer.add(obs);
        }
    }

    public void deleteObserver(Observer obs){
        if (observer.contains(obs)){
            observer.remove(obs);
        }
    }

    protected boolean isChanged(){
        return change;
    }

    protected  int countObserver(){
        return  observer.size();
    }

    protected void setChange() {
        change = true;
    }

    protected void clearChange() {
        change = false;
    }

    public void notifyObservers(Object obj) {
        if (isChanged()	) {
            observer.forEach((Observer observer) -> observer.update(this, obj)	);
            clearChange();
        }
    }
}
