package Mainfunctionalities;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Smoketesting {
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
	  
	  // sign up
	  
	  driver.findElement(By.id("ap_email")).sendKeys("sarthakbisht364@gmail.com");
	  Thread.sleep(2000);
	  
	  
	  driver.findElement(By.id("ap_password")).sendKeys("qwe123qwe@Q");
	  Thread.sleep(2000);
	  
	  
	  driver.findElement(By.id("signInSubmit")).click();
	  Thread.sleep(2000);
	  
	  
	  Actions a=new Actions(driver);
	  
	  List<WebElement>ls=driver.findElements(By.xpath("//*[@id=\"root\"]/div[1]/header/div[4]/div/nav/ul/li"));
	  
	  int size=ls.size();
		System.out.println("No. of webelements:"+size);
		
		for(int i=1;i<=size;i++)
		{
			//wait
			Thread.sleep(2000);
			//perform mouse hover
			 WebElement element = driver.findElement(By.xpath("//*[@id='root']/div[1]/header/div[4]/div/nav/ul/li[" + i + "]"));
	            a.moveToElement(element).click().perform();
	            
	            // Print the web element
	            System.out.println("Element " + i + ": " + element.findElement(By.xpath(".//a")).getText());
			
	            
		}
		
		//screenshot
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(f,new File("C:\\Users\\sarth\\OneDrive\\Desktop\\Automation Testing\\Eclipse Backup\\Finalautomation_Project\\src\\test\\resources\\Screenshots\\Smoketesting.png"));
		
		 Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"headerMyAccountDropdownToggle\"]")).click();
		  Thread.sleep(2000);
		
		 WebElement parentDiv = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/header/div[4]/div/div[2]/div/div"));
		  WebElement signOutLink = parentDiv.findElement(By.xpath(".//a[@href='/logout']"));
		  signOutLink.click();
	  Thread.sleep(2000);
	  driver.close();
	  
  }
}
