package de.exxcellent.challenge.format.csv.data.definition;

public class WeatherData {
    private int day;
    private int maxTemp;
    private int minTemp;

    public int getDay() {
        return day;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public WeatherData(int day, int maxTemp, int minTemp) {
        this.day = day;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }
}
