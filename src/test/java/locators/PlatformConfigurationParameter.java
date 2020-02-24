package locators;

import org.openqa.selenium.By;

import base.Constants;
import utils.Utility;

public interface PlatformConfigurationParameter {
	By filterDownArrow = By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']");
	By filterBy = By.xpath("//li[normalize-space(text())='Equals']");
	By txtName = By.id(Utility.readJSFile("INPUT_PARAMETER_ADD_NAME", Constants.ELEMENT_FILE));
	By txtDescription = By.id(Utility.readJSFile("INPUT_PARAMETER_ADD_DESCRIPTION", Constants.ELEMENT_FILE));
	By drpFieldType = By.xpath("//*[@id='inputParameterAddFieldtype']//*[@class='ant-select-arrow']");
	By drpComponentType = By.xpath("//*[@id='inputParameterAddComponenttype']//*[@class='ant-select-arrow']");
	By txtPossibleValue = By.id(Utility.readJSFile("INPUT_PARAMETER_ADD_POSSIBLEVALUE", Constants.ELEMENT_FILE));
	By txtPossibleValueInEdit = By.id(Utility.readJSFile("INPUT_PARAMETER_EDIT_POSSIBLEVALUE", Constants.ELEMENT_FILE));
	By drpDataType = By.xpath("//*[@id='" + Utility.readJSFile("INPUT_PARAMETER_ADD_DATATYPE", Constants.ELEMENT_FILE)
			+ "']//*[@class='ant-select-arrow']");
	By drpDataTypeInEdit = By
			.xpath("//*[@id='" + Utility.readJSFile("INPUT_PARAMETER_EDIT_DATATYPE", Constants.ELEMENT_FILE)
					+ "']//*[@class='ant-select-arrow']");
	By txtRegEx = By.id(Utility.readJSFile("INPUT_PARAMETER_ADD_REGEX", Constants.ELEMENT_FILE));
	By txtRegExInEdit = By.id(Utility.readJSFile("INPUT_PARAMETER_EDIT_REGEX", Constants.ELEMENT_FILE));
	By txtValidationMessage = By
			.id(Utility.readJSFile("INPUT_PARAMETER_ADD_VALIDATION_MESSAGE", Constants.ELEMENT_FILE));
	By txtValidationMessageInEdit = By
			.id(Utility.readJSFile("INPUT_PARAMETER_EDIT_VALIDATION_MESSAGE", Constants.ELEMENT_FILE));
	By drpFieldName = By
			.xpath("(//*[contains(@id,'" + Utility.readJSFile("INPUT_PARAMETER_ADD_CHILDFIELD", Constants.ELEMENT_FILE)
					+ "')]//*[@class='ant-select-arrow'])[last()]");
	String IsYes = "Yes";
	By btnChildFieldAdd = By.xpath(
			"//*[@class='custom-table has-btn has-textbox']//button[@type='button' and @class='ant-btn ant-btn-primary']");
	By drpChildField = By.xpath("(//*[contains(@id,'"
			+ Utility.readJSFile("INPUT_PARAMETER_ADD_CHILDFIELD", Constants.ELEMENT_FILE) + "')])[last()]");
	By drpChildFieldInEdit = By.xpath("(//*[contains(@id,'"
			+ Utility.readJSFile("INPUT_PARAMETER_EDIT_CHILDFIELD", Constants.ELEMENT_FILE) + "')])[last()]");
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By
			.xpath("//*[@class='filter-group-second ant-select ant-select-enabled']//*[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id(Utility.readJSFile("INPUT_PARAMETER_EDIT_DESCRIPTION", Constants.ELEMENT_FILE));
	By clickChildFieldText = By.xpath("//*[normalize-space(text())='"
			+ Utility.readJSFile("parameter.label.childfield", Constants.LABEl_FILE) + "']");
	By drpUsedBy = By.xpath("//*[@id='inputParameterAddUsedBy']//*[@class='ant-select-arrow']");
	By drpUsedByInSearch = By.xpath(
			"//*[normalize-space(text())='Used By']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By drpValueSource = By.xpath("//*[@id='inputParameterAddValueSource']//*[@class='ant-select-arrow']");
	String dropDownValue = "//li[normalize-space(text())='%s']";
}
