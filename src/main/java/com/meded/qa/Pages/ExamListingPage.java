package com.meded.qa.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.meded.qa.Base.Base;

public class ExamListingPage extends Base {

	// Left Side Menu Elements

	@FindBy(css = "a[routerlink='exam']")
	WebElement Exams;
	
	

	@FindBy(xpath = "//button[@class='btn btn-sm rounded-right']")
	WebElement add_filter_button; // Add_filter button Element

	public ExamListingPage() {
		PageFactory.initElements(driver, this); // Driver initializes to Elements in this class
	}

	public void Add_Filter_button() throws InterruptedException {

	

	}

	public void Select_filter() {
		try {
			Add_Filter_button();
		} catch (InterruptedException e) {
			System.out.println("Button not displayed");
		}
		String Before_xpath = "//div[@id='dropdownColumns']//label[contains(text(),'";
		String After_xpath = "')]";
		String filter_name = Prop.getProperty("Filter_name");
		WebElement filter = driver.findElement(By.xpath(Before_xpath + filter_name + After_xpath));
		

	}

	public void examiId() {

		List<WebElement> columnsNames = driver.findElements(By.xpath("//tr[@id='createColumnsDynamically']/th"));
		List<WebElement> tableData;
		for (int i = 0; i <= columnsNames.size(); i++) {

			if (columnsNames.get(i).getText().equalsIgnoreCase("Exam Status")) {

				tableData = driver.findElements(By.xpath("//tbody[@id='show_exam_list']/tr/td[" + i + "]"));

				for (WebElement tabledata : tableData) {

					System.out.println(tabledata.getText());

				}

			}
			break;
		}

	}

}
