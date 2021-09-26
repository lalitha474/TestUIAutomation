package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ShopApathokeloginpage {
	WebElement element = null;
	
	public static WebElement ClickCookiesOK(WebDriver driver)
	{
		WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
			       .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Ok']")));
		return element;
	}
	public static WebElement Username_txtbox(WebDriver driver){
		WebElement element = driver.findElement(By.id("login-email"));
		return element;
		
	}

	public static WebElement Password_txtbox(WebDriver driver){
		WebElement element = driver.findElement(By.id("login-password"));
		return element;
		
	}
	public static WebElement Login_button(WebDriver driver){
		WebElement element = driver.findElement(By.id("btn-login"));
		return element;
		
	}
	public static WebElement VerifyCustomerNumber(WebDriver driver)
	{
		WebElement element = driver.findElement(By.xpath("//span[@class='u-color--grey a-h6 u-no-margin']"));
		return element;
	 
	}
	
	
}
