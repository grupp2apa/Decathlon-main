package excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;

public class ExcelPrinter {

	private XSSFWorkbook workbook;
	private String excelFilePath;

	public ExcelPrinter(String filePath) throws IOException {

		excelFilePath = filePath;
		File excelFile = new File(excelFilePath);

		if (!excelFile.exists()) {
			System.out.println("Excel file does not exist at the specified path: " + excelFilePath);
		}

		FileInputStream file = new FileInputStream(excelFilePath);
		workbook = new XSSFWorkbook(file);

	}

	public void add(Object[][] data, String sheetName) {

		XSSFSheet sheet = workbook.getSheet(sheetName);

		if (sheet == null) {
			sheet = workbook.createSheet(sheetName);
		}

		int lastRow = sheet.getLastRowNum() + 1;

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