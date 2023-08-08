package com.EbankTestcases;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Ebank.utilities.EbankEdUtiles;
import com.EbankPageObjects.LoginPage;
import com.EbankPageObjects.LogoutPage;

public class TC3_LoginDDTest extends BaseClass
{
	BaseClass b;
	@Test(dataProvider="logindata")
	public void LoginExcelDD(String username, String pwd) throws InterruptedException
	{
		LoginPage lp =new LoginPage(driver);
		lp.setUserName(username);
		lp.setPasssword(pwd);
		lp.clickSubmit();
		
		if(isAlertPresent()==false) 
		{
			LogoutPage lo =new LogoutPage(driver);
			lo.clickLogOut();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		else
		{
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			Assert.assertFalse(true);	
		}
	}
	

	@DataProvider(name="logindata")
	public Object[][] getData() throws IOException
	{
		String excel ="E:\\SelJava\\EbankFrameWork\\src\\main\\java\\com\\Ebank\\Exceldata\\Credentials.xlsx";
		String sheetName="LoginCredentials";
		int rowCount = EbankEdUtiles.getRowCount(excel,sheetName);
		int colcount= EbankEdUtiles.getColCount(excel, sheetName, rowCount);
		
		Object data[][]=new Object[rowCount][colcount];
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				data[i-1][j]=EbankEdUtiles.getCelldata(excel,sheetName,i,j);
			}
		}
		
		return data;
	}
}
	


