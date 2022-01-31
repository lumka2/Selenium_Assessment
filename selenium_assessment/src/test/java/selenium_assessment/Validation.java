package selenium_assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;
import com.github.dockerjava.api.model.Config;

public class Validation {
  @Test
  public void validation() {
	//click to navigate to admin tab
	//click to navigate to admin tab
	  Configuration.driver.findElement(By.linkText(Locators.admin_tab)).click();	  
	  }
//test
@Test(priority = 7)
//validating admin Url
public void validateAdminUrl() {
	//test case and description
	Configuration.test = Configuration.extent.createTest("Url should contain admin/viewSystemUsers", "Validate that url contain admin/viewSystemUsers");
	
	//admin url
	String admin_url = Locators.admin_url;
	
	boolean result;
	//checking if current url contains admin url
	if(Configuration.driver.getCurrentUrl().contains(admin_url)) {
	result = true;
	}
	else {
	result = false;
	}
	
	//verify that the expected result and the actual result matched or not
	Configuration.assertTrue(result);
	Configuration.test.pass("url contain admin/viewSystemUsers");
	}
//test
@Test(priority = 8)
public void validateAdd () {
	//test case and description
	Configuration.test = Configuration.extent.createTest("Add button should be displayed", "Validate that add button is displayed");

	//calling web element by name
	WebElement save_btn = Configuration.driver.findElement(By.name(Locators.save_btn));
	
	//checking if add button is displayed or not
	if(save_btn.isDisplayed()) {
		Configuration.test.pass("save button is displayed");
	}
}
//test
@Test (priority = 9)
public void validateDelete() {
	//test case and description
	Configuration.test = Configuration.extent.createTest("Delete button should be displayed", "Validate that delete button is displayed");

	//calling web element by name
	WebElement delete_btn = Configuration.driver.findElement(By.name(Locators.delete_btn));
	
	//checking if delete button is displayed or not
	if(delete_btn.isDisplayed()) {
		Configuration.test.pass("delete button is displayed");
	}
}
//test
@Test(priority = 10)
public void validateSearch() {
	//test case and description
	Configuration.test = Configuration.extent.createTest("Search button should be displayed", "Validate that search button is displayed");

	//calling web element by name
	WebElement search_btn = Configuration.driver.findElement(By.name(Locators.search_btn));
	
	//checking if search button is displayed or not
	if(search_btn.isDisplayed()) {
		Configuration.test.pass("search button is displayed");
	}
}
//test
@Test(priority = 11)
public void validateReset() {
	//test case and description
	Configuration.test = Configuration.extent.createTest("Reset button should be displayed", "Validate that reset button is displayed");


	//calling web element by name
	WebElement reset_btn = Configuration.driver.findElement(By.name(Locators.reset_btn));
	//checking if reset button is displayed or not
	if(reset_btn.isDisplayed()) {
		Configuration.test.pass("reset button is displayed");
	}
}
}

	
	
	










