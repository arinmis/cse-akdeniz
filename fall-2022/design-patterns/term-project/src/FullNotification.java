public class FullNotification implements NotificationWay {
    public void push(NewsNotification newsNotification) {
        System.out.println("----- " + newsNotification.title + "\n      " + newsNotification.desc);
    }
}
