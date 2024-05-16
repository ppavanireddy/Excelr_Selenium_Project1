package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class Signin {
static WebDriver dr;
	
	public Signin(WebDriver dr)
	{
		this.dr = dr;
	}
	public void enterEmail(String email) 
	{
		WebElement Email = dr.findElement(By.xpath("//*[@id='email']"));
		Email.sendKeys(email);
    }
	public void enterPassword(String password) 
	{
		WebElement Password = dr.findElement(By.id("pass"));
		Password.sendKeys(password);
    }
	public void getSigninButton() {
		WebElement SigninButton= dr.findElement(By.xpath("//*[@id=\"send2\"]"));
		SigninButton.click();
        
    }
}