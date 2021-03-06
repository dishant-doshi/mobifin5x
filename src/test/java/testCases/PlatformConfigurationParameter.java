package testCases;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
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
	SetupInit init;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		platformConfigurationParameterPage = new PlatformConfigurationParameterPage(getDriver());
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

	@Test(dataProvider = "Parameter_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditParameter, Author: shivani.patel")
	public void editParameter(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editParameter");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationParameter();
			platformConfigurationParameterPage.editParameter(map, Utility.getMapKeys(map));
			platformConfigurationParameterPage.verifyEditedParameter(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "Parameter_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteParameter, Author: shivani.patel")
	public void deleteParameter(Map<Object, Object> map) {
		try {
			setTestParameters(map, "deleteParameter");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationParameter();
			platformConfigurationParameterPage.deleteParameter(map, Utility.getMapKeys(map));
			platformConfigurationParameterPage.verifyDeletedParameter(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
}
