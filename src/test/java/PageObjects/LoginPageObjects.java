package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

// Implemented using POM model 
public class LoginPageObjects {
	WebDriver driver = null;
	
	By textbox_username = By.id("login-email");
	By textbox_password = By.id("login-password");
	By button_login = By.id("btn-login");
	By Cookiesbutton = By.xpath("//a[text()='Ok']");
	
	public LoginPageObjects(WebDriver driver)
	{
		this.driver=driver;
	}
	public void ClickCookiesOK()
	{
		WebElement Cookieswait = new WebDriverWait(driver, Duration.ofSeconds(10))
			       .until(ExpectedConditions.elementToBeClickable(Cookiesbutton));
		Cookieswait.click();
	}
	
	public void setTextUsername(String username)
	{
		driver.findElement(textbox_username).clear();
		driver.findElement(textbox_username).sendKeys("lalitha.dumpeta@gmail.com");
	}
	public void setTextPassword(String password)
	{
		driver.findElement(textbox_password).clear();
		driver.findElement(textbox_password).sendKeys("lalitha");
	}
	public void ClickLogin()
	{
		driver.findElement(button_login).click();
	}
	public void VerifyCustomerNumber()
	{
	  String DisplayName =driver.findElement(By.xpath("//span[@class='u-color--grey a-h6 u-no-margin']")).getText();
	   String ExpectedName ="Kundennummer 17373670";
	    Assert.assertEquals(DisplayName, ExpectedName);
	}
}
