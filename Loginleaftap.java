package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Loginleaftap extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setData()
	{
		excelFilepath="./excelsheet/tc001.xlsx";
	}


	@Test(dataProvider ="Dynamic")
	public void runTC001(String username, String password, String companyname1,
			String firstname1, String lastname1) throws InterruptedException{
		
		
		 WebElement elementuser = driver.findElement(By.id("username"));
		 elementuser.sendKeys(username);
		 WebElement elementpwd = driver.findElement(By.id("password"));
		 elementpwd.sendKeys(password);
		 WebElement loginbutton = driver.findElement(By.className("decorativeSubmit"));
		 loginbutton.click();
		 WebElement link = driver.findElement(By.linkText("CRM/SFA"));
		 link.click();
		 WebElement leadtab = driver.findElement(By.linkText("Leads"));
		 leadtab.click();
		 WebElement createlead = driver.findElement(By.linkText("Create Lead"));
		 createlead.click();
		 WebElement companyname = driver.findElement(By.className("inputBox"));
		 companyname.sendKeys(companyname1);
		 WebElement firstname = driver.findElement(By.id("createLeadForm_firstName"));
		 firstname.sendKeys(firstname1);
		 WebElement lastname = driver.findElement(By.id("createLeadForm_lastName"));
		 lastname.sendKeys(lastname1);
		 driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");
		 driver.findElement(By.id("createLeadForm_description")).sendKeys("First automation exercise");
		 driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("preeya.deva@gmail.com");
		 Thread.sleep(30);
	     WebElement pro =  driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));         
		 Select province = new Select(pro);
		 province.selectByVisibleText("New York");
		 WebElement submit = driver.findElement(By.className("smallSubmit"));
		 submit.click();
		System.out.println(driver.getTitle());
		 
		 
		 
	}
	}


