package excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelPrinter {

	private XSSFWorkbook workbook;
	private String excelFilePath; // Store the file path

	// Constructor with file path parameter
	public ExcelPrinter(String filePath) throws IOException {
		excelFilePath = filePath;

		// Check if the file exists before attempting to open it
		File excelFile = new File(excelFilePath);
		if (!excelFile.exists()) {
			System.out.println("Excel file does not exist at the specified path: " + excelFilePath);
			// Handle this case, e.g., by creating the file if it doesn't exist
		}

		FileInputStream file = new FileInputStream(excelFilePath);
		workbook = new XSSFWorkbook(file);
	}

	// In ExcelPrinter class, modify the add method
	public void add(Object[][] data, String sheetName) {
		XSSFSheet sheet = workbook.getSheet(sheetName);
		if (sheet == null) {
			sheet = workbook.createSheet(sheetName);
		}

		// Determine the last row to append data
		int lastRow = sheet.getLastRowNum() + 1; // Increment by 1 to append new data

		for (Object[] rowData : data) {
			Row row = sheet.createRow(lastRow);
			lastRow++;
			int columnCount = 0;
			for (Object field : rowData) {
				Cell cell = row.createCell(columnCount);
				columnCount++;
				if (field instanceof String) {
					cell.setCellValue((String) field);
				} else if (field instanceof Integer) {
					cell.setCellValue((Integer) field);
				} else if (field instanceof Double) {
					cell.setCellValue((Double) field);
				}
			}
		}
	}

	public void write() throws IOException {
		System.out.println("Appending data to Excel file");
		FileOutputStream out = new FileOutputStream(excelFilePath);
		workbook.write(out);
		workbook.close();
		out.close();
	}
}