package designpattern.observer;

public class CNNChannel implements  Observer {

    @Override
    public void receiveUpdates(String observed) {
        System.out.println("We are CNN. Observerved this news: " + observed);
    }
}
