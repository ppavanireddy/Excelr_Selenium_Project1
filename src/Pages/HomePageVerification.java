package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageVerification {
	WebDriver dr;
	
	public HomePageVerification(WebDriver dr)
	{
		this.dr = dr;
	}
	public String getPageTitle()
	{
		return dr.getTitle();
	}
	public void url() {
        dr.get("https://magento.softwaretestingboard.com/");
    }
	
    public WebElement clickCreateAccount() {
    	return dr.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a"));
    }
    public WebElement clickSignIn() {
    	
	        return dr.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a"));

   }

}
