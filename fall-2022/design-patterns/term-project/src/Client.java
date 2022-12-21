public abstract class Client implements Observer {
    NotificationWay notificationWay;
    NewsNotification newsNotification;
    NewsNotificationServer newsNotificationServer;

    public Client(NotificationWay notificationWay) { 
        this.notificationWay = notificationWay;
    }

    public void setNotification(NewsNotification newsNotification) { 
        this.newsNotification = newsNotification;
    }
    
}
