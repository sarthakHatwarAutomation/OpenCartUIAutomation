package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement FirstName_InpBx;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement LastName_InpBx;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement Email_InpBx;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement Telephone_InpBx;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement Password_InpBx;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement PasswordConfim_InpBx;

	@FindBy(xpath = "//div[@id=\"content\"]/form/div/div/input[1]")
	WebElement PrivacyPolicy_ChBx;

	@FindBy(xpath = "//div[@id='content']/form/div/div/input[2]")
	WebElement Continue_Btn;

	@FindBy(xpath = "//div[@id='content']/h1")
	WebElement SuccessMessage_lbl;

	public void setFirstName_InpBx(String firstname) {
		FirstName_InpBx.sendKeys(firstname);
	}

	public void setLastName_InpBx(String lastname) {
		LastName_InpBx.sendKeys(lastname);
	}

	public void setEmail_InpBx(String email) {
		Email_InpBx.sendKeys(email);
	}
	
	public void setTelephone_InpBx(String email) {
		Telephone_InpBx.sendKeys(email);
	}

	public void setPassword_InpBx(String pass) {
		Password_InpBx.sendKeys(pass);
	}

	public void setPasswordConfim_InpBx(String pass) {
		PasswordConfim_InpBx.sendKeys(pass);
	}

	public void selectPrivacyPolicy_ChBx() {
		PrivacyPolicy_ChBx.click();
	}

	public void clickContinue_Btn() {
		Continue_Btn.click();
	}

	public String SuccessMessage_lbl() {

		try {
			String sucMsglbl = SuccessMessage_lbl.getText();
			return sucMsglbl;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
