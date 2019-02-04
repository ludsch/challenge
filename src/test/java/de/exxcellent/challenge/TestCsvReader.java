package de.exxcellent.challenge;

import de.exxcellent.challenge.format.csv.CsvReader;
import de.exxcellent.challenge.format.csv.data.definition.WeatherData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCsvReader {

    CsvReader<WeatherData, String> csvReader;

    @Nested
    @DisplayName("Parsing")
    public class Parsing {

    }
}
