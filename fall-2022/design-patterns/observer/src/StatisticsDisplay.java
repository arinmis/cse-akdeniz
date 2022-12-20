import java.util.ArrayList;

public class StatisticsDisplay implements Observer, DisplayElement {
    
    private ArrayList<Float> oldTemperatures;
    private Subject weatherData;
    private float min;
    private float max;
    private float avg;

    public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
        oldTemperatures = new ArrayList<Float>();
    }

    public void update(float temperature, float humidity, float pressure) {
        oldTemperatures.add(temperature);
        updateStats();
        // this.humidity = humidity;
        display();
    }

    /* recalculate statistics */
    public void updateStats() {
        float min = oldTemperatures.get(0);
        float max = oldTemperatures.get(0);
        float sum = 0;
        for (Float value : oldTemperatures) {
            min = Math.min(min, value);
            min = Math.max(max, value);
            sum += value;
        }
        // update stats
        this.min = min;
        this.max = max;
        this.avg = sum / oldTemperatures.size();
    }

    public void display() {
        System.out.println("Current stats min/max/avg: " + min + "/" + max + "/" + avg); 
    }
}