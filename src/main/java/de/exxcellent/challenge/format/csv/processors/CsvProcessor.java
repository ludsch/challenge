package de.exxcellent.challenge.format.csv.processors;

import java.util.List;

public interface CsvProcessor<T, U> {
    U process(List<T> data);
}
