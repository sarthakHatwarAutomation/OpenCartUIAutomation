package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
      public HomePage(WebDriver driver) {
    	  super(driver);
      }
      
      @FindBy(xpath="//div[@id=\"top-links\"]/ul/li[2]/a") 
      WebElement MyAccount_Dp;
      
      @FindBy(xpath="//div[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a") 
      WebElement Register_DpOpt;
      
      @FindBy(xpath="//div[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a") 
      WebElement Login_DpOpt;
      
      
      public void clickMyAccount_Dp() {
    	  MyAccount_Dp.click();
      }
      
      public void clickRegister_DpOpt() {
    	  Register_DpOpt.click();
      }
      
      public void clickLogin_DpOpt() {
    	  Login_DpOpt.click();
      }
      
      
      
      
      
      
      }
