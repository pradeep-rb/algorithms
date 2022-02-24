package designpattern.observer;

public interface Observable {
    void register(Observer observer);
    void publish(String observable);
}
