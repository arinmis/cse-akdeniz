
import java.util.ArrayList;
import java.util.List;

public class MagazineSubject implements Subject{
    //Store subscribers
    private List<Observer> observers=new ArrayList<Observer>();
    //Journal version
    private int version;

    @Override
    public void addObserver(Observer obj) {
        observers.add(obj);
    }

    @Override
    public void deleteObserver(Observer obj) {
        int i = observers.indexOf(obj);
        if(i>=0){
            observers.remove(obj);
        }
    }

    @Override
    public void notifyObserver() {
        for(int i=0;i<observers.size();i++){
            Observer o=(Observer)observers.get(i);
            o.update(version);
        }
    }

    //The magazine has released a new edition
    public void publish(){
        //New version
        this.version++;
        //Notify all observers when the information is updated
        notifyObserver();
    }

}
