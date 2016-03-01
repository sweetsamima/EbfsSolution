package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {
	
	WebDriver driver;
	
	public SearchResultPage(WebDriver argDriver){
		driver = argDriver;
	}
	
	By searchKey = By.xpath(".//*[@id='columns']/div[1]/span[2]");
	By searchTxt = By.xpath(".//*[@id='center_column']/h1/span[1]");
	By counter = By.className("heading-counter");
	
	public String SearchPageVerify(){
		return driver.findElement(searchKey).getText();
	}
	
	public String countItem(){
		return driver.findElement(counter).getText();
	}
	
	public String SearchText(){
		String d = driver.findElement(searchTxt).getText();
		String raw = (d.substring(1, d.length()-1));
		return raw;
	}

}
