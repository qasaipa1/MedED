package com.meded.qa.Test_cases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.meded.qa.Base.Base;
import com.meded.qa.Pages.LoginPage;

public class LoginPage_Test extends Base {

	public static Logger log = LogManager.getLogger(LoginPage_Test.class);

	public LoginPage_Test() {
		super();
	}

	@BeforeMethod(groups = "specific")
	public void initialize() {
		Initialization();
		LP = new LoginPage();

	}

	@Test(priority = 1)
	public void logIn_With_ValidEmail_And_ValidPassword() {
		LP.logIn_with_valid_details();
		Assert.assertEquals(driver.getCurrentUrl(), "https://104.42.2.231/meded-tool/dashboard");
	}

	@Test(priority = 2)
	public void logIn_With_InvalidEmail_And_ValidPassword() {
		LP.logIn_with_invalid_email();
		Assert.assertEquals("This email doesn’t belong to any account. REGISTER", LP.invalidEmail());
	}

	@Test(priority = 3)
	public void login_With_ValidEmail_And_InvalidPassword() {
		LP.logIn_with_invalid_password();
		Assert.assertEquals("Incorrect password. Try again or RESET PASSWORD", LP.invalidPassword());
	}

	@Test(priority = 4)
	public void login_With_InvalidEmail_And_InvalidPassword() {
		LP.logIn_with_Invalid_details();
		Assert.assertEquals("This email doesn’t belong to any account. REGISTER", LP.invalidEmail());
	}

	@Test(priority = 5)
	public void login_With_BlankEmail_And_BlankPassword() {
		LP.logIn_with_Blank_details();
		Assert.assertEquals(driver.getCurrentUrl(), "https://104.42.2.231/meded-tool/");
	}

	@Test(priority = 6)
	public void loginButton_Disabled_Without_Credentials() {
		Assert.assertFalse(LP.loginButton_DisabledByDefault());
	}

	@Test(priority = 7)
	public void loginButton_Enabled_With_Credentials() {
		Assert.assertTrue(LP.loginButton_Enabled_AfterCredentialsPassed());
	}

	@Test(priority = 8)
	public void resetPasswordPage_RedirectedTO_Loginpage() {
		Assert.assertEquals(LP.resetPasswordPage_redirectedTo_LoginPage(), true);
	}

	@Test(priority = 9)
	public void echonousLogo_Displayed() {
		Assert.assertEquals(LP.echoNous_Logo(), true);
	}

	@Test(priority = 10)
	public void loginYourAccountText_Displayed() {
		Assert.assertEquals(LP.loginYourAccount_Text(), true);
	}

	@Test(priority = 11)
	public void rememberMe_Dsiplayed() {
		Assert.assertEquals(LP.rememberMe(), true);
	}

	@Test(priority = 12)
	public void remeberMe_Checkbox_Unselected_Bydefault() {
		Assert.assertEquals(LP.rememberMeCheckbox_Unselected_ByDefault(), false);
	}

	@Test(priority = 13)
	public void sendButton_Enabled_WhenEmailProvided() {
		Assert.assertEquals(LP.sendButton_Enabled("enabled"), true);
	}

	@Test(priority = 14)
	public void sendButton_Disabled_WhenEmailNotProvided() {
		Assert.assertEquals(LP.sendButton_Enabled("disabled"), false);
	}

	@Test(priority = 15, groups = "specific")
	public void rememberMe_functionality() {
		Assert.assertEquals(LP.rememberMe_Functionality(), true);
		
	}

	@AfterMethod(groups = "specific")
	public void shutDown() {
		driver.quit();
	}

}
