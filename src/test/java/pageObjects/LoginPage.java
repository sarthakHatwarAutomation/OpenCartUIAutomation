package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement Email_InpBx;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement Password_InpBx;

	@FindBy(xpath = "//div[@id=\"content\"]/div/div[2]/div/form/input")
	WebElement Login_Btn;

	@FindBy(xpath = "//div[@id=\"content\"]/div/div[2]/div/form/input")
	WebElement ErrorMessage_Lbl;

	public void setEmail_InpBx(String email) {
		Email_InpBx.sendKeys(email);
	}

	public void setPassword_InpBx(String pwd) {
		Password_InpBx.sendKeys(pwd);
	}

	public void clickLogin_Btn() {
		Login_Btn.click();
	}	
	public boolean isErrorMessage_LblVisible() {
		try {
			return (ErrorMessage_Lbl.isDisplayed());

		} catch (Exception e) {
			return false;
		}
	}

}
