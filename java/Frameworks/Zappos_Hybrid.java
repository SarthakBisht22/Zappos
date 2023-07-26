package Frameworks;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Zappos_Hybrid {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		FileInputStream file=new FileInputStream("C:\\Users\\sarth\\OneDrive\\Desktop\\Automation Testing\\Eclipse Backup\\Finalautomation_Project\\src\\test\\resources\\Zappos.xlsx");
		XSSFWorkbook w=new XSSFWorkbook(file);
		XSSFSheet s=w.getSheet("Hybrid_framework"); 
	
		int size=s.getLastRowNum();
		System.out.println("No. of Keywords"+size);
	
		Operational_class_Zappos  o=new Operational_class_Zappos ();
		for(int i=1;i<=size;i++)//data driven framework
		{
			String Email=s.getRow(i).getCell(1).getStringCellValue();
			String password=s.getRow(i).getCell(2).getStringCellValue();
			System.out.println(Email+"\t\t"+password);
			
			try {
				//Login
				for(int j=1; j<=size ; j++)
				{
					String key=s.getRow(j).getCell(0).getStringCellValue();
					
					if(key.equals("MaximizeBrowser"))
					{
						o.maximizeBrowser(driver);
						System.out.println(key);
						Thread.sleep(2000);
					}
					
					else if (key.equals("EnterURL"))
					{
						o.url(driver);
						System.out.println(key);
						Thread.sleep(2000);
					}
					else if (key.equals("signin"))
					{
						o.signin(driver);
						System.out.println(key);
						Thread.sleep(2000);
					}
					else if (key.equals("zappossignin"))
					{
						o.zappossignin(driver);
						System.out.println(key);
						Thread.sleep(2000);
						}
					else if (key.equals("email"))
					{
						o.Email(driver,Email);
						System.out.println(key);
						Thread.sleep(5000);
					}
					else if (key.equals("password"))
					{
						o.Password(driver,password);
						System.out.println(key);
						Thread.sleep(5000);
					}
					else if (key.equals("Login"))
					{
						o.loginButton(driver);
						System.out.println(key);
						Thread.sleep(5000);
					}
					else if (key.equals("smoketesting"))
					{
						o.SmokeTesting(driver);
						System.out.println(key);
						Thread.sleep(10000);
					}
					else if (key.equals("Myaccount"))
					{
						o. Myaccount(driver);
						System.out.println(key);
						Thread.sleep(5000);
					}
					
					
					else if (key.equals("logout"))
					{
						o.logout(driver);
						System.out.println(key);
						Thread.sleep(5000);
						
						System.out.println("Valid credentials");
						System.out.println("");
						s.getRow(i).createCell(3).setCellValue("Valid credentials");
						
					}
				}}
				
			catch(Exception e)
			{
				System.out.println("Invalid credentials");
				System.out.println("");
				s.getRow(i).createCell(3).setCellValue("Invalid credentials");
			}
		}
		driver.close();
		FileOutputStream out=new FileOutputStream("C:\\\\Users\\\\sarth\\\\OneDrive\\\\Desktop\\\\Automation Testing\\\\Eclipse Backup\\\\Finalautomation_Project\\\\src\\\\test\\\\resources\\\\Zappos.xlsx");
		w.write(out);
		w.close();
	}}
							
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
