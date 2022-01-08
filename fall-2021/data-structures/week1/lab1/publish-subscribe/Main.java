
public class Main{
    public static void main(String[] args) {
        //Create theme (observed)
        MagazineSubject magazine = new MagazineSubject();
        //Create three different observers
        CustomerObserver a = new CustomerObserver("A");
        CustomerObserver b = new CustomerObserver("B");
        CustomerObserver c = new CustomerObserver("C");
        //Register observers with the topic
        magazine.addObserver(a);
        magazine.addObserver(b);
        magazine.addObserver(c);

        //Update the subject data. When the data is updated, all registered observers will be notified automatically
        magazine.publish();
    }
}

