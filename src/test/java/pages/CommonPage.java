package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.CommonConstants;
import base.SetupInit;
import utils.Utility;

public class CommonPage extends SetupInit {

	By btnAdd = By.id(Utility.readJSFile("OPERATIONBAR_BUTTON_ADD", CommonConstants.ELEMENT_FILE));
	By btnClear = By.id("clearbutton");
	By btnSave = By.id(Utility.readJSFile("OPERATIONBAR_BUTTON_SAVE", CommonConstants.ELEMENT_FILE));
	By btnCancel = By.xpath("(//*[normalize-space(text())='Cancel'])[last()]");
	By btnFilter = By.id(Utility.readJSFile("OPERATIONBAR_BUTTON_SERVERSEARCH", CommonConstants.ELEMENT_FILE));
	By btnFilterSearch = By.id("searchbutton");
	By stripText = By.xpath("(//*[@class='ant-notification-notice-message'])[last()]");
	String info = "//td[normalize-space(text())='%s']//preceding-sibling::td[@class='center-align']//i";

	public CommonPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnAddButton() {
		clickOnElement(btnAdd);
	}

	public void clickOnFilterBtn() {
		clickOnElement(btnFilter);
	}

	public void clickOnClearBtn() {
		clickOnElement(btnClear);
	}

	public void clickOnFilterSearchBtn() {
		clickOnElement(btnFilterSearch);
	}

	public void commonFilterSearch() {
		clickOnFilterBtn();
		clickOnClearBtn();
	}

	public void clickOnSaveBtn() {
		clickOnElement(btnSave);
	}

	public boolean isStriptTextDisplayed() {
		if (verifyElementIsDisplayed(stripText)) {
			String text;
			try {
				text = "Strip Confirmation Message : " + getElementText(stripText);
			} catch (Exception e) {
				log("</br><b style='color:#02563d'> Strip Message Not Generated.</b></br>");
				return false;
			}
			log("</br><b style='color:#02563d'>" + text + "</b></br>");
			return true;
		} else {
			log("</br><b style='color:#02563d'> Strip Message Not Generated.</b></br>");
			return false;
		}
	}

	public void clickOnInfoBtn(String string) {
		clickOnElement(By.xpath(String.format(info, string)));
	}
}
