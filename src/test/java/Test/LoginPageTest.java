package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.LoginPageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;

//Implemented using POM model 
public class LoginPageTest {
	static WebDriver driver = null;

	public static void main(String[] args) {
		LoginPageTestmethod();

	}

	public static void LoginPageTestmethod(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		LoginPageObjects LoginPageobj = new LoginPageObjects(driver);
		driver.get("https://www.shop-apotheke.com/nl/login.htm");
		
		LoginPageobj.ClickCookiesOK();
		
		LoginPageobj.setTextUsername("lalitha.dumpeta@gmail.com");
		
		LoginPageobj.setTextPassword("password");
		
		LoginPageobj.ClickLogin();
		
		LoginPageobj.VerifyCustomerNumber();
		
		driver.close();
		System.out.print("test completed successfully");
		driver.quit();
	}

}
