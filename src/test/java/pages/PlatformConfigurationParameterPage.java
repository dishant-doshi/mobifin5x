package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.elasticsearch.index.store.VerifyingIndexOutput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.CommonConstants;
import base.SetupInit;
import utils.Utility;

public class PlatformConfigurationParameterPage extends SetupInit {

	By filterDownArrow = By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']");
	By filterBy = By.xpath("//li[normalize-space(text())='Equals']");
	By txtName = By.id(Utility.readJSFile("INPUT_PARAMETER_ADD_NAME", CommonConstants.ELEMENT_FILE));
	By txtDescription = By.id(Utility.readJSFile("INPUT_PARAMETER_ADD_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By drpFieldType = By.xpath("//*[@id='inputParameterAddFieldtype']//*[@class='ant-select-arrow']");
	By drpComponentType = By.xpath("//*[@id='inputParameterAddComponenttype']//*[@class='ant-select-arrow']");
	By txtPossibleValue = By.id(Utility.readJSFile("INPUT_PARAMETER_ADD_POSSIBLEVALUE", CommonConstants.ELEMENT_FILE));
	By txtPossibleValueInEdit = By
			.id(Utility.readJSFile("INPUT_PARAMETER_EDIT_POSSIBLEVALUE", CommonConstants.ELEMENT_FILE));
	By drpDataType = By
			.xpath("//*[@id='" + Utility.readJSFile("INPUT_PARAMETER_ADD_DATATYPE", CommonConstants.ELEMENT_FILE)
					+ "']//*[@class='ant-select-arrow']");
	By drpDataTypeInEdit = By
			.xpath("//*[@id='" + Utility.readJSFile("INPUT_PARAMETER_EDIT_DATATYPE", CommonConstants.ELEMENT_FILE)
					+ "']//*[@class='ant-select-arrow']");
	By txtRegEx = By.id(Utility.readJSFile("INPUT_PARAMETER_ADD_REGEX", CommonConstants.ELEMENT_FILE));
	By txtRegExInEdit = By.id(Utility.readJSFile("INPUT_PARAMETER_EDIT_REGEX", CommonConstants.ELEMENT_FILE));
	By txtValidationMessage = By
			.id(Utility.readJSFile("INPUT_PARAMETER_ADD_VALIDATION_MESSAGE", CommonConstants.ELEMENT_FILE));
	By txtValidationMessageInEdit = By
			.id(Utility.readJSFile("INPUT_PARAMETER_EDIT_VALIDATION_MESSAGE", CommonConstants.ELEMENT_FILE));
	By drpFieldName = By.xpath(
			"(//*[contains(@id,'" + Utility.readJSFile("INPUT_PARAMETER_ADD_CHILDFIELD", CommonConstants.ELEMENT_FILE)
					+ "')]//*[@class='ant-select-arrow'])[last()]");
	String IsYes = "Yes";
	By btnChildFieldAdd = By.xpath(
			"//*[@class='custom-table has-btn has-textbox']//button[@type='button' and @class='ant-btn ant-btn-primary']");
	By drpChildField = By.xpath("(//*[contains(@id,'"
			+ Utility.readJSFile("INPUT_PARAMETER_ADD_CHILDFIELD", CommonConstants.ELEMENT_FILE) + "')])[last()]");
	By drpChildFieldInEdit = By.xpath("(//*[contains(@id,'"
			+ Utility.readJSFile("INPUT_PARAMETER_EDIT_CHILDFIELD", CommonConstants.ELEMENT_FILE) + "')])[last()]");
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By
			.xpath("//*[@class='filter-group-second ant-select ant-select-enabled']//*[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By
			.id(Utility.readJSFile("INPUT_PARAMETER_EDIT_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By clickChildFieldText = By.xpath("//*[normalize-space(text())='"
			+ Utility.readJSFile("parameter.label.childfield", CommonConstants.LABLE_FILE) + "']");
	By drpUsedBy = By.xpath("//*[@id='inputParameterAddUsedBy']//*[@class='ant-select-arrow']");
	By drpUsedByInSearch = By.xpath(
			"//*[normalize-space(text())='Used By']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By drpValueSource = By.xpath("//*[@id='inputParameterAddValueSource']//*[@class='ant-select-arrow']");
	By drpValueSourceInEdit = By.xpath("//*[@id='inputParameterEditValueSource']//*[@class='ant-select-arrow']");
	String dropDownValue = "//li[normalize-space(text())='%s']";
	String dropDownFieldValue = "//*[normalize-space(text())='%s']";
	String verifyElement = "(//td[text()='%s'])[1]";
	String drpStatus = "//*[@id='" + Utility.readJSFile("INPUT_PARAMETER_ADD_STATUS", CommonConstants.ELEMENT_FILE)
			+ "']//span[normalize-space(text())='%s']";
	String drpStatusEdit = "//*[@id='" + Utility.readJSFile("INPUT_PARAMETER_EDIT_STATUS", CommonConstants.ELEMENT_FILE)
			+ "']//span[normalize-space(text())='%s']";
	By isMandatoryBtn = By.xpath("(//*[contains(@id,'"
			+ Utility.readJSFile("INPUT_PARAMETER_ADD_CHILDFIELDMANDATORY", CommonConstants.ELEMENT_FILE)
			+ "')])[last()]");
	By isEditableBtn = By.xpath("(//*[contains(@id,'"
			+ Utility.readJSFile("INPUT_PARAMETER_ADD_CHILDFIELDEDITABLE", CommonConstants.ELEMENT_FILE)
			+ "')])[last()]");
	String name = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("parameter.label.name", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String description = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("parameter.label.description", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String FieldType = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("parameter.label.fieldtype", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String usedBy = "//*[normalize-space(text()) = 'Used By']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String ComponentType = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("parameter.label.componenttype", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String DataType = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("parameter.label.datatype", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String RegEx = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("parameter.label.regex", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String ValidationMessage = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("parameter.label.validationmessage", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String PossibleValue = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("parameter.label.possiblevalue", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String ChildField = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("parameter.label.childfield", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String ValueSource = "//*[normalize-space(text()) = 'Value Source']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String fieldName = "//*[normalize-space(text()) = '%s']";
	private CommonPage common;
	By possiblevalueInDropDown = By.xpath("(//*[@id='inputParameterAddPossiblevalue'])[last()]");
	String removeField = "//*[normalize-space(text())='%s']//ancestor  :: div[@class='ant-row ant-form-item']//parent :: td//following-sibling :: td//*[contains(@class,'ant-btn deleteBtn')]";

	public PlatformConfigurationParameterPage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
	}

	public void sendTextInName(String name) {
		sendKeys(txtName, name, 0);
	}

	public void sendTextInDescription(String description) {
		sendKeys(txtDescription, description, 0);
	}

	public void sendTextInDescriptionInEdit(String description) {
		sendKeys(txtDescriptionInEdit, description, 0);
	}

	public void selectFieldType(String fieldType) {
		selectFromDropDown(drpFieldType, By.xpath(String.format(dropDownFieldValue, fieldType)), 0);
	}

	public void selectUsedBy(String usedBy) {
		selectFromDropDown(drpUsedBy, By.xpath(String.format(dropDownValue, usedBy)), 0);
	}

	public void selectComponentType(String componentType) {
		selectFromDropDown(drpComponentType, By.xpath(String.format(dropDownValue, componentType)), 0);
	}

	public void sendTextInPossibleValue(String possibleValue) {
		sendKeys(txtPossibleValue, possibleValue, 0);
	}

	public void sendTextInPossibleValueInEdit(String possibleValue) {
		sendKeys(txtPossibleValueInEdit, possibleValue, 0);
	}

	public void selectStatus(String status) {
		clickOnElement(By.xpath(String.format(drpStatus, status)), 2);
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(By.xpath(String.format(drpStatusEdit, status)),2);
	}

	public void selectDataType(String dataType) {
		selectFromDropDown(drpDataType, By.xpath(String.format(dropDownValue, dataType)), 0);
	}

	public void selectDataTypeInEdit(String dataType) {
		selectFromDropDown(drpDataTypeInEdit, By.xpath(String.format(dropDownValue, dataType)), 0);
	}

	public void sendTextInRegEx(String regEx) {
		sendKeys(txtRegEx, regEx);
	}

	public void sendTextInRegExInEdit(String regEx) {
		sendKeys(txtRegExInEdit, regEx);
	}

	public void sendTextInValidationMessage(String validationMessage) {
		sendKeys(txtValidationMessage, validationMessage, 0);
	}

	public void sendTextInValidationMessageInEdit(String validationMessage) {
		sendKeys(txtValidationMessageInEdit, validationMessage, 0);
	}

	public void selectFieldName(String fieldName) {
		selectFromDropDown(drpFieldName, By.xpath(String.format(dropDownValue, fieldName)));
	}

	public void selectIsMandatory(String isMandatory) {
		if (isMandatory.equalsIgnoreCase(IsYes))
			clickOnElement(isMandatoryBtn);
	}

	public void selectIsEditable(String isEditable) {
		if (isEditable.equalsIgnoreCase(IsYes))
			clickOnElement(isEditableBtn);
	}

	public void clickOnChildFieldAdd() {
		clickOnElement(btnChildFieldAdd);
	}

	public void sendTextInNameFilterSearch(String name) {
		sendKeys(txtNameInSearch, name);
	}

	public void selectChildField(String childField) {
		clickOnElement(By.xpath(String.format(fieldName, childField)));
	}

	public void selectStatusInFilterSearch(String status) {
		selectFromDropDown(drpStatusInSearch, By.xpath(String.format(dropDownValue, status)), 2);
	}

	public void selectUsedByInFilterSearch(String usedBy) {
		selectFromDropDown(drpUsedByInSearch, By.xpath(String.format(dropDownValue, usedBy)), 0);
	}

	public void clickOnChildText() {
		clickOnElement(clickChildFieldText, 0);
	}

	public void selectValueSource(String valueSource) {
		selectFromDropDown(drpValueSource, By.xpath(String.format(dropDownValue, valueSource)), 0);
	}

	public void selectValueSourceInEdit(String valueSource) {
		selectFromDropDown(drpValueSourceInEdit, By.xpath(String.format(dropDownValue, valueSource)), 0);
	}

	public void sendTextInPossibleValueInDropdown(String possibleValue) {
		sendKeys(possiblevalueInDropDown, possibleValue);
	}

	public void sendTextInParameterNameFilterSearch(String name) {
		sendKeys(txtNameInSearch, name, 0);
	}

	public void filterSearch(String parameterName, String status, String usedBy, boolean isSubString) {
		common.commonFilterSearch();
		if (isSubString) {
			clickOnElement(filterDownArrow);
			clickOnElement(filterBy);
		}
		sendTextInParameterNameFilterSearch(parameterName);
		selectUsedByInFilterSearch(usedBy);
		selectStatusInFilterSearch(status);
		common.clickOnFilterSearchBtn();
	}

	public void addParameter(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(14)).toString(),
				map.get(mapKeys.get(15)).toString(), true);
		if (veifyElementIsNotVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5)) {
			common.clickOnAddButton();
			sendTextInName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(2)).toString());
			selectUsedBy(map.get(mapKeys.get(15)).toString());
			selectFieldType(map.get(mapKeys.get(3)).toString());
			if (map.get(mapKeys.get(3)).toString().toLowerCase().equals("base")) {
				selectComponentType(map.get(mapKeys.get(4)).toString());
				switch (map.get(mapKeys.get(4)).toString().toLowerCase()) {
				case "textbox":
					selectDataType(map.get(mapKeys.get(5)).toString());
					if (!map.get(mapKeys.get(6)).toString().equals(""))
						sendTextInRegEx(map.get(mapKeys.get(6)).toString());
					if (!map.get(mapKeys.get(7)).toString().equals(""))
						sendTextInValidationMessage(map.get(mapKeys.get(7)).toString());
					break;
				case "dropdown":
					selectValueSource(map.get(mapKeys.get(16)).toString());
					if (map.get(mapKeys.get(16)).toString().trim().toLowerCase().equals("parameter")) {
						int rows = Integer.parseInt(map.get(mapKeys.get(10)).toString());
						String[] fieldNameList = map.get(mapKeys.get(11)).toString().split(",");
						String[] ismandatory = map.get(mapKeys.get(12)).toString().split(",");
						String[] isEditable = map.get(mapKeys.get(13)).toString().split(",");
						for (int m = 0; m < rows; m++) {
							selectFieldName(fieldNameList[m].trim());
							if (m > 0) {
								selectIsMandatory(ismandatory[m].trim());
								selectIsEditable(isEditable[m].trim());
							}
							if (m < rows - 1)
								clickOnChildFieldAdd();
						}
					} else
						sendTextInPossibleValueInDropdown(map.get(mapKeys.get(9)).toString());
					break;
				case "checkbox":
					String[] checkchildFieldList = map.get(mapKeys.get(8)).toString().split(",");
					clickOnElement(drpChildField);
					for (int i = 0; i < checkchildFieldList.length; i++)
						selectChildField(checkchildFieldList[i].trim());
					clickOnChildText();
					break;
				case "radiobutton":
					String[] radioFieldList = map.get(mapKeys.get(8)).toString().split(",");
					clickOnElement(drpChildField);
					for (int i = 0; i < radioFieldList.length; i++)
						selectChildField(radioFieldList[i].trim());
					clickOnChildText();
					break;
				case "label":
					sendTextInPossibleValue(map.get(mapKeys.get(9)).toString());
					break;
				case "datepicker":
					break;
				case "fileselector":
					if (!map.get(mapKeys.get(6)).toString().equals(""))
						sendTextInRegEx(map.get(mapKeys.get(6)).toString());
					sendTextInValidationMessage(map.get(mapKeys.get(7)).toString());
					break;
				case "hyperlink":
					sendTextInPossibleValue(map.get(mapKeys.get(9)).toString());
					break;
				case "password":
					selectDataType(map.get(mapKeys.get(5)).toString());
					if (!map.get(mapKeys.get(6)).toString().equals(""))
						sendTextInRegEx(map.get(mapKeys.get(6)).toString());
					sendTextInValidationMessage(map.get(mapKeys.get(7)).toString());
					break;
				}
			} else {
				int rows = Integer.parseInt(map.get(mapKeys.get(10)).toString());
				String[] fieldNameList = map.get(mapKeys.get(11)).toString().split(",");
				String[] ismandatory = map.get(mapKeys.get(12)).toString().split(",");
				String[] isEditable = map.get(mapKeys.get(13)).toString().split(",");
				for (int m = 0; m < rows; m++) {
					selectFieldName(fieldNameList[m].trim());
					if (m > 0) {
						selectIsMandatory(ismandatory[m].trim());
						selectIsEditable(isEditable[m].trim());
					}
					if (m < rows - 1)
						clickOnChildFieldAdd();
				}
			}
			selectStatus(map.get(mapKeys.get(14)).toString());
			common.clickOnSaveBtn();
		}
	}

	public void verifyAddedParameter(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(14)).toString(),
				map.get(mapKeys.get(15)).toString(), true);
		verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5);
		common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
		verifyVisible(By.xpath(String.format(name, map.get(mapKeys.get(1)).toString())), 0);
		verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(2)).toString())), 0);
		verifyVisible(By.xpath(String.format(FieldType, map.get(mapKeys.get(3)).toString())), 0);
		verifyVisible(By.xpath(String.format(usedBy, map.get(mapKeys.get(15)).toString())), 0);
		if (map.get(mapKeys.get(3)).toString().toLowerCase().equals("base")) {
			verifyVisible(By.xpath(String.format(ComponentType, map.get(mapKeys.get(4)).toString())), 0);
			switch (map.get(mapKeys.get(4)).toString().toLowerCase()) {
			case "textbox":
				verifyVisible(By.xpath(String.format(DataType, map.get(mapKeys.get(5)).toString())), 0);
				if (!map.get(mapKeys.get(3)).toString().trim().equals(""))
					verifyVisible(By.xpath(String.format(RegEx, map.get(mapKeys.get(6)).toString())), 0);
				verifyVisible(By.xpath(String.format(ValidationMessage, map.get(mapKeys.get(7)).toString())), 0);
				break;
			case "dropdown":
				verifyVisible(By.xpath(String.format(ValueSource, map.get(mapKeys.get(16)).toString())), 0);
				if (map.get(mapKeys.get(16)).toString().trim().toLowerCase().equals("parameter")) {
					String[] fieldNameList = map.get(mapKeys.get(11)).toString().split(",");
					for (int m = 0; m < fieldNameList.length; m++)
						verifyVisible(By.xpath(String.format(fieldName, fieldNameList[m])), 0);
				} else {
					verifyVisible(By.xpath(String.format(PossibleValue, map.get(mapKeys.get(9)).toString())), 0);
				}
				break;
			case "checkbox":
				verifyVisible(By.xpath(String.format(ChildField, map.get(mapKeys.get(8)).toString())), 0);
				break;
			case "radiobutton":
				verifyVisible(By.xpath(String.format(ChildField, map.get(mapKeys.get(8)).toString())), 0);
				break;
			case "label":
				verifyVisible(By.xpath(String.format(PossibleValue, map.get(mapKeys.get(9)).toString())), 0);
				break;
			case "datepicker":
				break;
			case "fileselector":
				if (!map.get(mapKeys.get(3)).toString().trim().equals(""))
					verifyVisible(By.xpath(String.format(RegEx, map.get(mapKeys.get(6)).toString())), 0);
				verifyVisible(By.xpath(String.format(ValidationMessage, map.get(mapKeys.get(7)).toString())), 0);
				break;
			case "hyperlink":
				verifyVisible(By.xpath(String.format(PossibleValue, map.get(mapKeys.get(9)).toString())), 0);
				break;
			case "password":
				verifyVisible(By.xpath(String.format(DataType, map.get(mapKeys.get(5)).toString())), 0);
				if (!map.get(mapKeys.get(3)).toString().trim().equals(""))
					verifyVisible(By.xpath(String.format(RegEx, map.get(mapKeys.get(6)).toString())), 0);
				verifyVisible(By.xpath(String.format(ValidationMessage, map.get(mapKeys.get(7)).toString())), 0);
				break;
			}
		} else {
			String[] fieldNameList = map.get(mapKeys.get(11)).toString().split(",");
			for (int m = 0; m < fieldNameList.length; m++)
				verifyVisible(By.xpath(String.format(fieldName, fieldNameList[m])), 0);
		}
	}

	public void editParameter(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(15)).toString(),
				map.get(mapKeys.get(16)).toString(), true);
		verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5);
		common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
		common.clickOnEditButton();
		pauseInSeconds(2);
		sendTextInDescriptionInEdit(map.get(mapKeys.get(2)).toString());
		if (map.get(mapKeys.get(3)).toString().toLowerCase().equals("base")) {
			switch (map.get(mapKeys.get(4)).toString().toLowerCase()) {
			case "textbox":
				selectDataTypeInEdit(map.get(mapKeys.get(5)).toString());
				if (!map.get(mapKeys.get(6)).toString().equals("")) {
					sendTextInRegExInEdit(map.get(mapKeys.get(6)).toString());
				}
				sendTextInValidationMessageInEdit(map.get(mapKeys.get(7)).toString());
				break;
			case "dropdown":
				if (!map.get(mapKeys.get(18)).toString().equals("")) {
					selectValueSourceInEdit(map.get(mapKeys.get(18)).toString());
				}
				if (!map.get(mapKeys.get(10)).toString().equals("")) {
					int rows = Integer.parseInt(map.get(mapKeys.get(10)).toString());
					String[] removeFieldNameList = map.get(mapKeys.get(11)).toString().split(",");
					String[] fieldNameList = map.get(mapKeys.get(12)).toString().split(",");
					String[] ismandatory = map.get(mapKeys.get(13)).toString().split(",");
					String[] isEditable = map.get(mapKeys.get(14)).toString().split(",");
					if (!map.get(mapKeys.get(11)).toString().equals("")) {
						for (int j = 0; j < removeFieldNameList.length; j++) {
							clickOnElement(By.xpath(String.format(removeField, removeFieldNameList[j].trim())));
						}
					}
					for (int m = 0; m < rows; m++) {
						clickOnChildFieldAdd();
						selectFieldName(fieldNameList[m].trim());
						selectIsMandatory(ismandatory[m].trim());
						selectIsEditable(isEditable[m].trim());
					}
				}
				break;
			case "checkbox":
				String[] checkchildFieldList = map.get(mapKeys.get(8)).toString().split(",");
				clickOnElement(drpChildFieldInEdit);
				for (int i = 0; i < checkchildFieldList.length; i++) {
					selectChildField(checkchildFieldList[i].trim());
				}
				break;
			case "radiobutton":
				String[] radioFieldList = map.get(mapKeys.get(8)).toString().split(",");
				clickOnElement(drpChildFieldInEdit);
				for (int i = 0; i < radioFieldList.length; i++) {
					selectChildField(radioFieldList[i].trim());
				}
				break;
			case "label":
				sendTextInPossibleValueInEdit(map.get(mapKeys.get(9)).toString());
				break;
			case "datepicker":
				break;
			case "fileselector":
				if (!map.get(mapKeys.get(6)).toString().equals("")) {
					sendTextInRegExInEdit(map.get(mapKeys.get(6)).toString());
				}
				sendTextInValidationMessageInEdit(map.get(mapKeys.get(7)).toString());
				break;
			case "hyperlink":
				sendTextInPossibleValueInEdit(map.get(mapKeys.get(9)).toString());
				break;
			case "password":
				selectDataTypeInEdit(map.get(mapKeys.get(5)).toString());
				if (!map.get(mapKeys.get(6)).toString().equals("")) {
					sendTextInRegExInEdit(map.get(mapKeys.get(6)).toString());
				}
				sendTextInValidationMessageInEdit(map.get(mapKeys.get(7)).toString());
				break;
			}
		} else {
			int rows = Integer.parseInt(map.get(mapKeys.get(10)).toString());
			String[] fieldNameList = map.get(mapKeys.get(11)).toString().split(",");
			String[] ismandatory = map.get(mapKeys.get(12)).toString().split(",");
			String[] isEditable = map.get(mapKeys.get(13)).toString().split(",");
			for (int m = 0; m < rows; m++) {
				selectFieldName(fieldNameList[m].trim());
				if (m > 0) {
					selectIsEditable(isEditable[m].trim());
					selectIsMandatory(ismandatory[m].trim());
				}
				if (m < rows - 1) {
					clickOnChildFieldAdd();
				}
			}
		}
		selectStatusInEdit(map.get(mapKeys.get(17)).toString());
		common.clickOnSaveBtn();
	}

	public void verifyEditedParameter(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(17)).toString(),
				map.get(mapKeys.get(16)).toString(), true);
		verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0);
		common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
		verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(2)).toString())), 0);
		verifyVisible(By.xpath(String.format(FieldType, map.get(mapKeys.get(3)).toString())), 0);
		if (map.get(mapKeys.get(3)).toString().toLowerCase().equals("base")) {
			verifyVisible(By.xpath(String.format(ComponentType, map.get(mapKeys.get(4)).toString())), 0);
			switch (map.get(mapKeys.get(4)).toString().toLowerCase()) {
			case "textbox":
				verifyVisible(By.xpath(String.format(DataType, map.get(mapKeys.get(5)).toString())), 0);
				if (!map.get(mapKeys.get(6)).toString().trim().equals("")) {
					verifyVisible(By.xpath(String.format(RegEx, map.get(mapKeys.get(6)).toString())), 0);
				}
				verifyVisible(By.xpath(String.format(ValidationMessage, map.get(mapKeys.get(7)).toString())), 0);
				break;
			case "dropdown":
				if (!map.get(mapKeys.get(18)).toString().equals("")) {
					verifyVisible(By.xpath(String.format(ValueSource, map.get(mapKeys.get(18)).toString())), 0);
				}
				String[] fieldNameList = map.get(mapKeys.get(12)).toString().split(",");
				for (int m = 0; m < fieldNameList.length; m++) {
					verifyVisible(By.xpath(String.format(fieldName, fieldNameList[m])), 0);
				}
				break;
			case "checkbox":
				verifyVisible(By.xpath(String.format(ChildField, map.get(mapKeys.get(8)).toString())), 0);

				break;
			case "radiobutton":
				verifyVisible(By.xpath(String.format(ChildField, map.get(mapKeys.get(8)).toString())), 0);
				break;
			case "label":
				verifyVisible(By.xpath(String.format(PossibleValue, map.get(mapKeys.get(9)).toString())), 0);
				break;
			case "datepicker":
				break;
			case "fileselector":
				if (!map.get(mapKeys.get(3)).toString().trim().equals(""))
					verifyVisible(By.xpath(String.format(RegEx, map.get(mapKeys.get(6)).toString())), 0);
				verifyVisible(By.xpath(String.format(ValidationMessage, map.get(mapKeys.get(7)).toString())), 0);
				break;
			case "hyperlink":
				verifyVisible(By.xpath(String.format(PossibleValue, map.get(mapKeys.get(9)).toString())), 0);
				break;
			case "password":
				verifyVisible(By.xpath(String.format(DataType, map.get(mapKeys.get(5)).toString())), 0);
				if (!map.get(mapKeys.get(6)).toString().trim().equals(""))
					verifyVisible(By.xpath(String.format(RegEx, map.get(mapKeys.get(6)).toString())), 0);
				verifyVisible(By.xpath(String.format(ValidationMessage, map.get(mapKeys.get(7)).toString())), 0);
				break;
			}
		} else {
			String[] fieldNameList = map.get(mapKeys.get(11)).toString().split(",");
			for (int m = 0; m < fieldNameList.length; m++) {
				verifyVisible(By.xpath(String.format(fieldName, fieldNameList[m])), 0);
			}
		}
	}

	public void deleteParameter(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(),
				map.get(mapKeys.get(3)).toString(), true);
		verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0);
		common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
		common.delete();
	}

	public boolean verifyDeletedParameter(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(),
				map.get(mapKeys.get(3)).toString(), true);
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
