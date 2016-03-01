package PageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;

public class Home {
	WebDriver driver;
	
	By searchBox = By.id("search_query_top");
	By searchButton = By.xpath(".//*[@name='submit_search']");
	By myCart = By.xpath(".//*[@id='header']/div[3]/div/div/div[3]/div/a");
	By contactLink = By.xpath(".//*[@id='contact-link']/a");
	By signInLink = By.xpath(".//*[@class='login']");
	By logoImg = By.xpath(".//*[@id='header_logo']/a/img");
	By womenLink = By.xpath(".//*[@title='Women']");
	By tshirtLink = By.xpath(".//*[@title='T-shirts']");
	By dressesLink = By.xpath(".//*[@title='Dresses']");
	By bruteforceLink = By.xpath(".//*[@title='BruteForce']");
	By shopNow = By.xpath(".//*[@id='homeslider']/li[4]/div/p[2]/button");
	By nextBtn = By.className("bx-next");
	By prevBtn = By.className("bx-prev");
	By popular = By.className("homefeatured");
	By bestSeller = By.className("blockbestsellers");
	By featuredProduct = By.xpath(".//*[@id='homefeatured']/li[2]/div/div[1]/div/a[1]/img");
	By productContainer = By.xpath(".//*[@id='homefeatured']/li");
	//WebElement featuredPro = (WebElement) By.xpath(".//*[@id='homefeatured']/li[1]/div/div[1]/div/a[1]/img");
	By addToCartBtn = By.xpath(".//*[@id='homefeatured']/li[2]/div/div[2]/div[2]/a[1]/span");
	By proPrice = By.xpath(".//*[@id='homefeatured']/li[2]/div/div[1]/div/div[2]/span");
	By proceedToCheckoutBtn = By.xpath(".//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span");
	
	public Home(WebDriver argDriver){
		driver =argDriver;
	}
	public void featuredProductVisible(){
		driver.findElement(featuredProduct).isDisplayed();
		System.out.println(driver.findElements(productContainer).size());
		System.out.println("Featured Product is Visible to User");
	}
	public void Search(String keywords){
		driver.findElement(searchBox).sendKeys(keywords);
		driver.findElement(searchButton).click();
		driver.findElement(searchBox).clear();
	}
	
	public void Logo(){
		driver.findElement(logoImg).isDisplayed();
		System.out.println("Logo is visible");
	}
	
	public void SignInLinkClick(){
		driver.findElement(signInLink).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void NavLinks(){
		driver.findElement(womenLink).isDisplayed();
		driver.findElement(tshirtLink).isDisplayed();
		driver.findElement(dressesLink).isDisplayed();
		driver.findElement(bruteforceLink).isDisplayed();
		System.out.println("All nav links are present");
	}
	public String myEmptyCart(){
		return driver.findElement(myCart).getText();
	}
	
	public void MouseOverFeaturedProduct(){
		Actions act = new Actions(driver);
		WebElement we = driver.findElement(featuredProduct);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		act.moveToElement(we).moveToElement(driver.findElement(addToCartBtn)).click().build().perform();
	
	}
	

	public String productPrice(){
		return driver.findElement(proPrice).getText();
		
	}
	public double price(String p){
		String pric = p.substring(1);
		double pr = Double.parseDouble(pric);
		return pr;
		
	}
	
	public void proceedToCheckout(){
		driver.findElement(proceedToCheckoutBtn).click();
	}
	

	

}
