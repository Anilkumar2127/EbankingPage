package com.Ebank.ExtentReport;
//This class help us to create and configre the Reports
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reports 
{
	public ExtentSparkReporter reporter;
	public ExtentReports report;
	public ExtentTest test;
	
		 public  ExtentReports getExentReport()
		 {
			  String timeStamp =new SimpleDateFormat("yyyy.mm.dd-HH.mm.ss").format(new Date());//to get customised date format
			  String RepName="report-"+timeStamp+".html";
			  
			 reporter = new ExtentSparkReporter("E:\\SelJava\\EbankFrameWork\\test-output/"+RepName);//saving the report file
			 
			 reporter.config().setDocumentTitle("Internet Banking Project");
			 reporter.config().setReportName("Functional Test Report");	
			 reporter.config().setTheme(Theme.DARK);
			 
			 report=new ExtentReports();
			 report.attachReporter(reporter);//attache the changed reporter config to report
			 report.setSystemInfo("Host name","localhost");
			 report.setSystemInfo("Environment","QA");
			 report.setSystemInfo("user","anil");	 
			 return report;//finally report skeleton is generated
			
		 } 
		

}
