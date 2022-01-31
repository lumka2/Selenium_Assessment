package selenium_assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AddUser {
  @Test
  public void add() {
	  if(Setup.driver.findElement(By.id("btnAdd")) != null) {
		  Setup.driver.findElement(By.id("btnAdd")).click();
		  
		  if(Setup.driver.getCurrentUrl().contains("saveSystemUser") && Setup.driver.findElement(By.id("UserHeading")).getText().equalsIgnoreCase("Add User")) {
			  System.out.println(Setup.driver.findElement(By.id("systemUser_userType")).getText());
			  //NB verify status dropdown is Selected
			  Select Statuslocation = new Select(Setup.driver.findElement(By.id("systemUser_status")));
			  
			  if (Statuslocation.getFirstSelectedOption().getText().equalsIgnoreCase("Enabled")) {
				  Select newLocation = new Select(Setup.driver.findElement(By.id("systemUser_userType")));
				  newLocation.selectByVisibleText("ESS");
				  
				  Setup.driver.findElement(By.id("systemUser_employeeName_empName")).clear();
				  Setup.driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(InputVariable.Employee_Name);
				  
				  Setup.driver.findElement(By.id("systemUser_userName")).clear();
				  Setup.driver.findElement(By.id("systemUser_userName")).sendKeys(InputVariable.UserName);
				  
				  Setup.driver.findElement(By.id("systemUser_password")).clear();
				  Setup.driver.findElement(By.id("systemUser_password")).sendKeys("Selenium500");
				  
				  Setup.driver.findElement(By.id("systemUser_confirmPassword")).clear();
				  Setup.driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("Selenium500");
				  
				  try {
					  Thread.sleep(3000);
					  } catch (InterruptedException e) {
					  // TODO Auto-generated catch block
					  e.printStackTrace();
					  }

				  Setup.driver.findElement(By.name("btnSave")).click();
			  }
		  }
	  }
  }
}
  
			 



				  
				  

				  
				  
			  
			  

		  
		  
	  
  
