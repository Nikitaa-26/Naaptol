package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parameterization {
     public static String getData(String sheetName, int row,int cell) throws EncryptedDocumentException, IOException {
   	 FileInputStream file = new FileInputStream("");
     String value =WorkbookFactory.create(file).getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
     return value;
    			
    	
     }
}
