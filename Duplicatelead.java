package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Duplicatelead extends ProjectSpecificMethods{
@BeforeTest
public void setdata() {
	excelFilepath="./excelsheet/Duplicate.xlsx";
}

	@Test(dataProvider="Dynamic")
	public void runTC002(String username, String Password, String CompanyName, String firstname1,String lastname1,
			String departnam,String desc,String mail) {
		// TODO Auto-generated method stub
		
		WebElement elementuser = driver.findElement(By.id("username"));
		elementuser.sendKeys(username);
		WebElement elementpwd = driver.findElement(By.id("password"));
		elementpwd.sendKeys(Password);
		WebElement loginbutton = driver.findElement(By.className("decorativeSubmit"));
		loginbutton.click();
		WebElement link = driver.findElement(By.linkText("CRM/SFA"));
		link.click();
		WebElement leadtab = driver.findElement(By.linkText("Leads"));
		leadtab.click();
		WebElement createlead = driver.findElement(By.linkText("Create Lead"));
		createlead.click();
		WebElement companyname = driver.findElement(By.className("inputBox"));
		companyname.sendKeys(CompanyName);
		WebElement firstname = driver.findElement(By.id("createLeadForm_firstName"));
		firstname.sendKeys(firstname1);
		WebElement lastname = driver.findElement(By.id("createLeadForm_lastName"));
		lastname.sendKeys(lastname1);
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys(departnam);
		driver.findElement(By.id("createLeadForm_description")).sendKeys(desc);
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(mail);
		WebElement pro = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select province = new Select(pro);
		province.selectByVisibleText("New York");
		WebElement submit = driver.findElement(By.className("smallSubmit"));
		submit.click();
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Duplicate Lead")).click();
		WebElement newcompany = driver.findElement(By.id("createLeadForm_companyName"));
		newcompany.clear();
		newcompany.sendKeys("Wipro");
		WebElement replacefirst = driver.findElement(By.id("createLeadForm_firstName"));
		replacefirst.clear();
		replacefirst.sendKeys("Priya");
		driver.findElement(By.className("smallSubmit")).click();
		System.out.println(driver.getTitle());

	}

}
