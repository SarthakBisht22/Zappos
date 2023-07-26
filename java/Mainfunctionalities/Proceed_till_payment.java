package Mainfunctionalities;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Proceed_till_payment {
  @Test
  public void f() throws Exception 
  
  {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  
	  driver.get("https://www.zappos.com/");
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/header/div[4]/div/div[2]/div/a")).click();
	  Thread.sleep(3000);
	  
	  driver.findElement(By.id("zapposSignIn")).click();
	  Thread.sleep(3000);
	  
	  
	  driver.findElement(By.id("ap_email")).sendKeys("sarthakbbisht@gmail.com");
	  Thread.sleep(2000);
	  
	  
	  driver.findElement(By.id("ap_password")).sendKeys("qwe123qwe@Q");
	  Thread.sleep(2000);
	  
	  
	  driver.findElement(By.id("signInSubmit")).click();
	  Thread.sleep(2000);
	  
	  //Selecting Men section
	  Actions a=new Actions(driver);
	  WebElement element = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/header/div[4]/div/nav/ul/li[3]/a"));
      a.moveToElement(element).click().perform();
	  
	  //Selecting Sunglasses
		
	  WebElement sunglass = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/header/div[4]/div/nav/ul/li[3]/div/div/section[3]/ul/li[4]/a"));
      a.moveToElement(sunglass).click().perform();
      Thread.sleep(10000);
	  //Applying filters
      //Fit Assist
    

      // Click on "Square Face" filter
      driver.findElement(By.xpath("//*[@id=\"searchFilters\"]/div/div[2]/section[1]/div/ul/li[2]/a")).click();
      Thread.sleep(5000);
      
	  
	  //Categories
	  driver.findElement(By.xpath("//*[@id=\"searchFilters\"]/div/div[2]/section[2]/div/ul/li[1]/a")).click();
	  Thread.sleep(5000);	  
	
	 JavascriptExecutor js=(JavascriptExecutor)driver; 	
			//scroll till Brand
		WebElement w=driver.findElement(By.xpath("//*[@id=\"brandNameFacet\"]/button"));
			js.executeScript("arguments[0].scrollIntoView();",w);
			Thread.sleep(2000);	
		
	  
	  //Brand
	  driver.findElement(By.xpath("//*[@id=\"searchFilters\"]/div/div[2]/section[2]/div[2]/ul/li[2]/a")).click();
	  Thread.sleep(5000);
	 
	  //scroll till price	  
	  WebElement p=driver.findElement(By.xpath("//*[@id=\"priceFacet\"]/button"));
	  js.executeScript("arguments[0].scrollIntoView();",p);
		Thread.sleep(2000);	
	
	  //Price
	  driver.findElement(By.xpath("//*[@id=\"searchFilters\"]/div/div[2]/section[4]/div/ul/li[3]/a")).click();
	  Thread.sleep(2000);
	  
	 
	  //Screenshot
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(f,new File("C:\\Users\\sarth\\OneDrive\\Desktop\\Automation Testing\\Eclipse Backup\\Finalautomation_Project\\src\\test\\resources\\Screenshots\\ApplyFilters.png"));
		Thread.sleep(5000);
		
		//Choose a product
		 driver.findElement(By.xpath("//*[@id=\"products\"]/article[1]/a")).click();
		 Thread.sleep(2000);
		 
		 js.executeScript("window.scrollTo(0, 2500)");
		//add to cart
		 
		 driver.findElement(By.xpath("//*[@id=\"root\"]/div[5]/div/div[5]/button")).click();
		 Thread.sleep(2000);
		 
		 //Proceed to checkout
		 driver.findElement(By.xpath("/html/body/div[5]/div/div[4]/form/button")).click();
		 Thread.sleep(2000); 
		 
		 js.executeScript("window.scrollTo(0, 500)");
		
		 //Shipping Address
		 Select s;
		 driver.findElement(By.id("countryCode")).click();
		  s=new Select(driver.findElement(By.id("countryCode")));
		  s.selectByValue("US");
		  Thread.sleep(2000);  
		  //name
		  driver.findElement(By.id("fullName")).sendKeys("Sarthak");
		  Thread.sleep(2000);
		  //address
		  driver.findElement(By.id("addressLine1")).sendKeys("House Number: 123");
		  Thread.sleep(2000); 
		  
		  driver.findElement(By.id("addressLine2")).sendKeys("Street: Main Street");
		  Thread.sleep(2000); 
		  //mobile number
		  driver.findElement(By.id("primaryVoiceNumber")).sendKeys("(555) 123-4567");
		  Thread.sleep(2000); 
		  
		  File f1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Files.copy(f1,new File("C:\\Users\\sarth\\OneDrive\\Desktop\\Automation Testing\\Eclipse Backup\\Finalautomation_Project\\src\\test\\resources\\Screenshots\\proceedtocheckout.png"));
			Thread.sleep(5000);
		  
		 System.out.println("Successfully add address");
		  
		 
		  
		
		driver.close();
		
	  
  }
}
