package SeleniumBasics;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import week5.ReadExcel;

public class ProjectSpecificMethods {
	public RemoteWebDriver driver;
	public String excelFilepath;
	@Parameters({"URL","BROWSER_NAME"})
	
	@BeforeMethod
	public void BeforeMethod(String url, String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			  driver=new ChromeDriver();	
		}
		else if (browserName.equalsIgnoreCase("Firefox"))
		{
		WebDriverManager.firefoxdriver().setup();
		  driver=new FirefoxDriver();
		}
		 driver.get(url);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	 
	 @AfterMethod
	 public void AfterMethod()
	 {
		 driver.close(); 
	 }
	 
	 @DataProvider(name ="Dynamic")
		public String[][] data() throws IOException{
			String[][] data= ReadExcel.getData(excelFilepath);

		 return data;
	}
}
