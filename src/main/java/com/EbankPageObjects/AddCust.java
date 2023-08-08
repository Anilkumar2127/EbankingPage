package com.EbankPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCust 
{
	public WebDriver driver;
	public AddCust(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="name"	)
	WebElement custName;
	@FindBy(xpath="//input[@value='m']")
	WebElement rdbtm;
	@FindBy(xpath="//input[@value='f']")
	WebElement rdbtf;
	@FindBy(id="dob")
	WebElement Dob;
	@FindBy(name="addr"	)
	WebElement address;
	@FindBy(name="city")
	WebElement City;
	@FindBy(name="state")
	WebElement State;
	@FindBy(name="pinno")
	WebElement pin;
	@FindBy(name="telephoneno")
	WebElement Mob;
	@FindBy(name="emailid")
	WebElement Email;
	@FindBy(name="password")
	WebElement Pwd;
	@FindBy(xpath="//input[@type='submit']")
	WebElement submit;
	@FindBy(xpath="//input[@type='reset']")
	WebElement reset;
	@FindBy(xpath="//p[@class='heading3']")
	WebElement custPage;
	@FindBy(xpath="//p[@class='heading3']")
	WebElement message;
	public String getPageName()//before entering the customer data
	{
		String pageName=custPage.getText();
		System.out.print(pageName);
		return pageName;
	}
	public void addCustomerdata(String customerName,String gen,String dob,String adress,String city,String state,String pincode,String mob,String email,String pwd)
	{
		custName.sendKeys(customerName);
		if(gen.equalsIgnoreCase("Male"))
		{
			rdbtm.click();//selectd the male radio
		}
		else
		{
			System.out.print(dob);
			rdbtf.click();//selectd the Female radio
		}
		String []date=dob.split("/");
		Dob.sendKeys(date[0]);
		Dob.sendKeys(date[1]);
		Dob.sendKeys(date[2]);
		
	
		
		address.sendKeys(adress);
		City.sendKeys(city);
		State.sendKeys(state);
		pin.sendKeys(pincode);
		Mob.sendKeys(mob);
		Email.sendKeys(email);
		Pwd.sendKeys(pwd);
		
		submit.click();	
		
	}

}
