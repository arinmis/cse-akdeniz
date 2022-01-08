public interface Subject {
    //Add observer
    void addObserver(Observer obj);
    //Remove observer
    void deleteObserver(Observer obj);
    //When the subject method changes, this method is called to notify all observers
    void notifyObserver();
}

