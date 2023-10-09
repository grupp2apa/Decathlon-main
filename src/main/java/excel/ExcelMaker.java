package excel;

import java.util.List;
import java.util.ArrayList;

public class ExcelMaker {
    private final List<String> competitorNames;
    private final List<Double> competitorScores;
    private final List<String> selectedDisciplines; // List to store selected disciplines


    public ExcelMaker() {

        competitorNames = new ArrayList<>();
        competitorScores = new ArrayList<>();
        selectedDisciplines = new ArrayList<>();


    }

    public void addCompetitorAndScore(String competitorName, double score, String selectedDiscipline) {

        competitorNames.add(competitorName);
        competitorScores.add(score);
        selectedDisciplines.add(selectedDiscipline); // Store selected discipline


    }

    public List<String> getCompetitorNames() {

        return competitorNames;

    }

    public List<Double> getCompetitorScores() {

        return competitorScores;

    }

    public List<String> getSelectedDisciplines() {
        return selectedDisciplines; // Getter for selected disciplines
    }

}