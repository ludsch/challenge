package de.exxcellent.challenge.format.csv.data.mapper;

import de.exxcellent.challenge.format.csv.data.definition.WeatherData;

import java.util.Map;

public class WeatherDataCsvRecordMapper implements CsvRecordMapper<WeatherData> {
    @Override
    public WeatherData map(Map<String, String> record) {
        int day = Integer.parseInt(record.get("Day"));
        int maxTemp = Integer.parseInt(record.get("MxT"));
        int minTemp = Integer.parseInt(record.get("MnT"));

        return new WeatherData(day, maxTemp, minTemp);
    }
}
