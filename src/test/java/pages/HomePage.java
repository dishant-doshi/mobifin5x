package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;

public class HomePage extends SetupInit {
	
	By homeLogo = By.xpath("//img[@alt='logo']");
	By platformConfiguration = By.xpath("//*[text()='Platform Config']");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void goToHome() {
		clickOnElement(homeLogo);
	}
	
	public void clickOnPlateformConfigurationParameter() {
		clickOnElement(platformConfiguration);
	}
}
