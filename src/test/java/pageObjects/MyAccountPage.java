package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@id='content']/h2[1]") 
	WebElement MyAccountLabel;
	
	@FindBy(xpath="//aside[@id=\"column-right\"]/div/a[13]") 
	WebElement Logout_Btn;
	
	public boolean isMyAccountLabelVisible() {
		try {
		return (MyAccountLabel.isDisplayed());
		}catch(Exception e) {
			return false;
		}
	}
	
	public void clickLogout_Btn() {
		Logout_Btn.click();
    }
	
}
