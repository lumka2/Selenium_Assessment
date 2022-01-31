package selenium_assessment;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DeleteUser {
  @Test
  public void DeleteSelectedUser() {
	  
	  Setup.driver.findElement(By.name("chkSelectRow[]")).click();

	  Setup.driver.findElement(By.id("btnDelete")).click();

	  Setup.driver.findElement(By.id("dialogDeleteBtn")).click();
  }
}
	  

	  
	  
