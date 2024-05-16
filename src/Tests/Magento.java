package Tests;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.AddtoCart;
import Pages.AddtoCartCount;
import Pages.AdvancedSearch;
import Pages.Checkout;
import Pages.CompareProduct;
import Pages.CreateAccount;
import Pages.ForgetPassword;
import Pages.HomePageVerification;
import Pages.InvalidSignin;
import Pages.MyOrders;
import Pages.Orders_Returns;
import Pages.ProceedtoCheckout;
import Pages.RemoveProduct;
import Pages.Review_Payment;
import Pages.SearchPage;
import Pages.SearchforInvalidProduct;
import Pages.Signin;
import Pages.UpdateCart;
import Pages.WishList;
import Pages.WriteReview;
import Pages.subscribe;


public class Magento {
	WebDriver dr;
	HomePageVerification hpv;
	CreateAccount ca;
	Signin s;
	InvalidSignin is;
	ForgetPassword fp;
	SearchPage sp;
	AddtoCart a;
	AddtoCartCount ac;
	RemoveProduct rp;
	UpdateCart uc;
	ProceedtoCheckout pc;
	WishList w;
	CompareProduct cp;
	Checkout c;
	Review_Payment r_p;
	SearchforInvalidProduct sip;
	MyOrders mo;
	Orders_Returns or;
	subscribe su;
	AdvancedSearch as;
	WriteReview wr;
	Pages.SearchTerms st;
	
	
	@BeforeClass
    public void setUp() 
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver_v123.exe");
		
		dr= new ChromeDriver();
		dr.manage().window().maximize();
		
		hpv = new HomePageVerification(dr);
		ca=new CreateAccount(dr);
		s = new Signin(dr);
		fp = new ForgetPassword(dr);
		sp = new SearchPage(dr);
		a = new AddtoCart(dr);
		ac = new AddtoCartCount(dr);
		rp = new RemoveProduct(dr);
		uc = new UpdateCart(dr);
		pc = new ProceedtoCheckout(dr);
		w = new WishList(dr);
		cp = new CompareProduct(dr);
		c = new Checkout(dr);
		r_p = new Review_Payment(dr);
		sip = new SearchforInvalidProduct(dr);
		mo = new MyOrders(dr);
		or = new Orders_Returns(dr);
		su = new subscribe(dr);
		as = new AdvancedSearch(dr);
		wr = new WriteReview(dr);
		st = new Pages.SearchTerms(dr);
		
		
	}
	
	@Test(priority = 1)
    public void testHomePage() 
	{
		dr.get("https://magento.softwaretestingboard.com/");
		String PageTitle = hpv.getPageTitle();
		//System.out.println(PageTitle);
		Assert.assertEquals(PageTitle, "Home Page","Homepage did not load successfully. Error may have occurred.");
	}
	
	@DataProvider(name = "userData")
    public Object[][] userData() {
        return new Object[][] {
            {"Pavani", "Reddy", "pavani.reddy@gmail.com", "pavanireddy@12345","pavanireddy@12345"},
            {"Panasala", "Reddy", "panasala.reddy@gmail.com", "panasalareddy@12345","panasalareddy@12345"},
            {"yuva", "sree", "yuva.sree@gmail.com", "yuvasree@1234567890","yuvasree@1234567890"},
        };
    }

    @Test(dataProvider = "userData")
    public void testCreateAccountandSignin(String firstName, String lastName, String email, String password, String confirmPassword) {
    	dr.switchTo().defaultContent();
    	dr.get("https://magento.softwaretestingboard.com/customer/account/create/");

    	WebElement firstNameField  =dr.findElement(By.id("firstname"));
    	firstNameField .sendKeys(firstName);
    	WebElement lastNameField = dr.findElement(By.id("lastname"));
    	lastNameField.sendKeys(lastName);
    	WebElement emailField = dr.findElement(By.id("email_address"));
    	emailField.sendKeys(email);
        WebElement passwordField = dr.findElement(By.id("password"));
        passwordField.sendKeys(password);
        WebElement Confirm_password= dr.findElement(By.id("password-confirmation"));
        Confirm_password.sendKeys(password);
        WebElement create_Account = dr.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span"));
        create_Account.click();
        ca.getErrorMessage();
        
        dr.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2xvZ291dC8%2C/");
        
        WebElement Email = dr.findElement(By.xpath("//*[@id=\"email\"]"));
        Email.sendKeys(email);
        WebElement password1= dr.findElement(By.id("pass"));
        password1.sendKeys(password);
        WebElement SigninButton = dr.findElement(By.xpath("//*[@id=\"send2\"]"));
        SigninButton.click();
    }
        @DataProvider(name = "invalidCredentials")
        public Object[][] invalidCredentials() {
            return new Object[][] {
                {"dbjsysgt@gmail.com", "gsyugs13254365%6787"},
                {"panasala.reddy@gmail.com", "dghwudg^&*&90"},
                {"bdgyhdguydg@gmail.com", "panasalareddy@12345"},
               
            };
        }

        @Test(dataProvider = "invalidCredentials")
        public void testInvalidLogin(String email, String password) {
        	dr.switchTo().defaultContent();
        	dr.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2xvZ291dC8%2C/");
            
            WebElement Email = dr.findElement(By.xpath("//*[@id=\"email\"]"));
            Email.sendKeys(email);
            WebElement password1= dr.findElement(By.id("pass"));
            password1.sendKeys(password);
            WebElement SigninButton = dr.findElement(By.xpath("//*[@id=\"send2\"]"));
            SigninButton.click();
            WebElement ErrorMessage = dr.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div"));
            ErrorMessage.getText();
            String a_str = ErrorMessage.getText();
        	String e_str = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        	Assert.assertEquals(a_str, e_str);
        	
            
        }
        
        @DataProvider(name = "loginAndSearchProduct")
        public Object[][] getLoginAndSearchProduct() {
            return new Object[][] {
                {"pavani.reddy@gmail.com", "pavanireddy@12345", "T-Shirts for Women"}, // Test case 1: User 1 login and search for iPhone
                {"panasala.reddy@gmail.com", "panasalareddy@12345", "T-Shirts for Men"}, // Test case 2: User 2 login and search for Samsung
                // Add more test cases as needed
            };
        }
        @Test(dataProvider = "loginAndSearchProduct")
        public void testLoginAndSearch(String Email, String password, String searchElement) {
        	dr.switchTo().defaultContent();
        	dr.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2xvZ291dC8%2C/");
        	
        	WebElement email = dr.findElement(By.xpath("//*[@id=\"email\"]"));
            email.sendKeys(Email);
            WebElement password1= dr.findElement(By.id("pass"));
            password1.sendKeys(password);
            WebElement SigninButton = dr.findElement(By.xpath("//*[@id=\"send2\"]"));
            SigninButton.click();
            
            WebElement Search = dr.findElement(By.xpath("//input[@id='search']"));
            Search.sendKeys(searchElement);
            
        	sp.searchButton();
          
        }
       
        @DataProvider(name = "searchTerms")
        public Object[][] searchData() {
            return new Object[][]{
                    {"T-Shirts for Women"},
            };
        }

        @Test(dataProvider = "searchTerms")
        public void verifySearchResults(String searchTerm) 
        {
        	hpv.url();
            sp.searchFor(searchTerm);

            String[] searchResults = sp.getSearchResults();
            for (String result : searchResults) {
                Assert.assertTrue(result.contains(searchTerm), "Search result does not match expected product: " + result);
            }
        }
        @DataProvider(name = "loginAndAddtocartandRemove")
        public Object[][] getLoginAndAddtocartandRemove() {
            return new Object[][] {
                {"pavani.reddy@gmail.com", "pavanireddy@12345", "Radiant Tee","M","Purple"}, // Test case 1: User 1 login and search for iPhone
                {"panasala.reddy@gmail.com", "panasalareddy@12345", "Radiant Tee","M","Purple"}, // Test case 2: User 2 login and search for Samsung
                // Add more test cases as needed
            };
        }
        @Test(dataProvider = "loginAndAddtocartandRemove")
        public void testLoginAndAddtocartandRemove(String Email, String password,String productName, String Size, String Color) {
        	dr.switchTo().defaultContent();
        	dr.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2xvZ291dC8%2C/");
        	
        	WebElement email = dr.findElement(By.xpath("//*[@id=\"email\"]"));
            email.sendKeys(Email);
            WebElement password1= dr.findElement(By.id("pass"));
            password1.sendKeys(password);
            WebElement SigninButton = dr.findElement(By.xpath("//*[@id=\"send2\"]"));
            SigninButton.click();
            
            a.Women();
            a.clickProduct(productName); 
            try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            a.SelectSize(Size); 
            a.SelectColor(Color);
            a.ClickAddtoCart();
            
            try { 
            	Thread.sleep(5000); 
            	
            } catch (InterruptedException e) { 
            	// TODOAuto-generated catch block 
            	e.printStackTrace(); 
            	
            }
       		  
       		  String a_str = a.actualMessage(); 
       		  try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       		  
       		  String e_str ="You added Radiant Tee to your shopping cart."; 
       		  Assert.assertEquals(a_str,e_str);
       		  
       		  try 
       		  { 
       			  Thread.sleep(5000); 
       			  } catch (InterruptedException e) 
       		  { 
       		  e.printStackTrace(); 
       		  } 
       		  ac.ClickAddtoCart(); 
       		  String expectedCartItemCount = "1";
       		  
       		  String actualCartItemCount = ac.getCartItemCount();
       		  Assert.assertEquals(actualCartItemCount, expectedCartItemCount);
       		  
       		  try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       		  rp.remove();
       		  try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       		  
       		  rp.alert();
       		  
       		  try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       		  String actualMessage = rp.message();
       		  String ExpectedMessage = "You have no items in your shopping cart.";
       		Assert.assertEquals(actualMessage, ExpectedMessage);
       		  
        }
        @DataProvider(name = "loginAndAddtocartandUpdate")
        public Object[][] getLoginAndAddtocartandUpdate() {
            return new Object[][] {
                {"pavani.reddy@gmail.com", "pavanireddy@12345", "Radiant Tee","M","Purple","1"}, // Test case 1: User 1 login and search for iPhone
                
            };
        }
        @Test(dataProvider = "loginAndAddtocartandUpdate")
        public void testLoginAndAddtocartandUpdate(String Email, String password,String productName, String Size, String Color, String quantity) {
        	dr.switchTo().defaultContent();
        	dr.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2xvZ291dC8%2C/");
        	
        	WebElement email = dr.findElement(By.xpath("//*[@id=\"email\"]"));
            email.sendKeys(Email);
            WebElement password1= dr.findElement(By.id("pass"));
            password1.sendKeys(password);
            WebElement SigninButton = dr.findElement(By.xpath("//*[@id=\"send2\"]"));
            SigninButton.click();
            
            a.Women();
            a.clickProduct(productName); 
            a.SelectSize(Size); 
            a.SelectColor(Color);
            a.ClickAddtoCart();
            try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            ac.ClickAddtoCart();
            
            try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            uc.edit();
            
            
            
            try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            
            uc.Quantity(quantity);
            try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            uc.updatecart();
            
            try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            String actualTxt = uc.message();
            String expectedTxt = "Radiant Tee was updated in your shopping cart.";
            Assert.assertEquals(actualTxt, expectedTxt);
            
        }
        @DataProvider(name = "loginAndProceedtoCheckout")
        public Object[][] getloginAndProceedtoCheckout() {
            return new Object[][] {
                {"pavani.reddy@gmail.com", "pavanireddy@12345","Census","Nome", "12345","7894561230"}, 
                
            };
        }
        @Test(dataProvider = "loginAndProceedtoCheckout")
        public void testloginAndProceedtoCheckout(String Email, String password, String Address, String City,String Postalcode, String phnno) {
        	dr.switchTo().defaultContent();
        	dr.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2xvZ291dC8%2C/");
        	
			/*
			 * try { Thread.sleep(5000); } catch (InterruptedException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); } s.enterEmail(Email);
			 * s.enterPassword(password); s.getSigninButton();
			 */
        	
        	pc.Product();
        	pc.Backpack();
        	pc.addtocart();
        	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	ac.ClickAddtoCart();
        	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	
        	pc.Checkout();
        	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
			/*
			 * c.streetAddress(Address); c.city(City); c.state(); c.code(Postalcode);
			 * c.country(); c.phone(phnno); c.shippingmethod();
			 */
        	WebElement button = dr.findElement(By.xpath("//*[@id='shipping-method-buttons-container']/div/button"));
        	JavascriptExecutor executor = (JavascriptExecutor) dr;
        	executor.executeScript("arguments[0].click();", button);
        	
        	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	WebElement b = dr.findElement(By.xpath("//button[@class='action primary checkout']"));
        	JavascriptExecutor ex = (JavascriptExecutor) dr;
        	ex.executeScript("arguments[0].click();", b);
        	
        	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	String actualmsg = r_p.message();
        	String expectmsg = "Thank you for your purchase!";
        	Assert.assertEquals(actualmsg, expectmsg);
        	
        	
        }
        @DataProvider(name = "loginAndWishlist")
        public Object[][] getloginAndWishlist() {
            return new Object[][] {
                {"panasala.reddy@gmail.com", "panasalareddy@12345"}, 
                
            };
        }
        @Test(dataProvider = "loginAndWishlist")
        public void testloginAndWishlist(String Email, String password) {
dr.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2xvZ291dC8%2C/");
        	
        	
        	w.wishlist();
        	w.item();
        	w.Hoodies();
        	w.addtowishlist();
        	
        	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	String actualMessage = w.Message();
            String expectedMessage = "Circe Hooded Ice Fleece has been added to your Wish List. Click here to continue shopping.";
            Assert.assertEquals(actualMessage, expectedMessage);
        	
        }
        @DataProvider(name = "LoginAndCompare")
        public Object[][] getLoginAndCompare() {
            return new Object[][] {
            	{"panasala.reddy@gmail.com", "panasalareddy@12345"},  
                
            };
        }
        @Test(dataProvider = "LoginAndCompare")
        public void testLoginAndCompare(String Email, String password) {
        	dr.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2xvZ291dC8%2C/");
        	
        	cp.women();
        	cp.item();
        	cp.product();
        	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	cp.AddtoCompare();
        	
        	
        	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	String actualtxt = cp.Message();
            String expectedtxt = "You added product Erika Running Short to the comparison list.";
            Assert.assertEquals(actualtxt, expectedtxt);
        	
        }
        @DataProvider(name = "SearchInvalidProduct")
        public Object[][] getSearchInvalidProduct() {
            return new Object[][] {
            	{"Mobiles"},  
                
            };
        }
        @Test(dataProvider = "SearchInvalidProduct")
        public void testSearchInvalidProduct(String Product) {
        	dr.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2xvZ291dC8%2C/");
        	
        	sp.searchFor(Product);
        	sp.searchButton();
        	
        	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	String actualmsg = sip.msg();
        	String expectedmsg = "Your search returned no results.";
        	Assert.assertEquals(actualmsg, expectedmsg);
        	
        }
        
        @DataProvider(name = "LoginAndcheckMyOders")
        public Object[][] getLoginAndcheckMyOders() {
            return new Object[][] {
            	{"pavani.reddy@gmail.com", "pavanireddy@12345"},  
                
            };
        }
        @Test(dataProvider = "LoginAndcheckMyOders")
        public void testLoginAndcheckMyOders(String Email, String password) {
			/*
			 * mo.url(); try { Thread.sleep(5000); } catch (InterruptedException e) { //
			 * TODO Auto-generated catch block e.printStackTrace(); }
			 * 
			 * s.enterEmail(Email); s.enterPassword(password); s.getSigninButton();
			 * 
			 * try { Thread.sleep(5000); } catch (InterruptedException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */
        	
        	mo.MyOrders();
        }
        
        @DataProvider(name = "LoginAndcheckAddressBook")
        public Object[][] getLoginAndcheckAddressBook() {
            return new Object[][] {
            	{"pavani.reddy@gmail.com", "pavanireddy@12345"},  
                
            };
        }
        @Test(dataProvider = "LoginAndcheckAddressBook")
        public void testLoginAndcheckAddressBook(String Email, String password) {
        	mo.url();
        	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	s.enterEmail(Email);
        	s.enterPassword(password);
        	s.getSigninButton();
        	
        	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	WebElement Address = dr.findElement(By.xpath("//*[@id=\"block-collapsible-nav\"]/ul/li[6]/a"));
        	Address.click();
        }
        @DataProvider(name = "MyProductReviews")
        public Object[][] getMyProductReviews() {
            return new Object[][] {
            	{"pavani.reddy@gmail.com", "pavanireddy@12345"},  
                
            };
        }
        @Test(dataProvider = "MyProductReviews")
        public void testMyProductReviews(String Email, String password) {
			/*
			 * mo.url(); try { Thread.sleep(5000); } catch (InterruptedException e) { //
			 * TODO Auto-generated catch block e.printStackTrace(); }
			 * 
			 * s.enterEmail(Email); s.enterPassword(password); s.getSigninButton();
			 * 
			 * try { Thread.sleep(5000); } catch (InterruptedException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */
        	dr.get("https://magento.softwaretestingboard.com/review/customer/");
        	
			/*
			 * try { Thread.sleep(5000); } catch (InterruptedException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 * 
			 * WebElement product =
			 * dr.findElement(By.xpath("//*[@id=\"block-collapsible-nav\"]/ul/li[10]/strong"
			 * )); product.click();
			 */
        }
      
        @Test
        public void training()
        {
        	WebElement Train = dr.findElement(By.xpath("//*[@id=\"ui-id-7\"]"));
        	Train.click();
        	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	WebElement video = dr.findElement(By.xpath("//*[@id=\"narrow-by-list2\"]/dd/ol/li/a"));
        	video.click();
        }
       
        
        @DataProvider(name = "AdvancedSearch")
        public Object[][] getAdvancedSearch() {
            return new Object[][] {
            	{"Cassius Sparring Tank"},  
                
            };
        }
        @Test(dataProvider = "AdvancedSearch")
        public void testAdvancedSearch(String Product) {
        	
        	dr.get("https://magento.softwaretestingboard.com/");
        	as.Advancedsearch();
        	as.product(Product);
        	as.search();
        }
        @Test
        public void SearchTerms()
        {
        	dr.get("https://magento.softwaretestingboard.com/");
        	st.Search();
        	st.ajax();
        	
        }
        
        @DataProvider(name = "WriteReview")
        public Object[][] getWriteReview() {
            return new Object[][] {
            	{"Pavani","Loved the color","Nice Product"},  
                
            };
        }
        @Test(dataProvider = "WriteReview")
        public void testWriteReview(String Name, String S, String r) {
        	
        	dr.get("https://magento.softwaretestingboard.com/");
        	a.Women();
        	wr.product();
        	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	wr.review();
        	
        	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	WebElement element = dr.findElement(By.id("Rating_4_label"));
        	JavascriptExecutor executor = (JavascriptExecutor) dr;
        	executor.executeScript("arguments[0].click();", element);
        	wr.nickname(Name);
        	wr.summary(S);
        	wr.review(r);
        	wr.submit();
        }
        
        	
        @Test
        public void testSubscribe() {
        
        	su.link();
        	switchToNewTab();
        	WebDriverWait wait = new WebDriverWait(dr,Duration.ofSeconds(10));
        	WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='mce-EMAIL']")));

            emailInput.sendKeys("pavani.reddy@gmail.com");
        	su.button();
    		
    	}
        private void switchToNewTab() {
            
            Set<String> windowHandles = dr.getWindowHandles();

           
            for (String windowHandle : windowHandles) {
                dr.switchTo().window(windowHandle);
            }
        }
        
        
}