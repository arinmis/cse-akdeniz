import java.util.ArrayList;

public class NewsNotificationServer implements Subject {
    private ArrayList<Observer> observers;
    private NewsNotification notification;

    public NewsNotificationServer() {
        observers = new ArrayList<Observer>();
    }

    public void setNotification(NewsNotification notification)  {
        this.notification = notification;
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(notification);
        }
    }
    
}
