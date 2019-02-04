package de.exxcellent.challenge;

import de.exxcellent.challenge.format.csv.CsvReader;
import de.exxcellent.challenge.format.csv.data.definition.FootBallData;
import de.exxcellent.challenge.format.csv.data.definition.WeatherData;
import de.exxcellent.challenge.format.csv.data.mapper.FootBallDataCsvRecordMapper;
import de.exxcellent.challenge.format.csv.data.mapper.WeatherDataCsvRecordMapper;
import de.exxcellent.challenge.format.csv.processors.footballdata.MinimumGoalDifference;
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
        final String CHALLENGE_DATA_FILE_PATH = "/de/exxcellent/challenge/";

        // Weather data solution
        CsvReader<WeatherData, Integer> weatherDataCsvReader = new CsvReader<>(new WeatherDataCsvRecordMapper());
        try {
            weatherDataCsvReader.parse(CHALLENGE_DATA_FILE_PATH + "weather.csv");
        } catch (IOException e) {
            System.out.printf("%s%n", e.getMessage());
        }
        String dayWithSmallestTempSpread = String.valueOf(weatherDataCsvReader.process(new FindMinimumSpreadInAMonth()));
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);


        // Football data solution
        CsvReader<FootBallData, String> footBallDataCsvReader = new CsvReader<>(new FootBallDataCsvRecordMapper());
        try {
            footBallDataCsvReader.parse(CHALLENGE_DATA_FILE_PATH + "football.csv");
        } catch (IOException e) {
            System.out.printf("%s%n", e.getMessage());
        }

        String teamWithSmallestGoalSpread = footBallDataCsvReader.process(new MinimumGoalDifference());
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
