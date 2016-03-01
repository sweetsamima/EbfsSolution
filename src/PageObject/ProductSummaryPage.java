package PageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductSummaryPage {
	WebDriver driver;
	
	public ProductSummaryPage(WebDriver argDriver){
		driver = argDriver;
	}
	
	
	By cartQty = By.id("summary_products_quantity");
	By delIcon = By.className("cart_quantity_delete");
    By afterDelMsg = By.xpath(".//*[@id='center_column']/p");
    By minus = By.xpath(".//*[@title='Subtract']");
    By itmQty = By.xpath(".//*[@id='product_2_7_0_0']/td[5]/input[2]");
	By hide = By.xpath(".//input[@type='hidden']");
    By too = By.xpath("//input[starts-with(@name, 'quantity')]");
    By totalCost = By.id("total_product");
    By totalShipping = By.id("total_shipping");
    By toTal = By.id("total_price");
    By contShop = By.xpath("//a[@title='Continue shopping']");
    By pcTochk = By.linkText("Proceed to checkout");
	
	public String ItemQty(){
		return driver.findElement(cartQty).getText();
	}
    public void getMsg(){
    	System.out.println(driver.findElement(afterDelMsg).getText());
    	 
    }
	public String DeleteItem(){
		driver.findElement(delIcon).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(afterDelMsg));
		
	//	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String txt = driver.findElement(afterDelMsg).getText();

		return txt;
	}
	public void incItem(){
		driver.findElement(itmQty).clear();
		driver.findElement(itmQty).sendKeys("5");
	}
	public String minusQty(){
		driver.findElement(minus).click();
		System.out.println(driver.findElement(cartQty).getText());
		return driver.findElement(cartQty).getText();
	}
	public String totalCost(){
		return driver.findElement(totalCost).getText();
	}
	public String totalShip(){
		return driver.findElement(totalShipping).getText();
	}
	public String Total(){
		return driver.findElement(toTal).getText();
	}

	public void contShopping(){
		driver.findElement(contShop).isDisplayed();
	}
	public void proceedToChk(){
		driver.findElement(pcTochk).click();
	}
}
