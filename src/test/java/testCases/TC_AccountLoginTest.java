package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_AccountLoginTest extends BaseClass {

	@Test(groups= {"Sanity","Master"})
	public void verifyAccountLogin() throws InterruptedException {
		logger.info("***********Test Execution Started***********");
		try {
		HomePage homePage = new HomePage(driver);
		homePage.clickMyAccount_Dp();
		homePage.clickLogin_DpOpt();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail_InpBx(p.getProperty("email"));
		loginPage.setPassword_InpBx(p.getProperty("password"));
		loginPage.clickLogin_Btn();

		MyAccountPage myAccountPage = new MyAccountPage(driver);
		boolean temp = myAccountPage.isMyAccountLabelVisible();
			Assert.assertTrue(temp);
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("***********Test Execution Finished***********");
	}
}