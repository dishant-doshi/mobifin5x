package locators;

import org.openqa.selenium.By;

public interface Login {
	By unmTextBox = By.id("inputLoginUsername");
	By pwdTextBox = By.id("inputLoginPd");
	By loginBtn = By.id("btnLoginLogin");
}
