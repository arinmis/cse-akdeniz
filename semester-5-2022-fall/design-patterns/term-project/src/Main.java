public class Main {
    public static void main(String[] args) {
        /* create news notification server */
        NewsNotificationServer newsNotificationServer = new NewsNotificationServer();

        /* create clients */
        SmartPhone smartPhone =
         new SmartPhone(new FullNotification());
        WebBrowser webBrowser =
         new WebBrowser(new BlockNotification());
        SmartWatch smartWatch =
         new SmartWatch(new MinimalNotification());

        /* smart phone subscribe to new server */ 
        newsNotificationServer.registerObserver(smartPhone);  
        newsNotificationServer.registerObserver(webBrowser);  
        newsNotificationServer.registerObserver(smartWatch);  


         /* publish first notification */
         NewsNotification firstNewsNotification = 
         new NewsNotification("Breaking News", "Our news server is up and running💪");

        newsNotificationServer.setNotification(firstNewsNotification);
        newsNotificationServer.notifyObservers();


        /* comment out code below to see how web browser behave differently */
        System.out.println("\n\n\n");

        /* publish second notification */
        NewsNotification secondNewsNotification = 
         new NewsNotification("Web Browser Started to Running", "Web browser is running now, so it changed way to notification.");

        webBrowser.run(); // run web browser to receive notification


        newsNotificationServer.setNotification(secondNewsNotification);
        newsNotificationServer.notifyObservers();


    }
}