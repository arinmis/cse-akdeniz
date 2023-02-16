public class ChocolateBoiler { 
    private boolean empty;
    private boolean boiled;

    private static ChocolateBoiler uniqueInstance;

    /* control instantiation */
    private ChocolateBoiler() { 
        empty = true;
        boiled = false;
    }


    public static ChocolateBoiler getUniqueInstance() { 
        if (uniqueInstance == null) {
            synchronized (ChocolateBoiler.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new ChocolateBoiler();
                }
            }
        }    
        return uniqueInstance;
    }

    public void fill() { 
        if (isEmpty()) { 
            empty = false;
            boiled = false;
        }
    }

    public void drain() { 
        if (!isEmpty() && isBoiled()) {
            empty = true;
        }
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            boiled = true;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }

}
