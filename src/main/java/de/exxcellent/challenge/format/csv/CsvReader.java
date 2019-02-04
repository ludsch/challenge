package de.exxcellent.challenge.format.csv;

import java.util.ArrayList;
import java.util.List;

public class CsvReader<T, U> {

    private List<T> rows = new ArrayList<>();




    public List<T> getRows() {
        return rows;
    }

    private void addRow(T row) {
        rows.add(row);
    }
}


