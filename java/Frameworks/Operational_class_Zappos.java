package Frameworks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class Operational_class_Zappos 

{public void maximizeBrowser(WebDriver driver)
{
	driver.manage().window().maximize();
}
public void url(WebDriver driver)
{
driver.get("https://www.zappos.com/");
}
public void signin(WebDriver driver)
{
	driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/header/div[4]/div/div[2]/div/a")).click();
}
public void zappossignin(WebDriver driver)
{
	driver.findElement(By.id("zapposSignIn")).click();
}

public void Email(WebDriver driver, String Email)
{
driver.findElement(By.id("ap_email")).sendKeys(Email);
}
public void Password(WebDriver driver, String password)
{
driver.findElement(By.id("ap_password")).sendKeys(password);

}
public void loginButton(WebDriver driver)
{
	driver.findElement(By.id("signInSubmit")).click();
}
public void SmokeTesting(WebDriver driver) throws Exception
{ Actions a=new Actions(driver);

List<WebElement>ls=driver.findElements(By.xpath("//*[@id='root']/div[1]/header/div[4]/div/nav/ul/li"));

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
          System.out.println("Element " + i + ": " + element.getText());
		
    }}
public void Myaccount(WebDriver driver)
{
		driver.findElement(By.xpath("//*[@id=\"headerMyAccountDropdownToggle\"]")).click();
}	
public void logout(WebDriver driver)
{
	WebElement parentDiv = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/header/div[4]/div/div[2]/div/div"));
	  WebElement signOutLink = parentDiv.findElement(By.xpath(".//a[@href='/logout']"));
	  signOutLink.click();
}	

public static void main(String[] args) throws Exception 
{
	WebDriver driver=new ChromeDriver();
Operational_class_Zappos o=new Operational_class_Zappos();
	o.maximizeBrowser(driver);
	Thread.sleep(2000);
	o.url(driver);
	Thread.sleep(2000);
	o.signin(driver);
	Thread.sleep(2000);
	o.zappossignin(driver);
	Thread.sleep(2000);
	o.Email(driver,"sarthakbisht364@gmail.com");
	Thread.sleep(2000);
	o.Password(driver,"qwe123qwe@Q");
	Thread.sleep(2000);
	o.loginButton(driver);
	Thread.sleep(2000);
	o.SmokeTesting(driver);
	Thread.sleep(2000);
	o. Myaccount(driver);
	Thread.sleep(2000);
	o.logout(driver);
	Thread.sleep(2000);
	
}}	
	
	
	
	
	
	
	
	
	
	



