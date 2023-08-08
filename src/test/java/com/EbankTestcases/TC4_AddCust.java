package com.EbankTestcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Ebank.utilities.EbankEdUtiles;
import com.EbankPageObjects.AddCust;
import com.EbankPageObjects.CustAddSuccPage;
import com.EbankPageObjects.LoginPage;
import com.EbankPageObjects.LogoutPage;

public class TC4_AddCust extends BaseClass
{
	@Test(dataProvider="customerdata")
	public void addCustomer(String custname,String gender,String dateob,String address,String city,String state,String pinno,String mobile,String email,String password) throws IOException, InterruptedException
	{ 
		System.out.println(custname+"|"+gender+"|"+dateob+"|"+address+"|"+city+"|"+state+"|"+pinno+"|"+mobile+"|"+email+"|"+password);
		LogoutPage lo= new LogoutPage(driver);
		lo.addCustomer();//click on the add customer button
		AddCust newCust = new AddCust(driver);
		CustAddSuccPage addcussucc =new CustAddSuccPage(driver);
		if(newCust.getPageName().equalsIgnoreCase("Add New Customer"))
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			newCust.addCustomerdata(custname,gender,dateob,address,city,state,pinno,mobile,email,password);
			Thread.sleep(3000);
			if(addcussucc.addCustSuccess()==true)
				{
				Assert.assertTrue(true);
				addcussucc.clickAgainAddCustomer();
				}
				
			else
				{Assert.assertFalse(false);}
		}
	}
	
	@DataProvider(name="customerdata")
	public Object[][] getData() throws IOException
	{
		String excel ="E:\\SelJava\\EbankFrameWork\\src\\main\\java\\com\\Ebank\\Exceldata\\CustomerData.xlsx";
		String sheetName="CustData";
		int rowCount = EbankEdUtiles.getRowCount(excel,sheetName);
		int colcount= EbankEdUtiles.getColCount(excel, sheetName, rowCount);
		System.out.println(rowCount+"-"+colcount);
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
