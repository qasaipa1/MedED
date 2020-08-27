package com.meded.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.meded.qa.Pages.ExamListingPage;
import com.meded.qa.Pages.LoginPage;
import com.meded.qa.Utilities.Utils;

public class Base {

	public static WebDriver driver;
	public static Properties Prop;
	public LoginPage LP;
	public ExamListingPage ELP;
	public Actions action;
	public Utils utility;
	public static ExtentReports extent;
	public static ExtentTest test;

	public Base() {

		try {
			Prop = new Properties();
			FileInputStream FIS = new FileInputStream(
					"D:\\MedED-Automation\\MedED\\src\\main\\java\\com\\meded\\qa\\Config\\config.properties");
			Prop.load(FIS);
		} catch (FileNotFoundException e) {
			System.out.println("Properties file not exist in provided path");
		} catch (IOException e) {
			System.out.println("Properties file not loaded");
		}

	}

	public void Initialization() {
		String browser = Prop.getProperty("Browser");

		if (browser.equalsIgnoreCase("chrome")) {
			// Adding capabilities to Accept SSL certificates
			DesiredCapabilities dc = DesiredCapabilities.chrome();
			dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			ChromeOptions co = new ChromeOptions();
			co.merge(dc);

			// Setting System property
			System.setProperty("webdriver.chrome.driver", "D:\\MedED-Automation\\MedED\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver(co);
			action = new Actions(driver);
			utility = new Utils();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utils.PageLoad_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utils.Implicit_Wait, TimeUnit.SECONDS);
		driver.get(Prop.getProperty("Url"));

	}

	public void wait_And_Click(WebDriver driver, WebElement locator, int timeout) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();

	}

	public void wait_untilVisible(WebDriver driver, WebElement locator, int timeout) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.visibilityOf(locator));

	}

	public void wait_And_send(WebDriver driver, WebElement locator, String valueToBePassed, int timeout) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.visibilityOf(locator));
		locator.sendKeys(valueToBePassed);
	}

	public String windowHandles(String parentORchild) {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();

		while (itr.hasNext()) {
			String parentWindow = itr.next();
			String ChildWindow = itr.next();
			if (parentORchild.contains("parent")) {
				return parentWindow;
			} else if (parentORchild.contains("child")) {
				return ChildWindow;
			}
			break;
		}
		return "No window found";
	}

}
