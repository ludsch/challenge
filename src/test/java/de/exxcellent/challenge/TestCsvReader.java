package de.exxcellent.challenge;

import de.exxcellent.challenge.format.csv.CsvReader;
import de.exxcellent.challenge.format.csv.data.definition.WeatherData;
import de.exxcellent.challenge.format.csv.data.mapper.WeatherDataCsvRecordMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCsvReader {

    CsvReader<WeatherData, String> csvReader;

    @Nested
    @DisplayName("Parsing")
    public class Parsing {
        @BeforeEach
        public void createReader() {
            csvReader = new CsvReader<>(new WeatherDataCsvRecordMapper());
        }

        @Test
        @DisplayName("a valid csv file with 30 rows adds 30 rows")
        public void csvWithThirtyRowsAddsThirtyRows() throws IOException {
            final String file = "/valid-weather-test.csv";
            final int nExpectedRows = 30;

            csvReader.parse(file);
            int nRowsAfterParse = csvReader.getRows().size();
            assertEquals(nExpectedRows, nRowsAfterParse);
        }

        @Test
        @DisplayName("an empty file adds no objects")
        public void emptyFileAddsNoObjects() throws IOException {
            final String file = "/empty.csv";

            int nRowsBeforeParse = csvReader.getRows().size();
            csvReader.parse(file);
            int nRowsAfterParse = csvReader.getRows().size();
            assertEquals(nRowsBeforeParse, nRowsAfterParse);
        }

        @Test
        @DisplayName("a non-existent file throws an exception")
        public void nonExistentFileThrowsAnException() {
            final String file = "/hide-and-seek.csv";
            assertThrows(NullPointerException.class, ()-> {
                csvReader.parse(file);
            });
        }

        @Test
        @DisplayName("adding null as a file throws an exception")
        public void addingNullFileThrowsAnException() {
            final String file = null;
            assertThrows(NullPointerException.class, ()-> {
                csvReader.parse(file);
            });
        }

        @Test
        @DisplayName("a non-csv file throws an exception")
        public void nonCSVfileThrowsException() {
            final String file = "/sample.txt";
            assertThrows(InputMismatchException.class, ()-> {
                csvReader.parse(file);
            });
        }

    }
}
