package excel;

import java.util.List;
import java.util.ArrayList;

public class ExcelMaker {
    private final List<String> competitorNames;
    private final List<Double> competitorScores;

    public ExcelMaker() {
        competitorNames = new ArrayList<>();
        competitorScores = new ArrayList<>();
    }

    public void addCompetitorAndScore(String competitorName, double score) {
        competitorNames.add(competitorName);
        competitorScores.add(score);
    }

    public List<String> getCompetitorNames() {
        return competitorNames;
    }

    public List<Double> getCompetitorScores() {
        return competitorScores;
    }
}