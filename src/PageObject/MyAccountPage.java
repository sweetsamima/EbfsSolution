package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
	WebDriver driver;
	By homeIcon = By.xpath(".//*[@id='columns']/div[1]/a");
	By successMessage = By.xpath(".//*[@id='center_column']/p[1]");
	By pageHeading = By.xpath(".//*[@id='center_column']/h1");
	By signOut = By.className("logout");
	By userName = By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a/span");
	By addAddress = By.xpath(".//*[@id='center_column']/div/div[1]/ul/li[1]/a/span");
	By orderHistory = By.xpath(".//*[@id='center_column']/div/div[1]/ul/li[2]/a/span");
	By creditHistory = By.xpath(".//*[@id='center_column']/div/div[1]/ul/li[3]/a/span");
	By myAddress = By.xpath(".//*[@id='center_column']/div/div[1]/ul/li[4]/a/span");
	By myInformation = By.xpath(".//*[@id='center_column']/div/div[1]/ul/li[5]/a/span");
	By myWishlist = By.xpath(".//*[@id='center_column']/div/div[2]/ul/li/a/span");
	By backHome = By.xpath(".//*[@id='center_column']/ul/li/a/span");
	
	public void homeIconverify(){
		driver.findElement(homeIcon).isDisplayed();
	}
	public void homeIconClick(){
		driver.findElement(homeIcon).click();
	}

	public String successMessageTxt(){
		return driver.findElement(successMessage).getText();
		
	}
	public String pageHeadText(){
		return driver.findElement(pageHeading).getText();
	}
	public String signOutlink(){
		return driver.findElement(signOut).getText();
	}
	
	public void signOutLinksverify(){
		driver.findElement(signOut).isDisplayed();
	}
	public void signOutClick(){
		driver.findElement(signOut).click();
	}
	public String verifyUserName(){
		return driver.findElement(userName).getText();
	}
	public void addAddressverify(){
		driver.findElement(addAddress).isDisplayed();
	}
	public void addAddressClick(){
		driver.findElement(addAddress).click();
	}
	public void orderHistoryverify(){
		driver.findElement(orderHistory).isDisplayed();
	}
	public void orderHistoryClick(){
		driver.findElement(orderHistory).click();
	}
	public void creditHistoryverify(){
		driver.findElement(creditHistory).isDisplayed();
	}
	public void creditHistoryClick(){
		driver.findElement(creditHistory).click();
	}
	public void myAddressverify(){
		driver.findElement(myAddress).isDisplayed();
	}
	public void myAddressClick(){
		driver.findElement(myAddress).click();
	}
	public void myInformationVerify(){
		driver.findElement(myInformation).isDisplayed();
	}
	public void myInformationClick(){
		driver.findElement(myInformation).click();
	}
	public void myWishlistverify(){
		driver.findElement(myWishlist).isDisplayed();
	}
	public void myWishlistClick(){
		driver.findElement(myWishlist).click();
	}
	public void homePageverify(){
		driver.findElement(backHome).isDisplayed();
	}
	public void homePageClick(){
		driver.findElement(backHome).click();
	}
	
	public MyAccountPage(WebDriver argDriver){
		driver =argDriver;
	}
	
}
