package selenium_assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Test

public class OrangeHRM {
	
	WebDriver driver = null;
 @BeforeSuite
  public void setup() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			
			//validate page title
			if(!driver.getTitle().equalsIgnoreCase("OrangeHRM")) {
				System.err.println("Invalid page title");
				
			}
		}
 @Test (priority = 1)
  public void login() {
	  driver.findElement(By.id(Locators.usernameTextBox)).clear();
	  driver.findElement(By.id(Locators.usernameTextBox)).sendKeys(InputVariable.UserNameLogin);
	  driver.findElement(By.id(Locators.passwordTextBox)).clear();
	  driver.findElement(By.id(Locators.passwordTextBox)).sendKeys(InputVariable.Password);
	  
	  driver.findElement(By.id(Locators.LoginButton)).click();
	  
	  //Validation missing
	  
//validation 1
 if(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/index.php/dashboard")) {
	  System.out.println();
	  System.out.println(driver.findElement(By.id("menu_admin_viewAdminModule")).getText());
	  
	  driver.findElement(By.id("menu_admin_viewAdminModule")).click();
	  
	  if(driver.getCurrentUrl().contains("admin/viewSystemUsers")) {
		  if(driver.findElement(By.id("searchBtn")) != null) {
			  System.out.println("Search Button Exists");
		  }
		  if(driver.findElement(By.id("resetBtn")) != null) {
			  System.out.println("reset Button Exists");
		  }
		  if(driver.findElement(By.id("btnAdd")) != null) {
			  System.out.println("add Button Exists");
		  }
		  if(driver.findElement(By.id("btnDelete")) != null) {
			  System.out.println("Delete Button Exists");
		  }
	  }
 }
		  
 }
 @Test (priority = 2)
  public void add() {
		if(driver.findElement(By.id("btnAdd")) != null) {
			driver.findElement(By.id("btnAdd")).click();
			
			if(driver.getCurrentUrl().contains("saveSystemUser") && driver.findElement(By.id("UserHeading")).getText().equalsIgnoreCase("Add User")) {
				System.out.println(driver.findElement(By.id("systemUser_userType")).getText());
				//NB verify status dropdown is Selected
				Select Statuslocation = new Select(driver.findElement(By.id("systemUser_status")));
				
				if (Statuslocation.getFirstSelectedOption().getText().equalsIgnoreCase("Enabled")) {
					Select newLocation = new Select(driver.findElement(By.id("systemUser_userType")));
					newLocation.selectByVisibleText("ESS");
					
					driver.findElement(By.id("systemUser_employeeName_empName")).clear();
					driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(InputVariable.Employee_Name);
					
					driver.findElement(By.id("systemUser_userName")).clear();
					driver.findElement(By.id("systemUser_userName")).sendKeys(InputVariable.UserName);
					
					driver.findElement(By.id("systemUser_password")).clear();
					driver.findElement(By.id("systemUser_password")).sendKeys(InputVariable.Pass1);
					
					driver.findElement(By.id("systemUser_confirmPassword")).clear();
					driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(InputVariable.Pass1);
					
					
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					driver.findElement(By.name("btnSave")).click();
					
					 
					if(driver.findElement(By.className("validation-error")) != null) {
						//driver.switchTo().alert().getText();
						if(driver.findElement(By.xpath("//span[contains(@class, 'validation-error')]")).getText().equalsIgnoreCase("Employee does not exist")) {
							
							System.out.println(driver.findElement(By.xpath("//span[contains(@class, 'validation-error')]")).getText());
							
							driver.findElement(By.id("systemUser_employeeName_empName")).clear();
							driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(InputVariable.Employee_Name);
							
							driver.findElement(By.id("btnSave")).click();
						}
						System.out.println(driver.findElement(By.xpath("//span[contains(@class, 'validation-error')]")).getText());
						System.out.println(driver.findElement(By.className("validation-error")).getText());
					}
					
					
				}
			}
		}
 }
}