package de.exxcellent.challenge.format.csv.processors.weatherdata;

import de.exxcellent.challenge.format.csv.data.definition.WeatherData;
import de.exxcellent.challenge.format.csv.processors.CsvProcessor;

import java.util.List;

public class FindMinimumSpreadInAMonth implements CsvProcessor<WeatherData, Integer> {
    @Override
    public Integer process(List<WeatherData> data) {
        int currentSpread = 0;
        int currentMinSpread = 0;

        WeatherData dayWithMinSpread = data.get(0);

        for (WeatherData weatherData: data.subList(1, data.size())) {

            currentSpread = weatherData.getMaxTemp() - weatherData.getMinTemp();
            currentMinSpread = dayWithMinSpread.getMaxTemp() - dayWithMinSpread.getMinTemp();

            if (currentSpread < currentMinSpread) {
                dayWithMinSpread = weatherData;
            }
        }
        return dayWithMinSpread.getDay();
    }
}
