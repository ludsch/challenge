package de.exxcellent.challenge.format.csv.processors.footballdata;

import de.exxcellent.challenge.format.csv.data.definition.FootBallData;
import de.exxcellent.challenge.format.csv.processors.CsvProcessor;

import java.util.List;

public class MinimumGoalDifference implements CsvProcessor<FootBallData, String> {
    @Override
    public String process(List<FootBallData> data) {
        String teamWithMinimalAbsGoalDifference = data.get(0).getTeam();
        int minAbsDiff = Math.abs(data.get(0).getGoalsAllowed() - data.get(0).getGoals());
        int absDiff = 0;

        for (FootBallData footBallData: data.subList(1, data.size())) {

            absDiff = Math.abs(footBallData.getGoalsAllowed() - footBallData.getGoals());

            if (absDiff < minAbsDiff) {
                minAbsDiff = absDiff;
                teamWithMinimalAbsGoalDifference = footBallData.getTeam();
            }
        }
        return teamWithMinimalAbsGoalDifference;
    }
}
