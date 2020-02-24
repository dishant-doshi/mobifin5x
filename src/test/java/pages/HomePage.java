package pages;

import base.SetupInit;
import locators.Home;

public class HomePage extends SetupInit implements Home {
	public void goToHome() {
		clickOnElement(homeLogo);
	}
}
