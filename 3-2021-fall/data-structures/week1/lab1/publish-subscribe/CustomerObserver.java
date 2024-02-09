
public class CustomerObserver implements Observer{
    //Subscriber name
    private String name;
    private int version;

    public CustomerObserver(String name){
        this.name = name;
    }

    @Override
    public void update(int version) {
        this.version=version;
        System.out.println("The magazine has a new edition");
        this.buy();
    }

    public void buy(){
        System.out.println(name+"Bought the first"+version+"Issue magazine!");
    }

}

