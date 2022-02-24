package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency implements  Observable {

    List<Observer> observers = new ArrayList<>();

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void publish(String observable) {
      observers.forEach(o -> o.receiveUpdates(observable) );
    }


}
