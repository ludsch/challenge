package de.exxcellent.challenge;

import de.exxcellent.challenge.format.csv.CsvReader;
import de.exxcellent.challenge.format.csv.data.definition.WeatherData;
import de.exxcellent.challenge.format.csv.data.mapper.WeatherDataCsvRecordMapper;
import de.exxcellent.challenge.format.csv.processors.weatherdata.FindMinimumSpreadInAMonth;

import java.io.IOException;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …
        CsvReader<WeatherData, Integer> weatherDataCsvReader = new CsvReader<>(new WeatherDataCsvRecordMapper());
        try {
            weatherDataCsvReader.parse("/de/exxcellent/challenge/weather.csv");
        } catch (IOException e) {
            System.out.printf("%s%n", e.getMessage());
        }
        String dayWithSmallestTempSpread = String.valueOf(weatherDataCsvReader.process(new FindMinimumSpreadInAMonth()));
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);



        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
