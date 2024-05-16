package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InvalidSignin {
static WebDriver dr;
	
	public InvalidSignin(WebDriver dr)
	{
		this.dr = dr;
	}
	public static void InvalidSignin_App(String em, String pwd)
	{
		dr.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(em);
		dr.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(pwd);
		dr.findElement(By.xpath("//*[@id=\"send2\"]/span")).click();
	}
	public String getErrorMessage() {
        return dr.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")).getText();
	
	}
}

