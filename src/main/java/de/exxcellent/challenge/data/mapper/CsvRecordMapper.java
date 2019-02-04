package de.exxcellent.challenge.data.mapper;

import java.util.Map;

public interface CsvRecordMapper<T> {
    T map(Map<String, String> record);
}
