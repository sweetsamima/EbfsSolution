package PageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage {
	WebDriver driver;
	
	By createAccountTitle = By.xpath(".//*[@id='account-creation_form']/div[1]/h3");
	By Mr = By.id("id_gender1");
	By Mrs = By.id("id_gender2");
	By firstName = By.id("customer_firstname");
	By lastName = By.id("customer_lastname");
	By userEmail = By.id("email");
	By userPass = By.id("passwd");
	By birthDay = By.id("days");
	By birthMonth = By.id("months");
	By birthYear = By.id("years");
	By newsLetter = By.id("newsletter");
	By offerOption = By.id("optin");
	By registerButton = By.id("submitAccount");
	
	public void MrorMrs(String gender){
		if(gender.equalsIgnoreCase("Mr")){
		driver.findElement(Mr).click();
		}else{
		driver.findElement(Mrs).click();
		}
	}
	
	public String CreateTitleValid(){
		return driver.findElement(createAccountTitle).getText();
	}
	
	public void CheckNewsLetter(){
		driver.findElement(newsLetter).click();
	}
	public void CheckOption(){
		driver.findElement(offerOption).click();
	}
	
	public void UserAccount(String fname, String lname, String email, String pass, String day, String month, String year){
		driver.findElement(firstName).sendKeys(fname);
		driver.findElement(lastName).sendKeys(lname);
		driver.findElement(userEmail).sendKeys(email);
		driver.findElement(userPass).sendKeys(pass);
		driver.findElement(birthDay).click();
		Select dropdown = new Select(driver.findElement(birthDay));
		dropdown.selectByValue(day);
		driver.findElement(birthMonth).click();
		Select dropdown1 = new Select(driver.findElement(birthMonth));
		dropdown1.selectByValue(month);
		driver.findElement(birthYear).click();
		Select dropdown2 = new Select(driver.findElement(birthYear));
		dropdown2.selectByValue(year);		
		
		driver.findElement(registerButton).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public CreateAccountPage(WebDriver argDriver){
		driver =argDriver;
	}

}
