package Test;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

// Implemented Login test with TESTNG

public class LoginPage_TestNG {
	static WebDriver driver = null;


	@BeforeTest
	public static void LaunchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.shop-apotheke.com/nl/login.htm");
		driver.manage().window().maximize();

	}


	@Test

	public static void LoginShopApathoke()
	{
		// this code wait for cookie button on login screen and clicks on it
		WebElement Cookieswait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Ok']")));
		Cookieswait.click();
		// clears the text in user name text box and type email address on it 
		driver.findElement(By.id("login-email")).clear();
		driver.findElement(By.id("login-email")).sendKeys("lalitha.dumpeta@gmail.com");
		// clears the text in Password text box and type Password on it 
		driver.findElement(By.id("login-password")).clear();
		driver.findElement(By.id("login-password")).sendKeys("lalitha");
		//clicks on login button
		driver.findElement(By.id("btn-login")).click();

		// below piece of code verifies the customer number whether logged into page or not
		String DisplayName =driver.findElement(By.xpath("//span[@class='u-color--grey a-h6 u-no-margin']")).getText();
		String ExpectedName ="Kundennummer 17373670";
		Assert.assertEquals(DisplayName, ExpectedName);
	}


	@AfterTest

	public static void CloseBrowser()
	{

		driver.close();
		System.out.print("test completed successfully");
		driver.quit();

	}
}
