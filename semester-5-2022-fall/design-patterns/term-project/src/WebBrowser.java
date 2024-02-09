public class WebBrowser extends Client {
    public void update(NewsNotification newsNotification) {
        System.out.println("🌐 WEBBROWSER");
        notificationWay.push(newsNotification);
    }

    public WebBrowser(NotificationWay notificationWay) {
        super(notificationWay);
    }

    public void run() {
        this.notificationWay = new FullNotification();
    }

    public void kill() {
        this.notificationWay = new BlockNotification();
    }
}