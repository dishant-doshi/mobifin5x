package pages;

import org.openqa.selenium.WebDriver;

import base.SetupInit;
import locators.Home;

public class HomePage extends SetupInit implements Home {
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void goToHome() {
		clickOnElement(homeLogo);
	}
}
