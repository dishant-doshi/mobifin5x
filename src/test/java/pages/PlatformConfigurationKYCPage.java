package pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import base.CommonConstants;
import base.ScriptConstants;
import base.SetupInit;
import utils.Utility;

public class PlatformConfigurationKYCPage extends SetupInit {
	private CommonPage common;
	String IsYes = "Yes";
	String verifyElement = "(//td[text()='%s'])[1]";
	String dropDownValue = "//li[normalize-space(text())='%s']";
	By filterDownArrow = By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']");
	By filterBy = By.xpath("//li[normalize-space(text())='" + ScriptConstants.EQUEALS + "']");
	By txtNameInSearch = By.name("name");
	By txtName = By.id(Utility.readJSFile("INPUT_KYC_ADD_NAME", CommonConstants.ELEMENT_FILE));
	By txtDescription = By.id(Utility.readJSFile("INPUT_KYC_ADD_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By drpStatus = By.xpath("//*[@id='inputKYCAddStatus']//span[normalize-space(text())='%s']");
	By btnAddKYCLevel = By.xpath("//*[text()='" + ScriptConstants.KYC_KYCLEVEL_BUTTON + "']//parent::button");
	By txtLevelName = By.xpath("(//*[contains(@id,'LevelName')])[last()]");
	By btnselectLevelField = By.xpath("(//*[contains(@id,'LevelFieldsButton')])[last()]");
	By btnAddLevelFiels = By.xpath("//*[text()='" + ScriptConstants.KYC_ADDFIELD + "']//parent::button");
	By drplevelField = By.xpath("(//*[contains(@id,'LevelFields')]//*[@class='ant-select-arrow'])[last()]");
	By btnLevelFielsOk = By.xpath("//*[@role='dialog' and not(@style='display: none;')]//button[contains(.,'"
			+ ScriptConstants.KYC_OK + "')]");
	By drpStatusInSearch = By.xpath("//*[normalize-space(text())='"
			+ Utility.readJSFile("kyc.grid.status", CommonConstants.LABLE_FILE)
			+ "']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By selectMandatory = By.xpath("(//button[contains(@id,'IsMandatory') and @value='false'])[last()]");
	By selectEditable = By.xpath("(//button[contains(@id,'IsEditable') and @value='false'])[last()]");
	By drpLevelParameter = By.xpath("(//*[contains(@id,'LevelFields') and @class='ant-select-search__field'])[last()]");
	String name = "//*[normalize-space(text()) = '" + Utility.readJSFile("kyc.label.name", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String description = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("kyc.label.description", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String status = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("kyc.label.status", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String btnLevelNameDetail = "//*[normalize-space(text())='%s']//parent::tr//*[@class='ant-btn addBtn ant-btn-primary']";
	String verifyParameterField = "//*[normalize-space(text())='%s']";
	By txtDescriptionInEdit = By.id(Utility.readJSFile("INPUT_KYC_EDIT_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	String statusEdit = "//*[@id='inputKYCEditStatus']//span[normalize-space(text())='%s']";

	public PlatformConfigurationKYCPage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
	}

	public void selectStatus(String status) {
		clickOnElement(drpStatus, 2);
	}

	public void clickOnAddKYCLevel() {
		clickOnElement(btnAddKYCLevel, 0);
	}

	public void sendtextInName(String name) {
		sendKeys(txtName, name, 0);
	}

	public void sendtextInDescription(String description) {
		sendKeys(txtDescription, description, 0);
	}

	public void sendtextInLevelNameField(String levelname) {
		sendKeys(txtLevelName, levelname, 0);
	}

	public void clickOnSelectLevelField() {
		clickOnElement(btnselectLevelField, 0);
	}

	public void clickOnAddLevelFields() {
		clickOnElement(btnAddLevelFiels);
	}

	public void selectLevelField(String levalField) {
		clickOnElement(drplevelField);
		sendKeys(drpLevelParameter, levalField + Keys.ENTER, 0);
	}

	public void selectIsMandatory(String isMandatory) {
		if (isMandatory.equalsIgnoreCase(IsYes)) {
			clickOnElement(selectMandatory, 0);
		}
	}

	public void selectIsEditable(String isEditable) {
		if (isEditable.equalsIgnoreCase(IsYes)) {
			clickOnElement(selectEditable, 0);
		}
	}

	public void clickOnLevelFieldOkBtn() {
		clickOnElement(btnLevelFielsOk, 0);
	}

	public void clickOnViewDetailButton(String levelName) {
		clickOnElement(By.xpath(String.format(btnLevelNameDetail, levelName)), 0);
	}

	public void sendTextInDescriptionInEdit(String description) {
		sendKeys(txtDescriptionInEdit, description, 0);
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(By.xpath(String.format(statusEdit, status)), 1);
	}

	public void filterSearch(String name, String status, boolean isSubString) {
		common.commonFilterSearch();
		if (isSubString) {
			clickOnElement(filterDownArrow);
			clickOnElement(filterBy);
		}
		sendKeys(txtNameInSearch, name, 0);
		selectFromDropDown(drpStatusInSearch, By.xpath(String.format(dropDownValue, status)), 1);
		common.clickOnFilterSearchBtn();
	}

	public void addKYC(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(), true);
		if (veifyElementIsNotVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5)) {
			common.clickOnAddButton();
			sendtextInName(map.get(mapKeys.get(1)).toString());
			sendtextInDescription(map.get(mapKeys.get(2)).toString());
			selectStatus(map.get(mapKeys.get(3)).toString());
			String[] levelNameList = map.get(mapKeys.get(5)).toString().split(",");
			for (int m = 0; m < levelNameList.length; m++) {
				clickOnAddKYCLevel();
				sendtextInLevelNameField(levelNameList[m].trim());
				if (!map.get(mapKeys.get(5)).toString().equals("")) {
					clickOnSelectLevelField();
					String[] levelfieldList = map.get(mapKeys.get(6)).toString().split(";");
					String[] ismandatoryList = map.get(mapKeys.get(7)).toString().split(";");
					String[] isEditableList = map.get(mapKeys.get(8)).toString().split(";");
					String[] levelfield = levelfieldList[m].split(",");
					String[] ismandatory = ismandatoryList[m].split(",");
					String[] isEditable = isEditableList[m].split(",");
					for (int j = 0; j < levelfield.length; j++) {
						clickOnAddLevelFields();
						selectLevelField(levelfield[j].trim());
						selectIsMandatory(ismandatory[j].trim());
						selectIsEditable(isEditable[j].trim());
					}
					clickOnLevelFieldOkBtn();
				}
			}
			common.clickOnSaveBtn();
		}
	}

	public void verifyAddedKYC(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(), true);
		verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0);
		common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
		verifyVisible(By.xpath(String.format(name, map.get(mapKeys.get(1)).toString())), 0);
		verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(2)).toString())), 0);
		verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(3)).toString())), 2);
		int rows = Integer.parseInt(map.get(mapKeys.get(4)).toString());
		String[] levelNameList = map.get(mapKeys.get(5)).toString().split(",");
		for (int m = 0; m < rows; m++) {
			clickOnViewDetailButton(levelNameList[m]);
			if (!map.get(mapKeys.get(6)).toString().equals("")) {
				String[] levelfieldList = map.get(mapKeys.get(6)).toString().split(";");
				String[] levelfield = levelfieldList[m].split(",");
				for (int j = 0; j < levelfield.length; j++) {
					verifyVisible(By.xpath(String.format(verifyParameterField, levelfield[j], 0)));
				}
				clickOnLevelFieldOkBtn();
			}
		}
	}

	public void editKYC(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(), true);
		if (veifyElementIsNotVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5)) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			common.clickOnEditButton();
			pauseInMilliSeconds(2);
			sendTextInDescriptionInEdit(map.get(mapKeys.get(2)).toString());
			selectStatusInEdit(map.get(mapKeys.get(9)).toString());
			if (!map.get(mapKeys.get(4)).toString().equals("")) {
				int rows = Integer.parseInt(map.get(mapKeys.get(4)).toString());
				String[] levelNameList = map.get(mapKeys.get(5)).toString().split(",");
				for (int m = 0; m < rows; m++) {
					clickOnAddKYCLevel();
					sendtextInLevelNameField(levelNameList[m].trim());
					if (!map.get(mapKeys.get(6)).toString().equals("")) {
						clickOnSelectLevelField();
						String[] levelfieldList = map.get(mapKeys.get(6)).toString().split(";");
						String[] ismandatoryList = map.get(mapKeys.get(7)).toString().split(";");
						String[] isEditableList = map.get(mapKeys.get(8)).toString().split(";");
						String[] levelfield = levelfieldList[m].split(",");
						String[] ismandatory = ismandatoryList[m].split(",");
						String[] isEditable = isEditableList[m].split(",");
						for (int j = 0; j < levelfield.length; j++) {
							clickOnAddLevelFields();
							selectLevelField(levelfield[j].trim());
							selectIsMandatory(ismandatory[j].trim());
							selectIsEditable(isEditable[j].trim());
						}
						clickOnLevelFieldOkBtn();
					}
				}
			}
		}
	}

	public void verifyEditedKYC(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(), true);
		verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0);
		common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
		verifyVisible(By.xpath(String.format(name, map.get(mapKeys.get(1)).toString())), 0);
		verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(2)).toString())), 0);
		verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(3)).toString())), 2);
		int rows = Integer.parseInt(map.get(mapKeys.get(4)).toString());
		String[] levelNameList = map.get(mapKeys.get(5)).toString().split(",");
		for (int m = 0; m < rows; m++) {
			clickOnViewDetailButton(levelNameList[m]);
			if (!map.get(mapKeys.get(6)).toString().equals("")) {
				String[] levelfieldList = map.get(mapKeys.get(6)).toString().split(";");
				String[] levelfield = levelfieldList[m].split(",");
				for (int j = 0; j < levelfield.length; j++) {
					verifyVisible(By.xpath(String.format(verifyParameterField, levelfield[j], 0)));
				}
				clickOnLevelFieldOkBtn();
			}
		}
	}
	
	public void deleteKYC(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
		verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0);
		common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
		common.delete();
	}

	public boolean verifyDeletedKYC(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
		boolean res = veifyElementIsNotVisible(
				By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())));
		if (!res) {
			int[] a = { 0 };
			exceptionOnFailure(res, "Element = " + String.format(verifyElement, map.get(mapKeys.get(1)).toString())
					+ " is still visble", a);
		}
		return res;
	}
}
