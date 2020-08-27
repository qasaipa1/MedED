package com.meded.qa.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportss {

	

	public static ExtentReports getExtentReports() {

		String reportsPath = System.getProperty("user.dir") +"\\ExtentReports\\MedED_Reports.html"; // Path where report has to be saved 
		ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(reportsPath);
	
		htmlReport.config().setReportName("MedED Automation Report"); // TO Set Report Name

		ExtentReports extent = new ExtentReports();                  
		extent.attachReporter(htmlReport);            
		return extent;
	}

}
