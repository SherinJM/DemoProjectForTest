package excelhandler;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static XSSFWorkbook wb;

	public static Object[][] getDataFromSheet(String sheetName) {

		System.out.println("****Loading excel******");
		Object[][] arr = null;

		try {
			// load excel
			wb = new XSSFWorkbook(new FileInputStream(new File("./TestData/testData.xlsx")));

			// load sheet
			XSSFSheet sheet = wb.getSheet(sheetName);

			int row = sheet.getPhysicalNumberOfRows();
			System.out.println(sheet.getPhysicalNumberOfRows());
			int column = sheet.getRow(0).getPhysicalNumberOfCells();
			arr = new Object[row - 1][column];

			for (int i = 1; i < row; i++) {
				for (int j = 0; j < column; j++) {
					// arr[i][j] = wb.getSheet(sheetName).getRow(i).getCell(j).getStringCellValue();
					arr[i - 1][j] = getData(sheetName, i, j);
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return arr;
	}

	public static String getData(String sheetName, int row, int column) {
		XSSFCell cell = wb.getSheet(sheetName).getRow(row).getCell(column);
		String data = "";

		if (cell.getCellType() == CellType.STRING) {
			data = cell.getStringCellValue();

		} else if (cell.getCellType() == CellType.NUMERIC) {
			double dataInDouble = cell.getNumericCellValue();
			data = String.valueOf(dataInDouble);

		} else if (cell.getCellType() == CellType.BLANK) {
			data = "";
		}
		return data;
	}

}
