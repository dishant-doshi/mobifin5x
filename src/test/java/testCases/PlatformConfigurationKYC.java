package testCases;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.SetupInit;
import base.TestDataImport;
import pages.HomePage;
import pages.NavigationPage;
import pages.PlatformConfigurationKYCPage;
import utils.Utility;

public class PlatformConfigurationKYC extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	PlatformConfigurationKYCPage platformConfigurationKYCPage;
	SetupInit init;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		platformConfigurationKYCPage = new PlatformConfigurationKYCPage(getDriver());
	}

	@Test(dataProvider = "KYC_Add", dataProviderClass = TestDataImport.class, description = "Id: AddKYC, Author: shivani.patel")
	public void addKYC(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addKYC");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationKYC();
			platformConfigurationKYCPage.addKYC(map, Utility.getMapKeys(map));
			platformConfigurationKYCPage.verifyAddedKYC(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "KYC_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditKYC, Author: shivani.patel")
	public void editKYC(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editKYC");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationKYC();
			platformConfigurationKYCPage.editKYC(map, Utility.getMapKeys(map));
			platformConfigurationKYCPage.verifyEditedKYC(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
	
	@Test(dataProvider = "KYC_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteKYC, Author: shivani.patel")
	public void deleteKYC(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editKYC");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationKYC();
			platformConfigurationKYCPage.deleteKYC(map, Utility.getMapKeys(map));
			platformConfigurationKYCPage.verifyDeletedKYC(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
}
