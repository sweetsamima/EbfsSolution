package PageObject;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;


public class RunTest {
	ExtentReports report;
	ExtentTest logger;
	WebDriver driver;
	


 
 
	  @Test (priority=1,enabled=true)
	  public void LogInUse(){
		    try {
		        // Open the Excel file
		        FileInputStream fis = new FileInputStream("C:\\Users\\Samima\\Desktop\\BruteForceSolutions\\TestData.xls");
		        // Access the required test data sheet
		        HSSFWorkbook wb = new HSSFWorkbook(fis);
		        HSSFSheet sheet = wb.getSheet("userdata");
		        // Loop through all rows in the sheet
		        // Start at row 1 as row 0 is our header row
		        for(int count = 1;count<=sheet.getLastRowNum();count++){
		            HSSFRow row = sheet.getRow(count);
		            System.out.println("Running test case " + row.getCell(0).toString());
		            // Run the test for the current test data row
		           
		           String User =row.getCell(0).toString(); 
		           String Pass = row.getCell(1).toString();
		           String Name = row.getCell(2).toString();
		  logger = report.startTest("User Login for: "+Name);
		  Home home = new Home(driver);
		  home.SignInLinkClick();
		  LogInPage login = new LogInPage(driver);
		  String titl = login.CreateAccountTitle();
		  Assert.assertEquals(titl, "CREATE AN ACCOUNT");
		  logger.log(LogStatus.INFO, "User trying to login with Email: "+User+"  Password: "+Pass);
		  login.LogIn(User, Pass);
		  logger.log(LogStatus.INFO, "User is logged in");
		  MyAccountPage account = new MyAccountPage(driver);
		  
		  Assert.assertEquals(account.verifyUserName(), Name);
		  logger.log(LogStatus.INFO, "User name verified Expected: "+ Name+" Actual: "+account.verifyUserName());
		  account.signOutClick();
		  logger.log(LogStatus.PASS, Name +" is sign out");
		        }
		        fis.close();
		    } catch (IOException e) {
		        System.out.println("Test data file not found");
		    }  
	  }
	
	  @Test(priority=0,enabled=true)
	  public void SearchVali() {
		    try {
		        // Open the Excel file
		        FileInputStream fis = new FileInputStream("C:\\Users\\Samima\\Desktop\\BruteForceSolutions\\TestData.xls");
		        // Access the required test data sheet
		        HSSFWorkbook wb = new HSSFWorkbook(fis);
		        HSSFSheet sheet = wb.getSheet("testdata");
		        // Loop through all rows in the sheet
		        // Start at row 1 as row 0 is our header row
		        for(int count = 1;count<=sheet.getLastRowNum();count++){
		            HSSFRow row = sheet.getRow(count);
		            System.out.println("Running test case " + row.getCell(0).toString());
		            // Run the test for the current test data row
		           
		           String SearchText =row.getCell(0).toString(); 
		           String SearchResult = row.getCell(1).toString();
		           
		  		  logger = report.startTest("Search Validation");
		  		  Home home = new Home(driver);
		  		  logger.log(LogStatus.INFO,"Navigated to Home Page");
		  		  
		  		  home.Search(SearchText);
		  		logger.log(LogStatus.INFO,"Searching for keywords: "+SearchText);
		  		  SearchResultPage search = new SearchResultPage(driver);
		  		  Assert.assertEquals(search.SearchText(), SearchResult);
		  		  Assert.assertEquals(search.SearchPageVerify(), "Search");
		  		  logger.log(LogStatus.INFO, search.countItem());
		  		  logger.log(LogStatus.PASS,"Search result page is displayed with "+SearchResult);
		        }
		        fis.close();
		    } catch (IOException e) {
		        System.out.println("Test data file not found");
		    }  
		 
	  }
	
  @Test(priority=0,enabled=false)
  public void SearchValidate() {
	  logger = report.startTest("Search Validation");
	  Home home = new Home(driver);
	  logger.log(LogStatus.PASS,"Navigated to Home Page");
	  home.Search("dresses");
	  SearchResultPage search = new SearchResultPage(driver);
	  Assert.assertEquals(search.SearchText(), "DRESSES");
	  Assert.assertEquals(search.SearchPageVerify(), "Search");
	  logger.log(LogStatus.PASS,"Search result page is displayed");
	 
  }
  
  @Test(enabled=false)
  public void LogoPresent(){
	  logger = report.startTest("Logo must be visible");
	  Home home = new Home(driver);
	  logger.log(LogStatus.PASS,"Navigated to Home Page");
	  home.Logo();
	  logger.log(LogStatus.PASS,"Logo is visible to all users");
  }
  
  @Test(enabled=false)
  public void NavMenu(){
	  logger = report.startTest("Four Nav links are present");
	  Home home = new Home(driver);
	  logger.log(LogStatus.PASS, "Go to home page");
	  home.NavLinks();
	  logger.log(LogStatus.PASS, "Nav Links are visible");
  }
  
  @Test(enabled=false)
  public void InvalidEmailAccount(){
	  Home home = new Home(driver);
	  home.SignInLinkClick();
	  LogInPage login = new LogInPage(driver);
	  Assert.assertEquals(login.InvalidEmail("andyjainson"), "rgba(255, 241, 242, 1)");
	  System.out.println(login.InvalidEmail("andyjainson"));
	  
  }
  @Test(enabled=false)
  public void ExistedEmailAccount(){
	  Home home = new Home(driver);
	  home.SignInLinkClick();
	  LogInPage login = new LogInPage(driver);
	  Assert.assertEquals(login.ExistedEmail("rabbani@rabbani.com"), "An account using this email address has already been registered. Please enter a valid password or request a new one.");
	    
  }
  @Test (enabled=false)
  public void CreateNewValidAccount(){
	  Home home = new Home(driver);
	  home.SignInLinkClick();
	  LogInPage login = new LogInPage(driver);
	  String titl = login.CreateAccountTitle();
	  Assert.assertEquals(titl, "CREATE AN ACCOUNT");
	  login.CreateAccount("saymeoneagain@gmail.com");
	  CreateAccountPage userinfo = new CreateAccountPage(driver);
	  String valid = userinfo.CreateTitleValid();
	  Assert.assertEquals(valid, "YOUR PERSONAL INFORMATION");
  }
  @Test (enabled=false)
  public void CreateNewAccount(){
	  Home home = new Home(driver);
	  home.SignInLinkClick();
	  LogInPage login = new LogInPage(driver);
	  String titl = login.CreateAccountTitle();
	  Assert.assertEquals(titl, "CREATE AN ACCOUNT");
	  login.CreateAccount("saymeone@gmail.com");
	  CreateAccountPage userinfo = new CreateAccountPage(driver);
	  String valid = userinfo.CreateTitleValid();
	  Assert.assertEquals(valid, "YOUR PERSONAL INFORMATION");
	  userinfo.MrorMrs("Mr");
	  userinfo.CheckNewsLetter();
	  userinfo.CheckOption();
	  userinfo.UserAccount("Poly", "Sammy", "", "kolykoly","30","10","1991");	
	  MyAccountPage accountpage = new MyAccountPage(driver);
	  Assert.assertEquals(accountpage.successMessageTxt(), "Your account has been created.");
	  Assert.assertEquals(accountpage.verifyUserName(), "Poly Sammy");
	  accountpage.signOutLinksverify();
  }
  
  @Test (enabled=false)
  public void LogInUser(){
	  Home home = new Home(driver);
	  home.SignInLinkClick();
	  LogInPage login = new LogInPage(driver);
	  String titl = login.CreateAccountTitle();
	  Assert.assertEquals(titl, "CREATE AN ACCOUNT");
	  login.LogIn("saymeonce@gmail.com", "kolykoly");
  }
  
  @Test(enabled=false)
  public void InvalidEmailLogin(){
	  Home home = new Home(driver);
	  home.SignInLinkClick();
	  LogInPage login = new LogInPage(driver);
	  
	  Assert.assertEquals(login.InvalidEmailLogin("idontknow", "123456789"), "There is 1 error Invalid email address.");
  }
  
  @Test(enabled=false)
  public void addNewAddress(){
	  MyAccountPage accountpage = new MyAccountPage(driver);
	  accountpage.addAddressClick();
	  AddAddress addnewadd = new AddAddress(driver); 
	  Assert.assertEquals(addnewadd.pageHead(), "YOUR ADDRESSES");
	  Assert.assertEquals(addnewadd.pageTitle(), "Address - eBFS - the power of choice");
	  addnewadd.addAddress("", "", "Jainson Inc", "1213 St Lawrance", "", "Bronx", "New York", "10472", "United States", "1234567890", "0987654321", "No info here", "Home Address");
  }
  
  @Test(enabled=false)
  public void featuredProductPresent(){
	  logger = report.startTest("Verify Feature Product is visible");
	  Home home = new Home(driver);
	  home.featuredProductVisible();
	  logger.log(LogStatus.PASS, "Feature Product visible");
  }
  
  @Test(enabled=false)
  public void EmptyCart(){
	//  Home home = new Home(driver);

  }
  @Test(enabled=false)
  public void CartItemCount(){
	  logger = report.startTest("Verify Item Quantity Added");
	  Home home = new Home(driver);
	  home.MouseOverFeaturedProduct();
	  logger.log(LogStatus.INFO, "Hovered over on product");
	  logger.log(LogStatus.INFO, "Clicked ADD TO CART button");
	  home.proceedToCheckout();
	  logger.log(LogStatus.INFO, "Clicked PROCEED TO CHECKOUT button");
	  ProductSummaryPage summary = new ProductSummaryPage(driver);
	  String qty = summary.ItemQty();
	  Assert.assertEquals(qty, "1 product");
	  logger.log(LogStatus.PASS, "Product added to cart is visible");
	  
	  
  }
  
  @Test(enabled=false)
  public void DeleteItem(){
	  logger = report.startTest("Verify Item Deleted");
	  Home home = new Home(driver);
	  home.MouseOverFeaturedProduct();
	  logger.log(LogStatus.INFO, "Hovered over on product");
	  logger.log(LogStatus.INFO, "Clicked ADD TO CART button");
	  home.proceedToCheckout();
	  logger.log(LogStatus.INFO, "Clicked PROCEED TO CHECKOUT button");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  ProductSummaryPage summary = new ProductSummaryPage(driver);
	  String message = summary.DeleteItem();
	  Assert.assertEquals(message, "Your shopping cart is empty.");
	  logger.log(LogStatus.PASS, "Product is deleted sucessfully");
	  
  }
  
  @Test(enabled=false)
  public void minusItem(){
	  logger = report.startTest("Verify Item Deleted");
	  Home home = new Home(driver);
	  home.MouseOverFeaturedProduct();
	  logger.log(LogStatus.INFO, "Hovered over on product");
	  logger.log(LogStatus.INFO, "Clicked ADD TO CART button");
	  home.proceedToCheckout();
	  logger.log(LogStatus.INFO, "Clicked PROCEED TO CHECKOUT button");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  ProductSummaryPage summary = new ProductSummaryPage(driver);
	  summary.incItem();
	  String message = summary.minusQty();
	  
	  Assert.assertEquals(message, "4 products");
	  
	  logger.log(LogStatus.PASS, "Product is minus sucessfully");
	  
  }
  
  @Test(priority=0,enabled=false)
  public void costVerify(){
	  logger = report.startTest("Verify Item Total And Shipping Cost");
	  Home home = new Home(driver);
	  home.MouseOverFeaturedProduct();
	  logger.log(LogStatus.INFO, "Hovered over on product");
	  logger.log(LogStatus.INFO, "Clicked ADD TO CART button");
	  double expected = home.price(home.productPrice());
			  
	  home.proceedToCheckout();
	  logger.log(LogStatus.INFO, "Clicked PROCEED TO CHECKOUT button");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  ProductSummaryPage summary = new ProductSummaryPage(driver);
	  double actual = home.price(summary.totalCost());
	  Assert.assertEquals(actual, expected);
	  logger.log(LogStatus.PASS, "Total Product price is displayed "+actual);
	  double shipping = home.price(summary.totalShip());
	  Assert.assertEquals(shipping, 2.0);
	  logger.log(LogStatus.PASS, "Total Shipping price is displayed "+shipping);
	  double Cost = home.price(summary.Total());
	  double FinalPrice = actual+shipping;
	  Assert.assertEquals(Cost, FinalPrice);
	  logger.log(LogStatus.PASS, "Total price is displayed "+Cost);
	  
  }
  
  @Test(priority=1,enabled=false)
  public void ContShop(){
	  logger = report.startTest("Continue Shopping Link Validation");
	  Home home = new Home(driver);
	  home.MouseOverFeaturedProduct();
	  logger.log(LogStatus.INFO, "Hovered over on product");
	  logger.log(LogStatus.INFO, "Clicked ADD TO CART button");
	  home.proceedToCheckout();
	  logger.log(LogStatus.INFO, "Clicked PROCEED TO CHECKOUT button");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  ProductSummaryPage summary = new ProductSummaryPage(driver);
	  summary.contShopping();
	  logger.log(LogStatus.PASS,"Continue Shopping link is displayed");
  }
  
  @Test(priority=2,enabled=false)
  public void UserNewAccount(){
	  logger = report.startTest("Register User");
	  Home home = new Home(driver);
	  home.MouseOverFeaturedProduct();
	  logger.log(LogStatus.INFO, "Hovered over on product");
	  logger.log(LogStatus.INFO, "Clicked ADD TO CART button");
	  home.proceedToCheckout();
	  logger.log(LogStatus.INFO, "Clicked PROCEED TO CHECKOUT button");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  ProductSummaryPage summary = new ProductSummaryPage(driver);
	  summary.proceedToChk();
	  logger.log(LogStatus.INFO,"Proceed to checkout link is clicked");
	  LogInPage account = new LogInPage(driver);
	  Assert.assertEquals(account.CreateAccountTitle(), "CREATE AN ACCOUNT");
	  logger.log(LogStatus.INFO, "User is navigated to login or register page");
	  account.CreateAccount("rassmalaai@sweets.com");
	  CreateAccountPage create = new CreateAccountPage(driver);
	  Assert.assertEquals(create.CreateTitleValid(), "YOUR PERSONAL INFORMATION");
	  logger.log(LogStatus.PASS, "User is navigated to Create Account page");
	  
  }
  
  @Test(priority=3,enabled=false)
  public void UserAccount(){
	  logger = report.startTest("User Login");
	  Home home = new Home(driver);
	  home.MouseOverFeaturedProduct();
	  logger.log(LogStatus.INFO, "Hovered over on product");
	  logger.log(LogStatus.INFO, "Clicked ADD TO CART button");
	  home.proceedToCheckout();
	  logger.log(LogStatus.INFO, "Clicked PROCEED TO CHECKOUT button");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  ProductSummaryPage summary = new ProductSummaryPage(driver);
	  summary.proceedToChk();
	  logger.log(LogStatus.INFO,"Proceed to checkout link is clicked");
	  LogInPage account = new LogInPage(driver);
	  Assert.assertEquals(account.LoginTitle(), "ALREADY REGISTERED?");
	  logger.log(LogStatus.INFO, "User is navigated to login or register page");
	  account.LogIn("saymeonce@gmail.com","kolykoly");
	  MyAccountPage myact = new MyAccountPage(driver);
	  myact.signOutLinksverify();
	  logger.log(LogStatus.PASS, "User is sucesfully loged in and navigated to My Account page");
	  
  }
  
  
  @BeforeMethod
  public void OpenHome(){
	  driver.get("http://ebfs.bruteforcesolution.net/ebfs/index.php");
	  driver.manage().window().maximize();
  }
  
  @AfterMethod
  public void tearDown(ITestResult result) throws Throwable{
	 if(result.getStatus()==ITestResult.FAILURE){
		
		 String image = logger.addScreenCapture(Utility.captureScreenshot(driver,result.getName()));
		 logger.log(LogStatus.FAIL,"Featured Product visibility",image);
		
	  }
	  report.endTest(logger);
	  report.flush();
	  
  }
  @BeforeTest
  public void OpenBrowser() {
	  
	  report = new ExtentReports("C:\\Users\\Samima\\workspace\\Samima\\Report\\reporttest.html",true);
	  driver = new FirefoxDriver();
	 
  }

  @AfterTest
  public void CloseBrowser() {
	 // driver.close();
	  driver.get("C:\\Users\\Samima\\workspace\\Samima\\Report\\reporttest.html");
  }

}
