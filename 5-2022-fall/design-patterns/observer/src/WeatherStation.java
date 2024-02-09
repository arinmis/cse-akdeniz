public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weaterData = new WeatherData();

        /* create displays */
        CurrentConditionsDisplay currentDisplay = 
            new CurrentConditionsDisplay(weaterData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weaterData);

        weaterData.setMeasurements(80, 65, 30.4f);
        weaterData.setMeasurements(82, 70, 29.2f);
        weaterData.setMeasurements(78, 90, 29.2f);
    }
    
}
