package excel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.util.List;
import java.util.ArrayList;

public class ExcelMaker {
    private final List<String> competitorNames;
    private final String filePath;

    public ExcelMaker(String filePath) {

        this.filePath = filePath;
        competitorNames = new ArrayList<>();

    }

    public void addCompetitor(String competitorName) {
        competitorNames.add(competitorName);
    }
    public List<String> getCompetitorNames() {
        return competitorNames;
    }

    public void createExcelFile() {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Competitors");

        Row headerRow = sheet.createRow(0);
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("NAME");

        int customWidth = 25;
        sheet.setColumnWidth(0, customWidth * 256);

        try {
            FileOutputStream out = new FileOutputStream(filePath);
            workbook.write(out);
            out.close();
            System.out.println("Excel file created successfully on disk.");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}