package selenium_assessment;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SearchUser {
  @Test
  public void search() {
	  Setup.driver.findElement(By.id("searchSystemUser_userName")).clear();
	  Setup.driver.findElement(By.id("searchSystemUser_userName")).sendKeys(InputVariable.UserName);


	  Setup.driver.findElement(By.id("searchBtn")).click();
  }
}
	  
  