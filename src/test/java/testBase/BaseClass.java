package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public  WebDriver driver;
	public Logger logger;
	public Properties p;

	@BeforeClass(groups= {"Sanity","Master","Regression","DataDriven"})
	@Parameters({ "browser", "os"})
	public void setup(String browser, String os) throws IOException {
		logger = LogManager.getLogger(this.getClass());
		FileReader readFile= new FileReader("./src//test//resources//config.properties");
		p= new Properties();
		p.load(readFile);
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch(browser.toLowerCase())
			{
			case "chrome" : driver=new ChromeDriver(); break;
			case "edge" : driver=new EdgeDriver(); break;
			case "firefox": driver=new FirefoxDriver(); break;
			default : System.out.println("Invalid browser name.."); return;
			}
		}else if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("windows")){
				cap.setPlatform(Platform.WIN11); 
			} else if(os.equalsIgnoreCase("Mac")) {
				cap.setPlatform(Platform.MAC); 
			}
			switch(browser) {
			case "chrome": 
				cap.setBrowserName("chrome");
				break;
			case "edge":
				cap.setBrowserName("MicrosoftEdge"); 
				break;
			case "firefox":
				cap.setBrowserName("firefox");
				break;
			default: System.out.println("No matching browser");return;
			}
			 driver = new RemoteWebDriver(new URL(p.getProperty("hub_url")), cap);
		}

		driver.get(p.getProperty("OpenCartUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterClass(groups= {"Sanity","Master","Regression","DataDriven"})
	public void tearDown() {
		driver.quit();
	}

	public String RandomAlphabets() {
		@SuppressWarnings("deprecation")
		String generatedAlphabets = RandomStringUtils.randomAlphabetic(5);
		return generatedAlphabets;
	}

	public String RandomNumeric() {
		@SuppressWarnings("deprecation")
		String generatedAlphabets = RandomStringUtils.randomNumeric(5);
		return generatedAlphabets;
	}

	public String RandomAlphaNumeric() {
		@SuppressWarnings("deprecation")
		String generatedAlphabets = RandomStringUtils.randomAlphanumeric(5);
		return generatedAlphabets;
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}

}