package selenium_assessment;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Logout {
  @Test
  public void userLogout() {
	  Setup.driver.findElement(By.id("welcome")).click();
	  Setup.driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[3]/a")).click();
	  
  }
}
