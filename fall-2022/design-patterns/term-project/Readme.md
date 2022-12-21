# Statement of Work

This is a news service that notifies users when something new happened in the world. It has classic architecture, the system has two parts: clients and server. When an interesting event happens according to the server admin, the admin uploads it to the news server. After upload, the news server notifies all the clients who have subscribed to the news server.  Each news consists of two parts: the title of the news and the news description. This application is supported on several platforms:
    * Smart Phones
    * Web Browsers 
    * Smart Watches

So one server should push information to multiple different platforms. Although information sended by the server is the same to each client, the way to present this information in notifications varies on each platform. 

* Smart Phones
Smartphones are the best because they can directly show notifications with titles and descriptions to users.

* Web Browsers 
Web browsers cannot send notifications all the time because they can't pop-up notifications while the web browser does not run, the user must be running the news application on his/her web browser.

* Smart Watches
 Lastly, smart watches have too tiny a screen so they don't have enough screen size to present news descriptions, they can only show the title of the news to users.  

## Design Patterns
There are two design patterns to solve this problem **strategy** and **observer** pattern. 

Phases like **subscription**, **one server to many client**, **notification** obviously address the observer pattern because there is a one-to-many relation between server and clients. There are different kinds of clients and they have to subscribe to new servers to be notified whenever a new news is added to the server. In this problem, our subject is the news server and object.

We have several kinds of clients and their behavior, and algorithm to present news notification, varies. We can solve this problem with a strategy design pattern. There are 3 type of behavior(algorithm) to present notification:  
    * FullNotification
        - Presents notification title and description, suitable for smartphones and running browsers.
    * MinimalNotification
        - Only presents the title of the notification, suitable for smart watches.
    * BlockNotification
        - Does not notify the client at all, suitable for browsers that are not running.
Those are notification behavior that we can choose for each type of client. For web browser clients, notification behavior may change depending on browser status(running or not). If the browser is running it uses the *FullNotification* behavior, otherwise, it just blocks the notification.
