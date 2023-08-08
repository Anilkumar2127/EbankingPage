package com.EbankPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage
{
	public WebDriver driver;
	
	public LogoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@class='menusubnav']//a[text()='New Customer']"	)
	WebElement addcust;
	@FindBy(xpath="//ul[@class='menusubnav']//a[text()='Edit Customer']")
	WebElement editcust;
	@FindBy(xpath="//a[text()=\"Log out\"]")
	WebElement logout;
	
	public void clickLogOut()
	{
		logout.click();
	}
	public void addCustomer()
	{
		addcust.click();
	}
	public void editCustomer()
	{
		editcust.click();
	}

}
