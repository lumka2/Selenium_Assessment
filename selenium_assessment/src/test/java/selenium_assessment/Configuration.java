package selenium_assessment;

import java.lang.System.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.util.Assert;

public class Configuration {
	
	//gloabl variables
	static ExtentReports extent;
	static WebDriver driver;
	static ExtentTest test;
	static String message;
	static Logger log;
	static Assert assertTrue;
	static boolean result;
	
  @Test
  public void setup() {
	  //start reports
	  ExtentSparkReporter spark = new ExtentSparkReporter ("./src/test/resources/Report.html");
  }

public static void assertTrue(boolean result2) {
	// TODO Auto-generated method stub
	
}
}
