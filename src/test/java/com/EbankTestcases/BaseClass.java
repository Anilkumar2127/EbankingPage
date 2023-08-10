package com.EbankTestcases;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.Ebank.utilities.EbankEdUtiles;
import com.Ebank.utilities.ReadGlobal;
import com.EbankPageObjects.LoginPage;



public class BaseClass 
{
	
	
	ReadGlobal Rg =new ReadGlobal();
	public String username=Rg.getUserName();
	public String Password=Rg.getPassword();
	public String url=Rg.getUrl();
	public static WebDriver driver;
	@Parameters("browser")
	@BeforeTest
	public void setUp(String browser)
	{	
		if(browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",Rg.getPath());
		driver =new ChromeDriver();
		}
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.out.print("Firefox");
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	public String getErrorScreenShot(String methodName) throws IOException
	{
		
		TakesScreenshot ts =  (TakesScreenshot) driver;
		File src =ts.getScreenshotAs(OutputType.FILE);
	
		File dsfile=new File("./"+"/ScreenShots/"+methodName+".png");
		FileUtils.copyFile(src,dsfile);
		return "./"+"/ScreenShots/"+methodName+".png";
	}
	public boolean isAlertPresent()
	{
		try {
			driver.switchTo().alert().accept();
			return true;
		}
		catch(Exception e)//No alertPresentException
		{
			return false;
		}
			
	}



	
	/*public Object[][] getData(String excelpath,String SheetName) throws IOException
	{
		String excel =excelpath;
		String sheetName=SheetName;
		int rowCount = EbankEdUtiles.getRowCount(excel,sheetName);
		int colcount= EbankEdUtiles.getColCount(excel, sheetName, rowCount);
		System.out.println(rowCount+"-"+colcount);
		Object data[][]=new String[rowCount][colcount];
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				data[i-1][j]=EbankEdUtiles.getCelldata(excel,sheetName,i,j);
			}
		}
		
		return data;
	}*/
	

}
