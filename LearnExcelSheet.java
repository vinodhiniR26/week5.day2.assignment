package week5.day2.assignment;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LearnExcelSheet {
	public static String[][] getData(String excelFileStatus) throws IOException {
		XSSFWorkbook book = new XSSFWorkbook("./TestData/testData.xlsx");
		
		XSSFSheet sheetAt = book.getSheetAt(0);
		
		int rowCount = sheetAt.getLastRowNum();//print how many rows in the excel sheet
		System.out.println("No.of Rows are" + rowCount); //op : 2
		
		int colCount = sheetAt.getRow(0).getLastCellNum();
		System.out.println("No.of columns are "+ colCount); // print how many column in the excel sheet
		//op  :2 main() - we get op as 2 row n 2 column . we convert getData()-String array[][].
			
		String[][] data = new String[rowCount][colCount];
		
		for (int i = 1; i <= rowCount; i++) {    //int i =1, 0th position value as header so 1 we take it
			XSSFRow row = sheetAt.getRow(i);
			
			for (int j = 0; j < colCount; j++) {
				XSSFCell cell = row.getCell(j);
				String stringCellValue = cell.getStringCellValue();
				data[i-1][j] = stringCellValue; //i =0,so i-1 = 0-0= 0,j= 0 it take excel value as demosaleamanager
				
			}
		}
		book.close();
		return data;	
		
	}
}
	