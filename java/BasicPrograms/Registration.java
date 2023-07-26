package BasicPrograms;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Registration {
  @Test
  public void f() throws Exception 
  
  {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  
	  
	  Properties p=new Properties();
	  FileInputStream file =new FileInputStream("C:\\Users\\sarth\\OneDrive\\Desktop\\Automation Testing\\Eclipse Backup\\Finalautomation_Project\\src\\test\\resources\\Zappos.properties");
	  p.load(file);
	  
	  driver.get("https://www.zappos.com/");
	  Thread.sleep(5000);
	  
	  driver.findElement(By.xpath(p.getProperty("signin"))).click();
	  Thread.sleep(3000);
	  
	  driver.findElement(By.id(p.getProperty("Createaccount"))).click();
	  Thread.sleep(3000);
	  //Scanner
	  Scanner s= new Scanner(System.in);

	    // Prompt the user for registration details
	    System.out.print("Enter your username: ");
	    String username = s.nextLine();

	    System.out.print("Enter your email: ");
	    String email = s.nextLine();

	    System.out.print("Enter your password: ");
	    String password = s.nextLine();
	    
	    System.out.print("confirmpassword:");
	    String  confirmpassword = s.nextLine();
	 
	  driver.findElement(By.id(p.getProperty("yourname"))).sendKeys(username);
	  Thread.sleep(3000);
	  
	  driver.findElement(By.id(p.getProperty("email"))).sendKeys(email);
	  Thread.sleep(3000);
	  
	  driver.findElement(By.id(p.getProperty("password"))).sendKeys(password);
	  Thread.sleep(3000);
	  
	  driver.findElement(By.id(p.getProperty("reenterpassword"))).sendKeys(confirmpassword);
	  Thread.sleep(3000);
	  
	  driver.findElement(By.id(p.getProperty("Createbutton"))).click();
	  Thread.sleep(3000);
	  
	  WebDriverWait wait = new WebDriverWait(driver, 10);
      WebElement myAccountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(p.getProperty("Myaccount"))));
      // Check if registration is successful and print appropriate message
      if (myAccountElement.isDisplayed()) {
          System.out.println("Registration successful.");
      } else {
          System.out.println("Registration failed.");
      }
      s.close();
	  driver.close();
	  
	 
	 	  
  }
}
