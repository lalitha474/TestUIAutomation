import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BrowserTest {
	
	public static void main(String[] args) {
		
		//System.setProperty("webdriver.chrome.driver", "/Users/lalit/source/Selenium/SeleniumFrameWork/Drivers/chromedriver/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.shop-apotheke.com/nl/login.htm");
		
		
		
	}

}
