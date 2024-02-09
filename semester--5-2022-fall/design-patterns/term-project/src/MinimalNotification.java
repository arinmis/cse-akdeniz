public class MinimalNotification implements NotificationWay {
    public void push(NewsNotification newsNotification) {
        System.out.println("----- " + newsNotification.title);
    }
}


