package udemyBaseClass;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelClass {

	public static ArrayList<String> getExcel() throws IOException {
		String excelPath = System.getProperty("user.dir") + "/src/test/java/udemyFile/cred4.xlsx";
		String sheetName = "Sheet 1";
		XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
		
		String email = workbook.getSheet(sheetName).getRow(2).getCell(0).getStringCellValue();
		String password = workbook.getSheet(sheetName).getRow(2).getCell(1).getStringCellValue();
		String changePassword = workbook.getSheet(sheetName).getRow(2).getCell(2).getStringCellValue();
		
		workbook.close();
		
		ArrayList<String> list = new ArrayList<String>();
		list.add(email);
		list.add(password);
		list.add(changePassword);
		
		return list;
		
	}
	
	public static void pushExcel(String p1, String p2) throws IOException {
		String excelPath = System.getProperty("user.dir") + "/src/test/java/udemyFile/cred4.xlsx";
		String sheetName = "Sheet1";
		XSSFWorkbook workbook = new XSSFWorkbook(excelPath);

		workbook.getSheet(sheetName).getRow(2).getCell(1).setCellValue(p2);
		workbook.getSheet(sheetName).getRow(2).getCell(2).setCellValue(p1);

		workbook.close();
	}
}
