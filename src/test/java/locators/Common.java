package locators;

import org.openqa.selenium.By;

import base.CommonConstants;
import utils.Utility;

public interface Common {
	By btnAdd = By.id(Utility.readJSFile("OPERATIONBAR_BUTTON_ADD", CommonConstants.ELEMENT_FILE));
	By btnClear = By.id("clearbutton");
	By btnSave = By.id(Utility.readJSFile("OPERATIONBAR_BUTTON_SAVE", CommonConstants.ELEMENT_FILE));
	By btnCancel = By.xpath("(//*[normalize-space(text())='Cancel'])[last()]");
	By btnFilter = By.id(Utility.readJSFile("OPERATIONBAR_BUTTON_SERVERSEARCH", CommonConstants.ELEMENT_FILE));
	By btnFilterSearch = By.id("searchbutton");
}
