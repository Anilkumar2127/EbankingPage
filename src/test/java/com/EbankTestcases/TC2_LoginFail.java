package com.EbankTestcases;

import static org.testng.Assert.assertFalse;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EbankPageObjects.LoginPage;

public class TC2_LoginFail extends BaseClass
{
	@Test
	public void errorLogin() throws InterruptedException
	{
		LoginPage lp =new LoginPage(driver);
		lp.setUserName(username);
		lp.setPasssword(Password);
		lp.clickSubmit();
		Thread.sleep(2000);
		String ErrMsg =driver.switchTo().alert().getText();
		if(ErrMsg.equalsIgnoreCase("User or Password is not valid"))
		{
			driver.switchTo().alert().accept();	
			driver.switchTo().defaultContent();
		}
		Thread.sleep(2000);
		Assert.assertTrue(false);
	}
}
