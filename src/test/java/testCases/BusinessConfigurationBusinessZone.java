package testCases;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.SetupInit;
import base.TestDataImport;
import pages.BusinessConfigurationBusinessZonePage;
import pages.HomePage;
import pages.NavigationPage;
import utils.Utility;

public class BusinessConfigurationBusinessZone extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	BusinessConfigurationBusinessZonePage businessConfigurationBusinessZonePage;
	SetupInit init;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		businessConfigurationBusinessZonePage = new BusinessConfigurationBusinessZonePage(getDriver());
	}

	@Test(dataProvider = "BusinessZone_Add", dataProviderClass = TestDataImport.class, description = "Id: AddOperatingEntity, Author: shivani.patel")
	public void addBusinessZone(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addBusinessZone");
			homePage.goToHome();
			navigationPage.clickOnBusinessConfigBusinessZone();
			businessConfigurationBusinessZonePage.addBusinessZone(map, Utility.getMapKeys(map));
			businessConfigurationBusinessZonePage.verifyAddedBusinessZone(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
}
