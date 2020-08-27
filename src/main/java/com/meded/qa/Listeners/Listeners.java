package com.meded.qa.Listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.meded.qa.Base.Base;
import com.meded.qa.Reports.ExtentReportss;
import com.meded.qa.Utilities.Utils;

public class Listeners extends Base implements ITestListener {
	ExtentReports extent = ExtentReportss.getExtentReports();

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	public void onTestFailure(ITestResult arg0) {
		try {
			test.addScreenCaptureFromPath(Utils.getScreenshot(arg0.getMethod().getMethodName()));
		} catch (IOException e) {
			test.log(Status.ERROR, "Screenshot does not exist in destination path");
		}

	}

	public void onTestSkipped(ITestResult arg0) {

	}

	public void onTestStart(ITestResult arg0) {
		test = extent.createTest(arg0.getMethod().getMethodName()); // Creates entry for every method in Extent reports

	}

	public void onTestSuccess(ITestResult arg0) {

	}

	public void onFinish(ITestContext arg0) {
		extent.flush(); // Mandatory fucntion to generate reports

	}

	public void onStart(ITestContext arg0) {

	}
}