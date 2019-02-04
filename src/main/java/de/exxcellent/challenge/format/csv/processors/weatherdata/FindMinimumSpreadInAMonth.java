package de.exxcellent.challenge.format.csv.processors.weatherdata;

import de.exxcellent.challenge.format.csv.data.definition.WeatherData;
import de.exxcellent.challenge.format.csv.processors.CsvProcessor;

import java.util.List;

public class FindMinimumSpreadInAMonth implements CsvProcessor<WeatherData, Integer> {
    @Override
    public Integer process(List<WeatherData> data) {
        return 0;
    }
}
