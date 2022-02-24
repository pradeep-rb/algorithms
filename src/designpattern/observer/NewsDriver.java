package designpattern.observer;

public class NewsDriver {

    public static void main(String[] args) {
        Observer cnn = new CNNChannel();
        Observer fox = new FoxChannel();

        Observable newsAgency = new NewsAgency();
        newsAgency.register(cnn);
        newsAgency.register(fox);

        newsAgency.publish("breaking news");
    }
}
