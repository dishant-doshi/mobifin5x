package testCases;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.SetupInit;
import base.TestDataImport;
import pages.HomePage;
import pages.NavigationPage;
import pages.PlatformConfigurationRulePage;
import utils.Utility;

public class PlatformConfigurationRule extends SetupInit{
	HomePage homePage;
	NavigationPage navigationPage;
	PlatformConfigurationRulePage platformConfigurationRulePage;
	SetupInit init;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		platformConfigurationRulePage = new PlatformConfigurationRulePage(getDriver());
	}

	@Test(dataProvider = "Rule_Add", dataProviderClass = TestDataImport.class, description = "Id: AddRule, Author: shivani.patel")
	public void addRule(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addRule");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationRule();
			platformConfigurationRulePage.addRule(map, Utility.getMapKeys(map));
			platformConfigurationRulePage.verifyAddedRule(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "Rule_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditRule, Author: shivani.patel")
	public void editRule(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editRule");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationRule();
			platformConfigurationRulePage.editRule(map, Utility.getMapKeys(map));
			platformConfigurationRulePage.verifyEditedRule(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "Rule_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteRule, Author: shivani.patel")
	public void deleteRule(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editRule");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationRule();
			platformConfigurationRulePage.deleteRule(map, Utility.getMapKeys(map));
			platformConfigurationRulePage.verifyDeletedRule(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
}
