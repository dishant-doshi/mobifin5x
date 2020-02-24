package pages;

import base.SetupInit;
import locators.Common;

public class CommonPage extends SetupInit implements Common {
	public void clickOnAddButton() {
		clickOnElement(btnAdd);
	}

	public void clickOnFilterBtn() {
		clickOnElement(btnFilter);
	}

	public void clickOnClearBtn() {
		clickOnElement(btnClear);
	}

	public void commonFilterSearch() {
		clickOnFilterBtn();
		clickOnClearBtn();
	}
}
