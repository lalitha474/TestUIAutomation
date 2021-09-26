package ExtentReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReporttestDemo {
	
public static void main(String[] args) {
	
	ExtentSparkReporter htmlreporter = new ExtentSparkReporter("extent.html");
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(htmlreporter);
	
	ExtentTest Test1 = extent.createTest("LoginPagetest1","test to validate login ");
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
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
	Test1.pass("clicked on login");
	driver.close();
	Test1.pass("browser closed");
	driver.quit();
	Test1.info("test completed successfully");
	
	//to see the failed case senerio in reports creating below code
	
	ExtentTest Test2 = extent.createTest("LoginPagetest1","test to validate login ");
	WebDriverManager.chromedriver().setup();
	Test2.log(Status.INFO,"Launching browser and opening URL");
	driver.get("https://www.shop-apotheke.com/nl/login.htm");
	Test2.pass("Navigated to LoginPage");
	driver.findElement(By.id("login-email")).clear();
	driver.findElement(By.id("login-email")).sendKeys("lalitha.dumpeta@gmail.com");
	Test2.pass("Entered Username");
	driver.findElement(By.id("login-password")).clear();
	driver.findElement(By.id("login-password")).sendKeys("lalitha");
	Test2.pass("Entered Password");
	driver.findElement(By.id("btn-login")).click();
	Test2.fail("clicked on login");
	driver.close();
	Test2.pass("browser closed");
	driver.quit();
	Test1.info("test completed successfully");
	extent.flush();
}
}
