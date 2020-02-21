package pages;

import org.openqa.selenium.WebDriver;

import base.SetupInit;
import locators.Login;

public class LoginPage extends SetupInit implements Login {

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void login(String userNameVal, String passwordVal) {
	
	}
}
