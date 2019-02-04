package de.exxcellent.challenge.format.csv.data.definition;

public class FootBallData {
    int goals;
    int goalsAllowed;

    public int getGoals() {
        return goals;
    }

    public int getGoalsAllowed() {
        return goalsAllowed;
    }

    public FootBallData(int goals, int goalsAllowed) {
        this.goals = goals;
        this.goalsAllowed = goalsAllowed;
    }
}
