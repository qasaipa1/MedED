package com.meded.qa.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.meded.qa.Base.Base;

public class Utils extends Base {

	public static int PageLoad_timeout = 40;
	public static int Implicit_Wait = 20;

//	public void AcceptSsl() {
//		DesiredCapabilities dc = DesiredCapabilities.chrome();
//		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//		ChromeOptions co = new ChromeOptions();
//		co.merge(dc);
//
//	}

	public static String getScreenshot(String methodName) {

		File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File DestFile = new File("D:\\MedED-Automation\\MedED\\Screenshots\\" + methodName + ".png");
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			System.out.println("Destination does not exist");
		}
		return DestFile.getPath();
	}

	public void waiT(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}
