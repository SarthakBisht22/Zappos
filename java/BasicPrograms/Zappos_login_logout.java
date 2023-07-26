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

public class Zappos_login_logout {
  @Test
  public void f() throws Exception 
  {WebDriverManager.chromedriver().setup();
  WebDriver driver=new ChromeDriver();
  driver.manage().window().maximize();
  driver.manage().deleteAllCookies();
  
  
  Properties p=new Properties();
  FileInputStream file =new FileInputStream("C:\\Users\\sarth\\OneDrive\\Desktop\\Automation Testing\\Eclipse Backup\\Finalautomation_Project\\src\\test\\resources\\Zappos.properties");
  p.load(file);
  //URL
  driver.get("https://www.zappos.com/");
  Thread.sleep(5000);
  //Sign process
  driver.findElement(By.xpath(p.getProperty("signin"))).click();
  Thread.sleep(3000);
  
  driver.findElement(By.id(p.getProperty("zappossignin"))).click();
  Thread.sleep(3000);
  //Enter credentials
  Scanner s = new Scanner(System.in);
  System.out.print("Enter  Email: ");
 String Email=s.nextLine();
 System.out.print("Enter  Password: ");
  String Password=s.nextLine();
  
  driver.findElement(By.id(p.getProperty("Enteremail"))).sendKeys(Email);
  Thread.sleep(2000);
  s.close();
  
  driver.findElement(By.id(p.getProperty("Enterpassword"))).sendKeys(Password);
  Thread.sleep(2000);
  
  //clicking on login button
  driver.findElement(By.id(p.getProperty("login"))).click();
  Thread.sleep(2000);
//Verifying successful login
  WebDriverWait wait = new WebDriverWait(driver, 10);
  WebElement myAccountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(p.getProperty("Myaccount"))));
 
  if (myAccountElement.isDisplayed()) {
      System.out.println("Login successful: My Account element displayed after login.");
  } else {
      System.out.println("Login failed: My Account element not displayed after login.");
  }
  
  driver.findElement(By.xpath(p.getProperty("Myaccount"))).click();
  Thread.sleep(2000);
  WebElement parentDiv = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/header/div[4]/div/div[2]/div/div"));
  WebElement signOutLink = parentDiv.findElement(By.xpath(p.getProperty("logout")));
  signOutLink.click();
  
  WebElement signInLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(p.getProperty("signin"))));
  
  // Verifying successful logout
  if (signInLink.isDisplayed()) {
      System.out.println("Logout successful: Sign In link displayed after logout.");
  } else {
      System.out.println("Logout failed: Sign In link not displayed after logout.");
  }

  
  
 
  driver.close();

  
  
  }
}
