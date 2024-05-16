package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgetPassword {
	
static WebDriver dr;
	
	public ForgetPassword(WebDriver dr)
	{
		this.dr = dr;
	}
	public void url()
	{
		dr.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");
	}
	public void ForgetPassword_Button()
	{
		WebElement fp = dr.findElement(By.xpath("//a[@class='action remind']//span[contains(text(),'Forgot Your Password?')]"));
		fp.click();
	}
	public void enterEmail(String email) {
		
		WebElement Email =dr.findElement(By.xpath("//*[@id='email_address']"));
		Email.sendKeys(email);
    }
	public WebElement ResetMyPassword()
	{
		return dr.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button"));
	}
	public String Message()
	{
		return dr.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")).getText();
	}

}
