package testCases;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.SetupInit;
import base.TestDataImport;
import pages.HomePage;
import pages.NavigationPage;
import pages.PlatformConfigurationParameterPage;

public class PlatformConfigurationParameter extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	PlatformConfigurationParameterPage platformConfigurationParameterPage;
	private long startTime;

	@BeforeClass
	public void beforeClass() {
		homePage = new HomePage();
		navigationPage = new NavigationPage();
	}

	@Test(dataProvider = "Parameter_Add", dataProviderClass = TestDataImport.class, description = "Id: AddParameter, Author: shivani.patel")
	public void addParameter(Map<Object, Object> map) {
		startTime = System.currentTimeMillis();
		try {
			map.put("Test Start Time", startTime);
			map.put("Class Name", this.getClass().getName());
			map.put("Method Name", "addParameter");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationParameter();
			platformConfigurationParameterPage.addParameter(map);
			platformConfigurationParameterPage.verifyAddedParameter(map);
			map.put("value", 100);
			// map.put("Performed Steps", log.list);
		} catch (Exception e) {
			map.put("value", 0);
			// map.put("Performed Steps", log.list);
			logException(e, map);
		} finally {
			logData(map);
			// log.list.clear();
		}
	}
}
