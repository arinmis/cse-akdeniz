public class SmartPhone extends Client {

    public void update(NewsNotification newsNotification) {
        System.out.println("📱 SMARTPHONE");
        notificationWay.push(newsNotification);
    }

    public SmartPhone(NotificationWay notificationWay) { 
        super(notificationWay);
    }
}
