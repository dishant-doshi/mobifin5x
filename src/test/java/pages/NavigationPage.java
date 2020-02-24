package pages;

import org.openqa.selenium.WebDriver;

import base.SetupInit;
import locators.Navigation;

public class NavigationPage extends SetupInit implements Navigation {
	public NavigationPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnPlateformConfigurationParameter() {
		clickOnElement(platformConfiguration);
		clickOnElement(parameter);
	}
}
