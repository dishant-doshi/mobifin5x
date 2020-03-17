package testCases;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.SetupInit;
import base.TestDataImport;
import pages.HomePage;
import pages.NavigationPage;
import pages.PlatformConfigurationUserCategoryPage;
import utils.Utility;

public class PlatformConfigurationUserCategory extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	PlatformConfigurationUserCategoryPage platformConfigurationUserCategoryPage;
	SetupInit init;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		platformConfigurationUserCategoryPage = new PlatformConfigurationUserCategoryPage(getDriver());
	}

	@Test(dataProvider = "UserCategory_Add", dataProviderClass = TestDataImport.class, description = "Id: AddUserCategory, Author: shivani.patel")
	public void addUserCategory(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addUserCategory");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationUserCategory();
			platformConfigurationUserCategoryPage.addUserCategory(map, Utility.getMapKeys(map));
			platformConfigurationUserCategoryPage.verifyAddedUserCategory(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "UserCategory_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditUserCategory, Author: shivani.patel")
	public void editUserCategory(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editUserCategory");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationUserCategory();
			platformConfigurationUserCategoryPage.editUserCategory(map, Utility.getMapKeys(map));
			platformConfigurationUserCategoryPage.verifyEditedUserCategory(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "UserCategory_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteUserCategory, Author: shivani.patel")
	public void deleteUserCategory(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editUserCategory");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationUserCategory();
			platformConfigurationUserCategoryPage.deleteUserCategory(map, Utility.getMapKeys(map));
			platformConfigurationUserCategoryPage.verifyDeletedUserCategory(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
}