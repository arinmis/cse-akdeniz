public class SmartWatch extends Client  {

    public void update(NewsNotification newsNotification) {
        System.out.println("⌚ SMARTWATCH");
        notificationWay.push(newsNotification);
    }

    public SmartWatch(NotificationWay notificationWay) {
        super(notificationWay);
    }
}
