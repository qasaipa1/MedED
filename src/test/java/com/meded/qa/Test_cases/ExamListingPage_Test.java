package com.meded.qa.Test_cases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.meded.qa.Base.Base;
import com.meded.qa.Pages.ExamListingPage;
import com.meded.qa.Pages.LoginPage;

public class ExamListingPage_Test extends Base {

	public ExamListingPage_Test() {
		super();
	}

	@BeforeMethod
	public void Initialize() {
		Initialization();
		LP = new LoginPage();
		ELP = new ExamListingPage();
		LP.logIn_with_valid_details();

	}

	@Test
	public void Add_Filters() throws InterruptedException {
		ELP.Add_Filter_button();
	}
}
