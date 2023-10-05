package common;
import java.io.IOException;
import excel.ExcelMaker;
import excel.ExcelPrinter;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String excelFilePath = "D:/Decathlon-main/Resultat/Decathlon.excel.xlsx";

		ExcelMaker excelMaker = new ExcelMaker(excelFilePath);
		ExcelPrinter excelPrinter = null;

		Scanner scanner = new Scanner(System.in);

		while (true) {

			InputName inputName = new InputName();
			String competitorName = inputName.addCompetitor();
			excelMaker.addCompetitor(competitorName);
			SelectDiscipline selectDiscipline = new SelectDiscipline();
			selectDiscipline.inputSelection();

			System.out.println("Do you want to add more competitors? (yes/no)");
			String userResponse = scanner.nextLine();

			if (userResponse.equalsIgnoreCase("no")) {
				break;
			}

		}

		List<String> competitorNames = excelMaker.getCompetitorNames();
		Object[][] competitorData = new Object[competitorNames.size()][1];

		for (int i = 0; i < competitorNames.size(); i++) {
			competitorData[i][0] = competitorNames.get(i);
		}

		excelMaker.createExcelFile();

		try {

			excelPrinter = new ExcelPrinter(excelFilePath);
			excelPrinter.add(competitorData, "Competitors");
			excelPrinter.write();

		}
			catch (IOException e) {
			e.printStackTrace();
		}

		scanner.close();

	}

}