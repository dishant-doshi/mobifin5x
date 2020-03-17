package pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.CommonConstants;
import base.ScriptConstants;
import base.SetupInit;
import utils.Utility;

public class PlatformConfigurationUserCategoryPage extends SetupInit {
	private CommonPage common;
	String verifyElement = "(//td[text()='%s'])[1]";
	String dropDownValue = "//li[normalize-space(text())='%s']";
	By filterDownArrow = By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']");
	By filterBy = By.xpath("//li[normalize-space(text())='" + ScriptConstants.EQUEALS + "']");
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By
			.xpath("//*[@class='filter-group-second ant-select ant-select-enabled']//*[@class='ant-select-arrow']");
	By txtName = By.id(Utility.readJSFile("INPUT_USERCATEGORY_ADD_NAME", CommonConstants.ELEMENT_FILE));
	By txtDescription = By.id(Utility.readJSFile("INPUT_USERCATEGORY_ADD_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By drpCategoryType = By
			.xpath("//*[@id='" + Utility.readJSFile("INPUT_USERCATEGORY_ADD_CATEGORYTYPE", CommonConstants.ELEMENT_FILE)
					+ "']//*[@class='ant-select-arrow']");
	String selectStatus = "//*[@id='inputAddUserCategoryStatus']//span[normalize-space(text())='%s']";
	String dropDownValueForUserIdentifier = "(//*[normalize-space(text())='%s'])[last()]";
	By drpUserIdentifierField = By
			.xpath("(//*[contains(@id,'userIdentifierParam')]//*[@class='ant-select-arrow'])[last()]");
	By drpUserCredentialField = By.xpath("(//*[contains(@id,'userCrential')]//*[@class='ant-select-arrow'])[last()]");
	By btnIdentifierField = By
			.xpath("//*[text()='" + ScriptConstants.USERCATEGORY_IDENTIFIERBUTTON + "']//parent::button");
	String name = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("usercategory.grid.name", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String description = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("usercategory.label.description", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String categoryType = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("usercategory.label.categorytype", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String status = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("usercategory.grid.status", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String verifyidentifier = "//tr[%s]//*[text()='%s']";
	By txtDescriptionInEdit = By
			.id(Utility.readJSFile("INPUT_USERCATEGORY_EDIT_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By drpCategoryTypeInEdit = By.xpath(
			"//*[@id='" + Utility.readJSFile("INPUT_USERCATEGORY_EDIT_CATEGORYTYPE", CommonConstants.ELEMENT_FILE)
					+ "']//*[@class='ant-select-arrow']");
	String selectStatusEdit = "//*[@id='inputEditUsercategoryStatus']//span[normalize-space(text())='%s']";
	String removeIdentifier = "//*[text()='%s']//ancestor::tr//following-sibling::td//button[contains(@class,'deleteBtn')]";

	public PlatformConfigurationUserCategoryPage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
	}

	public void sendTextInName(String name) {
		sendKeys(txtName, name, 0);
	}

	public void sendTextInDescription(String description) {
		sendKeys(txtDescription, description, 0);
	}

	public void selectCategoryType(String categoryType) {
		selectFromDropDown(drpCategoryType, By.xpath(String.format(dropDownValue, categoryType)), 0);
	}

	public void selectStatus(String status) {
		clickOnElement(By.xpath(String.format(selectStatus, status)), 1);
	}

	public void selectUserIdentifierField(String userIdentifierField) {
		selectFromDropDown(drpUserIdentifierField,
				By.xpath(String.format(dropDownValueForUserIdentifier, userIdentifierField)), 0);
	}

	public void selectUserCredentialField(String userIdentifierField) {
		selectFromDropDown(drpUserCredentialField,
				By.xpath(String.format(dropDownValueForUserIdentifier, userIdentifierField)), 0);
	}

	public void clickOnIdentifierFieldFieldAddBtn() {
		clickOnElement(btnIdentifierField);
	}

	public void sendTextInDescriptionInEdit(String description) {
		sendKeys(txtDescriptionInEdit, description, 0);
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(By.xpath(String.format(selectStatusEdit, status)), 1);
	}

	public void selectCategoryTypeInEdit(String categoryType) {
		selectFromDropDown(drpCategoryTypeInEdit, By.xpath(String.format(dropDownValue, categoryType)), 0);
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

	public void addUserCategory(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (veifyElementIsNotVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5)) {
			common.clickOnAddButton();
			sendTextInName(map.get(mapKeys.get(1)).toString());
			selectCategoryType(map.get(mapKeys.get(2)).toString());
			sendTextInDescription(map.get(mapKeys.get(3)).toString());
			selectStatus(map.get(mapKeys.get(4)).toString());
			String[] userIdentifierFieldList = map.get(mapKeys.get(5)).toString().split(",");
			String[] userCredentialField = map.get(mapKeys.get(6)).toString().split(",");
			for (int j = 0; j < userIdentifierFieldList.length; j++) {
				selectUserIdentifierField(userIdentifierFieldList[j].trim());
				selectUserCredentialField(userCredentialField[j].trim());
				if (j < (userIdentifierFieldList.length) - 1) {
					clickOnIdentifierFieldFieldAddBtn();
				}
			}
			common.clickOnSaveBtn();
		}

	}

	public void verifyAddedUserCategory(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0);
		common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
		verifyVisible(By.xpath(String.format(name, map.get(mapKeys.get(1)).toString())), 0);
		verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(3)).toString())), 0);
		verifyVisible(By.xpath(String.format(categoryType, map.get(mapKeys.get(2)).toString())), 0);
		verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(4)).toString())), 1);
		String[] userIdentifierFieldList = map.get(mapKeys.get(5)).toString().split(",");
		String[] userCredentialField = map.get(mapKeys.get(6)).toString().split(",");
		for (int j = 0; j < userIdentifierFieldList.length; j++) {
			verifyVisible(By.xpath(String.format(verifyidentifier, String.valueOf(j + 1), userIdentifierFieldList[j])),
					0);
			verifyVisible(By.xpath(String.format(verifyidentifier, String.valueOf(j + 1), userCredentialField[j])), 0);
		}
	}

	public void editUserCategory(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0);
		common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
		common.clickOnEditButton();
		selectCategoryTypeInEdit(map.get(mapKeys.get(2)).toString());
		sendTextInDescriptionInEdit(map.get(mapKeys.get(3)).toString());
		selectStatusInEdit(map.get(mapKeys.get(5)).toString());
		if (!map.get(mapKeys.get(6)).toString().equals("")) {
			String[] removelist = map.get(mapKeys.get(6)).toString().split(",");
			for (String list : removelist) {
				clickOnElement(By.xpath(String.format(removeIdentifier, list)), 0);
			}
		}
		String[] userIdentifierFieldList = map.get(mapKeys.get(7)).toString().split(",");
		String[] userCredentialField = map.get(mapKeys.get(8)).toString().split(",");
		for (int j = 0; j < userIdentifierFieldList.length; j++) {
			selectUserIdentifierField(userIdentifierFieldList[j].trim());
			selectUserCredentialField(userCredentialField[j].trim());
			if (j < (userIdentifierFieldList.length) - 1) {
				clickOnIdentifierFieldFieldAddBtn();
			}
		}
		common.clickOnSaveBtn();
	}

	public void verifyEditedUserCategory(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(5)).toString(), true);
		verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0);
		common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
		verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(3)).toString())), 0);
		verifyVisible(By.xpath(String.format(categoryType, map.get(mapKeys.get(2)).toString())), 0);
		verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(5)).toString())), 1);
		String[] userIdentifierFieldList = map.get(mapKeys.get(7)).toString().split(",");
		String[] userCredentialField = map.get(mapKeys.get(8)).toString().split(",");
		for (int j = 0; j < userIdentifierFieldList.length; j++) {
			verifyVisible(By.xpath(String.format(verifyidentifier, String.valueOf(j + 1), userIdentifierFieldList[j])),
					0);
			verifyVisible(By.xpath(String.format(verifyidentifier, String.valueOf(j + 1), userCredentialField[j])), 0);
		}
	}

	public void deleteUserCategory(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
		verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0);
		common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
		common.delete();
	}

	public boolean verifyDeletedUserCategory(Map<Object, Object> map, List<Object> mapKeys) {
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
