package marathon3;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
public static String[][] main(String fileName) throws IOException {
	
	XSSFWorkbook wbook=new XSSFWorkbook("Data/"+fileName+".xlsx");
	XSSFSheet sheet = wbook.getSheetAt(0);
	int rowCount = sheet.getLastRowNum();
	short columnCount = sheet.getRow(0).getLastCellNum();
	String [][] data=new String[rowCount][columnCount];
	for(int i=1;i<=rowCount;i++) {
        XSSFRow row = sheet.getRow(i);//ctrl+2+l
        //column count using inner loop
        for (int j = 0; j<columnCount; j++) {
        XSSFCell cell = row.getCell(j);//ctrl+2+l
        System.out.println(cell.getStringCellValue());
        data[i-1][j]= cell.getStringCellValue();//0 0
        
        }
        
        }
        //to close the workbook
        wbook.close();
        return data;
}
}
