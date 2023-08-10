package com.Ebank.utilities;
import java.io.IOException;

// this class help us to do post actions done for every Test case.
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Ebank.ExtentReport.Reports;
import com.EbankTestcases.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class EbankListener extends BaseClass implements ITestListener
{
	 ExtentTest test;
	 Reports report =new Reports();
	 ExtentReports Extent = report.getExentReport();
	public void onTestStart(ITestResult result) 
	{
	   test=Extent.createTest(result.getMethod().getMethodName());
	}
	
	public void onTestFailure(ITestResult result)
	{
		
	   test.log(Status.FAIL,result.getMethod().getMethodName());
	   
	   try {
		   	String filepath = getErrorScreenShot(result.getMethod().getMethodName());
	   		} catch (IOException e) 
	   		{
	   				e.printStackTrace();
	   		}
	   String addss="E:\\SelJava\\EbankFrameWork\\ScreenShots\\"+result.getMethod().getMethodName()+".png";
	   test.addScreenCaptureFromPath(addss);
	}
	
	public void onTestSuccess(ITestResult result) 
	{
	    test.log(Status.PASS,"Testcase passed");
	}
	public void onTestSkipped(ITestResult result)
	{
	    // not implemented
	}
	public void onFinish(ITestContext context)
	{
		Extent.flush();
	}

}
