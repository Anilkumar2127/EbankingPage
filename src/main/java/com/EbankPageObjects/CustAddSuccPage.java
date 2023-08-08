package com.EbankPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustAddSuccPage
{
	public WebDriver driver;
	
	public CustAddSuccPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//p[@class='heading3']")
	WebElement message;
	
	@FindBy(xpath="//a[text()='Continue']")
	WebElement Continue;
	public boolean addCustSuccess()//adding successfully adding the customer data
	{
		System.out.print("customer success added");
		if(message.getText().equalsIgnoreCase("Customer Registered Successfully!!!"))
			return true;
		else
			return false;
	}
	public void clickAgainAddCustomer()
	{
		Continue.click();
	}
}
