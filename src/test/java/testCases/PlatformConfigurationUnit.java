package testCases;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.SetupInit;
import base.TestDataImport;
import pages.HomePage;
import pages.NavigationPage;
import pages.PlatformConfigurationUnitPage;
import utils.Utility;

public class PlatformConfigurationUnit extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	PlatformConfigurationUnitPage platformConfigurationUnitPage;
	SetupInit init;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		platformConfigurationUnitPage = new PlatformConfigurationUnitPage(getDriver());
	}

	@Test(dataProvider = "Unit_Add", dataProviderClass = TestDataImport.class, description = "Id: AddUnit, Author: shivani.patel")
	public void addUnit(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addUnit");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationUnit();
			platformConfigurationUnitPage.addUnit(map, Utility.getMapKeys(map));
			platformConfigurationUnitPage.verifyAddedUnit(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "Unit_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditUnit, Author: shivani.patel")
	public void editUnit(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editUnit");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationUnit();
			platformConfigurationUnitPage.editUnit(map, Utility.getMapKeys(map));
			platformConfigurationUnitPage.verifyEditedUnit(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "Unit_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteUnit, Author: shivani.patel")
	public void deleteUnit(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editUnit");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationUnit();
			platformConfigurationUnitPage.deleteUnit(map, Utility.getMapKeys(map));
			platformConfigurationUnitPage.verifyDeletedUnit(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
}
