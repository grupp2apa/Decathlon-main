package excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelPrinter {
	private XSSFWorkbook workbook;
	private String excelFilePath;

	public ExcelPrinter(String filePath) {
		excelFilePath = filePath;
		workbook = new XSSFWorkbook();
	}

	public void add(Object[][] data, String sheetName) {
		XSSFSheet sheet = workbook.createSheet(sheetName);

		// Create a header row
		Row headerRow = sheet.createRow(0);
		Cell headerCell = headerRow.createCell(0);
		headerCell.setCellValue("Name");

		headerCell = headerRow.createCell(1);
		headerCell.setCellValue("Discipline");

		headerCell = headerRow.createCell(2);
		headerCell.setCellValue("Score");

		sheet.setColumnWidth(0, 15 * 356); // Width for the "Name" column
		sheet.setColumnWidth(1, 15 * 556); // Width for the "Discipline" column
		sheet.setColumnWidth(2, 15 * 156); // Width for the "Score" column

		for (Object[] rowObject : data) {
			int lastRow = sheet.getLastRowNum() + 1;
			Row row = sheet.createRow(lastRow);

			for (int i = 0; i < rowObject.length; i++) {
				Cell cell = row.createCell(i);

				if (rowObject[i] instanceof String) {
					cell.setCellValue((String) rowObject[i]);
				} else if (rowObject[i] instanceof Double) {
					cell.setCellValue((Double) rowObject[i]);
				}
			}
		}
	}

	public void write() throws IOException {
		try {
			FileOutputStream out = new FileOutputStream(excelFilePath);
			workbook.write(out);
			out.close();
			workbook.close();
			System.out.println("Data has been written to Excel file successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}