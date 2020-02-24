package testCases;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.SetupInit;
import base.TestDataImport;
import pages.HomePage;
import pages.NavigationPage;
import pages.PlatformConfigurationParameterPage;
import utils.Utility;

public class PlatformConfigurationParameter extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	PlatformConfigurationParameterPage platformConfigurationParameterPage;

	@BeforeClass
	public void beforeClass() {
		homePage = new HomePage();
		navigationPage = new NavigationPage();
	}

	@Test(dataProvider = "Parameter_Add", dataProviderClass = TestDataImport.class, description = "Id: AddParameter, Author: shivani.patel")
	public void addParameter(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addParameter");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationParameter();
			platformConfigurationParameterPage.addParameter(map, Utility.getMapKeys(map));
			platformConfigurationParameterPage.verifyAddedParameter(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
}
