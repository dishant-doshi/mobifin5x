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

	@DataProvider(name = "OperatingEntityTemplate_Add")
	public static Object[][] OperatingEntityTemplate_Add() {
		return readExcelFileTo2D(BUSINESSCONFIG_FILE_PATH, "OperatingEntityTemplate_Add");
	}

	@DataProvider(name = "BusinessZone_Add")
	public static Object[][] BusinessZone_Add() {
		return readExcelFileTo2D(BUSINESSCONFIG_FILE_PATH, "BusinessZone_Add");
	}

	@DataProvider(name = "SystemOperatorEntity_Edit")
	public static Object[][] SystemOperatorEntity_Edit() {
		return readExcelFileTo2D(OPERATORCONFIG_FILE_PATH, "SystemOperatorEntity_Edit");
	}

	@DataProvider(name = "SystemOperatorEntity_Delete")
	public static Object[][] SystemOperatorEntity_Delete() {
		return readExcelFileTo2D(OPERATORCONFIG_FILE_PATH, "SystemOperatorEntity_Delete");
	}

	@DataProvider(name = "SystemOperatorEntity_Sort")
	public static Object[][] SystemOperatorEntity_Sort() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "SystemOperatorEntity_Sort");
	}
	
	@DataProvider(name = "Parameter_Edit")
	public static Object[][] Parameter_Edit() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Parameter_Edit");
	}
	
	@DataProvider(name = "Parameter_Delete")
	public static Object[][] Parameter_Delete() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Parameter_Delete");
	}

	@DataProvider(name = "KYC_Add")
	public static Object[][] KYC_Add() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "KYC_Add");
	}
	
	@DataProvider(name = "KYC_Edit")
	public static Object[][] KYC_Edit() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "KYC_Edit");
	}
	@DataProvider(name = "KYC_Delete")
	public static Object[][] KYC_Delete() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "KYC_Delete");
	}
	@DataProvider(name = "UserCategory_Add")
	public static Object[][] UserCategory_Add() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "UserCategory_Add");
	}
	
	@DataProvider(name = "UserCategory_Edit")
	public static Object[][] UserCategory_Edit() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "UserCategory_Edit");
	}
	@DataProvider(name = "UserCategory_Delete")
	public static Object[][] UserCategory_Delete() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "UserCategory_Delete");
	}
	@DataProvider(name = "Unit_Add")
	public static Object[][] Unit_Add() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Unit_Add");
	}
	
	@DataProvider(name = "Unit_Edit")
	public static Object[][] Unit_Edit() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Unit_Edit");
	}
	@DataProvider(name = "Unit_Delete")
	public static Object[][] Unit_Delete() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Unit_Delete");
	}
}
