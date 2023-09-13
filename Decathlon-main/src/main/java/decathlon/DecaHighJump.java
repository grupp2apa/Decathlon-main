package decathlon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import common.CalcTrackAndField;
import common.InputResult;
import common.InputName;
import common.Main;

public class DecaHighJump {

	private int score;
	private double A = 0.8465;
	private double B = 75;
	private double C = 1.42;
	boolean active = true;
	CalcTrackAndField calc = new CalcTrackAndField();
	InputResult inputResult = new InputResult();
    InputName inputName = new InputName();
    Main main = new Main();

	// Calculate the score based on distance and height. Measured in centimeters.
	public void calculateResult(double distance) {

		while (active) {

			try {
				// Acceptable values.
				if (distance < 0) {
					System.out.println("Value too low");
					distance = inputResult.enterResult();
				} else if (distance > 300) {
					System.out.println("Value too high");
					distance = inputResult.enterResult();
				} else {

					score = calc.calculateField(A, B, C, distance);
					active = false;
				}
			} catch (Exception e) {

				System.out.println("Please enter numbers");
			}
		}
		System.out.println("The result is: " + score);
	
		//Skapa ny workBook
        XSSFWorkbook workbook = new XSSFWorkbook();
			   
        //skapa en ny yta (SKALL ÄNDRAS SÅ ATT DEN LÄSER VAD SOM FINNS REDAN)
        XSSFSheet sheet = workbook.createSheet("DecaHighJump");

        
        
        
          
        //Datan som skall skrivas
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[] {"CompetitorName","Score"});
        data.put("2", new Object[] {inputName.addCompetitor(),score});
                  
        //Skriv datan
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset)
        {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
               Cell cell = row.createCell(cellnum++);
               if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
        try
        {
            //Outputta till Excel
            
            FileOutputStream out = new FileOutputStream(new File("Decathlon.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("DecaHighJump.xlsx written successfully on disk.");
            
            
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }}


