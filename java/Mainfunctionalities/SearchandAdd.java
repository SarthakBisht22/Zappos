package Mainfunctionalities;

import java.io.File;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;
// Other import statements...

public class SearchandAdd {
    @Test
    public void f() throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://www.zappos.com/");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id='root']/div[1]/header/div[4]/div/div[2]/div/a")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("zapposSignIn")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("ap_email")).sendKeys("sarthakbisht364@gmail.com");
        Thread.sleep(2000);

        driver.findElement(By.id("ap_password")).sendKeys("qwe123qwe@Q");
        Thread.sleep(2000);

        driver.findElement(By.id("signInSubmit")).click();
        Thread.sleep(2000);

        //Search
        Scanner s = new Scanner(System.in);
        System.out.print("Search: ");
        String Search = s.nextLine();
        driver.findElement(By.id("searchAll")).sendKeys(Search);
        Thread.sleep(2000);
        s.close();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Wait until the search button is clickable and then click it
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='root']/div[1]/header/div[4]/div/div[1]/form/button")));
        searchButton.click();
        Thread.sleep(5000);

        //Scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll till best seller
        WebElement bestSellerHeading = driver.findElement(By.xpath("//*[@id='main']/div/div/div[4]/h2"));
        js.executeScript("arguments[0].scrollIntoView();", bestSellerHeading);
        Thread.sleep(2000);

        //Screenshot
        File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(f, new File("C:\\Users\\sarth\\OneDrive\\Desktop\\Automation Testing\\Eclipse Backup\\Finalautomation_Project\\src\\test\\resources\\Screenshots\\Searchandscroll.png"));
        Thread.sleep(5000);

        // Click on the first product
        WebElement firstProductLink = driver.findElement(By.xpath("//*[@id='main']/div/div/div[4]/div/div[1]/div/article[1]/a"));
        js.executeScript("arguments[0].click();", firstProductLink);
        Thread.sleep(5000);

        //scroll
        js.executeScript("window.scrollTo(0, 2500)");

        Thread.sleep(2000);

        //select size
        WebElement sizeElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='buyBoxForm']/div[2]/fieldset[1]/div/div[5]")));
        sizeElement.click();
        Thread.sleep(2000);
        WebElement colorElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='buyBoxForm']/div[2]/fieldset[2]/div/div[2]")));
        colorElement.click();
        Thread.sleep(2000);

        //add to cart
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Add to Cart')]")));
        addToCartButton.click();
        Thread.sleep(5000);

        File f1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(f1, new File("C:\\Users\\sarth\\OneDrive\\Desktop\\Automation Testing\\Eclipse Backup\\Finalautomation_Project\\src\\test\\resources\\Screenshots\\Searchandaddtocart.png"));
        Thread.sleep(2000);

        driver.close();
    }
}
