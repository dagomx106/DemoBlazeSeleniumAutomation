package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;


public class ReadXLSData {
	
	@DataProvider(name = "Tdata")
	public String[][] getData(Method m) throws EncryptedDocumentException, IOException {
		String sheetName = m.getName();
		File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testdata.xlsx");
		FileInputStream fs = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fs);
		Sheet sName = wb.getSheet(sheetName);
		
		int totalRows = sName.getLastRowNum();
		Row rowCells = sName.getRow(0);
		int totalCol = rowCells.getLastCellNum();
		
		System.out.println("Filas totales: "+totalRows);
		System.out.println("Columnas totales: "+totalCol);
		
		DataFormatter format = new DataFormatter();
		String testData[][] = new String[totalRows][totalCol];
		
		for(int i=1; i<= totalRows; i++) {
			for (int j = 0; j < totalCol; j++) {
				
				testData[i-1][j]= format.formatCellValue(sName.getRow(i).getCell(j));
				System.out.println(testData[i-1][j]);
			}
		}
		return testData;	
	}
}
