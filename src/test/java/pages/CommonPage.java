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
	By btnSubmit = By.xpath("//span[normalize-space(text())='Submit']//parent::button");
	By btnNext = By.xpath("//span[normalize-space(text())='Next']//parent::button");
	By btnDeleteConfirm = By.xpath("(//*[@class='ant-btn ant-btn-primary'])[last()]");
	By btnClose = By.xpath("//button[@aria-label='Close']");
	By btnEdit = By.id(Utility.readJSFile("OPERATIONBAR_BUTTON_EDIT", CommonConstants.ELEMENT_FILE));
	By btnDelete = By.id(Utility.readJSFile("OPERATIONBAR_BUTTON_DELETE", CommonConstants.ELEMENT_FILE));

	public CommonPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnAddButton() {
		clickOnElement(btnAdd, 0);
	}

	public void clickOnFilterBtn() {
		clickOnElement(btnFilter);
	}

	public void clickOnClearBtn() {
		clickOnElement(btnClear);
	}

	public void clickOnFilterSearchBtn() {
		clickOnElement(btnFilterSearch, 0);
	}

	public void commonFilterSearch() {
		clickOnFilterBtn();
		clickOnClearBtn();
	}

	public void clickOnSaveBtn() {
		clickOnElement(btnSave, 0);
	}

	public boolean isStriptTextDisplayed() {
		if (verifyVisible(stripText)) {
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
		waitForLoader();
	}

	public void clickOnNextBtn() {
		clickOnElement(btnNext);
	}

	public void clickOnSubmitBtn() {
		clickOnElement(btnSubmit);
	}

	public void clickOnDeleteConfirm() {
		clickOnElement(btnDeleteConfirm);
	}

	public void clickOnCloseBtn() {
		clickOnElement(btnClose);
	}

	public void clickOnEditButton() {
		clickOnElement(btnEdit, 0);
	}

	public boolean verifyFilterBtn() {
		return verifyVisible(btnFilter);
	}

	public void delete() {
		clickOnDeleteBtn();
		clickOnDeleteConfirm();
		isStriptTextDisplayed();
	}

	public void clickOnDeleteBtn() {
		clickOnElement(btnDelete, 0);
	}
}
