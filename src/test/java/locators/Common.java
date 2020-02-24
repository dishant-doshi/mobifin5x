package locators;

import org.openqa.selenium.By;

import base.Constants;
import utils.Utility;

public interface Common {
	By btnAdd = By.id(Utility.readJSFile("OPERATIONBAR_BUTTON_ADD", Constants.ELEMENT_FILE));
	By btnClear = By.id("clearbutton");
	By btnSave = By.id(Utility.readJSFile("OPERATIONBAR_BUTTON_SAVE", Constants.ELEMENT_FILE));
	By btnCancel = By.xpath("(//*[normalize-space(text())='Cancel'])[last()]");
	By btnFilter = By.id(Utility.readJSFile("OPERATIONBAR_BUTTON_SERVERSEARCH", Constants.ELEMENT_FILE));
	By btnFilterSearch = By.id("searchbutton");
}
