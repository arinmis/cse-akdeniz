public class Light { 
    boolean isOn;

    public Light() { 
        this.isOn = false;
    }

    public void on() { 
        System.out.println("Light is on");
        this.isOn = true;
    }

    public void off() { 
        System.out.println("Light is off");
        this.isOn = false;
    }
}
