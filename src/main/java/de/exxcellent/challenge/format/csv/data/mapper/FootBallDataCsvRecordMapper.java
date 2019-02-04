package de.exxcellent.challenge.format.csv.data.mapper;

import de.exxcellent.challenge.format.csv.data.definition.FootBallData;

import java.util.Map;

public class FootBallDataCsvRecordMapper implements CsvRecordMapper<FootBallData> {
    @Override
    public FootBallData map(Map<String, String> record) {
        String team = record.get("Team");
        int goals = Integer.parseInt(record.get("Goals"));
        int goalsAllowed = Integer.parseInt(record.get("Goals Allowed"));

        return new FootBallData(team, goals, goalsAllowed);
    }
}
