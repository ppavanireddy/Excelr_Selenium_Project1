package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccount {

		static WebDriver dr;
		
		public CreateAccount(WebDriver dr)
		{
			this.dr = dr;
		}
		public void firstNameField(String firstname) 
		{
		
		WebElement firstNameField  =dr.findElement(By.id("firstname"));
    	firstNameField .sendKeys(firstname);
		}
		public void lastNameField(String lastname) 
		{
    	WebElement lastNameField = dr.findElement(By.id("lastname"));
    	lastNameField.sendKeys(lastname);
		}
		public void emailField(String email)
		{
    	WebElement emailField = dr.findElement(By.id("email_address"));
    	emailField.sendKeys(email);
		}
		public void passwordField(String password)
		{
        WebElement passwordField = dr.findElement(By.id("password"));
        passwordField.sendKeys(password);
		}
		public void Confirm_password(String password)
		{
        WebElement Confirm_password= dr.findElement(By.id("password-confirmation"));
        Confirm_password.sendKeys(password);
		}
        
		
		public WebElement getCreateButton() {
	        return dr.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span"));
	    }
		public String getErrorMessage() {
	        return dr.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")).getText();
		
		}
		public String getSuccessMessage() {
	        return dr.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText();
		
		}
	}




