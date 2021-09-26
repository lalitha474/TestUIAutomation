package ExtentReports;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReport_TestNG {
	static WebDriver driver = null;
	ExtentSparkReporter htmlreporter;
	ExtentReports extent;
	ExtentTest Test1;
	

	@BeforeSuite 
	public void setup()
	{
		 htmlreporter = new ExtentSparkReporter("extentTestNG.html");
		 extent = new ExtentReports();
		extent.attachReporter(htmlreporter);	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	@BeforeTest
	public  void LaunchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
	}
	@Test
	public void test1()
	{
		Test1 = extent.createTest("LoginPagetest1","test to validate login ");
		Test1.log(Status.INFO,"Launching browser and opening URL");
		driver.get("https://www.shop-apotheke.com/nl/login.htm");
		Test1.pass("Navigated to LoginPage");
		driver.findElement(By.id("login-email")).clear();
		driver.findElement(By.id("login-email")).sendKeys("lalitha.dumpeta@gmail.com");
		Test1.pass("Entered Username");
		driver.findElement(By.id("login-password")).clear();
		driver.findElement(By.id("login-password")).sendKeys("lalitha");
		Test1.pass("Entered Password");
		driver.findElement(By.id("btn-login")).click();
		Test1.fail("clicked on login");
		Test1.addScreenCaptureFromPath("screenshot.png");

	}
	
@AfterTest
	public  void CloseBrowser()
	{
		driver.close();
		driver.quit();
		Test1.pass("browser closed");
		System.out.print("test completed successfully");
	}
	@AfterSuite
	public void teardown()
	{
		
		Test1.info("test completed successfully");
		extent.flush();
	}

}
