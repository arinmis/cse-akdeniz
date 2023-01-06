public class Milk extends Beverage {

    Beverage beverage;

    public Milk(Beverage beverage) { 
        this.beverage = beverage;
    }


    public  String getDescription() { 
        return beverage.getDescription() + ", Milk";
    } 

    public double cost() { 
        return  .1 + beverage.cost();
    }
    
}
