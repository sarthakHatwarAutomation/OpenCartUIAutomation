package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_AccountRegistrationTest extends BaseClass {
	@Test(groups= {"Regression","Master"})
	public void verifyAccountRegistration() throws InterruptedException {
		logger.info("*********Test Execution Started*********");
		try {
			HomePage homePage = new HomePage(driver);
			homePage.clickMyAccount_Dp();
			logger.info("*********MyAccount Button Clicked*********");
			homePage.clickRegister_DpOpt();
			logger.info("*********Register Button Clicked*********");
			Assert.assertEquals(driver.getTitle(), "Register Account");
			logger.info("*********Landed On Register Account Page Successfully*********");
			AccountRegistrationPage acctRegistationPage = new AccountRegistrationPage(driver);

			acctRegistationPage.setFirstName_InpBx(RandomAlphabets().toUpperCase());
			acctRegistationPage.setLastName_InpBx(RandomAlphabets().toUpperCase());
			acctRegistationPage.setEmail_InpBx(RandomAlphabets() + "@gmail.com");
			acctRegistationPage.setTelephone_InpBx(RandomNumeric());
			String pwd = RandomAlphaNumeric();
			acctRegistationPage.setPassword_InpBx(pwd);
			acctRegistationPage.setPasswordConfim_InpBx(pwd);
			logger.info("*********User Details Filled Successfully*********");
			acctRegistationPage.selectPrivacyPolicy_ChBx();
			acctRegistationPage.clickContinue_Btn();
			if (acctRegistationPage.SuccessMessage_lbl().equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
				logger.info("*********Successful Registration Happened*********");
			} else {
				logger.error("Test Failed...");
				logger.debug("Debug Logs...");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("*********Test Execution Completed*********");
	}
}