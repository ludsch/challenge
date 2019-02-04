package de.exxcellent.challenge.format.csv.data.definition;

public class FootBallData {
    String team;
    int goals;
    int goalsAllowed;

    public String getTeam() {
        return team;
    }

    public int getGoals() {
        return goals;
    }

    public int getGoalsAllowed() {
        return goalsAllowed;
    }

    public FootBallData(String team, int goals, int goalsAllowed) {
        this.team = team;
        this.goals = goals;
        this.goalsAllowed = goalsAllowed;
    }
}
