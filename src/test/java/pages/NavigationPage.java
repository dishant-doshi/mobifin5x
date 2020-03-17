package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.CommonConstants;
import base.ScriptConstants;
import base.SetupInit;
import utils.Utility;

public class NavigationPage extends SetupInit {
	By platformConfiguration = By.xpath("//*[@class='ant-menu-submenu-title']//*[normalize-space(text())='"
			+ ScriptConstants.PLATFORM_CONFIGURATION + "']");
	By parameter = By.id(Utility.readJSFile("module.name.parameter", CommonConstants.LABLE_FILE));
	By KYC = By.id("Kyc");
	By userCategory = By.id(Utility.readJSFile("role.label.usercategory", CommonConstants.LABLE_FILE));
	By wallet = By.id(Utility.readJSFile("module.name.wallet", CommonConstants.LABLE_FILE));
	By unit = By.id("Unit");
	By pouch = By.id(Utility.readJSFile("module.name.pouch", CommonConstants.LABLE_FILE));
	By service = By.id("Service");
	By accessChannel = By.id(Utility.readJSFile("module.name.accesschannel", CommonConstants.LABLE_FILE));
	By UCP = By.id("Ucp");
	By counter = By.id(Utility.readJSFile("module.name.counter", CommonConstants.LABLE_FILE));
	By rule = By.id(Utility.readJSFile("module.name.rule", CommonConstants.LABLE_FILE));
	By product = By.id("Product");
	By productGroup = By.id(Utility.readJSFile("module.name.productgroup", CommonConstants.LABLE_FILE));
	By notificationTemplate = By.id(Utility.readJSFile("module.name.notificationtemplate", CommonConstants.LABLE_FILE));
	By exchnageRateManager = By.id(Utility.readJSFile("module.name.exchangeratemanager", CommonConstants.LABLE_FILE));
	By operatorConfiguration = By
			.xpath("//*[@class='ant-menu-submenu-title']//*[normalize-space(text())='Operator Config']");
	By role = By.id(Utility.readJSFile("module.name.role", CommonConstants.LABLE_FILE));
	By systemOperatorEntity = By.id(Utility.readJSFile("module.name.systemoperatorentity", CommonConstants.LABLE_FILE));
	By systemOperatorOnboarding = By.id("System Operator Onboarding");
	By businessConfiguration = By
			.xpath("//*[@class='ant-menu-submenu-title']//*[normalize-space(text())='Business Config']");
	By vendorManagement = By.id(Utility.readJSFile("module.name.vendormanagement", CommonConstants.LABLE_FILE));
	By serviceVendor = By.id(Utility.readJSFile("module.name.servicevendor", CommonConstants.LABLE_FILE));
	By notification = By.id(Utility.readJSFile("module.name.notification", CommonConstants.LABLE_FILE));
	By serviceProfile = By.id(Utility.readJSFile("module.name.serviceprofile", CommonConstants.LABLE_FILE));
	By productManagement = By.id(Utility.readJSFile("module.name.productmanagement", CommonConstants.LABLE_FILE));
	By businessHierarchy = By.id("Business Hierarchy");
	By technicalVendor = By.id(Utility.readJSFile("module.name.technicalvendor", CommonConstants.LABLE_FILE));
	By walletTemplate = By.id("Wallet Template");
	By operation = By.xpath("//*[@class='ant-menu-submenu-title']//*[normalize-space(text())='Operation']");
	By reportTool = By.id("Report Tool");
	By technicalConfig = By
			.xpath("//*[@class='ant-menu-submenu-title']//*[normalize-space(text())='Technical Config']");
	By addMoney = By.id("Add Money");
	By process = By.id("Process");
	By scheduler = By.id("Scheduler");
	By processScheduler = By.id("Process Scheduler");
	By processRunDetails = By.id("Process Run Details");
	By userManagement = By.xpath("//*[@class='ant-menu-submenu-title']//*[normalize-space(text())='User Management']");
	By viewUser = By.id("View User");

	public NavigationPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnPlateformConfigurationParameter() {
		clickOnElement(platformConfiguration, 0);
		clickOnElement(parameter, 0);
	}

	public void clickOnOperatorConfigSystemOperatorEntity() {
		clickOnElement(operatorConfiguration, 0);
		clickOnElement(systemOperatorEntity, 0);
	}

	public void clickOnOperatorConfigSystemOperatorOnboarding() {
		clickOnElement(operatorConfiguration, 0);
		clickOnElement(systemOperatorOnboarding, 0);
	}

	public void clickOnBusinessConfigOperatingEntity() {
		clickOnElement(businessConfiguration, 0);
		clickOnElement(businessHierarchy, 0);
	}

	public void clickOnUserManagementViewUser() {
		clickOnElement(userManagement, 0);
		clickOnElement(viewUser, 0);
	}

	public void clickOnPlateformConfigurationKYC() {
		clickOnElement(platformConfiguration, 0);
		clickOnElement(KYC, 0);
	}

	public void clickOnPlateformConfigurationUserCategory() {
		clickOnElement(platformConfiguration, 0);
		clickOnElement(userCategory, 0);
	}

	public void clickOnBusinessConfigOperatingEntityTemplate() {
		clickOnElement(businessConfiguration, 0);
		clickOnElement(businessHierarchy, 0);
	}

	public void clickOnBusinessConfigBusinessZone() {
		clickOnElement(businessConfiguration, 0);
		clickOnElement(businessHierarchy, 0);
	}

	public void clickOnPlateformConfigurationUnit() {
		clickOnElement(platformConfiguration, 0);
		clickOnElement(unit, 0);
	}
	public void clickOnPlateformConfigurationRule() {
		clickOnElement(platformConfiguration, 0);
		clickOnElement(rule, 0);
	}
}
