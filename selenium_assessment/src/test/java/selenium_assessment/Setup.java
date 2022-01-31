package selenium_assessment;

import java.lang.System.Logger;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
@Test
public class Setup {
	public static WebDriver driver = null;
	Logger log;
	static ExtentReports extent;
	static ExtentTest test; 
	
	@BeforeSuite
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		//extent report
		extent = new ExtentReports();
		ExtentSparkReporter spark_reporter = new ExtentSparkReporter("./src/test/resources/reporter.html");
		extent.attachReporter(spark_reporter);
		
		
		//validate page title
		if(!driver.getTitle().equalsIgnoreCase("OrangeHRM")) {
		System.err.println("Invalid page title");
		}
	}
	@AfterSuite
	public void Cleanup() {
		extent.flush();
	}
}


	
		
