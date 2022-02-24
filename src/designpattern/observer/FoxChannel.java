package designpattern.observer;

public class FoxChannel implements Observer {
    @Override
    public void receiveUpdates(String observed) {
        System.out.println("We are FOX. Observed this news but will falsify it anyways: " + observed);
    }
}
