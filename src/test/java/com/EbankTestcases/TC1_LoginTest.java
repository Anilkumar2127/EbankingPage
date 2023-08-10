package com.EbankTestcases;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ebank.utilities.ReadGlobal;
import com.EbankPageObjects.LoginPage;
import com.EbankPageObjects.LogoutPage;
import com.beust.jcommander.Parameter;

public class TC1_LoginTest extends BaseClass
{
	@Test
	public void LoginTest() throws InterruptedException
	{
		LoginPage lp =new LoginPage(driver);
	
		lp.setUserName(username);
		lp.setPasssword(Password);
		lp.clickSubmit();
		 if(driver.getCurrentUrl().equals("Guru99 Bank Manager HomePage"))
		 {
				LogoutPage lo =new LogoutPage(driver);
				lo.clickLogOut();
				Thread.sleep(3000);
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			
		 }
		 else
		 {
			 Assert.assertFalse(false);		 
		 }
	}

}
