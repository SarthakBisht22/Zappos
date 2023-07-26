package Frameworks;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zappos_datadriven {

	public static void main(String[] args) throws InterruptedException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\\\Users\\\\sarth\\\\OneDrive\\\\Desktop\\\\Automation Testing\\\\Eclipse Backup\\\\Finalautomation_Project\\\\src\\\\test\\\\resources\\\\Zappos.xlsx");
        XSSFWorkbook w=new XSSFWorkbook(file);
        
        XSSFSheet s=w.getSheet("Datadriven");
        
        //Store number of rows
        int size=s.getLastRowNum();
        System.out.println("No of Credentials:"+size);
        
        WebDriver driver = new ChromeDriver();
        
        
        Operational_class_Zappos  o=new Operational_class_Zappos ();
        o.maximizeBrowser(driver);
        for(int i=1;i<=size;i++)
    	{
    		//Store credentials in variables
    		String Email=s.getRow(i).getCell(0).getStringCellValue();
    		String password=s.getRow(i).getCell(1).getStringCellValue();
    		System.out.println(Email+"\t\t"+password);
    		
    		try
    		{
    			o.url(driver);
    			Thread.sleep(2000);
    			o.signin(driver);
    			Thread.sleep(2000);
    			o.zappossignin(driver);
    			Thread.sleep(2000);
    			o.Email(driver,Email);
    			Thread.sleep(2000);
    			o.Password(driver,password);
    			Thread.sleep(2000);
    			o.loginButton(driver);
    			Thread.sleep(2000);
    			o.SmokeTesting(driver);
    			Thread.sleep(2000);
    			o. Myaccount(driver);
    			Thread.sleep(2000);
    			o.logout(driver);
    			Thread.sleep(2000);
    			
    			//If credential is correct it will print valid data on console as well as in excel sheet
    			System.out.println("Valid username and password");
    			System.out.println("");
    			s.getRow(i).createCell(2).setCellValue("Valid Email and password");
    		
    		
    		}
    		
    		catch(Exception e)
    		{//If credential is incorrect it will handle by Catch block and print invalid data
    			System.out.println("Invalid username and password");
    			System.out.println("");
    			s.getRow(i).createCell(2).setCellValue("Invalid username and password");
    			
    			
    		}
    		//Write data
    		FileOutputStream out=new FileOutputStream("C:\\Users\\sarth\\OneDrive\\Desktop\\Automation Testing\\Eclipse Backup\\Finalautomation_Project\\src\\test\\resources\\Zappos.xlsx");
    		w.write(out);
    		
    		
        
        
        driver.close();
      
	}

}}
