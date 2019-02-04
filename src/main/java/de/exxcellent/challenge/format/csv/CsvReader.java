package de.exxcellent.challenge.format.csv;

import de.exxcellent.challenge.format.csv.data.mapper.CsvRecordMapper;
import de.exxcellent.challenge.format.csv.processors.CsvProcessor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class CsvReader<T, U> {

    private List<T> rows = new ArrayList<>();

    private CsvRecordMapper<T> csvRecordMapper;


    public void parse(String filePath) throws IOException {
        // Each parse flushes data
        if (getRows().size() > 0) {
            rows.clear();
        }

        Reader in = null;

        try {

            if (!FilenameUtils.getExtension(filePath).equals("csv")) {
                throw new InputMismatchException();
            }

            in = new InputStreamReader(getClass().getResourceAsStream(filePath));
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader().parse(in);

            for (CSVRecord record: records) {
                addRow(csvRecordMapper.map(record.toMap()));
            }

            in.close();

        } catch (IOException e) {
            System.out.printf("%s%n", e.getMessage());
            throw e;

        } catch (InputMismatchException e) {
            System.out.printf("%s%n", e.getMessage());
            throw e;

        } finally {
            if (in != null) {
                in.close();
            }
        }
    }


    public U process(CsvProcessor<T, U> processor) {
        return processor.process(getRows());
    }


    public List<T> getRows() {
        return rows;
    }

    private void addRow(T row) {
        rows.add(row);
    }

    public CsvReader(CsvRecordMapper<T> csvRecordMapper) {
        this.csvRecordMapper = csvRecordMapper;
    }
}


