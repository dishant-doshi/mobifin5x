package base;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TestDataImport extends SetupInit {
	public static Object[][] readExcelFileTo2D(String filepath, String sheetname) {
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(new File(filepath));
		} catch (BiffException | IOException e) {
			e.printStackTrace();
		}
		Sheet sheet = workbook.getSheet(sheetname);
		int lastRowNum = sheet.getRows();
		Object[][] object = new Object[lastRowNum - 1][1];
		for (int i = 1; i < lastRowNum; i++) {
			Map<Object, Object> map = new LinkedHashMap<Object, Object>();
			for (int j = 0; j < sheet.getColumns(); j++) {
				map.put(removeExtraSpaces(sheet.getCell(j, 0).getContents().toString().trim().replaceAll("  ", " ")),
						removeExtraSpaces(sheet.getCell(j, i).getContents().toString().trim().replaceAll("  ", " ")));
			}
			object[i - 1][0] = map;
		}
		return object;
	}

	/**
	 * @author dishant.doshi to remove extra spaces in string
	 * @param string
	 * @return string with one space
	 * @creation date 28/12/2018
	 */
	public static String removeExtraSpaces(String string) {
		return string.replaceAll("\\s+", " ");
	}

	public static int findRow(String fileName, String sheetName, String cellContent) {
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(new File(fileName));
		} catch (BiffException | IOException e) {
			e.printStackTrace();
		}
		Sheet sheet = workbook.getSheet(sheetName);
		int rows = sheet.getRows();
		for (int i = 1; i < rows; i++) {
			Cell cell = sheet.getCell(0, i);
			if (cell.getContents().toString().equals(cellContent)) {
				return i;
			}
		}
		return 0;
	}

	public static Map<Object, Object> readExcelFileTo2D(String fileName, String sheetName, int rowNumber) {
		File inputWorkbook = new File(fileName);
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(inputWorkbook);
		} catch (BiffException | IOException e) {
			e.printStackTrace();
		}
		Map<Object, Object> map = new LinkedHashMap<Object, Object>();
		Sheet sheet = workbook.getSheet(sheetName);
		int columns = sheet.getColumns();
		for (int j = 0; j < columns; j++) {
			map.put(sheet.getCell(j, 0).getContents().toString().trim().replaceAll("  ", " "),
					sheet.getCell(j, rowNumber).getContents().toString().trim().replaceAll("  ", " "));
		}
		return map;
	}

	@DataProvider(name = "Parameter_Add")
	public static Object[][] Parameter_Add() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Parameter_Add");
	}

	@DataProvider(name = "SystemOperatorEntity_Add")
	public static Object[][] SystemOperatorEntity_Add() {
		return readExcelFileTo2D(OPERATORCONFIG_FILE_PATH, "SystemOperatorEntity_Add");
	}

	@DataProvider(name = "SystemOperatorOnboarding_Add")
	public static Object[][] SystemOperatorOnboarding_Add() {
		return readExcelFileTo2D(OPERATORCONFIG_FILE_PATH, "SystemOperatorOnboarding_Add");
	}
	
	@DataProvider(name = "OperatingEntity_Add")
	public static Object[][] OperatingEntity_Add() {
		return readExcelFileTo2D(BUSINESSCONFIG_FILE_PATH, "OperatingEntity_Add");
	}
}
