package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddAddress {
	WebDriver driver;
	
	public AddAddress(WebDriver argDriver){
		driver= argDriver;
	}
	
	By yourAdd = By.xpath(".//*[@id='center_column']/div/h1");
	By fname = By.id("firstname");
	By lname = By.id("lastname");
	By company = By.id("company");
	By address = By.id("address1");
	By addressLine = By.id("address2");
	By city = By.id("city");
	By State = By.id("id_state");
	By zip = By.id("postcode");
	By country = By.id("id_country");
	By homePhone = By.id("phone");
	By mobilePhone = By.id("phone_mobile");
	By addInfo = By.id("other");
	By addTitle = By.id("alias");
	By submitBtn = By.id("submitAddress");
	By backToAddress = By.id(".//*[@id='center_column']/ul/li/a/span");
	
	public String pageTitle(){
		return driver.getTitle();
	}
	
	public String pageHead(){
		return driver.findElement(yourAdd).getText();
	}
	public void backToAddBtn(){
		driver.findElement(backToAddress).isDisplayed();
	}
	
	public void addAddress(String first,String last,String comp,String add1,String add2, String town,String state,String postal,String Country,String phone,String mobile,String info,String addName){
		driver.findElement(fname).sendKeys(first);
		driver.findElement(lname).sendKeys(last);
		driver.findElement(company).sendKeys(comp);
		driver.findElement(address).sendKeys(add1);
		driver.findElement(addressLine).sendKeys(add2);
		driver.findElement(city).sendKeys(town);
		driver.findElement(State).click();
		Select selectState = new Select(driver.findElement(State));
		selectState.selectByVisibleText(state);
		driver.findElement(zip).sendKeys(postal);
		driver.findElement(country).click();
		Select selectCoun = new Select(driver.findElement(country));
		selectCoun.selectByVisibleText(Country);
		driver.findElement(homePhone).sendKeys(phone);
		driver.findElement(mobilePhone).sendKeys(mobile);
		driver.findElement(addInfo).sendKeys(info);
		driver.findElement(addTitle).sendKeys(addName);
		driver.findElement(submitBtn).click();
		
	}
	
	
	

}
