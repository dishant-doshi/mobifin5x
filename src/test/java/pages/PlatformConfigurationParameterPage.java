package pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;

import com.panamax.init.CommonVariables;

import locators.PlatformConfigurationParameter;

public class PlatformConfigurationParameterPage extends CommonPage implements PlatformConfigurationParameter {
	public void filterSearch(String name, String str2, String usedBy, boolean isSubString) {
		commonFilterSearch();
		if (isSubString) {
			clickOnElement(filterDownArrow);
			clickOnElement(filterBy);
		}
		sendKeys(txtNameInSearch, name);
		selectFromDropDown(drpUsedBy, By.xpath(String.format(dropDownValue, usedBy)));
		selectStatusInFilterSearch(str2);
		clickOnFilterSearchBtn();
	}

	public void addParameter(Map<Object, Object> map, List<Object> mapKeys) {
		clickOnAddButton();
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(14)).toString(),
				map.get(mapKeys.get(15)).toString(), true);
	}

	public void verifyAddedParameter(Map<Object, Object> map, List<Object> mapKeys) {

	}

}
