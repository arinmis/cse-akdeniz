public abstract class Beverage {
    String description = new String();

    public String getDescription() { 
        return description;
    }

    public abstract double cost();
}