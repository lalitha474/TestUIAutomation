package Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

import PageObjects.ShopApathokeloginpage;
public class ShopApathokeLoginTest {
	static WebDriver driver =null;

	public static void main(String[] args) {
		LoginShopApathoke();
	}

	public static void LoginShopApathoke()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.shop-apotheke.com/nl/login.htm");
		driver.manage().window().maximize();
		
		// this code wait for cookie button on login screen and clicks on it
		WebElement Cookieswait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Ok']")));
		Cookieswait.click();
		
		// clears the text in user name text box and type email address on it 
		ShopApathokeloginpage.Username_txtbox(driver).clear();
		ShopApathokeloginpage.Username_txtbox(driver).sendKeys("lalitha.dumpeta@gmail.com");
		
		// clears the text in Password text box and type Password on it 
		ShopApathokeloginpage.Password_txtbox(driver).clear();
		ShopApathokeloginpage.Password_txtbox(driver).sendKeys("lalitha");
		
		//clicks on login button
		ShopApathokeloginpage.Login_button(driver).click();
		
		// below piece of code verifies the customer number whether logged into page or not
		String DisplayName =ShopApathokeloginpage.VerifyCustomerNumber(driver).getText();
		String ExpectedName ="Kundennummer 17373670";
		Assert.assertEquals(DisplayName, ExpectedName);
		//close browser 
		driver.close();
		System.out.print("test completed successfully");
		driver.quit();
	}

}
