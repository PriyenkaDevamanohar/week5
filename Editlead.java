package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Editlead extends ProjectSpecificMethods{
@BeforeTest
public void set()
{
	excelFilepath="./excelsheet/edit.xlsx";
}
	@Test(dataProvider="Dynamic")
	public void runTC004(String username, String password, String companyname, String firstname, String lastname, String description) {
		// TODO Auto-generated method stub
		
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
		 WebElement companyname1 = driver.findElement(By.className("inputBox"));
		 companyname1.sendKeys(companyname);
		 WebElement firstname1 = driver.findElement(By.id("createLeadForm_firstName"));
		 firstname1.sendKeys(firstname);
		 WebElement lastname1 = driver.findElement(By.id("createLeadForm_lastName"));
		 lastname1.sendKeys(lastname);
		 driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");
		
		WebElement desc= driver.findElement(By.id("createLeadForm_description"));
		desc.sendKeys(description);
		 driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("preeya.deva@gmail.com");
	     WebElement pro =  driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));         
		 Select province = new Select(pro);
		 province.selectByVisibleText("New York");
		 WebElement submit = driver.findElement(By.className("smallSubmit"));
		 submit.click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_description")).clear();
		
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("It is an important note");
		driver.findElement(By.className("smallSubmit")).click();
		System.out.println(driver.getTitle());
		
		 
	}

}
