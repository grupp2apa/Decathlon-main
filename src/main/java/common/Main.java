package common;

import excel.ExcelMaker;
import excel.ExcelPrinter;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String excelFilePath = "D:/Decathlon-main/Resultat/Decathlon.excel.xlsx";
		// Initialize ExcelMaker and ExcelPrinter objects
		ExcelMaker excelMaker = new ExcelMaker();
		ExcelPrinter excelPrinter = new ExcelPrinter(excelFilePath);

		Scanner scanner = new Scanner(System.in);

		while (true) {
			InputName inputName = new InputName();
			String competitorName = inputName.addCompetitor();

			SelectDiscipline selectDiscipline = new SelectDiscipline();
			selectDiscipline.inputSelection();
			double competitorScore = selectDiscipline.getCompetitorScore();
			String selectedDiscipline = selectDiscipline.selectedDiscipline(); // Get selected discipline

			// Use ExcelMaker to collect competitor data
			excelMaker.addCompetitorAndScore(competitorName, competitorScore, selectedDiscipline);

			System.out.println("Do you want to add more competitors? (yes/no)");
			String userResponse = scanner.nextLine();

			if (userResponse.equalsIgnoreCase("no")) {
				break;
			}
		}

		// Retrieve competitor data from ExcelMaker
		List<String> competitorNames = excelMaker.getCompetitorNames();
		List<Double> competitorScores = excelMaker.getCompetitorScores();
		List<String> selectedDisciplines = excelMaker.getSelectedDisciplines(); // Retrieve selected disciplines


		Object[][] competitorData = new Object[competitorNames.size()][3];

		for (int i = 0; i < competitorNames.size(); i++) {
			competitorData[i][0] = competitorNames.get(i);
			competitorData[i][2] = competitorScores.get(i);
			competitorData[i][1] = selectedDisciplines.get(i);

		}

		try {
			// Add data to the ExcelPrinter and write it to the Excel file
			excelPrinter.add(competitorData, "Competitors");
			excelPrinter.write();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}