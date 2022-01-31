package selenium_assessment;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login {
	@Test(dataProvider = "loginData", priority = 1)
  public void login(String UserName, String Password){
		Setup.driver.findElement(By.id(Locators.usernameTextBox)).clear();
		Setup.driver.findElement(By.id(Locators.usernameTextBox)).sendKeys(UserName);
		Setup.driver.findElement(By.id(Locators.passwordTextBox)).clear();
		Setup.driver.findElement(By.id(Locators.passwordTextBox)).sendKeys(Password);
		
		Setup.driver.findElement(By.id(Locators.LoginButton)).click();		
	}
	@Test(priority = 2)
	public void Validation() {
		if(Setup.driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/index.php/dashboard")) {
			System.out.println();			
		}
	}
	@Test(priority = 2)
	public void Validation2() {
		if(Setup.driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b")).getText().equals("Admin")) {
			System.out.println("Admin Displays");
			}
	}
	@Test(priority = 2)
	public void Validation3() {
		if(Setup.driver.findElement(By.id("welcome")).getText().equals("Welcome Admin")) {
			System.out.println("Welcome Admin Displays");
		}
	}
	@DataProvider(name="loginData")
	public Object[][] getData(){
		Object[][] loginData = new Object[2][2];
		//Incorrect Data
		loginData[0][0] = "Lumka";
		loginData[0][1] = "Thile1950";
		//Correct Data
		loginData[1][0] = "Admin";
		loginData[1][1] = "admin123";
		
		return loginData;
	}
}


		
		
	
	
		
		
	
		

		
	
	
	
		
		
 
