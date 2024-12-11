package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_LoginTestDDTTest extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups="DataDriven")
	public void verifyAccountLoginDDT(String username, String password, String Credential_Status)
			throws InterruptedException {
		logger.info("***********Test Execution Started***********");
		try {
			HomePage homePage = new HomePage(driver);
			homePage.clickMyAccount_Dp();
			homePage.clickLogin_DpOpt();

			LoginPage loginPage = new LoginPage(driver);
			loginPage.setEmail_InpBx(username);
			loginPage.setPassword_InpBx(password);
			loginPage.clickLogin_Btn();

			MyAccountPage myAccountPage = new MyAccountPage(driver);
			boolean temp = myAccountPage.isMyAccountLabelVisible();
			if (Credential_Status.equalsIgnoreCase("Valid")) {
				if (temp == true) {
					myAccountPage.clickLogout_Btn();
					Assert.assertTrue(true);
				} else if (temp == false && loginPage.isErrorMessage_LblVisible() == true) {
					Assert.assertTrue(false);
				} else if (temp == false && loginPage.isErrorMessage_LblVisible() == false) {
					Assert.assertTrue(false);
				}
			}
			if (Credential_Status.equalsIgnoreCase("Invalid")) {
				if (temp == true) {
					myAccountPage.clickLogout_Btn();
					Assert.assertTrue(false);
				} else if (temp == false && loginPage.isErrorMessage_LblVisible() == true) {
					Assert.assertTrue(true);
				} else if (temp == false && loginPage.isErrorMessage_LblVisible() == false) {
					Assert.assertTrue(false);
				}

			}
		} catch (Exception e) {
			Assert.fail();
			System.out.println("Error Is:" + e.getMessage());
		}
		Thread.sleep(3000);
		logger.info("***********Test Execution Finished***********");
	}
}
