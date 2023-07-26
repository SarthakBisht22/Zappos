package Multiple_browser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Mousehover_addtocart {

	public static void main(String[] args) throws Exception  
	{
		
		String[] browsers = {"chrome", "firefox"};
		for (String browser : browsers) {
			WebDriver driver;

			if (browser.equals("chrome")) {
			//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\sarth\\OneDrive\\Desktop\\Automation Testing\\Eclipse Backup\\Finalautomation_Project\\src\\test\\resources\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if(browser.equals("firefox")) {
				//System.setProperty("webdriver.gecko.driver", "C:\\Users\\sarth\\OneDrive\\Desktop\\Automation Testing\\Eclipse Backup\\Finalautomation_Project\\src\\test\\resources\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else {
				System.out.println("Invalid browser selection!");
				return;
			}

			driver.manage().window().maximize();
			
			performZapposTests(driver, browser);

			
			driver.quit();
		}
	}

	public static void performZapposTests(WebDriver driver, String browserName) throws Exception {
		// Test for Zappos website
		driver.get("https://www.zappos.com");

		driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/header/div[4]/div/div[2]/div/a")).click();
		Thread.sleep(3000);

		driver.findElement(By.id("zapposSignIn")).click();
		Thread.sleep(3000);


		driver.findElement(By.id("ap_email")).sendKeys("sarthakbisht364@gmail.com");
		Thread.sleep(2000);


		driver.findElement(By.id("ap_password")).sendKeys("qwe123qwe@Q");
		Thread.sleep(2000);


		driver.findElement(By.id("signInSubmit")).click();
		Thread.sleep(2000);


		Actions a = new Actions(driver);

		List<WebElement> ls = driver.findElements(By.xpath("//*[@id='root']/div[1]/header/div[4]/div/nav/ul/li"));

		int size = ls.size();
		System.out.println("No. of webelements:" + size);

		for (int i = 1; i <= size; i++) {
			//wait
			Thread.sleep(2000);
			//perform mouse hover
			WebElement element = driver.findElement(By.xpath("//*[@id='root']/div[1]/header/div[4]/div/nav/ul/li[" + i + "]"));
			a.moveToElement(element).click().perform();

			// Print the web element
			System.out.println("Element " + i + ": " + element.findElement(By.xpath(".//a")).getText());

		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"headerMyAccountDropdownToggle\"]")).click();
		Thread.sleep(2000);

		WebElement parentDiv = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/header/div[4]/div/div[2]/div/div"));
		WebElement signOutLink = parentDiv.findElement(By.xpath(".//a[@href='/logout']"));
		signOutLink.click();


		// Print test completion message
		System.out.println("Tests completed for " + browserName);
	}
}
