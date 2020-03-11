package testCases;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.SetupInit;
import base.TestDataImport;
import pages.HomePage;
import pages.NavigationPage;
import pages.OperatorConfigSystemOperatorEntityPage;
import utils.Utility;

public class OperatorConfigSystemOperatorEntity extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	OperatorConfigSystemOperatorEntityPage operatorConfigSystemOperatorEntityPage;
	SetupInit init;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		operatorConfigSystemOperatorEntityPage = new OperatorConfigSystemOperatorEntityPage(getDriver());
	}

	@Test(dataProvider = "SystemOperatorEntity_Add", dataProviderClass = TestDataImport.class, description = "Id: AddSystemOperatorEntity, Author: shivani.patel")
	public void addSystemOperatorEntity(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addSystemOperatorEntity");
			homePage.goToHome();
			navigationPage.clickOnOperatorConfigSystemOperatorEntity();
			operatorConfigSystemOperatorEntityPage.addSystemOperatorEntity(map, Utility.getMapKeys(map));
			operatorConfigSystemOperatorEntityPage.verifyAddedSystemOperatorEntity(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
}
