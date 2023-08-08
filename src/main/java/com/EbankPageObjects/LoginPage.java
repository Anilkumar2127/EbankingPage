package com.EbankPageObjects;
//This class contains objects and initialised the driver and giving entries into the AUT
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="uid")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement Loginbtn;
	

	public void setUserName(String Username)
	{
		username.sendKeys(Username);
	}
	public void setPasssword(String Password)
	{
		password.sendKeys(Password);
	}
	public void clickSubmit() 
	{
		Loginbtn.submit();
	}
}
